package com.devst.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class NormandieActivity extends AppCompatActivity {

    private Button btnLlamar, btnUbicacion, btnWeb, btnatras, btnreclamo;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normandie);

    btnLlamar = findViewById(R.id.btnLlamar);
    btnUbicacion = findViewById(R.id.btnUbicacion);
    btnWeb = findViewById(R.id.btnWeb);
    btnatras = findViewById(R.id.btnatras);
    btnreclamo = findViewById(R.id.btnreclamo);





        // Evento llamar
       btnLlamar.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+56938784")))
        );

       btnWeb.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://www.normandie.cl");
            Intent viewWeb = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(viewWeb);
        });

       btnUbicacion.setOnClickListener(v ->
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-33.44730023223645, -70.65173972506295?q=Normandie")))
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
