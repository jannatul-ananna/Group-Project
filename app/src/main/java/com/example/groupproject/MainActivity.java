package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.groupproject.R.id;

public class MainActivity extends AppCompatActivity {

    Button buttonImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(id.button_toast);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This Listener Button is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        buttonImage = findViewById(id.button_image);
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Go To New page for viewing image", Toast.LENGTH_SHORT).show();

                //Calling Image_view.java
                Intent callImage = new Intent(getApplicationContext(),Image_view.class);
                startActivity(callImage);
            }
        });

        /*GridView gridView = (GridView) findViewById(R.id.grid_image_view);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                Intent i = new Intent(getApplicationContext(),SingleViewActivity.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });*/
    }
}