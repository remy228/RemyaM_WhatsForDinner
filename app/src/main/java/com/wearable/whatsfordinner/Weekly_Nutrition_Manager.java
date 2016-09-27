package com.wearable.whatsfordinner;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Weekly_Nutrition_Manager extends AppCompatActivity {

    Button doneButton2;
    Intent mainpageintent;
    Button doneButton;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    EditText calories;
    EditText carbs;
    EditText minerals;
    EditText vitamins;
    EditText sugar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly__nutrition__manager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainpageintent = new Intent(this, Nutrition_Manager.class);
        doneButton2 = (Button) findViewById(R.id.nutritionButton);
        calories = (EditText) findViewById(R.id.textView44);
        carbs = (EditText)findViewById(R.id.textView43);
        minerals = (EditText)findViewById(R.id.textView45);
        vitamins = (EditText)findViewById(R.id.textView46);
        sugar = (EditText)findViewById(R.id.textView47);



        doneButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                int calories1 = Integer.parseInt(calories.getText().toString());
                int carbs1 = Integer.parseInt(carbs.getText().toString());
                int minerals1 = Integer.parseInt(minerals.getText().toString());
                int vitamins1 = Integer.parseInt(vitamins.getText().toString());
                int sugar1 = Integer.parseInt(sugar.getText().toString());


                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                myDBHandler.weeklynutritiontoDB(calories1,carbs1,minerals1,vitamins1, sugar1, sqLiteDatabase);
                Toast.makeText(getBaseContext(),"Ingredients Saved", Toast.LENGTH_LONG).show();
                myDBHandler.close();
                Toast.makeText(getBaseContext(), "Nutrition Values Saved", Toast.LENGTH_LONG).show();
                startActivity(mainpageintent);
                Toast.makeText(getBaseContext(), "You may now add the Recipe Nutritional Values!", Toast.LENGTH_LONG).show();


            }
        });

    }

}
