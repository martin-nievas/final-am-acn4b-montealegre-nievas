package com.example.parcial_1_am_acn4b_montealegre_nievas;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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

        // Botón Cerrar (X)
        View btnClose = dialog.findViewById(R.id.btn_close_menu);
        if (btnClose != null) {
            btnClose.setOnClickListener(v -> dialog.dismiss());
        }

        // Cerrar al tocar área oscura (Overlay lateral)
        View viewDismiss = dialog.findViewById(R.id.view_dismiss);
        if (viewDismiss != null) {
            viewDismiss.setOnClickListener(v -> dialog.dismiss());
        }

        // Opción 1: Inicio (LandingPageActivity)
        View btnInicio = dialog.findViewById(R.id.btn_nav_inicio);
        if (btnInicio != null) {
            btnInicio.setOnClickListener(v -> {
                dialog.dismiss();
                if (!(activity instanceof LandingPageActivity)) {
                    Intent intent = new Intent(activity, LandingPageActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    activity.startActivity(intent);
                }
            });
        }

        // Opción 2: Adopciones
        View btnAdopciones = dialog.findViewById(R.id.btn_nav_adopciones);
        if (btnAdopciones != null) {
            btnAdopciones.setOnClickListener(v -> {
                dialog.dismiss();
                if (!(activity instanceof AdopcionesActivity)) {
                    Intent intent = new Intent(activity, AdopcionesActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    activity.startActivity(intent);
                }
            });
        }

        // Opción 3: Donaciones (MainActivity)
        View btnDonaciones = dialog.findViewById(R.id.btn_nav_donaciones);
        if (btnDonaciones != null) {
            btnDonaciones.setOnClickListener(v -> {
                dialog.dismiss();
                if (!(activity instanceof MainActivity)) {
                    Intent intent = new Intent(activity, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    activity.startActivity(intent);
                }
            });
        }

        // Opción 4: Lógica de subopciones expansibles
        View option4Header = dialog.findViewById(R.id.option_4_header);
        LinearLayout suboptionsContainer = dialog.findViewById(R.id.suboptions_container);
        ImageView option4Chevron = dialog.findViewById(R.id.option_4_chevron);

        if (option4Header != null && suboptionsContainer != null) {
            option4Header.setOnClickListener(v -> {
                if (suboptionsContainer.getVisibility() == View.GONE) {
                    suboptionsContainer.setVisibility(View.VISIBLE);
                    if (option4Chevron != null) option4Chevron.setRotation(180f);
                } else {
                    suboptionsContainer.setVisibility(View.GONE);
                    if (option4Chevron != null) option4Chevron.setRotation(0f);
                }
            });
        }

        dialog.show();
    }
}
