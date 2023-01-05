package com.example.groupproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

public class Image_view extends AppCompatActivity {

    NotificationManager notificationManager;
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
                callTableNoti();
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

    public void callTableNoti() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("com.example.groupproject",
                    "Group Project", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(Image_view.this,
                    "com.example.groupproject");
            Notification notification = builder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("This is Table view")
                    .setPriority(NotificationManager.IMPORTANCE_HIGH)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .build();
            notificationManager.notify(0, notification);
            new CountDownTimer(10000, 100) {
                @Override
                public void onTick(long l) {
                }
                public void onFinish() {
                    notificationManager.cancel(0);
                }
            }.start();
        }
    }
}