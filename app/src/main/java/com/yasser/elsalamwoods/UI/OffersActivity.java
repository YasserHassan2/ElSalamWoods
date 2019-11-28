package com.yasser.elsalamwoods.UI;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.flatdialoglibrary.dialog.FlatDialog;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yasser.elsalamwoods.Adapter.CustomItemClickListener;
import com.yasser.elsalamwoods.Adapter.OfferAdapter;
import com.yasser.elsalamwoods.Adapter.ProductMowaz3RecyclerViewAdapter;
import com.yasser.elsalamwoods.Adapter.RecyclerViewAdapter;
import com.yasser.elsalamwoods.BuildConfig;
import com.yasser.elsalamwoods.Model.Product;
import com.yasser.elsalamwoods.Model.offer;
import com.yasser.elsalamwoods.Parse_DBHelper;
import com.yasser.elsalamwoods.R;

import java.util.ArrayList;
import java.util.List;

public class OffersActivity extends AppCompatActivity {
    ArrayList<offer> offers = new ArrayList<offer>();
    RecyclerView mRecyclerView;
    OfferAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        Parse_DBHelper parse_dbHelper = new Parse_DBHelper(OffersActivity.this);
        parse_dbHelper.connectToDB(OffersActivity.this);
        mRecyclerView = findViewById(R.id.offerRecyclerView);
        loadOffers();

    }

    private void loadOffers() {
        final ProgressDialog pd = ProgressDialog.show(OffersActivity.this, "", "جــارى التحميل برجاء الانتظار", true);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("offer");


        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, final ParseException e) {
                if (e == null) {
                    for (ParseObject o : objects) {

                        ParseFile image = o.getParseFile("offer_img");
                        String imgURL = image.getUrl();
                        String offer_title = o.getString("offer_title");
                        String offer_desc = o.getString("offer_desc");
                        String offerEnddate = o.getString("offer_enddate");


                        offer offer = new offer(imgURL, offer_title, offer_desc, offerEnddate);
                        offers.add(offer);

                    }


                    mRecyclerView.setLayoutManager(new LinearLayoutManager(OffersActivity.this, LinearLayoutManager.VERTICAL, false));
                    adapter = new OfferAdapter(OffersActivity.this, offers);
                    mRecyclerView.setAdapter(adapter);

                    pd.dismiss();


                    adapter.setOnItemClickListener(new CustomItemClickListener() {
                        @Override
                        public void onItemClick(View view, final int position) {

                            final FlatDialog flatDialog = new FlatDialog(OffersActivity.this);
                            flatDialog.setTitle("     استعلام عن العرض")
                                    .setSubtitle("يمكن التواصل معنا عن طريق زيارة موقعنا او الاتصال على رقم خدمة العملاء")
                                    .setFirstButtonText("زيارة موقعـــــنا")
                                    .setSecondButtonText("اتصال على خدمة العملاء")
                                    .setThirdButtonText("مشاركة العرض")
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
                                    })
                                    .withThirdButtonListner(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            try {
                                                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                                                shareIntent.setType("text/plain");
                                                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "تطبيق السلام للاخشاب");
                                                String shareMessage = "\nللحصول على افضل العروض و متابعة افضل انواع الابواب حمل دلوقتى تطبيق من على المتجر\n\n";
                                                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" +
                                                        BuildConfig.APPLICATION_ID +
                                                        "\n\n";
                                                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                                                startActivity(Intent.createChooser(shareIntent, "choose one"));
                                            } catch (Exception e) {
                                                Toast.makeText(OffersActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    })
                                    .isCancelable(true)
                                    .show();
                        }
                    });

                } else {
                    Toast.makeText(OffersActivity.this, "error: " + e, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
