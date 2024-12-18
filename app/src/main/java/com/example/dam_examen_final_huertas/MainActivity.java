package com.example.dam_examen_final_huertas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Definir el evento click sobre el botón Login
        btnLogin = findViewById(R.id.buttoningresar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NotasActivity.class);
                startActivity(i);
            }

        });

        // Configuración del Spinner
        Spinner spinnerTipoDocumento = findViewById(R.id.spinnerTipoDocumento);

        // Opciones para el Spinner
        String[] opciones = {"DNI", "Carnet de extranjería", "Pasaporte"};

        // Configurando el adaptador para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, opciones);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoDocumento.setAdapter(adapter);

        // Listener para manejar la selección del usuario
        spinnerTipoDocumento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Seleccionaste: " + seleccion, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Código opcional si no se selecciona nada
            }
        });
    }
}
