package com.vitoraugusto.vieats.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.vitoraugusto.vieats.R;

public class SplashActivity extends AppCompatActivity {
    ImageView imageLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageLogo = findViewById(R.id.logo);
        imageLogo.setAlpha(0f);
        imageLogo.animate().alpha(1f).setDuration(500).withEndAction(() -> {

            new Handler().postDelayed(() -> {

                imageLogo.animate().alpha(0f).setDuration(500).withEndAction(() -> {
                    startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
                    finish();
                });
            }, 2000);
        });
    }
}
