package com.wearable.whatsfordinner;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "WhatsForDinner_1.db";
    public static final int DATABASE_VERSION = 1;
   private static final String CREATE_QUERY =
            "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME + "(" + RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM1 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM2 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM3 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM4 + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM5 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM6 + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM7 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM8 + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM9 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM10 + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_DIRECTIONS + " TEXT);";

 //  private static final String CREATE_QUERY = "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME+"("+ RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME+" TEXT);";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS:" , "Db has been created");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS:" , "Table has been created");
        Log.i("Tag", CREATE_QUERY);

    }

    //Adding Recipe to Database
    public void addRecipeInformation(String recipe, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME,recipe);
        db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS:" , "Recipe has been inserted");
    }


    //Adding Ingredients to Database
    public void listViewtoDB(String item, int pos, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        if(pos==0) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM1, item);
        }
        else if(pos==1) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM2, item);
        }
        else if(pos==2) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM3, item);
        }
        else if(pos==4) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM4, item);
        }
        else if(pos==5) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM6, item);
        }
        else if(pos==6) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM7, item);
        }
        else if(pos==7) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM8, item);
        }
        else if(pos==8) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM9, item);
        }
        else if(pos==9) {
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_ITEM10, item);
        }
        else{
            //Don't insert anything
            Log.i("Tag","Cannot insert");
        }
       // db.insertWithOnConflict(RecipeContract.NewRecipeInfo.TABLE_NAME, null,contentValues,SQLiteDatabase.CONFLICT_REPLACE);
        db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS:" , "Ingredients have been inserted");
    }


    // Adding Directions to DB
    public void textViewtoDB(String data, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_DIRECTIONS,data);
        db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS:" , "Directions have been inserted");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + RecipeContract.NewRecipeInfo.TABLE_NAME);
        onCreate(db);
    }


}
