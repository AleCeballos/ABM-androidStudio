package com.example.pc.abm;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modificar extends AppCompatActivity {

    EditText campoNombre,campoApellido;
    Button buttonModificar, buttonEliminar;

int id;
String nombre;
String apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        //RECIBO LOS PARAMETROS DESDE LISTADO

        Bundle b = getIntent().getExtras();
        if(b!=null){

            id = b.getInt("Id");
            nombre = b.getString("Nombre");
            apellido = b.getString("Apellido");
        }

        campoNombre =(EditText) findViewById(R.id.campoNombre);
        campoApellido =(EditText) findViewById(R.id.campoApellido);

        //SETEO LOS DATOS EN LOS CAMPOS DE TEXTO
        campoNombre.setText(nombre);
        campoApellido.setText(apellido);

        buttonModificar = (Button) findViewById(R.id.buttonModificar);
        buttonEliminar = (Button) findViewById(R.id.buttonEliminar);


        //boton que eliminara al apretar
        buttonEliminar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Eliminar(id);
                onBackPressed();//vuelvo hacia atras
            }
        });



        //boton que modificara al apretar
        buttonModificar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Modificar(id,campoNombre.getText().toString(),campoApellido.getText().toString());
                onBackPressed();//vuelvo hacia atras
            }
        });
    }

    private  void Modificar(int Id, String Nombre, String Apellido){


        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        //DEBERIA PONER UN TRY CATCH LUEGO

        String sql ="update Personas set Nombre='"+Nombre+"',Apellido='"+Apellido+"'where Id="+Id;
        db.execSQL(sql);
        db.close();
    }

    //Elimino

    private  void Eliminar(int Id){


        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        //DEBERIA PONER UN TRY CATCH LUEGO

        String sql ="delete from Personas where Id="+Id;
        db.execSQL(sql);
        db.close();
    }
}
