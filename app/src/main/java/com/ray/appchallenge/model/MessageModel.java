package com.ray.appchallenge.model;

/**
 * @author  Raymond Chenon
 */

public class MessageModel extends AbstractModel {

    public final String text;
    public final String time;

    public MessageModel(final String text, final String time) {
        this.text = text;
        this.time = time;
    }

}
