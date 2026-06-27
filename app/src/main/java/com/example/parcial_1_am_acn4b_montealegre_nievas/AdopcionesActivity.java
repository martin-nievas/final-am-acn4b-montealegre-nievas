package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class AdopcionesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopciones);

        // Configurar menú lateral
        ImageView menuIcon = findViewById(R.id.menu_desplegable);
        if (menuIcon != null) {
            menuIcon.setOnClickListener(v -> MenuHelper.showMenuDialog(this));
        }

        // Configurar click en Pancho
        ImageView ivPancho = findViewById(R.id.iv_pancho_card);
        if (ivPancho != null) {
            ivPancho.setOnClickListener(v -> {
                Intent intent = new Intent(this, PerroDetalleActivity.class);
                intent.putExtra("NOMBRE_PERRO", "Pancho");
                intent.putExtra("IMAGEN_PERRO", R.drawable.perro_adopcion_1);
                startActivity(intent);
            });
        }

        // Configurar click en Bianca
        ImageView ivBianca = findViewById(R.id.iv_bianca_card);
        if (ivBianca != null) {
            ivBianca.setOnClickListener(v -> {
                Intent intent = new Intent(this, PerroDetalleActivity.class);
                intent.putExtra("NOMBRE_PERRO", "Bianca");
                intent.putExtra("IMAGEN_PERRO", R.drawable.perro_adopcion_2);
                startActivity(intent);
            });
        }
    }
}
