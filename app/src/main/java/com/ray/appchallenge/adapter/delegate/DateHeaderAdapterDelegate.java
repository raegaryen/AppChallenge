package com.ray.appchallenge.adapter.delegate;

import java.util.List;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import com.ray.appchallenge.R;
import com.ray.appchallenge.model.AbstractModel;
import com.ray.appchallenge.model.DateHeaderModel;

import android.app.Activity;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

/**
 * @author  Raymond Chenon
 */

public class DateHeaderAdapterDelegate extends AdapterDelegate<List<AbstractModel>> {

    private LayoutInflater inflater;

    public DateHeaderAdapterDelegate(final Activity activity) {
        inflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(@NonNull final List<AbstractModel> items, final int position) {
        return items.get(position) instanceof DateHeaderModel;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        return new DateHeaderAdapterDelegate.ViewHolder(inflater.inflate(R.layout.date_header_viewholder, parent,
                    false));
    }

    @Override
    protected void onBindViewHolder(@NonNull final List<AbstractModel> items, final int position,
            @NonNull final RecyclerView.ViewHolder holder, @NonNull final List<Object> payloads) {

        DateHeaderAdapterDelegate.ViewHolder vh = (ViewHolder) holder;
        DateHeaderModel model = (DateHeaderModel) items.get(position);

        vh.dateTextView.setText(model.timeHeader);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView dateTextView;

        public ViewHolder(final View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.viewholder_date_text);
        }
    }
}
