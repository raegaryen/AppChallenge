package com.ray.appchallenge.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ray.appchallenge.adapter.viewholder.MsgViewHolder;
import com.ray.appchallenge.dto.Msg;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {

    private final List<Msg> list;

    public MsgAdapter(final List<Msg> list){
        this.list = list;
    }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return MsgViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, int position) {
        Msg item = list.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
