package com.devst.app;

import android.content.Intent;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class HomeActivity extends AppCompatActivity {

    // Variables
    private String emailUsuario = "";
    private TextView tvBienvenida;

    private Button btnPerfil;
    private Button btnCines;
    private Button btnAlimentos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        //Referencias
        tvBienvenida = findViewById(R.id.tvBienvenida);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnCines = findViewById(R.id.btnCines);
        btnAlimentos = findViewById(R.id.btnAlimentos);

        // Eventos
        btnCines.setOnClickListener(v ->
                startActivity(new Intent(this, CinesActivity.class))
        );

        btnAlimentos.setOnClickListener(v ->
                startActivity(new Intent(this, AlimentosActivity.class))
        );



        // Recibir dato del Login
        emailUsuario = getIntent().getStringExtra("email_usuario");
        if (emailUsuario == null) emailUsuario = "";
        tvBienvenida.setText("Bienvenido a CinemaSurf: " + emailUsuario);

        // Evento: Intent explícito → ProfileActivity (esperando resultado)
        btnPerfil.setOnClickListener(v -> {
            Intent i = new Intent(HomeActivity.this, PerfilActivity.class);
            i.putExtra("email_usuario", emailUsuario);
            startActivity(i);

        });


    }
}