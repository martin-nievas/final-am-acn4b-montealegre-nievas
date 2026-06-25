package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MenuHelper {

    public static void showMenuDialog(Activity activity) {
        Dialog dialog = new Dialog(activity, android.R.style.Theme_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.layout_menu_desplegable);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        ImageView btnClose = dialog.findViewById(R.id.btn_close_menu);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        View viewDismiss = dialog.findViewById(R.id.view_dismiss);
        viewDismiss.setOnClickListener(new View.OnClickListener() {
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
