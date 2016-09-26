package com.wearable.whatsfordinner;

import android.content.Intent;
import android.database.Cursor;
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
    String VALUE =  null;
    String values = null;
    String value_quant = null;
    String value_unit = null;
    Button doneButton;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;


    ArrayList<String> m_listItems = new ArrayList<String>();
    ArrayList<String> spinnerarray = new ArrayList<String>();

    String[] spinnerItems = new String[]{
            "Select Ingredient", "Potatoes", "Tomatoes", "Bread"
    };


    String[] quantityItems = new String[]{
            "1","2","3","4","5","6","7","8","9","10"};

    String[] unitItems = new String[]{
            "pieces","grams","lbs","teaspoons","tablespoons","cup","pinch","nos","ounces","pints"};

    String GETTEXT = null;
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

        myDBHandler = new MyDBHandler(getApplicationContext());
        sqLiteDatabase = myDBHandler.getReadableDatabase();
        //Add the values to Spinner from database
        Cursor cur = sqLiteDatabase.rawQuery(" SELECT " + RecipeContract.NewRecipeInfo.COLUMN_INGREDIENT_NAME + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME5, null);

        try {
            while (cur.moveToNext()) {
                String uname = cur.getString(cur.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_INGREDIENT_NAME));
                if(uname != null) {
                    if(!uname.isEmpty()){
                        if(!stringlist.contains(uname))
                        {
                        stringlist.add(uname);
                        Log.i("Ingredients :", "Ingredients added to array");
                    }
                    }
                }


            }

        } finally {
            cur.close();
        }

        //Ends here

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

        //Add Spinner Selected value to listview

        SPINNER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {

                VALUE = SPINNER.getSelectedItem().toString();

                if(VALUE!="Select Ingredient") {

                    values = VALUE + " " + value_quant + " " + value_unit;

                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {


                value_quant = SPINNER1.getSelectedItem().toString();


            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        SPINNER2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View arg1,
                                       int pos, long arg3) {


                value_unit = SPINNER2.getSelectedItem().toString();


            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        // Edit Text Add Button Listener
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String listvalue2=null;
                String listvalue = null;

                if (VALUE != "Select Ingredient") {
                     listvalue2 = VALUE + " " + value_quant + " " + value_unit;
                    m_listItems.add(listvalue2);
                    arrayadapter.notifyDataSetChanged();
                }
                GETTEXT = EDITTEXT.getText().toString();
                if(GETTEXT.length()>0) {

                    EDITTEXT.setText("");
                    listvalue = GETTEXT + " " + value_quant + " " + value_unit;
                    stringlist.add(GETTEXT);
                    spinnerarray.add(GETTEXT);
                    m_listItems.add(listvalue);
                    arrayadapter.notifyDataSetChanged();

                }

                //Add Ingredients for spinner
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                for(String s: spinnerarray)
                {
                    if(s!=null) {
                        if (s != "Select Ingredient") {
                            myDBHandler.addIngredientsforSpinner(s, sqLiteDatabase);
                            System.out.println("Testing spinner array"+ s);
                        }
                    }

                }
                Toast.makeText(Ingredients.this, "Item Added", Toast.LENGTH_LONG).show();

                arrayadapter = new ArrayAdapter<String>(Ingredients.this,android.R.layout.simple_list_item_1, m_listItems);
                lv.setAdapter(arrayadapter);



                        }
        });


        // Calling the listViewtoDB function on click of Done button

        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                int i=0;
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                for ( i=0;i<m_listItems.size();i++){
                    String val = m_listItems.get(i);
                    Log.i("ListView Items",val);
                    myDBHandler.listViewtoDB(val,i,recipe_name,sqLiteDatabase);
                }

                Toast.makeText(getBaseContext(),"Ingredients Saved", Toast.LENGTH_LONG).show();
                myDBHandler.close();
                donebuttonintent.putExtra("Recipe",recipe_name);
                startActivity(donebuttonintent);


            }
        });

    }


}






