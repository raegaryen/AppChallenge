package com.ray.appchallenge.dto;

public class Msg {

    public final String id;
    public final String text;
    public final long time;

    public Msg(String id, String text, long time) {
        this.id = id;
        this.text = text;
        this.time = time;
    }

}
