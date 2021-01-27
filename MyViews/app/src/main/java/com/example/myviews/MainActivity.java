package com.example.myviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter;
        adapter = ArrayAdapter.createFromResource(this,
                R.array.planets, android.R.layout.simple_spinner_item);
        spin.setAdapter(adapter);

        AdapterView.OnItemSelectedListener choice = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = spin.getSelectedItem().toString();
                TextView txt = findViewById(R.id.textView2);
                txt.setText(str);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        spin.setOnItemSelectedListener(choice);

        Switch sw = (Switch) findViewById(R.id.switch1);
        if(sw.isChecked()){
            sw.setText("ON");
        }else{
            sw.setText("OFF");
        }





    }

    public void botaoB(View view) {
        TextView txt = findViewById(R.id.textView2);
        txt.setText("BBB");
    }

    public void botaoA(View view) {
        TextView txt = findViewById(R.id.textView2);
        txt.setText("AAA");
    }


    public void swclick(View view) {
        Switch sw = (Switch) findViewById(R.id.switch1);
        if(sw.isChecked()){
            sw.setText("ON");
        }else{
            sw.setText("OFF");
        }
    }

    public void rad(View view) {
//        RadioButton rd1 = findViewById(R.id.radioButton);
//        RadioButton rd2 = findViewById(R.id.radioButton2);
//        if(rd1.isSelected()){
//            TextView txt = findViewById(R.id.textView2);
//            txt.setText("RADIO A");
//        }else if(rd2.isSelected()){
//            TextView txt = findViewById(R.id.textView2);
//            txt.setText("RADIO B");
//        }

        RadioGroup radiog = findViewById(R.id.radioGroup);

        radiog.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                Log.d("thone", "clicou");
                RadioButton rd1 = findViewById(R.id.radioButton);
                RadioButton rd2 = findViewById(R.id.radioButton2);
                if(rd1.isChecked()){
                    TextView txt = findViewById(R.id.textView2);
                    txt.setText("RADIO A");
                }else if(rd2.isChecked()){
                    TextView txt = findViewById(R.id.textView2);
                    txt.setText("RADIO B");
                }
            }
        });


    }
}
