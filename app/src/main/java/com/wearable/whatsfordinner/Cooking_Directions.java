package com.wearable.whatsfordinner;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking__directions);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        directions = (Button)findViewById(R.id.directionadd);
        tv = (TextView)findViewById(R.id.directions);

        directions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String value=null;
                int i=0;
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                String a = tv.getText().toString();
                Log.i("TextView Items",a);
                    myDBHandler.textViewtoDB(a,sqLiteDatabase);

                Toast.makeText(getBaseContext(),"Directions Saved", Toast.LENGTH_LONG).show();
                myDBHandler.close();

            }


        });
    }

}
