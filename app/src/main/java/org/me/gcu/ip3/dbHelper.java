package org.me.gcu.ip3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dbHelper extends SQLiteOpenHelper {

    public static final String USR_TBL = "USER_TABLE";
    public static final String FNAME_FIELD = "FNAME";
    public static final String SNAME_FIELD = "SURNAME";
    public static final String USRNME_FIELD = "USERNAME";
    public static final String PSWRD_FIELD = "PASSWORD";
    public static final String EMAIL_FIELD = "EMAIL";
    public static final String ID_FIELD = "ID";

    public dbHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    //Called first time db is called, this method creates a new db
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USR_TBL + " (" + ID_FIELD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FNAME_FIELD + " TEXT, " + SNAME_FIELD + " TEXT, " + USRNME_FIELD + " TEXT UNIQUE, " + PSWRD_FIELD + " TEXT, " + EMAIL_FIELD + " TEXT)";

        db.execSQL(createTableStatement);
    }

    //Called when version number changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean addOne(sqlConnect sqlConnect){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(FNAME_FIELD, sqlConnect.getFirname());
        cv.put(SNAME_FIELD, sqlConnect.getSurname());
        cv.put(USRNME_FIELD, sqlConnect.getUsername());
        cv.put(PSWRD_FIELD, sqlConnect.getPassword());
        cv.put(EMAIL_FIELD, sqlConnect.getEmail());



        long insert = db.insert(USR_TBL, null, cv);
        Log.d("insert value", "value = "+insert);
        if(insert == -1){db.close();
            return false;
        } else {
            db.close();
            return true;
        }

    }

    public List<sqlConnect> checkUsrnme(){

        List<sqlConnect> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + USR_TBL;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()){
            //loop through results
            do {
                int usrID = cursor.getInt(0);
                String fname =cursor.getString(1);
                String sname = cursor.getString(2);
                String usrName = cursor.getString(3);
                String email = cursor.getString(5);

                sqlConnect sql = new sqlConnect(usrID, fname, sname, usrName, "null", email);
                returnList.add(sql);

            } while (cursor.moveToNext());
        } else { }
        cursor.close();
        db.close();
        return returnList;
    }
}