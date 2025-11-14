package com.devst.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CinesActivity extends AppCompatActivity {
    private Button btnCinepolis;
    private Button btnCinemark;
    private Button btnCinehoyts;
    private Button btnNormandie;

    private Button btnatras;

    private Button btnGestionCines;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cines);

        btnCinepolis = findViewById(R.id.btnCinepolis);
        btnCinemark = findViewById(R.id.btnCinemark);
        btnCinehoyts = findViewById(R.id.btnCinehoyts);
        btnNormandie = findViewById(R.id.btnNormandie);
        btnatras = findViewById(R.id.btnatras);
        btnGestionCines = findViewById(R.id.btonGestionCines);


        btnCinepolis.setOnClickListener(v ->
                startActivity(new Intent(this, CinepolisActivity.class))
        );

        btnGestionCines.setOnClickListener(v ->
                 startActivity(new Intent(this, ListaCinesActivity.class))
        );

        btnCinemark.setOnClickListener(v ->
                startActivity(new Intent(this, CinemarkActivity.class))
        );

        btnCinehoyts.setOnClickListener(v ->
                startActivity(new Intent(this, CinehoytsActivity.class))
        );

        btnNormandie.setOnClickListener(v ->
                startActivity(new Intent(this, NormandieActivity.class))
        );

        btnatras.setOnClickListener(v ->
                finish()
        );

    }
}
