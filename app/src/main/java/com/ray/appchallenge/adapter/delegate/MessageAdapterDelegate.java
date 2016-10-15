package com.ray.appchallenge.adapter.delegate;

import java.util.List;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import com.ray.appchallenge.R;
import com.ray.appchallenge.model.AbstractModel;
import com.ray.appchallenge.model.MessageModel;

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

public class MessageAdapterDelegate extends AdapterDelegate<List<AbstractModel>> {

    private LayoutInflater inflater;

    public MessageAdapterDelegate(final Activity activity) {
        inflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(@NonNull final List<AbstractModel> items, final int position) {
        return items.get(position) instanceof MessageModel;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        return new MessageAdapterDelegate.MessageViewHolder(inflater.inflate(R.layout.message_viewholder, parent,
                    false));
    }

    @Override
    protected void onBindViewHolder(@NonNull final List<AbstractModel> items, final int position,
            @NonNull final RecyclerView.ViewHolder holder, @NonNull final List<Object> payloads) {
        MessageAdapterDelegate.MessageViewHolder vh = (MessageAdapterDelegate.MessageViewHolder) holder;
        MessageModel model = (MessageModel) items.get(position);

        vh.textView.setText(model.text);
        vh.timeTextView.setText(model.time);
    }

    static class MessageViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private TextView timeTextView;

        public MessageViewHolder(final View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.viewholder_text);
            this.timeTextView = (TextView) itemView.findViewById(R.id.viewholder_time);
        }

    }
}
