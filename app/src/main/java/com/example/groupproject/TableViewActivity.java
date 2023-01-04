package com.example.groupproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class TableViewActivity extends Activity, MainActivity{

    Button btnTabNext, btnTabBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_table);


    }

    public void openAnimation(){
        Intent openAnim = new Intent(getApplicationContext(),AnimActivity.class);
        startActivity(openAnim);
    }

    public void openImage(){
        Intent openIma
    }
}
