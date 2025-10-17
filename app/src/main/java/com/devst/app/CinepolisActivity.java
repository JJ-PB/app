package com.devst.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CinepolisActivity extends AppCompatActivity {

    private Button btnLlamar, btnUbicacion, btnWeb, btnatras, btnreclamo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinepolis);

        btnLlamar = findViewById(R.id.btnLlamar);
        btnUbicacion = findViewById(R.id.btnUbicacion);
        btnWeb = findViewById(R.id.btnWeb);
        btnatras = findViewById(R.id.btnatras);
        btnreclamo = findViewById(R.id.btnreclamo);




        btnLlamar.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789")))
        );

        btnWeb.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.cinepolis.com");
            Intent viewWeb = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(viewWeb);
        });

        btnUbicacion.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-33.39868395651165, -70.59855063124016?q=Cinepolis")))
        );

        btnreclamo.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReclamosActivity.class);
            startActivity(intent);
        });

        btnatras.setOnClickListener(v ->
                finish()
        );
    }
}

