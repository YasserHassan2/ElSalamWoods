package com.yasser.elsalamwoods.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yasser.elsalamwoods.Adapter.CustomItemClickListener;
import com.yasser.elsalamwoods.Adapter.Product3amelRecyclerViewAdapter;
import com.yasser.elsalamwoods.Adapter.ProductMowaz3RecyclerViewAdapter;
import com.yasser.elsalamwoods.Model.Product;
import com.yasser.elsalamwoods.Parse_DBHelper;
import com.yasser.elsalamwoods.R;

import java.util.ArrayList;
import java.util.List;

import static com.yasser.elsalamwoods.UI.MainActivity.mwaze3or3amel;

public class ProductsActivity extends AppCompatActivity {

    Parse_DBHelper parse_dbHelper;
    String prductId;
    ArrayList<Product> products = new ArrayList<Product>();
    RecyclerView productRecycelrVIew;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        parse_dbHelper = new Parse_DBHelper(ProductsActivity.this);
        parse_dbHelper.connectToDB(ProductsActivity.this);
        intent = getIntent();
        productRecycelrVIew = findViewById(R.id.prodRecyclerView);
        if (mwaze3or3amel == 0)
            loadProductByCatIdAndCustomerType(intent.getStringExtra("catId"),true);
        else
            loadProductByCatIdAndCustomerType(intent.getStringExtra("catId"),false);


    }

    public void loadProductByCatIdAndCustomerType(String categoryId, Boolean loadMwze3) {
        if (loadMwze3 == true) {

            final ProgressDialog pd = ProgressDialog.show(ProductsActivity.this, "", "جــارى التحميل برجاء الانتظار", true);

            ParseQuery<ParseObject> query = ParseQuery.getQuery("products");
            query.whereEqualTo("cat_id", categoryId);


            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, final ParseException e) {
                    if (e == null) {
                        for (ParseObject o : objects) {

                            prductId = o.getObjectId();
                            String currentProjectId = o.getObjectId();
                            ParseFile image = o.getParseFile("pr_img");
                            String imgURL = image.getUrl();
                            String name = o.getString("pr_name");
                            String gomlaPrice = o.getString("pr_gomla_price");
                            String ata3yPrice = o.getString("pr_ata3y_price");
                            String descirption = o.getString("pr_description");
                            String catId = o.getString("projecgt_price");
                            String type = o.getString("pr_type");


                            Product product = new Product(prductId, catId, imgURL, name, type, descirption, gomlaPrice, ata3yPrice);
                            products.add(product);

                        }


                        productRecycelrVIew.setLayoutManager(new LinearLayoutManager(ProductsActivity.this, LinearLayoutManager.VERTICAL, false));

                        ProductMowaz3RecyclerViewAdapter adapter = new ProductMowaz3RecyclerViewAdapter(ProductsActivity.this, products);

                        productRecycelrVIew.setAdapter(adapter);

                        pd.dismiss();


                        adapter.setOnItemClickListener(new CustomItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                            sendToDetailsWithObjectMwz3(products.get(position));

                            }
                        });

                    } else {
                        Toast.makeText(ProductsActivity.this, "error: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {

            final ProgressDialog pd = ProgressDialog.show(ProductsActivity.this, "", "جــارى التحميل برجاء الانتظار", true);

            ParseQuery<ParseObject> query = ParseQuery.getQuery("products");
            query.whereEqualTo("cat_id", categoryId);


            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, final ParseException e) {
                    if (e == null) {
                        for (ParseObject o : objects) {

                            prductId = o.getObjectId();
                            String currentProjectId = o.getObjectId();
                            ParseFile image = o.getParseFile("pr_img");
                            String imgURL = image.getUrl();
                            String name = o.getString("pr_name");
                            String gomlaPrice = o.getString("pr_gomla_price");
                            String ata3yPrice = o.getString("pr_ata3y_price");
                            String descirption = o.getString("pr_description");
                            String catId = o.getString("projecgt_price");
                            String type = o.getString("pr_type");


                            Product product = new Product(prductId, catId, imgURL, name, type, descirption, gomlaPrice, ata3yPrice);
                            products.add(product);

                        }


                        productRecycelrVIew.setLayoutManager(new LinearLayoutManager(ProductsActivity.this, LinearLayoutManager.VERTICAL, false));


                        Product3amelRecyclerViewAdapter adapter = new Product3amelRecyclerViewAdapter(ProductsActivity.this, products);

                        productRecycelrVIew.setAdapter(adapter);


                        pd.dismiss();
                        adapter.setOnItemClickListener(new CustomItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                              sendToDetailsWithObjectM3amel(products.get(position));
                            }
                        });

                    } else {
                        Toast.makeText(ProductsActivity.this, "error: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
    public void sendToDetailsWithObjectMwz3(Product product){
        String imageURL = product.getPrImageURL();
        String name = product.getPrName();
        String desc = product.getPrDescri();
        String type = product.getPrType();
        String price = product.getPrPriceMwoza3();

        Intent intent = new Intent(ProductsActivity.this,DetailsActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("imageURL",imageURL);
        intent.putExtra("desc",desc);
        intent.putExtra("type",type);
        intent.putExtra("price",price);
        startActivity(intent);

    }
    public void sendToDetailsWithObjectM3amel(Product product){
        String imageURL = product.getPrImageURL();
        String name = product.getPrName();
        String desc = product.getPrDescri();
        String type = product.getPrType();
        String price = product.getPrPrice3amel();

        Intent intent = new Intent(ProductsActivity.this,DetailsActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("imageURL",imageURL);
        intent.putExtra("desc",desc);
        intent.putExtra("type",type);
        intent.putExtra("price",price);
        startActivity(intent);

    }
}


