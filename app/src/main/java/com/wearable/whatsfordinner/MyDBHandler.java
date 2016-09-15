package com.wearable.whatsfordinner;

import android.content.ClipData;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "WhatsForDinner.db";
    public static final String TABLE_DISHES = "dishes";
    public static final String COLUMN_RECIPENAME = "recipename";
    //public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_ITEM1 = "item1";
    //public static final String COLUMN_QUANTITY1= "quantity1";
    //public static final String COLUMN_UNIT1 = "unit1";
    public static final String COLUMN_ITEM2 = "item2";
    //public static final String COLUMN_QUANTITY2= "quantity2";
    //public static final String COLUMN_UNIT2 = "unit2";
    public static final String COLUMN_ITEM3 = "item3";
    //public static final String COLUMN_QUANTITY3= "quantity3";
    //public static final String COLUMN_UNIT3 = "unit3";
    public static final String COLUMN_ITEM4 = "item4";
    //public static final String COLUMN_QUANTITY4= "quantity4";
    //public static final String COLUMN_UNIT4 = "unit4";
    public static final String COLUMN_ITEM5 = "item5";
    //public static final String COLUMN_QUANTITY5= "quantity5";
    //public static final String COLUMN_UNIT5 = "unit5";
    public static final String COLUMN_ITEM6 = "item6";
    //public static final String COLUMN_QUANTITY6= "quantity6";
    //public static final String COLUMN_UNIT6 = "unit6";
    public static final String COLUMN_ITEM7 = "item7";
    //public static final String COLUMN_QUANTITY7= "quantity7";
    //public static final String COLUMN_UNIT7 = "unit7";
    public static final String COLUMN_ITEM8 = "item8";
    //public static final String COLUMN_QUANTITY8= "quantity8";
    //public static final String COLUMN_UNIT8 = "unit8";
    public static final String COLUMN_ITEM9 = "item9";
    //public static final String COLUMN_QUANTITY9= "quantity9";
    //public static final String COLUMN_UNIT9 = "unit9";
    public static final String COLUMN_ITEM10 = "item10";
    //public static final String COLUMN_QUANTITY10= "quantity10";
    //public static final String COLUMN_UNIT10 = "unit10";*/


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE" + TABLE_DISHES + "(" + COLUMN_RECIPENAME + "PRIMARY KEY" + COLUMN_ITEM1 + "TEXT" + COLUMN_ITEM2 + "TEXT" + COLUMN_ITEM3 + "TEXT" + COLUMN_ITEM4 + "TEXT" + COLUMN_ITEM5 + "TEXT" + COLUMN_ITEM6 + "TEXT" + COLUMN_ITEM7 + "TEXT" + COLUMN_ITEM8 + "TEXT" +COLUMN_ITEM9 + "TEXT" +COLUMN_ITEM10 + "TEXT" + ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_DISHES);
            onCreate(db);
    }

    //Adding a row to the database
    public void addRecipe(new_dish_activity recipe){
        ContentValues values = new ContentValues();
        values.put(COLUMN_RECIPENAME, recipe.getRecipename());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DISHES, null, values);
        db.close();
    }
    //Print out the database as a string
    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_DISHES + "WHERE 1";

        //Cursor point to a location in your results
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();

        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("recipename"))!=null){
                dbString += c.getString(c.getColumnIndex("recipename"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;

    }
}
