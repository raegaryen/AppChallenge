package com.ray.appchallenge.http.dto;

public class Msg {

    public final String id;
    public final String text;
    public final long time;

    public Msg(final String id, final String text, final long time) {
        this.id = id;
        this.text = text;
        this.time = time;
    }

}
