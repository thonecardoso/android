package com.example.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AlunoDbHelper extends SQLiteOpenHelper {



    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE aluno ( " +
                    " _id integer primary key autoincrement, " +
                    " nome TEXT )";


    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS alunos";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "aluno.db";
    public static final String TABLE_NAME = "aluno";
    public AlunoDbHelper(Context context){
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
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

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }

    /**
     * Getting user data from database
     * */
    public List<Datas> getUserSLDetails() {

        String selectQuery = "SELECT * FROM aluno";
        List<Datas>  mMemberDetails =  new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {

            while (cursor.moveToNext()) {

                Datas pMemebr = new Datas();

                pMemebr.setId(cursor.getInt(0));
                pMemebr.setName(cursor.getString(1));


                mMemberDetails.add(pMemebr);
                Log.d("Dados DB", pMemebr.getName());
            }
        }
        else{
            Log.d("Dados DB", "DB is empty");
        }
        cursor.close();
        db.close();

        return mMemberDetails;

    }

    public ArrayList<String> getAdapter() {

        String selectQuery = "SELECT * FROM aluno";
        ArrayList<String>  mMemberDetails =  new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = String.valueOf(cursor.getInt(0));
                String pMemebr = cursor.getString(1);

                //pMemebr.setId(cursor.getInt(0));
                //pMemebr.setName(cursor.getString(1));


                mMemberDetails.add(id + " " + pMemebr);
                Log.d("DEPURADOR", "ALUNO:  " + pMemebr.toString());
            }
        }
        else{
            Log.d("DEPURADOR", "NADA NO DB!");
        }
        cursor.close();
        db.close();

        return mMemberDetails;

    }


}
