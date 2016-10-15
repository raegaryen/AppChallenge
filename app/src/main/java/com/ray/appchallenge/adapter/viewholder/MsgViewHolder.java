package com.ray.appchallenge.adapter.viewholder;

import java.util.Date;

import com.bumptech.glide.Glide;

import com.ray.appchallenge.R;
import com.ray.appchallenge.dto.Msg;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MsgViewHolder extends RecyclerView.ViewHolder {

    private ViewGroup container;
    private TextView textView;
    private TextView timeTextView;
    private ImageView imageView;

    public static MsgViewHolder create(final ViewGroup viewGroup) {

        ViewGroup container = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.message_viewholder, viewGroup, false);
        return new MsgViewHolder(container);
    }

    public MsgViewHolder(final ViewGroup itemView) {
        super(itemView);
        this.container = itemView;
        this.textView = (TextView) itemView.findViewById(R.id.viewholder_text);
        this.timeTextView = (TextView) itemView.findViewById(R.id.viewholder_time);
        this.imageView = (ImageView) itemView.findViewById(R.id.viewholder_imageview);
    }

    public void bindData(final Msg item) {

        Date date = new Date(item.time);
        timeTextView.setText(date.toString());

        if (item.text.startsWith("https://")) {
            imageView.setVisibility(View.VISIBLE);
            textView.setVisibility(View.GONE);

            Glide.with(container.getContext()).load(item.text).centerCrop().crossFade().into(imageView);

        } else {
            imageView.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
            textView.setText(item.text);
        }
    }

}
