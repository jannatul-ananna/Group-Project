package com.example.groupproject;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.ColorInt;

public class ImageAdapter extends BaseAdapter{
    private Context mContext;

    //Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    public int getCount(){
        return mThumbIds.length;
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    //create new image for each item
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;

        if (convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(275,275));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 12, 8,8);
            //imageView.setOutlineSpotShadowColor(@ColorInt);
        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public Integer[] mThumbIds = {
            R.drawable.item_01, R.drawable.item_02, R.drawable.item_03,
            R.drawable.item_04, R.drawable.item_05, R.drawable.item_06,
            R.drawable.item_07, R.drawable.item_08, R.drawable.item_09,
            R.drawable.item_10, R.drawable.item_11, R.drawable.item_12,
            R.drawable.item_13, R.drawable.item_14, R.drawable.item_15,
            R.drawable.item_16, R.drawable.item_17, R.drawable.item_18
    };
}
