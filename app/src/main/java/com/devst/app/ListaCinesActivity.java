package com.devst.app;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.devst.app.db.AdminSQLiteOpenHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListaCinesActivity extends AppCompatActivity {

    ListView listViewCines;
    FloatingActionButton Agregar;

    ArrayList<String> listaCinesInfo;
    ArrayList<Integer> listaCinesId;

    AdminSQLiteOpenHelper adminDB;

    private Button btnatras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cines);

        listViewCines = findViewById(R.id.listViewCines);
        Agregar = findViewById(R.id.Agregar);
        btnatras = findViewById(R.id.btnatras);


        adminDB = new AdminSQLiteOpenHelper(this, "CinesDB.db", null, 1);

        Agregar.setOnClickListener(v -> {
            Intent intent = new Intent(ListaCinesActivity.this, RegistroCineActivity.class);
            startActivity(intent);
        });

        btnatras.setOnClickListener(v ->
                finish()
        );



        listViewCines.setOnItemClickListener((parent, view, position, id) -> {
            int idCine = listaCinesId.get(position);
            Intent intent = new Intent(ListaCinesActivity.this, DetalleCineActivity.class);
            intent.putExtra("CINE_ID", idCine);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        cargarListaCines();
    }

    private void cargarListaCines() {
        listaCinesInfo = new ArrayList<>();
        listaCinesId = new ArrayList<>();

        SQLiteDatabase db = adminDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, nombre, direccion, telefono, sitioWeb FROM cines", null);
        if (cursor.moveToFirst()) {
            do {
                listaCinesId.add(cursor.getInt(0));

                String info = "ID: " + cursor.getInt(0) +
                        " | " + cursor.getString(1) +       // nombre
                        " | Dir: " + cursor.getString(2) + // direccion
                        " | Tel: " + cursor.getString(3) + // telefono
                        " | Web: " + cursor.getString(4);  // sitioWeb

                listaCinesInfo.add(info);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCinesInfo);

        listViewCines.setAdapter(adapter);
    }
}