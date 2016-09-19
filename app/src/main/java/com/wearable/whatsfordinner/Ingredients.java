package com.wearable.whatsfordinner;

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
    Button ADD;
    EditText EDITTEXT;
    ListView lv;
    String VALUE;
    Button doneButton;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;

    ArrayList<String> m_listItems = new ArrayList<String>();


    String[] spinnerItems = new String[]{
            "Select Ingredient","Cheese", "Bread",
    };

    String GETTEXT;
    List<String> stringlist;
    ArrayAdapter<String> arrayadapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SPINNER = (Spinner)findViewById(R.id.spinner1);
        ADD = (Button)findViewById(R.id.button1);
        EDITTEXT = (EditText)findViewById(R.id.editText1);
        lv = (ListView) findViewById(R.id.listView1);
        doneButton = (Button)findViewById(R.id.doneButton);

        stringlist = new ArrayList<>(Arrays.asList(spinnerItems));

        arrayadapter = new ArrayAdapter<>(Ingredients.this,R.layout.textview,stringlist );

        arrayadapter.setDropDownViewResource(R.layout.textview);

        // spinner item select listener

        SPINNER.setAdapter(arrayadapter);


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
                if(VALUE!="Select Ingredient") {

                    m_listItems.add(VALUE);
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        // Calling the listViewtoDB function on click of Done button

        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String value=null;
                int i=0;
                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getWritableDatabase();
                for ( i=0;i<arrayadapter.getCount();i++){
                    value = arrayadapter.getItem(i);
                    Log.i("ListView Items",value);
                    myDBHandler.listViewtoDB(value,i,sqLiteDatabase);
                }

                Toast.makeText(getBaseContext(),"Ingredients Saved", Toast.LENGTH_LONG).show();
                myDBHandler.close();
            }
        });

    }


}






