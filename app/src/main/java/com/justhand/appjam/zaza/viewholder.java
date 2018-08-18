package com.justhand.appjam.zaza;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class viewholder extends RecyclerView.ViewHolder {
    public ImageView profile_img;

    public viewholder(View itemView) {
        super(itemView);

        profile_img = (ImageView) itemView.findViewById(R.id.profile_img);
    }


}
