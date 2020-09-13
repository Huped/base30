package com.example.basededatos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CArticulos(View view){
        Intent siguiente = new Intent(this, MainActivity2.class);
        startActivity(siguiente);
    }
    public void CClientes(View view){
        Intent siguiente = new Intent(this, MainActivity3.class);
        startActivity(siguiente);
    }
}