package com.wearable.whatsfordinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
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
import java.util.Arrays;
import java.util.List;
import android.widget.Toast;



public class Ingredients extends AppCompatActivity {

    Spinner SPINNER;
    Spinner SPINNER1;
    Spinner SPINNER2;
    Button ADD;
    EditText EDITTEXT;
    ListView lv;
    String VALUE;
    String values;
    String value_quant;
    String value_unit;
    Button doneButton;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;


    ArrayList<String> m_listItems = new ArrayList<String>();


    String[] spinnerItems = new String[]{
            "Select Ingredient","Cheese", "Bread",
    };

    String[] quantityItems = new String[]{
            "1","2","3","4","5","6","7","8","9","10"};

    String[] unitItems = new String[]{
            "pieces","grams","lbs","teaspoons","tablespoons","cup","pinch","nos","ounces","pints"};

    String GETTEXT;
    List<String> stringlist;
    List<String> quantitylist;
    List<String> unitlist;
    ArrayAdapter<String> arrayadapter;
    ArrayAdapter<String> arrayadapter1;
    ArrayAdapter<String> arrayadapter2;

    Intent submitbuttonintent = getIntent();
    Intent donebuttonintent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SPINNER = (Spinner)findViewById(R.id.spinner1);
        SPINNER1 = (Spinner)findViewById(R.id.spinner2);
        SPINNER2 = (Spinner)findViewById(R.id.spinner3);

        ADD = (Button)findViewById(R.id.button1);
        EDITTEXT = (EditText)findViewById(R.id.editText1);
        lv = (ListView) findViewById(R.id.listView1);
        doneButton = (Button)findViewById(R.id.doneButton);

        stringlist = new ArrayList<>(Arrays.asList(spinnerItems));
        quantitylist = new ArrayList<>(Arrays.asList(quantityItems));
        unitlist = new ArrayList<>(Arrays.asList(unitItems));

        arrayadapter = new ArrayAdapter<>(Ingredients.this,R.layout.textview,stringlist );
        arrayadapter1 = new ArrayAdapter<>(Ingredients.this,R.layout.textview,quantitylist );
        arrayadapter2 = new ArrayAdapter<>(Ingredients.this,R.layout.textview,unitlist );

        arrayadapter.setDropDownViewResource(R.layout.textview);
        arrayadapter1.setDropDownViewResource(R.layout.textview);
        arrayadapter2.setDropDownViewResource(R.layout.textview);

        //Intent for receiving Recipe name
        submitbuttonintent = new Intent(this, Ingredients.class);

        Bundle extras=getIntent().getExtras();
        final String recipe_name = extras.getString("Recipe");
        System.out.println("Intent test:" + recipe_name);

        //Intent for sending Recipe name
        donebuttonintent = new Intent(Ingredients.this, Cooking_Directions.class);

        // spinner item select listener

        SPINNER.setAdapter(arrayadapter);
        SPINNER1.setAdapter(arrayadapter1);
        SPINNER2.setAdapter(arrayadapter2);

        // Edit Text Add Button Listener
        ADD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                GETTEXT = EDITTEXT.getText().toString();
                EDITTEXT.setText("");
                    stringlist.add(GETTEXT);

                arrayadapter.notifyDataSetChanged();

                Toast.makeText(Ingredients.this, "Item Added", Toast.LENGTH_LONG).show();

                arrayadapter = new ArrayAdapter<String>(Ingredients.this,android.R.layout.simple_list_item_1, m_listItems);
                lv.setAdapter(arrayadapter);

               //Add edittext values to the listview

                        if(null!=GETTEXT&&GETTEXT.length()>0){

                            m_listItems.add(GETTEXT);

                            arrayadapter.notifyDataSetChanged();


                        }
                    }
                });

        //Add Spinner Selected value to listview

        SPINNER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE = SPINNER.getSelectedItem().toString();
                value_quant = SPINNER1.getSelectedItem().toString();
                value_unit = SPINNER2.getSelectedItem().toString();

                if(VALUE!="Select Ingredient") {

                    values = VALUE + " " + value_quant + " " + value_unit;
                    m_listItems.add(values);
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        // Calling the listViewtoDB function on click of Done button

        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                int i=0;
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                for ( i=0;i<arrayadapter.getCount();i++){
                    Log.i("ListView Items",values);
                    myDBHandler.listViewtoDB(values,i,recipe_name,sqLiteDatabase);
                }

                Toast.makeText(getBaseContext(),"Ingredients Saved", Toast.LENGTH_LONG).show();
                myDBHandler.close();
                donebuttonintent.putExtra("Recipe",recipe_name);
                startActivity(donebuttonintent);


            }
        });

    }


}






