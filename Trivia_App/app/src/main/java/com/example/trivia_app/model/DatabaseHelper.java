package com.example.trivia_app.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "users_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserAnswersModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UserAnswersModel.TABLE_NAME);

        onCreate(db);
    }

    public long insertUser(UserAnswersModel user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserAnswersModel.COLUMN_NAME, user.getName());
        values.put(UserAnswersModel.COLUMN_NAME, user.getName());
        values.put(UserAnswersModel.COLUMN_BEST_CRICKETER, user.getBestCricketer());
        values.put(UserAnswersModel.COLUMN_COLORS_IN_FLAG,user.getColorsInFlag());

        long id = db.insert(UserAnswersModel.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public List<UserAnswersModel> getAllUsers() {
        List<UserAnswersModel> users = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + UserAnswersModel.TABLE_NAME + " ORDER BY " +
                UserAnswersModel.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UserAnswersModel userAnswersModel = new UserAnswersModel();
                userAnswersModel.setId(cursor.getInt(cursor.getColumnIndex(UserAnswersModel.COLUMN_ID)));
                userAnswersModel.setName(cursor.getString(cursor.getColumnIndex(UserAnswersModel.COLUMN_NAME)));
                userAnswersModel.setTimestamp(cursor.getString(cursor.getColumnIndex(UserAnswersModel.COLUMN_TIMESTAMP)));
                userAnswersModel.setBestCricketer(cursor.getString(cursor.getColumnIndex(UserAnswersModel.COLUMN_BEST_CRICKETER)));
                userAnswersModel.setColorsInFlag(cursor.getString(cursor.getColumnIndex(UserAnswersModel.COLUMN_COLORS_IN_FLAG)));

                users.add(userAnswersModel);
            } while (cursor.moveToNext());
        }

        cursor.close();

        db.close();

        return users;
    }
}
