package com.example.jains.loginpage;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DB_Name="Login";
    private static final int DB_Version=1;
    DatabaseHelper(Context context)
    {
        super(context,DB_Name,null,DB_Version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE Details ( " +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    "Fullname TEXT, " +
                    "EmailId TEXT, " +
                    "Password TEXT) ");

        insertDetails(db,"Shreyansh","jain.shrey@gmail.com","password");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static void insertDetails(SQLiteDatabase db,String name,String email_id,String password)
    {

        ContentValues cv=new ContentValues();
        cv.put("Fullname",name);
        cv.put("EmailId",email_id);
        cv.put("Password",password);
        //cv.put("Mobile-No.",mob_no);

        db.insert("Detail",null,cv);
    }

    public void writeDetails(String name,String e_id,String pass)
    {
        SQLiteDatabase db=getWritableDatabase();
        insertDetails(db,name,e_id,pass);
    }

    public List<Details> getDetails()
    {
        try {
            SQLiteDatabase db = getReadableDatabase();

            List<Details> d = new ArrayList<Details>();
            String selquery = "SELECT * FROM Details";
            Cursor cursor = db.rawQuery(selquery, null);

            if (cursor.moveToFirst()) {
                do {
                    Details de = new Details();
                    de.username = cursor.getString(0);
                    de.email_id = cursor.getString(1);
                    de.password = cursor.getString(2);

                    d.add(de);
                } while (cursor.moveToNext());
            }
            return d;
        }
        catch(SQLiteException e)
        {
            e.getMessage();
        }
        return null;
    }
}
