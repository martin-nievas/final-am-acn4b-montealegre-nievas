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

        String urlPancho = "https://images.unsplash.com/photo-1761583779782-668295ac8368?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTYxfHxqdW1waW5nJTIwZG9nfGVufDB8fDB8fHww";
        String urlBianca = "https://plus.unsplash.com/premium_photo-1708983591032-40822c6afa84?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzYzfHxqdW1waW5nJTIwZG9nfGVufDB8fDB8fHww";

        ImageView ivPancho = findViewById(R.id.iv_pancho_card);
        ImageView ivBianca = findViewById(R.id.iv_bianca_card);

        // Configurar click en Pancho
        if (ivPancho != null) {
            com.bumptech.glide.Glide.with(this).load(urlPancho).into(ivPancho);

            ivPancho.setOnClickListener(v -> {
                Intent intent = new Intent(this, PerroDetalleActivity.class);
                intent.putExtra("NOMBRE_PERRO", "Pancho");
                intent.putExtra("URL_IMAGEN_PERRO", urlPancho);
                startActivity(intent);
            });
        }

        // Configurar click en Bianca
        if (ivBianca != null) {
            com.bumptech.glide.Glide.with(this).load(urlBianca).into(ivBianca);

            ivBianca.setOnClickListener(v -> {
                Intent intent = new Intent(this, PerroDetalleActivity.class);
                intent.putExtra("NOMBRE_PERRO", "Bianca");
                intent.putExtra("URL_IMAGEN_PERRO", urlBianca);
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
