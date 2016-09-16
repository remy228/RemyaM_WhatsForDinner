package com.wearable.whatsfordinner;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.Toast;

public class Ingredients extends AppCompatActivity {


    Spinner SPINNER;
    Button ADD;
    EditText EDITTEXT;
    //  TextView textview;
    String[] spinnerItems = new String[]{
            "Cheese", "Bread"
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

        stringlist = new ArrayList<>(Arrays.asList(spinnerItems));

        arrayadapter = new ArrayAdapter<String>(Ingredients.this,R.layout.textview,stringlist );

        arrayadapter.setDropDownViewResource(R.layout.textview);

        SPINNER.setAdapter(arrayadapter);

        ADD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                GETTEXT = EDITTEXT.getText().toString();

                stringlist.add(GETTEXT);

                arrayadapter.notifyDataSetChanged();

                Toast.makeText(Ingredients.this, "Item Added", Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}






