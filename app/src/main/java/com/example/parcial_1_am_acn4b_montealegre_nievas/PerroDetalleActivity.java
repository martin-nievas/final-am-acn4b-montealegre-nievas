package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PerroDetalleActivity extends AppCompatActivity {
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
        int imagenResId = getIntent().getIntExtra("IMAGEN_PERRO", 0);

        // Referencias a las vistas
        ImageView ivPerro = findViewById(R.id.iv_dog_detail);
        TextView tvConoceA = findViewById(R.id.tv_conoce_a);

        // Setear datos
        if (nombrePerro != null) {
            // Volvemos a la concatenación directa como pediste
            tvConoceA.setText("Conocé a " + nombrePerro);
        }
        if (imagenResId != 0) {
            ivPerro.setImageResource(imagenResId);
        }
    }
}
