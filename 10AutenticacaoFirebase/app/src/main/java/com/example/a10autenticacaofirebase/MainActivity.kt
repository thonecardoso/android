package com.example.a10autenticacaofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance() //inicializar
    }

    fun logar(view: View) {
        var edte = findViewById<EditText>(R.id.editNome)
        var edtp = findViewById<EditText>(R.id.editSenha)
        var email = edte.text.toString()
        var password = edtp.text.toString()
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task->
                if (task.isSuccessful) {
                    imprimir("login OK:")
                } else {
                    imprimir("login Falha:" + task.getException())
                }
            atualizarUI()
        }

    }

    private fun atualizarUI() {
        var user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            var nome = user.getDisplayName()
            var email = user.getEmail()
            imprimir("usuario: " + nome +":"+email)
        } else {
            imprimir("Faça Login")
        }
    }

    fun cadastrar(view: View) {
        val intent = Intent(this, cadastrar::class.java).apply{}
        startActivity(intent)
    }
    fun sair(view: View) {
        mAuth.signOut()
    }

    private fun imprimir(s: String) {
        var saida = findViewById<TextView>(R.id.txtsaida)
        saida.append("\n" + s)
    }
}