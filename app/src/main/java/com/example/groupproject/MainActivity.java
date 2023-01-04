package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnImage, btnToast, btnGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Action Toast
        btnToast = findViewById(R.id.Btn_Toast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This Listener Button is Clicked", Toast.LENGTH_SHORT).show();

            }
        });

        //Action Grid
        btnGrid =findViewById(R.id.btn_grid);
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGrindView();
            }
        });

        //Action Image
        btnImage = findViewById(R.id.btn_Image);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Go To New page for viewing image", Toast.LENGTH_SHORT).show();
                openImageView();
            }
        });
    }

    public void openImageView(){
        Intent openImage = new Intent(getApplicationContext(),Image_view.class);
        startActivity(openImage);
    }

    public void openGrindView(){
        Intent openGrid = new Intent(getApplicationContext(),GridViewActivity.class);
        startActivity(openGrid);
    }
}