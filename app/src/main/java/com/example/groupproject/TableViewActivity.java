package com.example.groupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TableViewActivity extends Activity{

    Button btnTabNext, btnTabBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_table);

        //Action to Animation
        btnTabNext = findViewById(R.id.button_table_next);
        btnTabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnimation();
            }
        });

        //Action to Image
        btnTabBack = findViewById(R.id.button_table_back);
        btnTabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageView();
            }
        });
    }

    public void openAnimation(){
        Intent openAnim = new Intent(getApplicationContext(),AnimActivity.class);
        startActivity(openAnim);
    }

    public void openImageView(){
        Intent openImage =  new Intent(getApplicationContext(),Image_view.class);
        startActivity(openImage);
    }
}
