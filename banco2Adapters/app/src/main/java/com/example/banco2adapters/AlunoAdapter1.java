package com.example.banco2adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AlunoAdapter1 extends ArrayAdapter<Aluno> {

    private static final String TAG = "AdapterAluno";
    private Context mContext;
    int mResource;

    public AlunoAdapter1(@NonNull Context context, int resource, List<Aluno> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int id = getItem(position).get_id();
        String strId = String.valueOf(id);
        String nome = getItem(position).get_nome();

        Aluno aluno = new Aluno(id, nome);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvId = (TextView) convertView.findViewById(R.id.textViewId);
        TextView tvNome = (TextView) convertView.findViewById(R.id.textViewNome);

        tvId.setText(strId);
        tvNome.setText(nome);

        return convertView;

    }
}
