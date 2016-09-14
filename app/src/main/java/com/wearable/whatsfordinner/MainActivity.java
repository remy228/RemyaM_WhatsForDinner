package com.wearable.whatsfordinner;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }
    public void printMsg(View view)
    {

        Log.i("Banner onClick","Test here");
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.popup, null);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("App_Information");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        //alert.setCancelable(false);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"toast test", Toast.LENGTH_SHORT).show();
                Log.i("Banner onClick","Test here 2");
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void addNewMeals(View view)
    {
        Intent intent = new Intent(this,new_dish_activity.class);
        Log.i("Meals button on Click","testing activity 2");
        startActivity(intent);
    }

    public void viewRecipes(View view)
    {
        Intent intent = new Intent(this,Recipes_Activity.class);
        Log.i("Recipes button on Click","testing activity 3");
        startActivity(intent);
    }

    public void viewGroceries(View view)
    {
        Intent intent = new Intent(this,groceries_activity.class);
        Log.i("Recipes button on Click","testing activity 4");
        startActivity(intent);
    }

    public void viewMeals(View view)
    {
        Intent intent = new Intent(this,meals_activity.class);
        Log.i("Recipes button on Click","testing activity 5");
        startActivity(intent);
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
