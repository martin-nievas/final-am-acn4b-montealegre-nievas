package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FormularioAdopcionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_adopcion);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Formulario de Adopción");
        }

        TextView tvMascota = findViewById(R.id.tvMascotaSeleccionada);
        EditText etNombre = findViewById(R.id.etNombreCompleto);
        EditText etEmail = findViewById(R.id.etEmail);
        EditText etTelefono = findViewById(R.id.etTelefono);
        Button btnEnviar = findViewById(R.id.btnEnviarSolicitud);
        Button btnVolver = findViewById(R.id.btnVolver);

        String nombrePerro = getIntent().getStringExtra("NOMBRE_PERRO");
        if (nombrePerro != null) {
            tvMascota.setText(getString(R.string.est_s_postul_ndote_para_adoptar_a, nombrePerro));
        }

        FirebaseUser usuarioActual = FirebaseAuth.getInstance().getCurrentUser();
        if (usuarioActual != null) {
            if (usuarioActual.getEmail() != null) {
                etEmail.setText(usuarioActual.getEmail());
            }
            if (usuarioActual.getDisplayName() != null) {
                etNombre.setText(usuarioActual.getDisplayName());
            }
        }

        btnEnviar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String telefono = etTelefono.getText().toString().trim();

            if (nombre.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(this, "Por favor completá los campos obligatorios", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "¡Solicitud enviada! Nos contactaremos a la brevedad.", Toast.LENGTH_LONG).show();
                finish(); // Cierra la pantalla y regresa al detalle
            }
        });

        btnVolver.setOnClickListener(v -> finish());
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}