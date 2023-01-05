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



public class TableViewActivity extends AppCompatActivity {
    NotificationManager notificationManager;
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
                callAnimNoti();

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

    public void callAnimNoti() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel("com.example.groupproject",
                    "Group Project", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.cancel(0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(TableViewActivity.this,
                    "com.example.groupproject");
            Notification notification = builder.setOngoing(true)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("This is Animation Tab")
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
