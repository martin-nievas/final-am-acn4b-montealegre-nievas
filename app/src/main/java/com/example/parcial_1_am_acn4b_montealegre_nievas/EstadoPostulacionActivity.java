package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EstadoPostulacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_postulacion);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Estado de Postulación");
        }

        ImageView ivIcono = findViewById(R.id.ivIconoEstado);
        TextView tvTitulo = findViewById(R.id.tvTituloEstado);
        TextView tvMensaje = findViewById(R.id.tvMensajeEstado);
        Button btnVolver = findViewById(R.id.btnVolverMenu);
        Button btnCancelarPostulacion = findViewById(R.id.btnCancelarPostulacion);

        FirebaseUser usuarioActual = FirebaseAuth.getInstance().getCurrentUser();

        if (usuarioActual != null && usuarioActual.getEmail() != null) {
            SharedPreferences prefs = getSharedPreferences("MisAdopciones", MODE_PRIVATE);
            boolean tienePostulacion = prefs.getBoolean("postulacion_" + usuarioActual.getEmail(), false);
            String nombrePerro = prefs.getString("perro_" + usuarioActual.getEmail(), "");

            if (tienePostulacion) {
                ivIcono.setImageResource(android.R.drawable.ic_dialog_info);
                tvTitulo.setText(R.string.postulaci_n_recibida);
                tvMensaje.setText(getString(R.string.tu_postulaci_n_para_adoptar_a_s_ya_fue_recibida_y_nos_contactaremos_a_la_brevedad, nombrePerro.isEmpty() ? "una mascota" : nombrePerro));

                if (btnCancelarPostulacion != null) {
                    btnCancelarPostulacion.setVisibility(View.VISIBLE);
                    btnCancelarPostulacion.setOnClickListener(v -> new AlertDialog.Builder(this)
                            .setTitle(R.string.titulo_dialogo_cancelar)
                            .setMessage(R.string.mensaje_dialogo_cancelar)
                            .setPositiveButton(R.string.confirmar_cancelar, (dialog, which) -> {
                                //eliminar datos
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.remove("postulacion_" + usuarioActual.getEmail());
                                editor.remove("perro_" + usuarioActual.getEmail());
                                editor.apply();

                                Toast.makeText(this, R.string.postulacion_cancelada_exito, Toast.LENGTH_SHORT).show();
                                //actualizar vista
                                ivIcono.setImageResource(android.R.drawable.ic_delete);
                                tvTitulo.setText(R.string.sin_postulaciones_pendientes);
                                tvMensaje.setText(R.string.no_ten_s_ninguna_postulaci_n_activa_actualmente_explor_nuestras_mascotas_y_postulate);
                                btnCancelarPostulacion.setVisibility(View.GONE);
                            })
                            .setNegativeButton(R.string.cancelar_dialogo, null)
                            .show());
                }
            } else {
                ivIcono.setImageResource(android.R.drawable.ic_delete);
                tvTitulo.setText(R.string.sin_postulaciones_pendientes);
                tvMensaje.setText(R.string.no_ten_s_ninguna_postulaci_n_activa_actualmente_explor_nuestras_mascotas_y_postulate);
            }
        } else {
            tvTitulo.setText(R.string.sesi_n_no_iniciada);
            tvMensaje.setText(R.string.deb_s_iniciar_sesi_n_para_ver_el_estado_de_tu_postulaci_n);
        }

        btnVolver.setOnClickListener(v -> finish());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}