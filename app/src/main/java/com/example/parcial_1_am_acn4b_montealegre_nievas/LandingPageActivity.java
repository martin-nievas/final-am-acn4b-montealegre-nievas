package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class LandingPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        // Menú desplegable
        ImageView menuIcon = findViewById(R.id.menu_desplegable);
        if (menuIcon != null) {
            menuIcon.setOnClickListener(v -> MenuHelper.showMenuDialog(this));
        }

        // Botón "Convertite en su hogar" -> Navegar a Adopciones
        Button btnAction = findViewById(R.id.btn_action);
        if (btnAction != null) {
            btnAction.setOnClickListener(v -> {
                Intent intent = new Intent(LandingPageActivity.this, AdopcionesActivity.class);
                startActivity(intent);
            });
        }
    }
}
