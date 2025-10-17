package com.devst.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CinemarkActivity extends AppCompatActivity {

    private Button btnLlamar, btnUbicacion, btnWeb, btnatras, btnreclamo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cinemark);

    btnLlamar = findViewById(R.id.btnLlamar);
    btnUbicacion = findViewById(R.id.btnUbicacion);
    btnWeb = findViewById(R.id.btnWeb);
    btnatras = findViewById(R.id.btnatras);
    btnreclamo = findViewById(R.id.btnreclamo);




        // Evento llamar
        btnLlamar.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+56938784")))
        );

        // Evento: abrir web
        btnWeb.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.cinemark.cl");
            Intent viewWeb = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(viewWeb);
        });

        // Evento: abrir ubicación
        btnUbicacion.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-33.390983084678005, -70.54498991897171?q=Cinemark")))
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
