package com.ray.appchallenge.adapter;

import java.util.LinkedList;
import java.util.List;

import com.ray.appchallenge.adapter.viewholder.MsgViewHolder;
import com.ray.appchallenge.dto.Msg;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.ViewGroup;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {

    private List<Msg> list;

    public MsgAdapter() {
        this.list = new LinkedList<Msg>();
    }

    public MsgAdapter(final List<Msg> list) {
        this.list = list;
    }

    @Override
    public MsgViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return MsgViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(final MsgViewHolder holder, final int position) {
        Msg item = list.get(position);
        holder.bindData(item);
    }

    public void addItems(@NonNull final List<Msg> newItems) {
        if (newItems != null && !newItems.isEmpty()) {
            list.addAll(newItems);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
