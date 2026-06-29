package com.example.parcial_1_am_acn4b_montealegre_nievas;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class DatosBancoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_banco);

        Button btnVolver = findViewById(R.id.btn_volver_donaciones);
        if (btnVolver != null) {

            btnVolver.setOnClickListener(v -> finish());
        }
    }
}
