package com.example.mydatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public DbHandler(Context context){
        super(context,"Example",null,2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql_table= "CREATE TABLE students(fname TEXT,lname TEXT,address TEXT,email TEXT);";
        db.execSQL(sql_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS students");
        onCreate(db);
    }

    public long insertStudent(String fname,String lname, String address,String email){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("fname",fname);
        values.put("lname",lname);
        values.put("address",address);
        values.put("email",email);
        return db.insert("students",null,values);
    }

    public String getData(){
        db=this.getReadableDatabase();
        String [] coloms = new String [] {"fname","lname","address","email"};
        Cursor cursor= db.query("students",coloms,null,null,null,null,null);
        int first =cursor.getColumnIndex("fname");
        int last =cursor.getColumnIndex("lname");
        int add =cursor.getColumnIndex("address");
        int iemail =cursor.getColumnIndex("email");
        String result="";

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            result= result+
                    "First Name:  "+cursor.getString(first)+ "\n"+
                    "Last Name:  "+cursor.getString(last)+ "\n"+
                    "Address:  "+cursor.getString(add)+ "\n"+
                    "Email:  "+cursor.getString(iemail)+ "\n";
        }
        db.close();
        return result;
    }
}
