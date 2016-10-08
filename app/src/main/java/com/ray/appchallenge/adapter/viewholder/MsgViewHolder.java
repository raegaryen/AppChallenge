package com.ray.appchallenge.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ray.appchallenge.R;
import com.ray.appchallenge.dto.Msg;



public class MsgViewHolder extends RecyclerView.ViewHolder {

    private ViewGroup container;
    private TextView textView;

    public static MsgViewHolder create(ViewGroup viewGroup){

        ViewGroup container = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.message_viewholder, viewGroup, false);
        return new MsgViewHolder(container);
    }

    public MsgViewHolder(final ViewGroup itemView) {
        super(itemView);
        this.container = itemView;
        this.textView = (TextView) itemView.findViewById(R.id.viewholer_text);
    }

    public void bindData(final Msg item){
        textView.setText(item.text);
    }

}
