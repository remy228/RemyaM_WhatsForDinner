package com.wearable.whatsfordinner;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Nutrition_Manager extends AppCompatActivity {

    Intent mainpageintent;
    Intent weeklygoalspageintent;
    Button doneButton;
    Button noinfoButton;
    Button weeklygoalsButton;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    Intent submitbuttonintent = getIntent();
    EditText calories;
    EditText carbs;
    EditText minerals;
    EditText vitamins;
    EditText sugar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition__manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mainpageintent = new Intent(Nutrition_Manager.this, MainActivity.class);
        submitbuttonintent = new Intent(this, Nutrition_Manager.class);
        weeklygoalspageintent = new Intent(this, Weekly_Nutrition_Manager.class);

        Bundle extras=getIntent().getExtras();
        final String recipe_name = extras.getString("Recipe");

        calories = (EditText) findViewById(R.id.textView44);
        carbs = (EditText)findViewById(R.id.textView43);
        minerals = (EditText)findViewById(R.id.textView45);
        vitamins = (EditText)findViewById(R.id.textView46);
        sugar = (EditText)findViewById(R.id.textView47);
        doneButton = (Button) findViewById(R.id.nutritionButton);
        noinfoButton = (Button) findViewById(R.id.noinfobutton);
        weeklygoalsButton = (Button) findViewById(R.id.weeklygoalbutton);



        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

               int calories1 = Integer.parseInt(calories.getText().toString());
               int carbs1 = Integer.parseInt(carbs.getText().toString());
               int minerals1 = Integer.parseInt(minerals.getText().toString());
               int vitamins1 = Integer.parseInt(vitamins.getText().toString());
               int sugar1 = Integer.parseInt(sugar.getText().toString());


                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                myDBHandler.nutritiontoDB(recipe_name,calories1,carbs1,minerals1,vitamins1, sugar1, sqLiteDatabase);
                Toast.makeText(getBaseContext(),"Ingredients Saved", Toast.LENGTH_LONG).show();
                myDBHandler.close();
                Toast.makeText(getBaseContext(), "Nutrition Values Saved", Toast.LENGTH_LONG).show();
                startActivity(mainpageintent);


            }
        });

        noinfoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(mainpageintent);

            }
        });


        weeklygoalsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                startActivity(weeklygoalspageintent);


            }
        });


    }

}
