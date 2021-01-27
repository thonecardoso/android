package com.example.preferenciascompartilhadas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("IFTM", 0);
        String nomeOpc = pref.getString("nome", "");
        Boolean checkOpc = pref.getBoolean("check", true);
        int seekbOpc = pref.getInt("seekb", 25);
        int radiobOpc = pref.getInt("radiob", R.id.radio1);


        EditText txt1 = (EditText) findViewById(R.id.editText1);
        txt1.setText(nomeOpc);
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb1.setChecked(checkOpc);
        SeekBar sb1 = (SeekBar) findViewById(R.id.seekBar1);
        sb1.setProgress(seekbOpc);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg.check(radiobOpc);

    }

    public void salvar(View view) {

        SharedPreferences pref = getSharedPreferences("IFTM", 0);
        SharedPreferences.Editor editor = pref.edit();
        EditText txt1 = (EditText) findViewById(R.id.editText1);
        String nomeopc = txt1.getText().toString();
        editor.putString("nome", nomeopc);
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        Boolean checkopc = cb1.isChecked();
        editor.putBoolean("check", checkopc);
        SeekBar sb1 = (SeekBar) findViewById(R.id.seekBar1);
        int seekbopc = sb1.getProgress();
        editor.putInt("seekb", seekbopc);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        int radiobopc = rg.getCheckedRadioButtonId();
        editor.putInt("radiob", radiobopc);
        editor.commit();

        AlertDialog.Builder alertaMsg = new AlertDialog.Builder(this);
        alertaMsg.setTitle("Salvar Configurações");
        alertaMsg.setMessage("Operação realizada com sucesso!");
        alertaMsg.setIcon(R.drawable.ic_launcher_background);
        alertaMsg.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertaMsg.show();

    }
}
