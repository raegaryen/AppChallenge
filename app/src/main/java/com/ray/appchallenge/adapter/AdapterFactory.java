package com.ray.appchallenge.adapter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import com.ray.appchallenge.adapter.delegate.ImageAdapterDelegate;
import com.ray.appchallenge.adapter.delegate.MessageAdapterDelegate;
import com.ray.appchallenge.model.AbstractModel;
import com.ray.appchallenge.swipetodelete.ItemTouchHelperAdapter;

import android.app.Activity;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.ViewGroup;

/**
 * @author  Raymond Chenon
 */

public class AdapterFactory extends RecyclerView.Adapter implements ItemTouchHelperAdapter {

    private AdapterDelegatesManager<List<AbstractModel>> delegatesManager;
    private List<AbstractModel> list;

    public AdapterFactory(final Activity activity) {
        this.list = new LinkedList<AbstractModel>();
        delegatesManager = new AdapterDelegatesManager<>();
        delegatesManager.addDelegate(new ImageAdapterDelegate(activity));
        delegatesManager.addDelegate(new MessageAdapterDelegate(activity));
    }

    @Override
    public int getItemViewType(final int position) {
        return delegatesManager.getItemViewType(list, position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return delegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        delegatesManager.onBindViewHolder(list, position, holder);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position, final List payloads) {
        delegatesManager.onBindViewHolder(list, position, holder, payloads);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void addItems(@NonNull final List<AbstractModel> newItems) {
        if (newItems != null && !newItems.isEmpty()) {
            list.addAll(newItems);
        }
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
