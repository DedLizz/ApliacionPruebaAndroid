package com.example.primeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la interfaz grafica
        EditText etNombre = findViewById(R.id.etNombre);
        Button btnSaludar = findViewById(R.id.btnSaludar);
        TextView tvSaludo = findViewById(R.id.tvSaludo);

        // Referencia al boton de la segunda actividad
        Button btnIrTabla = findViewById(R.id.idBtnTabla);
        // Referencia al boton de la tercera actividad
        Button btnIrTabla2 = findViewById(R.id.idBtnTabla2);

        //evento click del boton para mandar mensaje
        btnSaludar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                tvSaludo.setText("Hola " + nombre);
            }
        });

        //evento click del boton para mostrar el segundo actividad
        btnIrTabla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        //eveto clic del boton "TABLA 2" para mostrar la actividad activity_tercera
        btnIrTabla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TerceraActivity.class);
                startActivity(intent);
            }
        });


    }
}