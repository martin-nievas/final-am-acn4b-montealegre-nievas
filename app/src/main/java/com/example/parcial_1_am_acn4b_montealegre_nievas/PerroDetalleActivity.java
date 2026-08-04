package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PerroDetalleActivity extends AppCompatActivity {
    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perro_detalle);

        // Configurar menú lateral
        ImageView menuIcon = findViewById(R.id.menu_desplegable);
        if (menuIcon != null) {
            menuIcon.setOnClickListener(v -> MenuHelper.showMenuDialog(this));
        }

        // Obtener datos del Intent
        String nombrePerro = getIntent().getStringExtra("NOMBRE_PERRO");
        String urlImagenPerro = getIntent().getStringExtra("URL_IMAGEN_PERRO");

        // Referencias a las vistas
        ImageView ivPerro = findViewById(R.id.iv_dog_detail);
        TextView tvConoceA = findViewById(R.id.tv_conoce_a);
        
        CardView cvCollapsed = findViewById(R.id.cv_collapsed_info);
        CardView cvExpanded = findViewById(R.id.perro_info_completa);
        View llBadges = findViewById(R.id.estrellas);
        
        TextView tvNameDetail = findViewById(R.id.tv_dog_name_detail);
        TextView tvDescription = findViewById(R.id.tv_dog_description);

        Button btnAdoptame = findViewById(R.id.btn_adoptame);

        // Setear datos básicos
        if (nombrePerro != null) {
            tvConoceA.setText(getString(R.string.conoce_a_mascota, nombrePerro));
            tvNameDetail.setText(nombrePerro);
            
            if (nombrePerro.equalsIgnoreCase("Pancho")) {
                tvDescription.setText(R.string.descripcion_pancho);
            } else if (nombrePerro.equalsIgnoreCase("Bianca")) {
                tvDescription.setText(R.string.descripcion_bianca);
            }
        }

        if (ivPerro != null && urlImagenPerro != null) {
            Glide.with(this)
                    .load(urlImagenPerro)
                    .into(ivPerro);
        }


        if (btnAdoptame != null) {
            btnAdoptame.setOnClickListener(v -> {
                FirebaseUser usuarioActual = FirebaseAuth.getInstance().getCurrentUser();

                if (usuarioActual == null) {
                    Toast.makeText(PerroDetalleActivity.this, "Debes iniciar sesión para postularte", Toast.LENGTH_SHORT).show();
                    Intent intentLogin = new Intent(PerroDetalleActivity.this, LoginActivity.class);
                    startActivity(intentLogin);
                } else if (usuarioActual.getEmail() != null) {
                    SharedPreferences prefs = getSharedPreferences("MisAdopciones", MODE_PRIVATE);
                    boolean tienePostulacion = prefs.getBoolean("postulacion_" + usuarioActual.getEmail(), false);

                    if (tienePostulacion) {
                        Toast.makeText(PerroDetalleActivity.this, "Ya tenés una postulación activa. Revisá su estado desde el menú.", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intentFormulario = new Intent(PerroDetalleActivity.this, FormularioAdopcionActivity.class);
                        intentFormulario.putExtra("NOMBRE_PERRO", nombrePerro);
                        startActivity(intentFormulario);
                    }
                }
            });
        }

        //TransitionManager sirve para que el cambio sea suave

        cvCollapsed.setOnClickListener(v -> {
            TransitionManager.beginDelayedTransition((ViewGroup) cvCollapsed.getParent());
            
            cvCollapsed.setVisibility(View.GONE);
            cvExpanded.setVisibility(View.VISIBLE);
            llBadges.setVisibility(View.VISIBLE);
        });
        
        cvExpanded.setOnClickListener(v -> {
            TransitionManager.beginDelayedTransition((ViewGroup) cvCollapsed.getParent());
            cvExpanded.setVisibility(View.GONE);
            llBadges.setVisibility(View.GONE);
            cvCollapsed.setVisibility(View.VISIBLE);
        });
    }
}
