package com.example.trivia_app.model;

import java.io.Serializable;

public class UserAnswersModel implements Serializable {

    public static final String TABLE_NAME = "user_answers";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_BEST_CRICKETER = "bestCricketer";
    public static final String COLUMN_COLORS_IN_FLAG = "colorsInFlag";

    private int id;
    private String name;
    private String timestamp;
    private String bestCricketer;
    private String colorsInFlag;

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP,"
                    + COLUMN_BEST_CRICKETER + " TEXT,"
                    + COLUMN_COLORS_IN_FLAG + " TEXT"
                    + ")";

    public UserAnswersModel() {
    }

    public UserAnswersModel(int id, String name, String timestamp, String bestCricketer, String colorsInFlag) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
        this.bestCricketer = bestCricketer;
        this.colorsInFlag = colorsInFlag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBestCricketer() {
        return bestCricketer;
    }

    public void setBestCricketer(String bestCricketer) {
        this.bestCricketer = bestCricketer;
    }

    public String getColorsInFlag() {
        return colorsInFlag;
    }

    public void setColorsInFlag(String colorsInFlag) {
        this.colorsInFlag = colorsInFlag;
    }
}
