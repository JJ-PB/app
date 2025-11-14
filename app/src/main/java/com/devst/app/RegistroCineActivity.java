package com.devst.app;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devst.app.db.AdminSQLiteOpenHelper;

public class RegistroCineActivity extends AppCompatActivity {

    EditText etNombre, etDireccion, etTelefono, etSitioWeb;
    Button btnGuardar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cine);

        etNombre = findViewById(R.id.etNombre);
        etDireccion = findViewById(R.id.etDireccion);
        etTelefono = findViewById(R.id.etTelefono);
        etSitioWeb = findViewById(R.id.etSitioWeb);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnCancelar = findViewById(R.id.btnCancelar);

        btnGuardar.setOnClickListener(v -> guardarCine());
        btnCancelar.setOnClickListener(v -> finish());
    }

    private void guardarCine() {
        String nombre = etNombre.getText().toString();
        String direccion = etDireccion.getText().toString();
        String telefono = etTelefono.getText().toString();
        String sitioWeb = etSitioWeb.getText().toString();

        if (nombre.isEmpty() || direccion.isEmpty()) {
            Toast.makeText(this, "Completa los campos obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "CinesDB.db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("direccion", direccion);
        valores.put("telefono", telefono);
        valores.put("sitioWeb", sitioWeb);

        long id = db.insert("cines", null, valores);
        db.close();

        if (id > 0) {
            Toast.makeText(this, "Cine registrado con éxito", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show();
        }
    }
}