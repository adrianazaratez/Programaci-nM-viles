package com.example.adriana.sesion5;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class ActivityMain extends AppCompatActivity {

    EditText nombre;
    EditText telefono;
    Spinner spinner;
    AutoCompleteTextView textView;
    Alumnos alumnos;
    RadioButton generoM;
    RadioButton generoF;
    String gender;
    AutoCompleteTextView libro;
    CheckBox deporte;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.main_layout_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.escolaridad,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        textView = findViewById(R.id.activity_main_libros);
        String[] libros = getResources().getStringArray(R.array.libros);
        ArrayAdapter<String> adapterLib = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,libros);
        textView.setAdapter(adapterLib);


        nombre = findViewById(R.id.activity_main_nombre);
        telefono = findViewById(R.id.activity_main_telefono);
        generoM = findViewById(R.id.activity_main_masc);
        generoF = findViewById(R.id.activity_main_fem);
        libro = findViewById(R.id.activity_main_libros);
        deporte = findViewById(R.id.activity_main_deporte);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.activity_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.activity_menu_save:
                guardar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void cleanOnClick(View v){
        createDialog();
    }

    public void radioSelected(View v){
        boolean selected = ((RadioButton)v).isChecked();
    }

    public void guardar(){
        int x;

        if(generoM.isChecked()){
            gender = "masculino";
        }else {
            gender = "femenino";
        }

        if(deporte.isChecked()) {
            x = 1;
        }else {
            x = 0;
        }
        alumnos = new Alumnos(nombre.getText().toString(),telefono.getText().toString(),spinner.getSelectedItem().toString(),gender,libro.getText().toString(),x);
        Toast.makeText(this, alumnos.toString(), Toast.LENGTH_LONG).show();
    }

   public void createDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(ActivityMain.this);
        dialog.setMessage("¿Desea limpiar el contenido?").setCancelable(true).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                nombre.setText(null);
                telefono.setText(null);
                spinner.setSelection(0);
                generoF.setChecked(true);
                generoM.setChecked(false);
                libro.setText(null);
                deporte.setChecked(false);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert = dialog.create();
        alert.show();
   }

}
