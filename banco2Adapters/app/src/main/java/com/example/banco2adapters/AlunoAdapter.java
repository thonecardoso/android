package com.example.banco2adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AlunoAdapter extends BaseAdapter {

    List<Aluno> _dados;
    LayoutInflater _mInflater;
    AlunoAdapter(List<Aluno> alunos, Context context){
        _dados = alunos;
        _mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return _dados.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = _mInflater.inflate(R.layout.aluno_layout, null);
        }

        Aluno a = _dados.get(position);
        final TextView txtId = (TextView) convertView.findViewById(R.id.textViewId);
        final TextView txtNome = (TextView) convertView.findViewById(R.id.textViewNome);

        txtId.setText(String.valueOf(a.get_id()));
        txtNome.setText(a._nome);
        return convertView;
    }
}
