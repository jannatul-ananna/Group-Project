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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NotificationManager notificationManager;
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
                callGridNoti();
            }
        });

        //Action Image
        btnImage = findViewById(R.id.btn_Image);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thanks for viewing our images", Toast.LENGTH_SHORT).show();
                openImageView();
                callImageNoti();
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

    //Notification Image View
    public void callImageNoti() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("com.example.groupproject",
                    "Group Project", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.cancel(0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,
                    "com.example.groupproject");
            Notification notification = builder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("This is Image View")
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

    //Grid view notification
    public void callGridNoti() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("com.example.groupproject",
                    "Group Project", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.cancel(0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,
                    "com.example.groupproject");
            Notification notification = builder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("This is Grid View")
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