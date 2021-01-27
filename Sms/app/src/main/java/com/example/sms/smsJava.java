package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class smsJava extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_java);
    }



    public void smsJava(View v){
        if(ContextCompat.checkSelfPermission(smsJava.this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    1);
            return;
        }
        EditText edtNumero = (EditText) findViewById(R.id.editText);
        EditText edtSMS = (EditText) findViewById(R.id.editText2);
        String numero = edtNumero.getText().toString();
        String sms = edtSMS.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numero,null,sms,null,null);
            Toast.makeText(getApplicationContext(),"SMS Enviado:",
                    Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),
                    "Falha ao enviar SMS, tente mais tarde",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
