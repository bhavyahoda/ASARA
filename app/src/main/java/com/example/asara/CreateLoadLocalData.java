package com.example.asara;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CreateLoadLocalData extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase";
    private static final int DATABASE_VERSION = 1;
    private Context context;
    //Context context;

    public CreateLoadLocalData(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public CreateLoadLocalData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // No specific tables are created here.
        // Tables should be created dynamically using the createTable method.
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed
    }

    public void createTable(String tableName, String schema) {
        SQLiteDatabase db = this.getWritableDatabase();
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + schema + ");";
        db.execSQL(createTableQuery);
        db.close();
    }

    public void insertData(String tableName, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(tableName, null, values);
        db.close();
    }

    public void createAndInsertAnimalTable() {
        SQLiteDatabase db = this.getWritableDatabase();

        // List of SQL file resource IDs
        int[] sqlFileResourceIds = { R.raw.animals_data, R.raw.ambulence_data,R.raw.animalcasehistory,R.raw.facilitydetails
                ,R.raw.registeredcases,R.raw.statusdetails,R.raw.treatmentoptions,R.raw.users_data,R.raw.vetdetails,R.raw.vetfacilitymap,R.raw.vetfacilityreview}; // Add more SQL file resource IDs if needed

        try {
            for (int resourceId : sqlFileResourceIds) {
                // Open and read the SQL file from the raw resources
                InputStream inputStream = context.getResources().openRawResource(resourceId);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder queryBuilder = new StringBuilder();
                String line;

                // Read SQL statements line by line
                while ((line = bufferedReader.readLine()) != null) {
                    queryBuilder.append(line);
                    queryBuilder.append("\n");
                }

                // Execute the SQL statements
                String sqlStatements = queryBuilder.toString();
                db.execSQL(sqlStatements);

                // Close resources
                bufferedReader.close();
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        db.close();
    }

    public Cursor readAnimalData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                "AnimalID",
                "Name",
                "Species",
                "Breed",
                "DateOfBirth"
        };

        Cursor cursor = db.query(
                "Animal",
                projection,
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }
}
