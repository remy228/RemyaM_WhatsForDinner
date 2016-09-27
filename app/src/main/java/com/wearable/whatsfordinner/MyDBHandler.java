package com.wearable.whatsfordinner;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "WhatsForDinner_12.db";
    public static final int DATABASE_VERSION = 1;
   private static final String CREATE_QUERY =
            "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME + "(" + RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM1 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM2 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM3 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM4 + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM5 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM6 + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM7 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM8 + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_ITEM9 + " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_ITEM10 + " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_DIRECTIONS + " TEXT);";

    private static final String CREATE_QUERY2 =
            "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME2 + "(" + RecipeContract.NewRecipeInfo.COLUMN_SELECTEDRECIPENAME + " TEXT); ";


    private static final String CREATE_QUERY3 =
            "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME3 + "(" + RecipeContract.NewRecipeInfo.COLUMN_INGREDIENTNAME + " TEXT, " +  RecipeContract.NewRecipeInfo.COLUMN_QUANTITY + " INTEGER); ";

    private static final String CREATE_QUERY4 =
    "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME4 + "(" + RecipeContract.NewRecipeInfo.COLUMN_RECIPE_NAME + " TEXT, " +
    RecipeContract.NewRecipeInfo.COLUMN_CALORIES + " INTEGER, " + RecipeContract.NewRecipeInfo.COLUMN_CARBS + " INTEGER, " +
            RecipeContract.NewRecipeInfo.COLUMN_MINERALS+ " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_VITAMINS+ " TEXT, " +
         RecipeContract.NewRecipeInfo.COLUMN_SUGAR + " TEXT);";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS:" , "Db has been created");
    }

    private static final String CREATE_QUERY5 =
            "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME5 + "(" + RecipeContract.NewRecipeInfo.COLUMN_INGREDIENT_NAME + " TEXT); ";

    private static final String CREATE_QUERY6 =
            "CREATE TABLE "+ RecipeContract.NewRecipeInfo.TABLE_NAME6 + "(" + RecipeContract.NewRecipeInfo.COLUMN_CALORIES + " INTEGER, " + RecipeContract.NewRecipeInfo.COLUMN_CARBS + " INTEGER, " +
                    RecipeContract.NewRecipeInfo.COLUMN_MINERALS+ " TEXT, " + RecipeContract.NewRecipeInfo.COLUMN_VITAMINS+ " TEXT, " +
                    RecipeContract.NewRecipeInfo.COLUMN_SUGAR + " TEXT);";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS:" , "Table has been created");
        Log.i("Tag", CREATE_QUERY);
        db.execSQL(CREATE_QUERY2);
        Log.e("DATABASE OPERATIONS:" , "Table2 has been created");
        db.execSQL(CREATE_QUERY3);
        Log.e("DATABASE OPERATIONS:" , "Table3 has been created");
        db.execSQL(CREATE_QUERY4);
        Log.e("DATABASE OPERATIONS:" , "Table4 has been created");
        db.execSQL(CREATE_QUERY5);
        Log.e("DATABASE OPERATIONS:" , "Table5 has been created");
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_INGREDIENT_NAME,"Cheese");
        db.insertWithOnConflict(RecipeContract.NewRecipeInfo.TABLE_NAME5,null,contentValues,SQLiteDatabase.CONFLICT_IGNORE);
        db.execSQL(CREATE_QUERY6);
        Log.e("DATABASE OPERATIONS:" , "Table6 has been created");
    }

    //Adding Recipe to Database
    public void addRecipeInformation(String recipe, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME,recipe);
        db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS:" , "Recipe has been inserted");
    }

    public void addSelectedRecipe(String recipe_name, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_SELECTEDRECIPENAME,recipe_name);
        db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME2,null,contentValues);
        Log.e("DATABASE OPERATIONS:" , "Selected Recipe has been inserted");
    }


    public void addIngredientsforSpinner(String ingredient_name, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_INGREDIENT_NAME,ingredient_name);
        db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME5,null,contentValues);
        Log.e("DATABASE OPERATIONS:" , "Selected Recipe has been inserted");
    }


    //Adding Ingredients to Database
    public void listViewtoDB(String item, int pos, String recipevalue, SQLiteDatabase db){
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
        db.update(RecipeContract.NewRecipeInfo.TABLE_NAME,contentValues,RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME +  "='" + recipevalue + "'",null);
        Log.e("DATABASE OPERATIONS:" , "Ingredients have been inserted");
    }


    // Adding Directions to DB
    public void textViewtoDB(String data, String recipevalue,SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_DIRECTIONS,data);
        db.update(RecipeContract.NewRecipeInfo.TABLE_NAME,contentValues,RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME +  "='" + recipevalue + "'",null);
       // db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS:" , "Directions have been inserted");
    }
    ArrayList<String> checkarray = new ArrayList<>();


    //Adding groceries from the meals screen
    public void groceriestoListView(String ingredient, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        if(checkarray.contains(ingredient))
        {
            db.execSQL("UPDATE Groceries SET Quantity='Quantity+1' WHERE Shopping_Ingredients ='"+ingredient+"'");
            Log.e("DATABASE OPERATIONS:", "Ingredient has been updated");
        }

        else {
            // Inserting record
            checkarray.add(ingredient);
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_INGREDIENTNAME, ingredient);
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_QUANTITY, 1);
            db.insertWithOnConflict(RecipeContract.NewRecipeInfo.TABLE_NAME3, null, contentValues, SQLiteDatabase.CONFLICT_IGNORE);
            Log.e("DATABASE OPERATIONS:", "Ingredient has been inserted");
        }
    }

    //Adding groceries from the meals screen
    public void nutritiontoDB(String Recipe, int calories, int carbohydrates, int minerals, int vitamins, int sugar, SQLiteDatabase db){
            ContentValues contentValues = new ContentValues();
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME, Recipe);
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_CALORIES, calories);
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_CARBS, calories);
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_MINERALS, calories);
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_VITAMINS, calories);
            contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_SUGAR, calories);
            db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME4, null, contentValues);
            Log.e("DATABASE OPERATIONS:", "Ingredient has been inserted");
        }

//Ends Here


    public void weeklynutritiontoDB(int calories, int carbohydrates, int minerals, int vitamins, int sugar, SQLiteDatabase db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_CALORIES, calories);
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_CARBS, calories);
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_MINERALS, calories);
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_VITAMINS, calories);
        contentValues.put(RecipeContract.NewRecipeInfo.COLUMN_SUGAR, calories);
        db.insert(RecipeContract.NewRecipeInfo.TABLE_NAME6, null, contentValues);
        Log.e("DATABASE OPERATIONS:", "Weekly Nutrition has been inserted");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + RecipeContract.NewRecipeInfo.TABLE_NAME);
        onCreate(db);
    }

}
