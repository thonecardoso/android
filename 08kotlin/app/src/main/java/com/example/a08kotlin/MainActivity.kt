package com.example.a08kotlin

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun requisicao(view: View?) {
        val textView = findViewById<View>(R.id.text) as TextView
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.loboguara.site/pdm2_aula1.php"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                textView.text = "Resposta: $response"
            }) { textView.text = "Algo deu errado!" }
        queue.add(stringRequest)
    }


    fun isNetwork(context: Context): Boolean {
        val cm = context
            .getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return if (netInfo != null && netInfo.isConnectedOrConnecting) {
            true
        } else false
    }
}