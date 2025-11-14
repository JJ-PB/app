package com.devst.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.devst.app.db.AdminSQLiteOpenHelper;

public class DetalleCineActivity extends AppCompatActivity {

    EditText etNombre, etDireccion, etTelefono, etSitioWeb;
    Button btnActualizar, btnEliminar, btnCancelar, btnatras;
    int idCine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cine);

        etNombre = findViewById(R.id.etNombre);
        etDireccion = findViewById(R.id.etDireccion);
        etTelefono = findViewById(R.id.etTelefono);
        etSitioWeb = findViewById(R.id.etSitioWeb);

        btnActualizar = findViewById(R.id.btnActualizar);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnatras = findViewById(R.id.btnatras);


        // Recibir ID desde ListaCinesActivity
        idCine = getIntent().getIntExtra("CINE_ID", -1);

        if (idCine == -1) {
            Toast.makeText(this, "Error: ID no válido", Toast.LENGTH_SHORT).show();
            finish();
        }

        cargarDatos();

        btnActualizar.setOnClickListener(v -> actualizarCine());
        btnEliminar.setOnClickListener(v -> eliminarCine());
        btnCancelar.setOnClickListener(v -> finish());
    }

    private void cargarDatos() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "CinesDB.db", null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT nombre, direccion, telefono, sitioWeb FROM cines WHERE id = ?",
                new String[]{String.valueOf(idCine)}
        );

        if (cursor.moveToFirst()) {
            etNombre.setText(cursor.getString(0));
            etDireccion.setText(cursor.getString(1));
            etTelefono.setText(cursor.getString(2));
            etSitioWeb.setText(cursor.getString(3));
        }

        cursor.close();
        db.close();
    }

    private void actualizarCine() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "CinesDB.db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nombre", etNombre.getText().toString());
        valores.put("direccion", etDireccion.getText().toString());
        valores.put("telefono", etTelefono.getText().toString());
        valores.put("sitioWeb", etSitioWeb.getText().toString());

        int filas = db.update("cines", valores, "id = ?", new String[]{String.valueOf(idCine)});
        db.close();

        if (filas > 0) {
            Toast.makeText(this, "Actualizado correctamente", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show();
        }
    }

    private void eliminarCine() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "CinesDB.db", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        int filas = db.delete("cines", "id = ?", new String[]{String.valueOf(idCine)});
        db.close();

        if (filas > 0) {
            Toast.makeText(this, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Error al eliminar", Toast.LENGTH_SHORT).show();
        }
    }
}
