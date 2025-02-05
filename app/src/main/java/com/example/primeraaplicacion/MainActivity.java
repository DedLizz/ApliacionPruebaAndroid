package com.example.primeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        //evento click del boton
        btnSaludar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                tvSaludo.setText("Hola " + nombre);
            }
        });
    }
}