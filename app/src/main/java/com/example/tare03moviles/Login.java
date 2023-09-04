package com.example.tare03moviles;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Login extends AppCompatActivity {
    private EditText usuarioEditText;
    private EditText contraseñaEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usuarioEditText = findViewById(R.id.usuarioText);
        contraseñaEditText = findViewById(R.id.contraText);
        loginButton = findViewById(R.id.btnlogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = usuarioEditText.getText().toString();
                String contraseña = contraseñaEditText.getText().toString();

                // Aquí deberías realizar la lógica de verificación de inicio de sesión
                if (validarCredenciales(usuario, contraseña)) {
                    // Inicio de sesión exitoso, muestra un mensaje de éxito
                    Toast.makeText(Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    // Redirige al usuario a la pantalla principal
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Opcional: para cerrar la actividad de inicio de sesión
                } else {
                    // Inicio de sesión fallido, muestra un mensaje de error
                    Toast.makeText(Login.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Esta función simula la validación de las credenciales del usuario
    private boolean validarCredenciales(String usuario, String contraseña) {
        return (usuario.equals("juan") && contraseña.equals("123")) ||
                (usuario.equals("lucia") && contraseña.equals("123"));
    }
}