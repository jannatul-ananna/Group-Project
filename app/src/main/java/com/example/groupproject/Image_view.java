package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Image_view extends AppCompatActivity {

    //Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        //going back to activity_main
        /*btnBack = findViewById(R.id.button_image_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //calling MainActivity.java
                Intent callMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(callMain);
            }
        });*/
    }
}