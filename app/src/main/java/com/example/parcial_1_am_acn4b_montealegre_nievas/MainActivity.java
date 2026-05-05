package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView pregunta1 = findViewById(R.id.QuestionText);
        TextView respuesta1 = findViewById(R.id.AnswerText);

        pregunta1.setOnClickListener(v -> {
            if (respuesta1.getVisibility() == View.GONE){
                respuesta1.setVisibility(View.VISIBLE);
        } else {
            respuesta1.setVisibility(View.GONE);

            }
        }
        );

        TextView pregunta2 = findViewById(R.id.QuestionText2);
        TextView respuesta2 = findViewById(R.id.AnswerText2);

        pregunta2.setOnClickListener(v -> {
            if (respuesta2.getVisibility() == View.GONE){
                respuesta2.setVisibility(View.VISIBLE);
            } else {
                respuesta2.setVisibility(View.GONE);

            }
        }

        );

        LinearLayout contenedorPagos = findViewById(R.id.iconsBox);
        TextView tituloPagos = new TextView(this);

        tituloPagos.setText(R.string.titulo_medios_de_pago_disponibles);
        tituloPagos.setTextSize(18);
        tituloPagos.setTypeface(null, Typeface.BOLD);
        tituloPagos.setTextColor(Color.BLACK);
        tituloPagos.setPadding(0, 30, 0, 20);

        contenedorPagos.addView(tituloPagos, 0);

    }

}

