package com.example.new_year;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    public TextView textView, data;
    LinearLayout click;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        textView = itemView.findViewById(R.id.name);
        data = itemView.findViewById(R.id.data);
        click = itemView.findViewById(R.id.click);
    }

}
