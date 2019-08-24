package com.example.firebasedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class DataViewHolder extends RecyclerView.ViewHolder {
    View mView;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setTitle(String title) {
        TextView post_title = mView.findViewById(R.id.post_title);
        post_title.setText(title);
    }

    public void setDesc(String desc) {
        TextView post_title = mView.findViewById(R.id.post_desc);
        post_title.setText(desc);
    }

    public void setImage(Context ctx, String image) {
        ImageView post_image = mView.findViewById(R.id.post_image);
        Picasso.with(ctx).load(image).into(post_image);
    }
}
