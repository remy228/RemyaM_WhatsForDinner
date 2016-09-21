package com.wearable.whatsfordinner;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class new_dish_activity extends AppCompatActivity {


    ImageView imageView;
    Button button;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    Button submitButton;
    EditText recipeInput ;
    TextView recipeText;
    Context context;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    Intent submitbuttonintent;

    ArrayList<String> recipesarray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recipeInput = (EditText)findViewById(R.id.ingredientsInput);
        submitButton = (Button)findViewById(R.id.submitButton);
        recipeText = (TextView) findViewById(R.id.recipeText);
        imageView = (ImageView)findViewById(R.id.imageView);
        button = (Button)findViewById(R.id.photobutton);

        //Send recipe intent
        submitbuttonintent = new Intent(new_dish_activity.this, Ingredients.class);



        button.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                openGallery();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String recipename = recipeInput.getText().toString();

                if(recipesarray.contains(recipename))
                {
                    Toast.makeText(getBaseContext(),"Recipe already exists!", Toast.LENGTH_LONG).show();
                }
                else {
                    recipesarray.add(recipename);
                    myDBHandler = new MyDBHandler(getApplicationContext());
                    sqLiteDatabase = myDBHandler.getWritableDatabase();
                    myDBHandler.addRecipeInformation(recipename, sqLiteDatabase);
                    Toast.makeText(getBaseContext(), "Recipe Saved", Toast.LENGTH_LONG).show();
                    myDBHandler.close();
                    //Send to Ingredients activity
                    submitbuttonintent.putExtra("Recipe",recipename);
                    startActivity(submitbuttonintent);

                }


            }
        });

   }

    //Choose image from gallery
    private void openGallery()
    {
        Log.i("Image add on click","Test works");
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
        }
    }

    //Move to Add Ingredients Activity
    public void addIngredients(View view)
    {
        Intent intent = new Intent(this,Ingredients.class);
        Log.i("Ingredients screen","testing ");
        startActivity(intent);
    }

    //Move to Add Directions Activity
    public void addDirections(View view)
    {
        Intent intent = new Intent(this,Cooking_Directions.class);
        Log.i("Directions","testing ");
        startActivity(intent);
    }


}
