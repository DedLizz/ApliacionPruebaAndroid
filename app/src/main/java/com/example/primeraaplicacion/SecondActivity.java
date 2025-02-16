package com.example.primeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.primeraaplicacion.controller.UsuarioController;
import com.example.primeraaplicacion.model.Usuario;

public class SecondActivity extends AppCompatActivity {

    private EditText textInputNombre, textInputApellido, textInputEmail;
    private TableLayout tableLayout;
    private UsuarioController usuarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //referencia al TextView en activity_second.xml
        TextView textDosMensaje = findViewById(R.id.textDosMensaje);
        textDosMensaje.setText("Bienvenido a la segunda actividad");


        // ! logíca de la tabla
        usuarioController = new UsuarioController();
        tableLayout = findViewById(R.id.tableLayout2);
        textInputNombre = findViewById(R.id.textInputNombre2);
        textInputApellido = findViewById(R.id.textInputApellido2);
        textInputEmail = findViewById(R.id.textInputCorreo2);
        Button btnAgregar = findViewById(R.id.btnGrabar2);

        // ! Agregar usuario cuando el botón sea presionado
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nombre = textInputNombre.getText().toString();
                    String apellido = textInputApellido.getText().toString();
                    String email = textInputEmail.getText().toString();

                    if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
                        Toast.makeText(SecondActivity.this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
                    } else {
                        // Crear al usuario
                        Usuario usuario = new Usuario(0, nombre, apellido, email);

                        // Agregar el usuario al controlador
                        usuarioController.agregarUsuario(usuario);

                        // Limpiar los campos de Entrada
                        textInputNombre.setText("");
                        textInputApellido.setText("");
                        textInputEmail.setText("");

                        // Mostrar los usuarios actualizados en la tabla
                        mostrarUsuarios();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(SecondActivity.this, "Ocurrió un error al guardar el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // ! Metodo para mostrar los usuarios en la tabla
    private void mostrarUsuarios(){
        tableLayout.removeAllViews();

        TableRow header = new TableRow(this);
        header.addView(createTextView("ID"));
        header.addView(createTextView("Nombre"));
        header.addView(createTextView("Apellido"));
        header.addView(createTextView("Email"));
        tableLayout.addView(header);

        // ! Mostrar cada usuario en la tabla
        for(Usuario usuario : usuarioController.getUsuarios()){
            TableRow row = new TableRow(this);
            row.addView(createTextView(String.valueOf(usuario.getId())));
            row.addView(createTextView(usuario.getNombre()));
            row.addView(createTextView(usuario.getApellido()));
            row.addView(createTextView(usuario.getEmail()));
            tableLayout.addView(row);
        }
    }

    private TextView createTextView(String text) {
        TextView textView = new TextView(this);  // Crea una nueva instancia de TextView
        textView.setText(text);  // Establece el texto que se mostrará en el TextView
        textView.setPadding(8, 8, 8, 8);  // Establece el relleno (padding) en los 4 lados del TextView
        return textView;  // Devuelve el TextView configurado
    }
}