package com.taylorandtucker.jot.localdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.taylorandtucker.jot.localdb.EntriesContract.ContractEntries;

/**
 * Created by Taylor on 9/16/2015.
 */
public class EntryDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1; //update this if schema/ContractEntries changes
    public static final String DATABASE_NAME = "JotEntries.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + ContractEntries.TABLE_NAME + " (" +
                ContractEntries._ID + " INTEGER PRIMARY KEY," +
                ContractEntries.COLUMN_DATE + TEXT_TYPE + COMMA_SEP +
                ContractEntries.COLUMN_BODY + TEXT_TYPE + COMMA_SEP +
                ContractEntries.COLUMN_SENTIMENT + TEXT_TYPE +
        " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ContractEntries.TABLE_NAME;

    public EntryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}