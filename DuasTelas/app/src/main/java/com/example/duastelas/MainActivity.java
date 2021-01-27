package com.example.duastelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Abrir(View view) {
        Toast.makeText(this,"Abrir OK",Toast.LENGTH_LONG).show();
        Intent i = new Intent(MainActivity.this, SegundaActivity.class);
        startActivity(i);
    }

    public void message(View view) {
        EditText edtName = findViewById(R.id.editName);
        String name = edtName.getText().toString();
        Toast.makeText(this, "Boa Noite " + name, Toast.LENGTH_SHORT).show();
    }

    public void mudar(View view) {
        EditText edtName = findViewById(R.id.editName);
        edtName.setText("mudou");

    }

    public void quadrado(View view) {
        EditText edtName = findViewById(R.id.editName);
        float numero = 0;
        try {
            numero = Float.parseFloat(edtName.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_LONG).show();
        }
        numero = numero * numero;
        if(numero>0){
            edtName.setText(String.valueOf(numero));
        }


    }
}
