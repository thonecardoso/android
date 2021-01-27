package com.example.a01requisicaosimples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetwork(getApplicationContext())){
            Toast.makeText(getApplicationContext(), "Internet Connected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Internet Is Not Connected", Toast.LENGTH_SHORT).show();
        }
    }

    public void requisicao(View view){
// text view onde serão exibidos os resultados
        final TextView textView = (TextView) findViewById(R.id.text);
// Instanciar o RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
// endereço para acessar na web
        String url ="https://www.loboguara.site/pdm2_aula1.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
// exibir a resposta dentro do textview

                        textView.setText("Resposta: "+ response.toString());

                    }
                }, new Response.ErrorListener() {
            // em caso de erro
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Algo deu errado!");
            }
        });
// adicionar a requisicao na file de requisições e rodar.
        queue.add(stringRequest);
    }// fim

    public boolean isNetwork(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }


}
