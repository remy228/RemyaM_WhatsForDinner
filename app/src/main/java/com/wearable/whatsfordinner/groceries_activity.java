package com.wearable.whatsfordinner;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class groceries_activity extends AppCompatActivity {


    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    ListView grocerieslistview;
    ArrayList<String> groceriesarray = new ArrayList<>();
    ImageButton imageButton;
    ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Displaying values in the ListView
        grocerieslistview = (ListView) findViewById(R.id.grocerieslistView);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton);

        myDBHandler = new MyDBHandler(getApplicationContext());
        sqLiteDatabase = myDBHandler.getReadableDatabase();
        Cursor cur = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_INGREDIENTNAME + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME3, null);
        try {
            while (cur.moveToNext()) {
                String uname = cur.getString(cur.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_INGREDIENTNAME));
                if(!groceriesarray.contains(uname)) {
                    groceriesarray.add(uname);
                }
                    Log.i("Recipe Array", uname);

            }

        } finally {
            cur.close();
        }

 // Displaying the groceries in the Groceries Screen

        for (int i = 0; i < groceriesarray.size(); i++) {
            if (groceriesarray.toString() != null) {
                if (!groceriesarray.toString().isEmpty()) {
                    System.out.println("Array Values: " + groceriesarray.get(i));
                    ArrayAdapter<String> arrayadapter1 = new ArrayAdapter<String>(groceries_activity.this, android.R.layout.simple_list_item_1, groceriesarray);
                    grocerieslistview.setAdapter(arrayadapter1);
                    arrayadapter1.notifyDataSetChanged();

                }
            }
            else {
                System.out.println("Empty Array value found");
            }
        }

        grocerieslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                final String selectedRecipe = grocerieslistview.getItemAtPosition(position).toString();
                Toast.makeText(getBaseContext(), "Recipe Selected " + selectedRecipe, Toast.LENGTH_LONG).show();
                imageButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        int i=1;
                        myDBHandler = new MyDBHandler(getBaseContext());
                        sqLiteDatabase = myDBHandler.getWritableDatabase();
                        myDBHandler.changeRecipeQuantity(i,selectedRecipe, sqLiteDatabase);
                        myDBHandler.close();
                        Toast.makeText(getBaseContext(),selectedRecipe + ": Quantity Updated", Toast.LENGTH_LONG).show();

                    }
                });

                imageButton2.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                        int i=2;
                        myDBHandler = new MyDBHandler(getBaseContext());
                        sqLiteDatabase = myDBHandler.getWritableDatabase();
                        myDBHandler.changeRecipeQuantity(i,selectedRecipe, sqLiteDatabase);
                        myDBHandler.close();
                        Toast.makeText(getBaseContext(),selectedRecipe + ": Quantity Updated", Toast.LENGTH_LONG).show();
                        myDBHandler = new MyDBHandler(getApplicationContext());
                        sqLiteDatabase = myDBHandler.getReadableDatabase();

                        Cursor cur = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_QUANTITY + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME3 + " where Shopping_Ingredients = '" + selectedRecipe + "'", null);
                        try {
                            while (cur.moveToNext()) {
                                int uname = cur.getInt(cur.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_QUANTITY));
                                if((uname <= 0)) {
                                    TextView text = (TextView) v;
                                    text.setPaintFlags(text.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                                }


                            }

                        } finally {
                            cur.close();
                        }



                    }
                });



            }

        });


    }


}
