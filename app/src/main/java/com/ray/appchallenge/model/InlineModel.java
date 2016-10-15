package com.ray.appchallenge.model;

/**
 * @author  Raymond Chenon
 */

public class InlineModel extends AbstractModel {

    public final String text1;
    public final String text2;
    public final String imageUrl;
    public final String time;

    public InlineModel(final String text1, final String text2, final String imageUrl, final String time) {
        this.text1 = text1;
        this.text2 = text2;
        this.imageUrl = imageUrl;
        this.time = time;
    }

}
