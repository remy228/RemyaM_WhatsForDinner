package com.wearable.whatsfordinner;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Cooking_Directions extends AppCompatActivity {

     Button directions;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    TextView tv;
    Intent donebuttonintent = getIntent();
    Intent nutritionpageintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking__directions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        directions = (Button)findViewById(R.id.directionadd);
        tv = (TextView)findViewById(R.id.directions);
        donebuttonintent=new Intent(this, Cooking_Directions.class);
        nutritionpageintent = new Intent(Cooking_Directions.this, Nutrition_Manager.class);

       //Receiving recipe name
        Bundle extras=getIntent().getExtras();
        final String recipename2 = extras.getString("Recipe");

        System.out.println("Intent test2:" + recipename2);

        directions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String value=null;
                int i=0;
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                String a = tv.getText().toString();
                Log.i("TextView Items",a);
                    myDBHandler.textViewtoDB(a,recipename2,sqLiteDatabase);

                Toast.makeText(getBaseContext(),"Directions Saved", Toast.LENGTH_LONG).show();
                myDBHandler.close();
                nutritionpageintent.putExtra("Recipe",recipename2);
                startActivity(nutritionpageintent);

            }


        });
    }

}
