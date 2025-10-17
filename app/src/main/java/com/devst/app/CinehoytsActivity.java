package com.devst.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CinehoytsActivity extends AppCompatActivity {

    private Button btnLlamar, btnUbicacion, btnWeb, btnatras, btnreclamo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinehoyts);

        btnLlamar = findViewById(R.id.btnLlamar);
        btnUbicacion = findViewById(R.id.btnUbicacion);
        btnWeb = findViewById(R.id.btnWeb);
        btnatras = findViewById(R.id.btnatras);
        btnreclamo = findViewById(R.id.btnreclamo);



        // Evento llamar
        btnLlamar.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789")))
        );

        // Evento: abrir web
        btnWeb.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.cinepolischile.cl");
            Intent viewWeb = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(viewWeb);
        });

        // Evento: abrir ubicación
        btnUbicacion.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-33.40185892504276, -70.57805234465131?q=Cine Hoyts")))
        );

        btnatras.setOnClickListener(v ->
                finish()
        );

        btnreclamo.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReclamosActivity.class);
            startActivity(intent);
        });


    }
}