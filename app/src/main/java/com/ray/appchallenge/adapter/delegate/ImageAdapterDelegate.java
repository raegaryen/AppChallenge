package com.ray.appchallenge.adapter.delegate;

import java.util.List;

import com.bumptech.glide.Glide;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import com.ray.appchallenge.R;
import com.ray.appchallenge.model.AbstractModel;
import com.ray.appchallenge.model.ImageModel;

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

public class ImageAdapterDelegate extends AdapterDelegate<List<AbstractModel>> {

    private LayoutInflater inflater;

    public ImageAdapterDelegate(final Activity activity) {
        inflater = activity.getLayoutInflater();
    }

    @Override
    protected boolean isForViewType(@NonNull final List<AbstractModel> items, final int position) {
        return items.get(position) instanceof ImageModel;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent) {
        return new ImageViewHolder(inflater.inflate(R.layout.image_viewholder, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull final List<AbstractModel> items, final int position,
            @NonNull final RecyclerView.ViewHolder holder, @NonNull final List<Object> payloads) {

        ImageViewHolder vh = (ImageViewHolder) holder;
        ImageModel model = (ImageModel) items.get(position);

        Glide.with(vh.imageView.getContext()).load(model.imageUrl).centerCrop().crossFade().into(vh.imageView);
        vh.time.setText(model.time);
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView time;

        public ImageViewHolder(final View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.viewholder_imageview);
            time = (TextView) itemView.findViewById(R.id.viewholder_image_time);
        }
    }
}
