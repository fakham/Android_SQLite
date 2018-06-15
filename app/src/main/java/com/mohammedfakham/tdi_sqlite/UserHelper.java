package com.mohammedfakham.tdi_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class UserHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "myDatabase";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Users";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String AGE = "age";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "+NOM+" VARCHAR(255), "+PRENOM+" VARCHAR(255), "+AGE+" INTEGER)";
    private static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;

    UserHelper(Context context) {
        this(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    UserHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Toast.makeText(context, "Erreur : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "onUpgrade : " + DATABASE_NAME, Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Toast.makeText(context, "Erreur : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
