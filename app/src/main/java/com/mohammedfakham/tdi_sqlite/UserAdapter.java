package com.mohammedfakham.tdi_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserAdapter {

    UserHelper userHelper;

    UserAdapter(Context context) {
        userHelper = new UserHelper(context);
    }

    public long ajouterUser(User user) {

        SQLiteDatabase db = userHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserHelper.NOM, user.getNom());
        contentValues.put(UserHelper.PRENOM, user.getPrenom());
        contentValues.put(UserHelper.AGE, user.getAge());

        return db.insert(UserHelper.TABLE_NAME, null, contentValues);
    }

    public long supprimerUser(String id) {

        SQLiteDatabase db = userHelper.getWritableDatabase();

        String [] whereArgs = {id};

        return db.delete(UserHelper.TABLE_NAME, "_id = ?", whereArgs);
    }

    public long modifierUser(User user) {

        SQLiteDatabase db = userHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(UserHelper.NOM, user.getNom());
        contentValues.put(UserHelper.PRENOM, user.getPrenom());
        contentValues.put(UserHelper.AGE, user.getAge());

        String [] whereArgs = {String.valueOf(user.getId())};

        return db.update(UserHelper.TABLE_NAME, contentValues, "_id = ?", whereArgs);
    }

    public ArrayList<User> listeUsers() {

        ArrayList<User> users = new ArrayList<>();

        SQLiteDatabase db = userHelper.getReadableDatabase();

        String [] columns = {"_id", UserHelper.NOM, UserHelper.PRENOM, UserHelper.AGE};

        Cursor cursor = db.query(UserHelper.TABLE_NAME, columns, null, null, null, null, null);

        while (cursor.moveToNext()) {

            long id = cursor.getLong(cursor.getColumnIndex("_id"));
            String nom = cursor.getString(cursor.getColumnIndex(UserHelper.NOM));
            String prenom = cursor.getString(cursor.getColumnIndex(UserHelper.PRENOM));
            int age = cursor.getInt(cursor.getColumnIndex(UserHelper.AGE));

            users.add(new User(id, nom, prenom, age));
        }

        cursor.close();

        return users;
    }

}
