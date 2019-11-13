package com.yasser.elsalamwoods;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class CategotiesActivity extends AppCompatActivity {

    ArrayList<Category> categories = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoties);
        addingCategpries();


        mRecyclerView = (RecyclerView) findViewById(R.id.catRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(CategotiesActivity.this, LinearLayoutManager.VERTICAL, false));

        adapter = new RecyclerViewAdapter(CategotiesActivity.this, categories);

        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(CategotiesActivity.this, categories.get(position).getCatName(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void addingCategpries() {
        Category cat1 = new Category("ابــــواب مصفــــــحة", R.drawable.doorone);
        Category cat2 = new Category("ابــــواب زانــــــــ", R.drawable.doortwo);
        Category cat3 = new Category("ابــــواب اروبـــــــى", R.drawable.doorthree);
        Category cat4 = new Category("ابــــواب أرو", R.drawable.doorfour);
        Category cat5 = new Category("ابــــواب سويـــــــدى", R.drawable.doorfive);
        Category cat6 = new Category("ابــــواب خشــب موسكــى", R.drawable.doorsfin);

        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);
        categories.add(cat4);
        categories.add(cat5);
        categories.add(cat6);


    }
}
