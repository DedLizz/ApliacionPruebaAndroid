package com.example.primeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.primeraaplicacion.controller.UsuarioController;
import com.example.primeraaplicacion.model.Usuario;

public class TerceraActivity extends AppCompatActivity {
    private EditText TextInputNombre2, TextInputApellido2, TextINputEmail;
    private TableLayout tableLayout2;
    private UsuarioController usuarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        // ! logíca de la tabla
        usuarioController = new UsuarioController();
        tableLayout2 = findViewById(R.id.tableLayout2);
        TextInputNombre2 = findViewById(R.id.textInputNombre2);
        TextInputApellido2 = findViewById(R.id.textInputApellido2);
        TextINputEmail = findViewById(R.id.textInputCorreo2);
        Button btnAgregar2 = findViewById(R.id.btnGrabar2);

        // ! Agregar usuario cuando el boton sea presionado
        btnAgregar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nombre = TextInputNombre2.getText().toString();
                    String apellido = TextInputApellido2.getText().toString();
                    String email = TextINputEmail.getText().toString();

                    if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
                        Toast.makeText(TerceraActivity.this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
                    } else {
                        // Crear al usuario
                        Usuario usuario = new Usuario(0, nombre, apellido, email);

                        // Agregar el usuario al controlador
                        usuarioController.agregarUsuario(usuario);

                        // Limpiar los campos de Entrada
                        TextInputNombre2.setText("");
                        TextInputApellido2.setText("");
                        TextINputEmail.setText("");

                        // Mostrar mensaje de éxito
                        Toast.makeText(TerceraActivity.this, "Usuario agregado con éxito", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(TerceraActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // ! Metodo para mostrar los usuarrios en la tabla
    private void mostrarUsuarios() {
        // Limpiar la tabla
        tableLayout2.removeAllViews();

        //Crear la fila de encabezado
        TableRow encabezado = new TableRow(this);
        encabezado.addView(createTextView("ID"));
        encabezado.addView(createTextView("Nombre"));
        encabezado.addView(createTextView("Apellido"));
        encabezado.addView(createTextView("Email"));
        tableLayout2.addView(encabezado);

        // !Mostrar cada usuario en la tabla
        for(Usuario usu: usuarioController.getUsuarios()){
            TableRow fila = new TableRow(this);
            fila.addView(createTextView(String.valueOf(usu.getId())));
            fila.addView(createTextView(usu.getNombre()));
            fila.addView(createTextView(usu.getApellido()));
            fila.addView(createTextView(usu.getEmail()));
            tableLayout2.addView(fila);
        }
    }

    private TextView createTextView(String text){
        TextView textView = new TextView(this);
        textView.setText(text);
        textView.setPadding(5, 5, 5, 5);
        return textView;
    }
}