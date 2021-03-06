package com.ray.appchallenge.adapter.delegate;

import java.util.List;

import com.bumptech.glide.Glide;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import com.ray.appchallenge.R;
import com.ray.appchallenge.model.AbstractModel;
import com.ray.appchallenge.model.InlineImageModel;

import android.app.Activity;

import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author  Raymond Chenon
 */

public class InlineImageAdapterDelegate extends AdapterDelegate<List<AbstractModel>> {

    private LayoutInflater inflater;

    public InlineImageAdapterDelegate(final Activity activity) {
        inflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(@NonNull final List<AbstractModel> items, final int position) {
        return items.get(position) instanceof InlineImageModel;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        return new InlineImageAdapterDelegate.ViewHolder(inflater.inflate(R.layout.inline_image_viewholder, parent,
                    false));
    }

    @Override
    protected void onBindViewHolder(@NonNull final List<AbstractModel> items, final int position,
            @NonNull final RecyclerView.ViewHolder holder, @NonNull final List<Object> payloads) {
        InlineImageAdapterDelegate.ViewHolder vh = (ViewHolder) holder;
        InlineImageModel model = (InlineImageModel) items.get(position);

        Glide.with(vh.imageView.getContext()).load(model.imageUrl).thumbnail(0.2f).fitCenter().crossFade()
             .error(R.drawable.ic_error).into(vh.imageView);

        vh.text1.setText(model.text1);
        vh.text2.setText(model.text2);
        vh.time.setText(model.time);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text1, text2, time;
        private ImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView);

            text1 = (TextView) itemView.findViewById(R.id.viewholder_inline_text1);
            text2 = (TextView) itemView.findViewById(R.id.viewholder_inline_text2);
            time = (TextView) itemView.findViewById(R.id.viewholder_inline_time);
            imageView = (ImageView) itemView.findViewById(R.id.viewholder_inline_imageview);
        }
    }
}
