package com.example.pc.abm;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText campoNombre,campoApellido;
    Button buttonGuardar,buttonMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNombre =(EditText) findViewById(R.id.campoNombre);
        campoApellido =(EditText) findViewById(R.id.campoApellido);

        buttonGuardar = (Button) findViewById(R.id.buttonGuardar);
        buttonMostrar = (Button) findViewById(R.id.buttonMostrar);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar( campoNombre.getText().toString(),campoApellido.getText().toString());
            }
        });

        buttonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Listado.class));
            }
        });


    }

    private void guardar(String Nombre,String Apellido){

        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues c = new ContentValues();
            c.put("Nombre",Nombre);
            c.put("Apellido",Apellido);
            db.insert("PERSONAS",null,c);
            db.close();
            Toast.makeText(this,"Registro insertado",Toast.LENGTH_SHORT).show();



        }catch (Exception e){
            Toast.makeText(this,"Error"+ e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
