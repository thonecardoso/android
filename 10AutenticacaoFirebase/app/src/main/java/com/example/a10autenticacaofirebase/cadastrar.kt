package com.example.a10autenticacaofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class cadastrar : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)
        mAuth = FirebaseAuth.getInstance() //inicializar
    }

    fun registrar(view: View){
        var edte = findViewById<EditText>(R.id.editNome)
        var edtp = findViewById<EditText>(R.id.editSenha)
        var email = edte.text.toString()
        var password = edtp.text.toString()
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task ->
                if(task.isSuccessful()){
                    imprimir("cadastrar: OK:")
                } else{
                    imprimir("cadastrar: Falha:" + task.exception)
                }

        }
    }

    private fun imprimir(s: String) {
        var saida = findViewById<TextView>(R.id.txtsaida)
        saida.append("\n" + s)
    }
}