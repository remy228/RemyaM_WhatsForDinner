package com.wearable.whatsfordinner;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import  android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LandscapeFragment extends android.app.Fragment {

    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    ListView recipelistview;
    ArrayList<String> recipearray = new ArrayList<>();
    ArrayList<String> ingredientsarray = new ArrayList<>();
    ArrayList<String> directionsarray = new ArrayList<>();
    TextView textview;
    TextView textview2;


    public LandscapeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_landscape, container, false);

        //Extract Recipe values from database
        recipelistview = (ListView) view.findViewById(R.id.display_listview);
        textview = (TextView) view.findViewById(R.id.ingredientstextView);
        textview2 = (TextView) view.findViewById(R.id.directionstextView);

        myDBHandler = new MyDBHandler(getActivity().getApplicationContext());
        sqLiteDatabase = myDBHandler.getReadableDatabase();

        Cursor cur = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME, null);
        try {
            while (cur.moveToNext()) {
                String uname = cur.getString(cur.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_RECIPENAME));
                recipearray.add(uname);
                Log.i("Recipe Array", "Recipes Added to array");

            }

        } finally {
            cur.close();
        }

        for (int i = 0; i < recipearray.size(); i++) {
            if (recipearray.toString() != null) {
                if (!recipearray.toString().isEmpty()) {
                    System.out.println("Array Values: " + recipearray.get(i));
                    ArrayAdapter<String> arrayadapter1 = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, recipearray);
                    recipelistview.setAdapter(arrayadapter1);
                    arrayadapter1.notifyDataSetChanged();

                }
            }
                else {
                    System.out.println("Empty Array value found");
                }
                }

        //Recipe Item Set OnClickListener select the Ingredients and Directions for selected recipe
            recipelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            String selectedRecipe = recipelistview.getItemAtPosition(position).toString();


            //Retrieve the ingredients and directions
            //1st Item
            Cursor cur1 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM1 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur1.moveToNext()) {
                    String iname = cur1.getString(cur1.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM1));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur1.close();
            }

            //2nd Item
            Cursor cur2 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM2 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur2.moveToNext()) {
                    String iname = cur2.getString(cur2.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM2));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur2.close();
            }


            //3rd Item
            Cursor cur3 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM3 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur3.moveToNext()) {
                    String iname = cur3.getString(cur3.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM3));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur3.close();
            }

            //4th Item
            Cursor cur4 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM4 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur4.moveToNext()) {
                    String iname = cur4.getString(cur4.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM4));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur4.close();
            }

            //5th Item
            Cursor cur5 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM5 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur5.moveToNext()) {
                    String iname = cur5.getString(cur5.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM5));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur5.close();
            }

            //6th Item
            Cursor cur6 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM6 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur6.moveToNext()) {
                    String iname = cur6.getString(cur6.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM6));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur6.close();
            }

            //7th Item
            Cursor cur7 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM7 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur7.moveToNext()) {
                    String iname = cur7.getString(cur7.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM7));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur7.close();
            }

            //8th Item
            Cursor cur8 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM8 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur8.moveToNext()) {
                    String iname = cur8.getString(cur8.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM8));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur8.close();
            }

            //9th Item
            Cursor cur9 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM9 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur9.moveToNext()) {
                    String iname = cur9.getString(cur9.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM9));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur9.close();
            }

            //10th Item
            Cursor cur10 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_ITEM10 + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur10.moveToNext()) {
                    String iname = cur10.getString(cur10.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_ITEM10));
                    if (iname != null) {
                        if (!iname.isEmpty()) {

                            ingredientsarray.add(iname);
                            System.out.println("Ingredients Array: " + iname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur10.close();
            }

            //Cooking Directions
            Cursor cur11 = sqLiteDatabase.rawQuery("SELECT " + RecipeContract.NewRecipeInfo.COLUMN_DIRECTIONS + " FROM " + RecipeContract.NewRecipeInfo.TABLE_NAME + " where Recipe_Name = '" + selectedRecipe + "'", null);
            try {
                while (cur11.moveToNext()) {
                    String rname = cur11.getString(cur11.getColumnIndex(RecipeContract.NewRecipeInfo.COLUMN_DIRECTIONS));
                    if (rname != null) {
                        if (!rname.isEmpty()) {

                            directionsarray.add(rname);
                            System.out.println("Cooking Directions" + rname);
                            Toast.makeText(getActivity().getBaseContext(), "Recipe Selected: " + selectedRecipe, Toast.LENGTH_LONG).show();
                        }
                    }

                }

            } finally {
                cur11.close();
            }

            StringBuilder builder = new StringBuilder();
            for (String s : ingredientsarray) {
                builder.append(s + "\n");
            }

            textview.setText(builder.toString());
            ingredientsarray.clear();

            StringBuilder builder2 = new StringBuilder();
            for (String d : directionsarray) {
                builder2.append(d + "\n");

            }
            textview2.setText(builder2.toString());
            directionsarray.clear();
        }
   });



        return view;
    }
}



