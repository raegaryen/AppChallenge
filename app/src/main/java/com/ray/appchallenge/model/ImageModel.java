package com.ray.appchallenge.model;

/**
 * @author  Raymond Chenon
 */

public class ImageModel extends AbstractModel {

    public final String imageUrl;
    public final String time;

    public ImageModel(final String imageUrl, final String time) {
        this.imageUrl = imageUrl;
        this.time = time;
    }

}
