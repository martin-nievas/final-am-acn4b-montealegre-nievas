package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

        EditText etBuscar = findViewById(R.id.et_buscar);
        LinearLayout layoutPancho = findViewById(R.id.layout_pancho);
        LinearLayout layoutBianca = findViewById(R.id.layout_bianca);

        if (etBuscar != null && layoutPancho != null && layoutBianca != null) {
            etBuscar.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String texto = s.toString().toLowerCase().trim();

                    if ("pancho".contains(texto)) {
                        layoutPancho.setVisibility(View.VISIBLE);
                    } else {
                        layoutPancho.setVisibility(View.GONE);
                    }

                    if ("bianca".contains(texto)) {
                        layoutBianca.setVisibility(View.VISIBLE);
                    } else {
                        layoutBianca.setVisibility(View.GONE);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });
        }
    }

    protected void onResume() {
        super.onResume();

        EditText etBuscar = findViewById(R.id.et_buscar);
        LinearLayout layoutPancho = findViewById(R.id.layout_pancho);
        LinearLayout layoutBianca = findViewById(R.id.layout_bianca);

        if (etBuscar != null) {
            etBuscar.setText("");
            etBuscar.clearFocus();
        }

        if (layoutPancho != null) {
            layoutPancho.setVisibility(View.VISIBLE);
        }

        if (layoutBianca != null) {
            layoutBianca.setVisibility(View.VISIBLE);
        }
    }
}
