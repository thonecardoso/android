package com.example.a04updatefiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    //https://www.learn2crack.com/2017/08/upload-image-using-retrofit.html

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void act_enviar(View view) {
        Intent intent = new Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Escolha:"), 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 123 && resultCode == RESULT_OK) {
            Uri selectedfile = data.getData();
            String arquivo = tempfile(selectedfile);
            upload(arquivo);
        }
    }

    public void upload(String arquivo){
        ProgressBar pb = findViewById(R.id.progresso);
        pb.setVisibility(View.VISIBLE);
        File file = new File(arquivo);
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"),
                file);
        MultipartBody.Part fileToUpload =
                MultipartBody.Part.createFormData("arquivo", file.getName(),
                        requestBody);
        RequestBody filename =
                RequestBody.create(MediaType.parse("text/plain"), file.getName());
        ApiConfig getResponse =
                AppConfig.getRetrofit().create(ApiConfig.class);
        Call call = getResponse.uploadFile(fileToUpload, filename);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                ServerResponse serverResponse = (ServerResponse) response.body();
                if (serverResponse != null) {

                    if (serverResponse.getSuccess()) {
                        Toast.makeText(getApplicationContext(),
                                serverResponse.getMessage(),Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                serverResponse.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                } else {
                    assert serverResponse != null;
                    Log.v("Response", serverResponse.toString());
                }
                ProgressBar pb = findViewById(R.id.progresso);
                pb.setVisibility(View.GONE);
            }
            @Override
            public void onFailure(Call call, Throwable t) {
            }
        });
    }

    private String tempfile(Uri contentUri) {
        String retorno = "";
        try {
            String extensao = "." +
                    getContentResolver().getType(contentUri).split("/")[1];
            File outputDir = getCacheDir();
            File outputFile = File.createTempFile("upload", extensao, outputDir);
            retorno = outputFile.getAbsolutePath();
            OutputStream out = new FileOutputStream(outputFile);
            InputStream in = getContentResolver().openInputStream(contentUri);
//copiar
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close(); in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retorno;
    }
}