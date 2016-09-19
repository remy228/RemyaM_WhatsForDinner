package com.wearable.whatsfordinner;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class Recipes_Activity extends AppCompatActivity {

    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    ListView recipelistview;
    ArrayAdapter<String> arrayadapter1;
    ArrayList<String> recipearray = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recipelistview = (ListView) findViewById(R.id.display_listview);

        Configuration config = getResources().getConfiguration();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            LandscapeFragment landscapeFragment = new LandscapeFragment();
            fragmentTransaction.replace(android.R.id.content, landscapeFragment);
        } else {
            PortraitFragment portraitFragment = new PortraitFragment();
            fragmentTransaction.replace(android.R.id.content, portraitFragment);
        }
        fragmentTransaction.commit();

        //New

        //Ends
        storeRecipes();

    }

   public void storeRecipes(){


        myDBHandler = new MyDBHandler(getApplicationContext());
        sqLiteDatabase = myDBHandler.getReadableDatabase();
        Cursor cur = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME, new String[] {});
        while (cur.moveToNext()) {
            String uname = cur.getString(cur.getColumnIndex( RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME));
            recipearray.add(uname);
            Log.i("Recipe Array","Recipes Added to array");

        }
       arrayadapter1 = new ArrayAdapter<String>(Recipes_Activity.this,android.R.layout.simple_list_item_1, recipearray);
       recipelistview.setAdapter(arrayadapter1);
    }

        }







