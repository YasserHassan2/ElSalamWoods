package com.yasser.elsalamwoods.UI;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.flatdialoglibrary.dialog.FlatDialog;
import com.yasser.elsalamwoods.R;

public class DetailsActivity extends AppCompatActivity {
    ImageView prImage;
    TextView prName, prType, prDesc, prPrice;
    Button btn_es3lam;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        prImage = findViewById(R.id.prImage);
        prName = findViewById(R.id.prName);
        prType = findViewById(R.id.prType);
        prDesc = findViewById(R.id.prDesc);
        prPrice = findViewById(R.id.prPrice);

        btn_es3lam = findViewById(R.id.btn_est3alm);

        intent = getIntent();

        Glide.with(DetailsActivity.this)
                .load(intent.getStringExtra("imageURL"))
                .into(prImage);

        prName.setText("اسم المنتج : " + intent.getStringExtra("name"));
        prDesc.setText("المواصفات : " + intent.getStringExtra("desc"));
        prType.setText("النوع : " + intent.getStringExtra("type"));
        prPrice.setText("السعــر : " + intent.getStringExtra("price") + " EGP");

        btn_es3lam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FlatDialog flatDialog = new FlatDialog(DetailsActivity.this);
                flatDialog.setTitle("     استعلام عن المنتج")
                        .setSubtitle("يمكن التواصل معنا عن طريق زيارة موقعنا او الاتصال على رقم خدمة العملاء")
                        .setFirstButtonText("زيارة موقعـــــنا")
                        .setSecondButtonText("اتصال على خدمة العملاء")
                        .withFirstButtonListner(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onClick(View view) {

                                String url = "http://www.google.com";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);

                            }
                        })
                        .withSecondButtonListner(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                intent.setData(Uri.parse("tel:" + "123123212"));
                                startActivity(intent);
                            }
                        }).isCancelable(true)
                        .show();
            }
        });


    }
}
