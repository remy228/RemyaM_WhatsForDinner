package com.wearable.whatsfordinner;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class meals_activity extends AppCompatActivity {

    Spinner SPINNER;
    Spinner SPINNER2;
    Spinner SPINNER3;
    Spinner SPINNER4;
    Spinner SPINNER5;
    Spinner SPINNER6;
    Spinner SPINNER7;
    Spinner SPINNER8;
    Spinner SPINNER9;
    Spinner SPINNER10;
    Spinner SPINNER11;
    Spinner SPINNER12;
    Spinner SPINNER13;
    Spinner SPINNER14;
    Spinner SPINNER15;
    Spinner SPINNER16;
    Spinner SPINNER17;
    Spinner SPINNER18;
    Spinner SPINNER19;
    Spinner SPINNER20;
    Spinner SPINNER21;
    String VALUE,VALUE2,VALUE3,VALUE4,VALUE5,VALUE6,VALUE7,VALUE8,VALUE9,VALUE10,VALUE11,
            VALUE12,VALUE13,VALUE14,VALUE15,VALUE16,VALUE17,VALUE18,VALUE19,VALUE20,VALUE21;

    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    ArrayList<String> selectedrecipearray = new ArrayList<>();
    ArrayList<String> groceriesrecipearray = new ArrayList<>();
    ArrayList<String> groceries = new ArrayList<>();
    Button mealsButton;
    int uname, uname1, uname2, uname3, uname4, uname5, uname6, uname7, uname8, uname9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SPINNER = (Spinner) findViewById(R.id.spinner1);
        SPINNER2 = (Spinner) findViewById(R.id.spinner2);
        SPINNER3 = (Spinner) findViewById(R.id.spinner3);
        SPINNER4 = (Spinner) findViewById(R.id.spinner4);
        SPINNER5 = (Spinner) findViewById(R.id.spinner5);
        SPINNER6 = (Spinner) findViewById(R.id.spinner6);
        SPINNER7 = (Spinner) findViewById(R.id.spinner7);
        SPINNER8 = (Spinner) findViewById(R.id.spinner8);
        SPINNER9 = (Spinner) findViewById(R.id.spinner9);
        SPINNER10 = (Spinner) findViewById(R.id.spinner10);
        SPINNER11 = (Spinner) findViewById(R.id.spinner11);
        SPINNER12 = (Spinner) findViewById(R.id.spinner12);
        SPINNER13 = (Spinner) findViewById(R.id.spinner13);
        SPINNER14 = (Spinner) findViewById(R.id.spinner14);
        SPINNER15 = (Spinner) findViewById(R.id.spinner15);
        SPINNER16 = (Spinner) findViewById(R.id.spinner16);
        SPINNER17 = (Spinner) findViewById(R.id.spinner17);
        SPINNER18 = (Spinner) findViewById(R.id.spinner18);
        SPINNER19 = (Spinner) findViewById(R.id.spinner19);
        SPINNER20 = (Spinner) findViewById(R.id.spinner20);
        SPINNER21 = (Spinner) findViewById(R.id.spinner21);
        mealsButton = (Button)findViewById(R.id.mealsbutton);


        myDBHandler = new MyDBHandler(getApplicationContext());
        sqLiteDatabase = myDBHandler.getReadableDatabase();
        final ArrayAdapter<String> arrayadapter;
        selectedrecipearray.add("Select");

        Cursor cur = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_SELECTEDRECIPENAME + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME2, null);
        try {
            while (cur.moveToNext()) {
                String uname = cur.getString(cur.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_SELECTEDRECIPENAME));
                selectedrecipearray.add(uname);
                Log.i("Recipe Array", "Recipes Added to array");

            }

        } finally {
            cur.close();
        }

        selectedrecipearray.add("Eating Out");

        for (int i = 0; i < selectedrecipearray.size(); i++) {
            if (selectedrecipearray.toString() != null) {
                if (!selectedrecipearray.toString().isEmpty()) {
                    System.out.println("Array Values: " + selectedrecipearray.get(i));
                }
            } else {
                System.out.println("Empty Array value found");
            }
        }

        arrayadapter = new ArrayAdapter<>(meals_activity.this, R.layout.textview, selectedrecipearray);
        arrayadapter.setDropDownViewResource(R.layout.textview);

        SPINNER.setAdapter(arrayadapter);
        SPINNER2.setAdapter(arrayadapter);
        SPINNER3.setAdapter(arrayadapter);
        SPINNER4.setAdapter(arrayadapter);
        SPINNER5.setAdapter(arrayadapter);
        SPINNER6.setAdapter(arrayadapter);
        SPINNER7.setAdapter(arrayadapter);
        SPINNER8.setAdapter(arrayadapter);
        SPINNER9.setAdapter(arrayadapter);
        SPINNER10.setAdapter(arrayadapter);
        SPINNER11.setAdapter(arrayadapter);
        SPINNER12.setAdapter(arrayadapter);
        SPINNER13.setAdapter(arrayadapter);
        SPINNER14.setAdapter(arrayadapter);
        SPINNER15.setAdapter(arrayadapter);
        SPINNER16.setAdapter(arrayadapter);
        SPINNER17.setAdapter(arrayadapter);
        SPINNER18.setAdapter(arrayadapter);
        SPINNER19.setAdapter(arrayadapter);
        SPINNER20.setAdapter(arrayadapter);
        SPINNER21.setAdapter(arrayadapter);



        SPINNER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE = SPINNER.getSelectedItem().toString();
                if (VALUE != "Select" && VALUE != "Eating Out") {

                    selectedrecipearray.remove(VALUE);
                    groceriesrecipearray.add(VALUE);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });



        SPINNER2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

               VALUE2 = SPINNER2.getSelectedItem().toString();
                if (VALUE2 != "Select" && VALUE2 != "Eating Out"){

                    selectedrecipearray.remove(VALUE2);
                    groceriesrecipearray.add(VALUE2);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

               VALUE3 = SPINNER3.getSelectedItem().toString();
                if (VALUE3 != "Select" && VALUE3 != "Eating Out") {

                    selectedrecipearray.remove(VALUE3);
                    groceriesrecipearray.add(VALUE3);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

             VALUE4 = SPINNER4.getSelectedItem().toString();
                if (VALUE4 != "Select" && VALUE4 != "Eating Out") {

                    selectedrecipearray.remove(VALUE4);
                    groceriesrecipearray.add(VALUE4);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

               VALUE5 = SPINNER5.getSelectedItem().toString();
                if (VALUE5 != "Select" && VALUE5 != "Eating Out") {

                    selectedrecipearray.remove(VALUE5);
                    groceriesrecipearray.add(VALUE5);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE6 = SPINNER6.getSelectedItem().toString();
                if (VALUE6 != "Select" && VALUE6 != "Eating Out") {

                    selectedrecipearray.remove(VALUE6);
                    groceriesrecipearray.add(VALUE6);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE7 = SPINNER7.getSelectedItem().toString();
                if (VALUE7 != "Select" && VALUE7 != "Eating Out") {

                    selectedrecipearray.remove(VALUE7);
                    groceriesrecipearray.add(VALUE7);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                 VALUE8 = SPINNER8.getSelectedItem().toString();
                if (VALUE8 != "Select" && VALUE8 != "Eating Out") {

                    selectedrecipearray.remove(VALUE8);
                    groceriesrecipearray.add(VALUE8);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                 VALUE9 = SPINNER9.getSelectedItem().toString();
                if (VALUE9 != "Select" && VALUE9 != "Eating Out"){

                    selectedrecipearray.remove(VALUE9);
                    groceriesrecipearray.add(VALUE9);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

               VALUE10 = SPINNER10.getSelectedItem().toString();
                if (VALUE10 != "Select" && VALUE10 != "Eating Out"){

                    selectedrecipearray.remove(VALUE10);
                    groceriesrecipearray.add(VALUE10);
                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE11 = SPINNER11.getSelectedItem().toString();
                if (VALUE11 != "Select" && VALUE11 != "Eating Out") {

                    selectedrecipearray.remove(VALUE11);
                    groceriesrecipearray.add(VALUE11);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE12 = SPINNER12.getSelectedItem().toString();
                if (VALUE12 != "Select" && VALUE12 != "Eating Out"){

                    selectedrecipearray.remove(VALUE12);
                    groceriesrecipearray.add(VALUE12);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE13 = SPINNER13.getSelectedItem().toString();
                if (VALUE13 != "Select" && VALUE13 != "Eating Out"){

                    selectedrecipearray.remove(VALUE13);
                    groceriesrecipearray.add(VALUE13);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE14 = SPINNER14.getSelectedItem().toString();
                if (VALUE14 != "Select" && VALUE14 != "Eating Out") {

                    selectedrecipearray.remove(VALUE14);
                    groceriesrecipearray.add(VALUE14);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                 VALUE15 = SPINNER15.getSelectedItem().toString();
                if (VALUE15 != "Select" && VALUE15 != "Eating Out") {

                    selectedrecipearray.remove(VALUE15);
                    groceriesrecipearray.add(VALUE15);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE16 = SPINNER16.getSelectedItem().toString();
                if (VALUE16 != "Select" && VALUE16 != "Eating Out"){

                    selectedrecipearray.remove(VALUE16);
                    groceriesrecipearray.add(VALUE16);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE17 = SPINNER17.getSelectedItem().toString();
                if (VALUE17 != "Select" && VALUE17 != "Eating Out") {

                    selectedrecipearray.remove(VALUE17);
                    groceriesrecipearray.add(VALUE17);
                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE18 = SPINNER18.getSelectedItem().toString();
                if (VALUE18 != "Select" && VALUE18 != "Eating Out") {

                    selectedrecipearray.remove(VALUE18);
                    groceriesrecipearray.add(VALUE18);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER19.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE19 = SPINNER19.getSelectedItem().toString();
                if (VALUE19 != "Select" && VALUE19 != "Eating Out") {

                    selectedrecipearray.remove(VALUE19);
                    groceriesrecipearray.add(VALUE19);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER20.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE20 = SPINNER20.getSelectedItem().toString();
                if (VALUE20 != "Select" && VALUE20 != "Eating Out") {

                    selectedrecipearray.remove(VALUE20);
                    groceriesrecipearray.add(VALUE20);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        SPINNER21.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE21 = SPINNER21.getSelectedItem().toString();
                if (VALUE21 != "Select" && VALUE21 != "Eating Out"){

                    selectedrecipearray.remove(VALUE21);
                    groceriesrecipearray.add(VALUE21);

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        // Set values not selected to "Eating Out"

        mealsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                if (VALUE == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER.setSelection(s);

                }
                if (VALUE2== "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER2.setSelection(s);

                }

                if (VALUE3 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER3.setSelection(s);

                }

                if (VALUE4 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER4.setSelection(s);

                }

                if (VALUE5 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER5.setSelection(s);

                }
                if (VALUE6 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER6.setSelection(s);

                }

                if (VALUE7 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER7.setSelection(s);

                }

                if (VALUE8 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER8.setSelection(s);

                }

                if (VALUE9 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER9.setSelection(s);

                }

                if (VALUE10 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER10.setSelection(s);

                }

                if (VALUE11 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER11.setSelection(s);

                }

                if (VALUE12 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER12.setSelection(s);

                }

                if (VALUE13 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER13.setSelection(s);

                }

                if (VALUE14 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER14.setSelection(s);

                }

                if (VALUE15 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER15.setSelection(s);

                }

                if (VALUE16 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER16.setSelection(s);

                }

                if (VALUE17 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER17.setSelection(s);

                }

                if (VALUE18 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER18.setSelection(s);

                }

                if (VALUE19 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER19.setSelection(s);

                }

                if (VALUE20 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER20.setSelection(s);

                }

                if (VALUE21 == "Select" )
                {
                    int s;
                    s = arrayadapter.getPosition("Eating Out");
                    SPINNER21.setSelection(s);

                }


                //Adding all the selected recipes' ingredients from Meals screen into an array

                for (String s : groceriesrecipearray) {

                System.out.println(s);
                Cursor cur11 = sqLiteDatabase.rawQuery(" SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM1 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur11.moveToNext()) {
                            String uname = cur11.getString(cur11.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM1));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                groceries.add(uname);
                                Log.i("Groceries Array", "Groceries added to array");
                            }
                            }


                        }

                    } finally {
                        cur11.close();
                    }

                    Cursor cur2 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM2 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur2.moveToNext()) {
                            String uname = cur2.getString(cur2.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM2));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur2.close();
                    }

                    Cursor cur3 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM3 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur3.moveToNext()) {
                            String uname = cur3.getString(cur3.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM3));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur3.close();
                    }

                    Cursor cur4 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM4 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur4.moveToNext()) {
                            String uname = cur4.getString(cur4.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM4));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur4.close();
                    }

                    Cursor cur5 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM5 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur5.moveToNext()) {
                            String uname = cur5.getString(cur5.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM5));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur5.close();
                    }

                    Cursor cur6 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM6 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur6.moveToNext()) {
                            String uname = cur6.getString(cur6.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM6));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur6.close();
                    }

                    Cursor cur7 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM7 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur7.moveToNext()) {
                            String uname = cur7.getString(cur7.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM7));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur7.close();
                    }

                    Cursor cur8 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM8 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur8.moveToNext()) {
                            String uname = cur8.getString(cur8.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM8));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur8.close();
                    }

                    Cursor cur9 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM9 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur9.moveToNext()) {
                            String uname = cur9.getString(cur9.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM9));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur9.close();
                    }

                    Cursor cur10 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM10 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + s + "'", null);

                    try {
                        while (cur10.moveToNext()) {
                            String uname = cur10.getString(cur10.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM10));
                            if(uname != null) {
                                if(!uname.isEmpty()){
                                    groceries.add(uname);
                                    Log.i("Recipe Array", "Recipes Added to array");
                                }
                            }


                        }

                    } finally {
                        cur10.close();
                    }

                }

                for(String s: groceries)
                {
                    System.out.println("Groceries: " + s);
                }
               //Ends Here: Adding ingredients for groceries ends here

                //Function to add all the ingredients to a Groceries Table in the database so that it can be accessed
                // from the Groceries screen

                //Insert the array into the database using a Function
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                for ( String s: groceries){

                    myDBHandler.groceriestoListView(s,sqLiteDatabase);

                }
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getReadableDatabase();
                //Add the values to Spinner from database
               Cursor cur = sqLiteDatabase.rawQuery(" SELECT SUM(Calories)FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME4, null);

                try {

                    while (cur.moveToNext()) {
                          uname = cur.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                       // Toast.makeText(getBaseContext(),"Total Calories for the week: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur.close();
                }

                Cursor cur5 = sqLiteDatabase.rawQuery(" SELECT Calories FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME6, null);

                try {
                    while (cur5.moveToNext()) {
                          uname1 = cur5.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                      //  Toast.makeText(getBaseContext(),"Your weekly Calorie goal: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur5.close();
                }

                if(uname < uname1)
                {
                    Toast.makeText(getBaseContext(),"Your weekly Calorie goal has not been met!",Toast.LENGTH_LONG).show();
                }


                Cursor cur1 = sqLiteDatabase.rawQuery(" SELECT SUM(Carbohydrates)FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME4, null);

                try {
                    while (cur1.moveToNext()) {
                       uname2 = cur1.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                        //Toast.makeText(getBaseContext(),"Total Carbs for the week: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur1.close();
                }

                Cursor cur6 = sqLiteDatabase.rawQuery(" SELECT Carbohydrates FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME6, null);

                try {
                    while (cur6.moveToNext()) {
                        uname3 = cur6.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                       // Toast.makeText(getBaseContext(),"Your weekly Carbs goal: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur6.close();
                }

                if(uname2 < uname3)
                {
                    Toast.makeText(getBaseContext(),"Your weekly Carbs goal has not been met!",Toast.LENGTH_LONG).show();
                }

                Cursor cur2 = sqLiteDatabase.rawQuery(" SELECT SUM(Minerals)FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME4, null);

                try {
                    while (cur2.moveToNext()) {
                        uname4 = cur2.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                      //  Toast.makeText(getBaseContext(),"Total Minerals for the week: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur2.close();
                }

                Cursor cur7 = sqLiteDatabase.rawQuery(" SELECT Minerals FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME6, null);

                try {
                    while (cur7.moveToNext()) {
                      uname5 = cur7.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                      //  Toast.makeText(getBaseContext(),"Your weekly Minerals goal: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur7.close();
                }


                if(uname4 < uname5)
                {
                    Toast.makeText(getBaseContext(),"Your weekly Minerals goal has not been met!",Toast.LENGTH_LONG).show();
                }

                Cursor cur3 = sqLiteDatabase.rawQuery(" SELECT SUM(Vitamins)FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME4, null);

                try {
                    while (cur3.moveToNext()) {
                       uname6 = cur3.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                     //   Toast.makeText(getBaseContext(),"Total Vitamins for the week: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur3.close();
                }


                Cursor cur8 = sqLiteDatabase.rawQuery(" SELECT Vitamins FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME6, null);

                try {
                    while (cur8.moveToNext()) {
                      uname7 = cur8.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                       // Toast.makeText(getBaseContext(),"Your weekly Vitamin goal: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur8.close();
                }

                if(uname6 < uname7)
                {
                    Toast.makeText(getBaseContext(),"Your weekly Vitamin goal has not been met!",Toast.LENGTH_LONG).show();
                }



                Cursor cur4 = sqLiteDatabase.rawQuery(" SELECT SUM(Sugar)FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME4, null);

                try {
                    while (cur4.moveToNext()) {
                         uname8 = cur4.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                    //   Toast.makeText(getBaseContext(),"Total Sugar for the week: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur4.close();
                }


                Cursor cur9 = sqLiteDatabase.rawQuery(" SELECT Sugar FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME6, null);

                try {
                    while (cur9.moveToNext()) {
                        uname9 = cur9.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_CALORIES);
                     //   Toast.makeText(getBaseContext(),"Your weekly Sugar goals: " + uname, Toast.LENGTH_LONG).show();
                    }

                } finally {
                    cur9.close();
                }

                if(uname8 < uname9)
                {
                    Toast.makeText(getBaseContext(),"Your weekly Sugar goal has not been met!",Toast.LENGTH_LONG).show();
                }



            }


        });






    }
}

