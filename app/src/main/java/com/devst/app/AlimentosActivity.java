package com.devst.app;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AlimentosActivity extends AppCompatActivity {

    private Button btnatras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos);

        btnatras = findViewById(R.id.btnatras);

        btnatras.setOnClickListener(v ->
                finish()
        );
    }

}
