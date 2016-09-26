package com.wearable.whatsfordinner;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class new_dish_activity extends AppCompatActivity {


    ImageView imageView;
    Button button;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    Button submitButton;
    EditText recipeInput ;
    TextView recipeText;
    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    Button addIngredientButton;
    Button addDirectionsButton;
    Button addNutritionButton;
    String recipename;
    Intent editintent=getIntent();

    ArrayList<String> recipesarray = new ArrayList<>();
    ArrayList<String> recipesarray_new = new ArrayList<>();


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recipeInput = (EditText) findViewById(R.id.ingredientsInput);
        submitButton = (Button) findViewById(R.id.submitButton);
        recipeText = (TextView) findViewById(R.id.recipeText);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.photobutton);
        addIngredientButton = (Button) findViewById(R.id.addIngredient);
        addDirectionsButton = (Button) findViewById(R.id.addDirections);
        addNutritionButton = (Button) findViewById(R.id.addNutrition);

        editintent = new Intent(new_dish_activity.this, new_dish_activity.class);
        Bundle extras=getIntent().getExtras();
            if(extras!=null) {
                String recipe_name = extras.getString("Recipe");
                System.out.println("Intent test from new dish:" + recipe_name);
                recipeInput.setText(recipe_name);
            }


        //Send recipe intent


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               recipename = recipeInput.getText().toString();

                myDBHandler = new MyDBHandler(getApplicationContext());
                sqLiteDatabase = myDBHandler.getReadableDatabase();

                if(!recipesarray_new.contains("Rem_Test"))

                {
                    recipesarray_new.add("Rem_Test");
                }

                Cursor cur = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME, null);
                try {
                    while (cur.moveToNext()) {
                        String uname = cur.getString(cur.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME));
                        recipesarray_new.add(uname);
                        Log.i("Recipe Array", "Recipes Added to array");

                    }

                } finally {
                    cur.close();
                }

                if (recipesarray_new.contains(recipename)) {
                    Toast.makeText(getBaseContext(), "Recipe already exists!", Toast.LENGTH_LONG).show();
                }
                else  if(!recipename.isEmpty())

                {
                    Intent intent = new Intent(new_dish_activity.this, Ingredients.class);
                    recipesarray.add(recipename);
                    myDBHandler = new MyDBHandler(getApplicationContext());
                    sqLiteDatabase = myDBHandler.getWritableDatabase();
                    myDBHandler.addRecipeInformation(recipename, sqLiteDatabase);
                    Toast.makeText(getBaseContext(), "Recipe Saved", Toast.LENGTH_LONG).show();
                    myDBHandler.close();
                    intent.putExtra("Recipe", recipename);
                    startActivity(intent);

                }

                    else
                    {
                        Toast.makeText(getBaseContext(), "Please enter a Recipe to continue!", Toast.LENGTH_LONG).show();
                    }


                }

        });


        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipename = recipeInput.getText().toString();
                Intent intent = new Intent(new_dish_activity.this, Ingredients.class);
                Log.i("Ingredients button", "testing activity");
                   if (!recipename.isEmpty()) {
                        intent.putExtra("Recipe", recipename);
                        startActivity(intent);
                    }

                    else
                    {
                        Toast.makeText(getBaseContext(), "Please enter a Recipe to continue!", Toast.LENGTH_LONG).show();
                    }

                }

        });


    addDirectionsButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            recipename = recipeInput.getText().toString();
            Intent intent = new Intent(new_dish_activity.this, Cooking_Directions.class);
            Log.i("Directions button", "testing activity");
                if (!recipename.isEmpty()) {
                    intent.putExtra("Recipe", recipename);
                    startActivity(intent);
                 }

            else
            {
                Toast.makeText(getBaseContext(), "Please enter a Recipe to continue!", Toast.LENGTH_LONG).show();
            }

        }
    });

   addNutritionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recipename = recipeInput.getText().toString();
                Intent intent = new Intent(new_dish_activity.this, Nutrition_Manager.class);
                Log.i("Directions button", "testing activity");
                    if (!recipename.isEmpty()) {
                        intent.putExtra("Recipe", recipename);
                        startActivity(intent);
                    }

                else
                {
                    Toast.makeText(getBaseContext(), "Please enter a Recipe to continue!", Toast.LENGTH_LONG).show();
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
