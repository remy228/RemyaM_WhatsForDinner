package com.wearable.whatsfordinner;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;

public class new_dish_activity extends AppCompatActivity {

    ImageView imageView;
    Button button;
    // new
    private String recipename;

    public new_dish_activity(){

    }

    public new_dish_activity(String recipename) {this.recipename = recipename;}

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public String getRecipename() {
        return recipename;
    }

    private static final int PICK_IMAGE = 100;
    Uri imageUri;


    EditText recipeInput;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView)findViewById(R.id.imageView);
        button = (Button)findViewById(R.id.photobutton);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                openGallery();
            }
        });


        //Storing Recipes in an Array
        recipeInput = (EditText)findViewById(R.id.ingredientsInput);
        submitButton = (Button)findViewById(R.id.submitButton);

    }
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

    public void addIngredients(View view)
    {
        Intent intent = new Intent(this,Ingredients.class);
        Log.i("Ingredients screen","testing ");
        startActivity(intent);
    }

    public void addDirections(View view)
    {
        Intent intent = new Intent(this,Cooking_Directions.class);
        Log.i("Directions","testing ");
        startActivity(intent);
    }


}
