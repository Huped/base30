package com.example.basededatos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.basededatos2.modelo.Articulo;

import java.sql.ResultSet;

public class MainActivity2 extends AppCompatActivity {

    private EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10;
    private RadioButton rd1, rd2, rd3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = (EditText) findViewById(R.id.editTextTextPersonName10);
        et2 = (EditText) findViewById(R.id.editTextTextPersonName);
        et3 = (EditText) findViewById(R.id.editTextTextPersonName2);
        et4 = (EditText) findViewById(R.id.editTextTextPersonName3);
        et5 = (EditText) findViewById(R.id.editTextTextPersonName6);
        et6 = (EditText) findViewById(R.id.editTextTextPersonName7);
        et7 = (EditText) findViewById(R.id.editTextTextPersonName8);
        et8 = (EditText) findViewById(R.id.editTextTextPersonName9);
        et9 = (EditText) findViewById(R.id.editTextTextPersonName13);
        et10 = (EditText) findViewById(R.id.editTextTextPersonName15);
        rd1 = (RadioButton) findViewById(R.id.rbutton1);
        rd2 = (RadioButton) findViewById(R.id.rbutton2);
        rd3 = (RadioButton) findViewById(R.id.rbutton3);
    }

    public void Buscar(View view) {
        String codigo = et1.getText().toString();
        System.out.println(codigo);

        String desc = et2.getText().toString();

        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
        et7.setText("");
        et8.setText("");
        et9.setText("");
        et10.setText("");

        if (rd1.isChecked()==true) {

            System.out.println(" Entra en el buscar, antes de abrir el hilo 1");

            com.example.basededatos2.Hilo1 proceso = new com.example.basededatos2.Hilo1(codigo);

            proceso.start();

            try {
                proceso.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            Articulo xarti = proceso.getxArticulo();

            System.out.println("**** CODIGO *** " + xarti.getCodigo());
            System.out.println("**** DESCRI *** " + xarti.getDescri());
            System.out.println("**** BARRA *** " + xarti.getBarra());

            if (xarti.getCodigo() == null) {
                Context context = getApplicationContext();
                CharSequence text = "ARTICULO NO ENCONTRADO";
                Toast.makeText(context, "Articulo no encontrado", Toast.LENGTH_LONG).show();
            } else {
                System.out.println(xarti);
                et2.setText(xarti.getCodigo());
                et2.setText(xarti.getDescri());
                et3.setText(String.valueOf(xarti.getPreven()));
                et4.setText(String.valueOf(xarti.getStock1()));
                et5.setText(String.valueOf(xarti.getGrupo()));
                et6.setText(String.valueOf(xarti.getCospro()));
                et7.setText(String.valueOf(xarti.getPreve2()));
                et8.setText(String.valueOf(xarti.getPreve3()));
                et9.setText(xarti.getBarra());
                et10.setText(String.valueOf(xarti.getStock2()));
            }
        } else if (rd2.isChecked()==true){
            System.out.println(" Entra en el buscar, antes de abrir el hilo 2 ***");

            com.example.basededatos2.Hilo2 proceso = new com.example.basededatos2.Hilo2(codigo);

            proceso.start();

            try {
                proceso.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            Articulo xarti = proceso.getxArticulo();

            System.out.println("**** CODIGO *** " + xarti.getCodigo());
            System.out.println("**** DESCRI *** " + xarti.getDescri());
            System.out.println("**** BARRA *** " + xarti.getBarra());

            if (xarti.getCodigo() == null) {
                Context context = getApplicationContext();
                CharSequence text = "ARTICULO NO ENCONTRADO";
                Toast.makeText(context, "Articulo no encontrado", Toast.LENGTH_LONG).show();
            } else {
                System.out.println(xarti);
                et2.setText(xarti.getDescri());
                et3.setText(String.valueOf(xarti.getPreven()));
                et4.setText(String.valueOf(xarti.getStock1()));
                et5.setText(String.valueOf(xarti.getGrupo()));
                et6.setText(String.valueOf(xarti.getCospro()));
                et7.setText(String.valueOf(xarti.getPreve2()));
                et8.setText(String.valueOf(xarti.getPreve3()));
                et9.setText(xarti.getBarra());
                et10.setText(String.valueOf(xarti.getStock2()));
            }

        }
    }
}
