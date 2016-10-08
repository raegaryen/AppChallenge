package com.ray.appchallenge.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ray.appchallenge.R;
import com.ray.appchallenge.dto.Msg;

import java.util.Date;


public class MsgViewHolder extends RecyclerView.ViewHolder {

    private ViewGroup container;
    private TextView textView;
    private TextView timeTextView;

    public static MsgViewHolder create(ViewGroup viewGroup){

        ViewGroup container = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.message_viewholder, viewGroup, false);
        return new MsgViewHolder(container);
    }

    public MsgViewHolder(final ViewGroup itemView) {
        super(itemView);
        this.container = itemView;
        this.textView = (TextView) itemView.findViewById(R.id.viewholder_text);
        this.timeTextView = (TextView) itemView.findViewById(R.id.viewholder_time);
    }

    public void bindData(final Msg item){
        textView.setText(item.text);
        Date date = new Date(item.time);
        timeTextView.setText(date.toString());
    }

}
