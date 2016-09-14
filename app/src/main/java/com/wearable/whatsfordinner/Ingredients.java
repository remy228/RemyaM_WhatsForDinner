package com.wearable.whatsfordinner;

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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class Ingredients extends AppCompatActivity {

    public Ingredients(){

    }

    // Adding Ingredients Array
    Button save;
    ArrayList<String> addIngredientsArray = new ArrayList<String>();
    Spinner spinner;
    ArrayAdapter<CharSequence> dataadapter;



    EditText txt;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        spinner = (Spinner)findViewById(R.id.spinner);
        dataadapter = ArrayAdapter.createFromResource(this,R.array.addIngredientsArray,android.R.layout.simple_spinner_item);
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataadapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // show.setAdapter(dataadapter);
                String tex=parent.getItemAtPosition(position).toString();
                Log.d("Selected", tex);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //Storing Ingredients in an Array
        txt = (EditText)findViewById(R.id.ingredientsInput);
        save = (Button)findViewById(R.id.addIngredients);
        show = (ListView)findViewById(R.id.listView);

        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String getInput = txt.getText().toString();
                {
                    addIngredientsArray.add(getInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Ingredients.this, android.R.layout.simple_list_item_1,addIngredientsArray);
                    //setAdapter(adapter);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.ingredientsInput)).setText(" ");

                }
              }


            });
        }
    public ArrayList<String> getList() {
        return addIngredientsArray;
    }
    }


