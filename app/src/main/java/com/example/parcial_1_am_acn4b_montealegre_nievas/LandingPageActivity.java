package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class LandingPageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        ImageView menuIcon = findViewById(R.id.menu_desplegable);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenuDialog();
            }
        });
    }

    private void showMenuDialog() {
        Dialog dialog = new Dialog(this, android.R.style.Theme_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.layout_menu_desplegable);

        ImageView btnClose = dialog.findViewById(R.id.btn_close_menu);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        LinearLayout option4Header = dialog.findViewById(R.id.option_4_header);
        LinearLayout suboptionsContainer = dialog.findViewById(R.id.suboptions_container);
        ImageView option4Chevron = dialog.findViewById(R.id.option_4_chevron);

        option4Header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (suboptionsContainer.getVisibility() == View.GONE) {
                    suboptionsContainer.setVisibility(View.VISIBLE);
                    option4Chevron.setRotation(180f);
                } else {
                    suboptionsContainer.setVisibility(View.GONE);
                    option4Chevron.setRotation(0f);
                }
            }
        });

        dialog.show();
    }
}
