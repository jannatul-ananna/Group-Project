package com.example.groupproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Image_view extends AppCompatActivity {

    Button btnBack, btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        //Action Back to Main
        btnBack = findViewById(R.id.back_from_image);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainAct();
            }
        });

        //Action to Table
        btnNext = findViewById(R.id.next_from_image);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTable();
            }
        });
    }

    public void openMainAct(){
        Intent openMain =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(openMain);
    }

    public void openTable(){
        Intent openTable = new Intent(getApplicationContext(),TableViewActivity.class);
        startActivity(openTable);
    }
}