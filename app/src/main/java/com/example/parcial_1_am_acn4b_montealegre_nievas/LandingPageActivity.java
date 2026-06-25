package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class LandingPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        ImageView menuIcon = findViewById(R.id.menu_desplegable);
        if (menuIcon != null) {
            menuIcon.setOnClickListener(v -> MenuHelper.showMenuDialog(this));
        }
    }
}
