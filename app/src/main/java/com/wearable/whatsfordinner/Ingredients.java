package com.wearable.whatsfordinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
   // ArrayAdapter<String> m_adapter;
    ArrayList<String> m_listItems = new ArrayList<String>();

    String[] spinnerItems = new String[]{
            "Select Ingredient","Cheese", "Bread"
    };

    String GETTEXT;
    List<String> stringlist;
    ArrayAdapter<String> arrayadapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
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

        SPINNER = (Spinner)findViewById(R.id.spinner1);
        ADD = (Button)findViewById(R.id.button1);
        EDITTEXT = (EditText)findViewById(R.id.editText1);
        lv = (ListView) findViewById(R.id.listView1);

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


            //Ends here



    }


}






