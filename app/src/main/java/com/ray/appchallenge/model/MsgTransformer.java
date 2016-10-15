package com.ray.appchallenge.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ray.appchallenge.dto.Msg;

/**
 * @author  Raymond Chenon
 */

public class MsgTransformer {

    public MsgTransformer() { }

    public List<AbstractModel> transform(final List<Msg> items) {

        LinkedList<AbstractModel> list = new LinkedList();

        for (Msg msg : items) {
            if (msg.text.startsWith("https://")) {
                list.add(new ImageModel(msg.text, convertTimestamp(msg.time)));
            } else {
                list.add(new MessageModel(msg.text, convertTimestamp(msg.time)));
            }
        }

        return list;
    }

    private String convertTimestamp(final long timestamp) {
        Date date = new Date(timestamp);
        return date.toString();
    }

}
