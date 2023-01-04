package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.btnok);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This Listener Button is Clicked", Toast.LENGTH_SHORT).show();

            }
        });



        btnimage = findViewById(R.id.btn2);
        btnimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Go To New page for viewing image", Toast.LENGTH_SHORT).show();
                openGridView();
            }
        });
    }

    public void openGridView(){
        Intent intent = new Intent(getApplicationContext(),Image_view.class);
        startActivity(intent);
    }
}