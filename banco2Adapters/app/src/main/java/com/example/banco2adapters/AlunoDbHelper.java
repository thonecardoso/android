package com.example.banco2adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AlunoDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE aluno ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS aluno";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "aluno.db";
    private static final String TABLE_NAME = "alunos";

    public AlunoDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public List<Aluno> getAllAlunos(){
        List<Aluno> arrayAlunos = new ArrayList<Aluno>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM alunos", null);

        cursor.moveToFirst();
        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                Aluno aluno = new Aluno(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("nome")));
                arrayAlunos.add(aluno);
                Log.d("SQLite aluno: ", String.valueOf(aluno.get_id()) + " " + aluno.get_nome());
            }
        }else{
            Log.d("Data Base Empty",null);
        }

        return arrayAlunos;
    }

    public long setAluno(Aluno aluno){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", aluno.get_nome());

        long newRowId = db.insert(this.TABLE_NAME,"", values);

        return newRowId;
    }

}
