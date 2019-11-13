package com.yasser.elsalamwoods.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yasser.elsalamwoods.R;

public class MainActivity extends AppCompatActivity {
    Button btn_mwoz3,btn_3amel;
    public static int mwaze3or3amel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_3amel = findViewById(R.id.btn_3amel);
        btn_mwoz3 = findViewById(R.id.btn_mwoz33);

        btn_mwoz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mwaze3or3amel = 0;
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        btn_3amel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mwaze3or3amel = 1;
                Intent intent = new Intent(MainActivity.this,CategotiesActivity.class);
                startActivity(intent);
            }
        });
    }
}
