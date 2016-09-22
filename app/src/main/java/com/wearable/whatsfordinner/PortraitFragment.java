package com.wearable.whatsfordinner;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import  android.app.Fragment;
import android.support.v4.app.FragmentActivity;
//import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PortraitFragment extends android.app.Fragment {

    MyDBHandler myDBHandler;
    SQLiteDatabase sqLiteDatabase;
    ListView recipelistview;
    ArrayList<String> recipearray = new ArrayList<>();


    public PortraitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_portrait, container, false);

        //Displaying values in the ListView
        recipelistview = (ListView) view.findViewById(R.id.display_listview);
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
        return view;

    }




}