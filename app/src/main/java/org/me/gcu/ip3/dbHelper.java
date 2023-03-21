package org.me.gcu.ip3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
        String createTableStatement = "CREATE TABLE " + USR_TBL + " (" + ID_FIELD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FNAME_FIELD + " TEXT, " + SNAME_FIELD + " TEXT, " + USRNME_FIELD + " TEXT, " + PSWRD_FIELD + " TEXT, " + EMAIL_FIELD + " TEXT)";

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

        if(insert == -1){
            return false;
        } else {
            return true;
        }
    }
}
