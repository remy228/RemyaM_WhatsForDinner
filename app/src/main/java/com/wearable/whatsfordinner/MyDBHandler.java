package com.wearable.whatsfordinner;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "WhatsForDinner_Application.db";
    public static final int DATABASE_VERSION = 1;
   /* private static final String CREATE_QUERY =
            "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME+ "("+ RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME+" TEXT,"+
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM1+" TEXT,"+ RecipeContract.NewRecipeInfo.COLUMN_ITEM2+" TEXT,"+
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM3+" TEXT,"+ RecipeContract.NewRecipeInfo.COLUMN_ITEM4+" TEXT,"+
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM5+" TEXT,"+ RecipeContract.NewRecipeInfo.COLUMN_ITEM6+" TEXT,"+
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM7+" TEXT,"+ RecipeContract.NewRecipeInfo.COLUMN_ITEM8+" TEXT,"+
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM9+" TEXT,"+ RecipeContract.NewRecipeInfo.COLUMN_ITEM10+" TEXT);";
*/
   private static final String CREATE_QUERY = "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME+"("+ RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME+" TEXT);";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS:" , "Db has been created");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS:" , "Table has been created");

    }

    public void addRecipeInformation(String recipe, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME,recipe);
        db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS:" , "Recipe has been inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + RecipeContract.NewRecipeInfo.TABLE_NAME);
        onCreate(db);
    }


}
