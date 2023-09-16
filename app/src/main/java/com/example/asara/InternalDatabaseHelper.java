package com.example.asara;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InternalDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase";
    private static final int DATABASE_VERSION = 1;

    public InternalDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your user credentials table here if not already created.
        // Example: CREATE TABLE IF NOT EXISTS UserCredentials (
        //     Username TEXT PRIMARY KEY,
        //     Password TEXT NOT NULL
        // );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }

    public boolean verifyUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {"Username", "Password"};
        String selection = "Username = ? AND Password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query("UserCredentials", projection, selection, selectionArgs, null, null, null);
        boolean isValid = cursor.moveToFirst();
        cursor.close();
        db.close();

        return isValid;
    }
}
