package com.devst.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ReclamosActivity extends AppCompatActivity {

    private Button btnatras;
    private Button btncorreo;
    private Button btncompartir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamos);

        btnatras = findViewById(R.id.btnatras);
        btncorreo = findViewById(R.id.btncorreo);
        btncompartir = findViewById(R.id.btncompartir);

        // Evento: Intent implícito → enviar correo
        btncorreo.setOnClickListener(v -> {
            Intent email = new Intent(Intent.ACTION_SENDTO);
            email.setData(Uri.parse("mailto:")); // Solo apps de correo
            String emailUsuario = "";
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailUsuario});
            email.putExtra(Intent.EXTRA_SUBJECT, "Gracias por contactarnos");
            email.putExtra(Intent.EXTRA_TEXT, "Gracias por contactarnos");
            startActivity(Intent.createChooser(email, "Enviar correo con:"));
        });

        // Evento: Intent implícito → compartir texto
        btncompartir.setOnClickListener(v -> {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, "Hola ingresa tu reclamo aquí");
            startActivity(Intent.createChooser(share, "Compartir usando:"));
        });



        btnatras.setOnClickListener(v -> finish());
    }

}
