package com.yasser.elsalamwoods.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yasser.elsalamwoods.Adapter.CustomItemClickListener;
import com.yasser.elsalamwoods.Adapter.RecyclerViewAdapter;
import com.yasser.elsalamwoods.Model.Category;
import com.yasser.elsalamwoods.R;

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
                Intent intent = new Intent(CategotiesActivity.this,ProductsActivity.class);
                intent.putExtra("catId",categories.get(position).getId());
                startActivity(intent);
            }
        });


    }

    private void addingCategpries() {
        Category cat1 = new Category("1","ابــــواب مصفــــــحة", R.color.colorPrimary);
        Category cat2 = new Category("2","ابــــواب زانــــــــ", R.color.colorPrimary);
        Category cat3 = new Category("3","ابــــواب اروبـــــــى", R.color.colorPrimary);
        Category cat4 = new Category("4","ابــــواب أرو", R.color.colorPrimary);
        Category cat5 = new Category("5","ابــــواب سويـــــــدى", R.color.colorPrimary);
        Category cat6 = new Category("6","ابــــواب خشــب موسكــى", R.color.colorPrimary);

        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);
        categories.add(cat4);
        categories.add(cat5);
        categories.add(cat6);


    }
}
