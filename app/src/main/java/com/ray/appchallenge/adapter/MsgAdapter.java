package com.ray.appchallenge.adapter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.ray.appchallenge.adapter.viewholder.MsgViewHolder;
import com.ray.appchallenge.dto.Msg;
import com.ray.appchallenge.swipetodelete.ItemTouchHelperAdapter;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.ViewGroup;

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> implements ItemTouchHelperAdapter {

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

    @Override
    public boolean onItemMove(final int fromPosition, final int toPosition) {
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(final int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }
}
