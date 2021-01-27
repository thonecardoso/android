package com.example.banco2adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlunoDbHelper dbHelper = new AlunoDbHelper(getApplicationContext());
        dbHelper.setAluno(new Aluno("Thone"));
        List<Aluno> alunos = dbHelper.getAllAlunos();
        AlunoAdapter1 adapter = new AlunoAdapter1(this,R.layout.aluno_layout, dbHelper.getAllAlunos());
        ListView listView = (ListView) findViewById(R.id.listViewAlunos);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView texId = (TextView) view.findViewById(R.id.textViewId);
                TextView texNome = (TextView) view.findViewById(R.id.textViewNome);
                int pId = Integer.parseInt(texId.getText().toString());
                String pNome = texNome.getText().toString();
                Toast.makeText(getApplicationContext(),pNome, Toast.LENGTH_LONG).show();
                return true;

            }
        });
    }
}
