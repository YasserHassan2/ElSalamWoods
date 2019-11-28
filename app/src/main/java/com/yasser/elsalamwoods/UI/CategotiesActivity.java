package com.yasser.elsalamwoods.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.yasser.elsalamwoods.Adapter.CustomItemClickListener;
import com.yasser.elsalamwoods.Adapter.RecyclerViewAdapter;
import com.yasser.elsalamwoods.Model.Category;
import com.yasser.elsalamwoods.R;

import java.util.ArrayList;

public class CategotiesActivity extends AppCompatActivity {

    ArrayList<Category> categories = new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerViewAdapter adapter;

    ArrayList<SlideModel> imageList = new ArrayList<SlideModel>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoties);
        initBanner();
        addingCategpries();


        mRecyclerView = (RecyclerView) findViewById(R.id.catRecyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(CategotiesActivity.this,3));

        adapter = new RecyclerViewAdapter(CategotiesActivity.this, categories);

        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(CategotiesActivity.this, ProductsActivity.class);
                intent.putExtra("catId", categories.get(position).getId());
                startActivity(intent);
            }
        });


    }

    private void addingCategpries() {
        Category cat1 = new Category("1", "ابــواب مصفــحة", R.drawable.doortwo);
        Category cat2 = new Category("2", "ابــــواب زانـــ", R.drawable.doorone);
        Category cat3 = new Category("3", "ابــــواب اروبــى", R.drawable.doorsix);
        Category cat4 = new Category("4", "ابـواب أرو", R.drawable.doorfour);
        Category cat5 = new Category("5", "ابــــواب سويــدى", R.drawable.doorfive);
        Category cat6 = new Category("6", "ابواب خشب موسكى", R.drawable.doorsfin);

        categories.add(cat1);
        categories.add(cat2);
        categories.add(cat3);
        categories.add(cat4);
        categories.add(cat5);
        categories.add(cat6);


    }

    private void initBanner() {

        ImageSlider imageSlider = new ImageSlider(CategotiesActivity.this);
        imageSlider = findViewById(R.id.image_slider);

        imageList.add(new SlideModel(R.drawable.bannerone, "الحق عرض التخفيضات", true));

        imageList.add(new SlideModel(R.drawable.bannertwo, "عروض على الابواب المصفحة", true));

        imageList.add(new SlideModel(R.drawable.bannerthree, "عرض الابواب الزان", true));

        imageSlider.setImageList(imageList);
        imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                Intent intent = new Intent(CategotiesActivity.this,OffersActivity.class);
                startActivity(intent);
            }
        });

    }
}
