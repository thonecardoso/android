package com.example.a02requestjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

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

        final TextView textView = (TextView) findViewById(R.id.text);
        String url = "https://loboguara.site/pdm2_aula2.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        textView.setText("Resposta: " + response.toString());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("Algo deu errado!");
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

    }

    public void showProgress(boolean exibir){
        ProgressBar pb = findViewById(R.id.progressBar);
        if(exibir){
            pb.setVisibility(View.VISIBLE);

        }else{
            pb.setVisibility(View.GONE);
        }
    }


    public boolean isNetwork(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public void login(View view) {

        showProgress(true);
        EditText tnome = findViewById(R.id.usuario);
        EditText tsenha = findViewById(R.id.senha);
        final TextView tresultado = findViewById(R.id.resultado);
        String url = "https://loboguara.site/api/usuario/login.php";
        JSONObject parametros = new JSONObject();

        try {
            parametros.put("nome", tnome.getText().toString());
            parametros.put("senha", tsenha.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, parametros, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        tresultado.setText("Resposta: " + response.toString());

                        showProgress(false);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        tresultado.setText("Algo deu errado!");

                        showProgress(false);
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

    }

    public void cadastrar(View view) {
        showProgress(true);
        EditText tnome = findViewById(R.id.usuario);
        EditText tsenha = findViewById(R.id.senha);
        final TextView tresultado = findViewById(R.id.resultado);
        String url = "https://loboguara.site/api/usuario/create.php";
        JSONObject parametros = new JSONObject();
        try {
            parametros.put("nome", tnome.getText().toString());
            parametros.put("senha", tsenha.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, url, parametros, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        tresultado.setText("Resposta: " + response.toString());

                        showProgress(false);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        tresultado.setText("Algo deu errado!");

                        showProgress(false);
                    }
                });
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

    }
}
