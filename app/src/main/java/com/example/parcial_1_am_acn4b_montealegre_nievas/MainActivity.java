package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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

        // Menu Logic
        ImageView menuIcon = findViewById(R.id.menu_desplegable);
        if (menuIcon != null) {
            menuIcon.setOnClickListener(v -> MenuHelper.showMenuDialog(this));
        }

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

        ImageButton btnMP = findViewById(R.id.buttonMercadoPago);
        btnMP.setOnClickListener(v -> {
            String url = "https://www.mercadopago.com.ar/";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        ImageButton btnModo = findViewById(R.id.buttonModo);
        btnModo.setOnClickListener(v -> {
            String url = "https://www.modo.com.ar/";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        ImageButton btnPP = findViewById(R.id.buttonPaypal);
        btnPP.setOnClickListener(v -> {
            String url = "https://www.paypal.com/ar/";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        ImageButton btnTef = findViewById(R.id.buttonTransferencia);
        if (btnTef != null) {
            btnTef.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, DatosBancoActivity.class);
                startActivity(intent);
            });
        }
    }
}
