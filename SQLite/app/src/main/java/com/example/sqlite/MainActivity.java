package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AlunoDbHelper mDbHelper;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mDbHelper = new AlunoDbHelper(getApplicationContext());


    }

    public void adicionar(View v){
        //AlunoDbHelper mDbHelper = new AlunoDbHelper(getApplicationContext());

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        EditText edtName = (EditText) findViewById(R.id.edtName);
        String name = edtName.getText().toString();

        ContentValues values = new ContentValues();
        Log.d("EDT Text",name);
        values.put("nome", name);

        long newRowId = db.insert(mDbHelper.TABLE_NAME,"",values);

        edtName.setText(null);
        hideKeyboard(getApplicationContext(),edtName);
        if (newRowId == -1) {
            toast("Erro ao Cadastrar!");
        } else {
            toast("Cadastrado com Sucesso!");
        }


    }

    public void toast(String str){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, str, duration);
        toast.show();
    }

    public static void hideKeyboard(Context context, View editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }


    public void setSpinner(View view) {
        getData(view);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
    }

    public void getData(View view) {
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, mDbHelper.getAdapter());
    }
/*
    public void getData(View view) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = { "id", "nome"};

        String sortOrder = "nome DESC";

        Cursor c = db.query(
            FeedEntry.TABLE_NAME,
            projection,
            selection,
            selectionArgs,
            null,
                null,
                sortOrder

        );
    }*/
}
