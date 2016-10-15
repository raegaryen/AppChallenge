package com.ray.appchallenge.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ray.appchallenge.dto.Msg;

/**
 * @author  Raymond Chenon
 */

public class MsgTransformer {

    private static final String HTTPS = "https://";
    private static final String SEPARATOR = " ";

    public MsgTransformer() { }

    public List<AbstractModel> transform(final List<Msg> items) {

        LinkedList<AbstractModel> list = new LinkedList();

        for (Msg msg : items) {
            if (msg.text.startsWith(HTTPS)) {
                list.add(new ImageModel(msg.text, convertTimestamp(msg.time)));
            } else if (msg.text.contains(HTTPS)) {
                list.add(transformToInlineModel(msg));
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

    public InlineModel transformToInlineModel(final Msg item) {

        String[] array = item.text.split(SEPARATOR);

        String imageUrl = "";
        for (String s : array) {
            if (s.startsWith(HTTPS)) {
                imageUrl = s;
                break;
            }
        }

        int indexStart = item.text.indexOf(imageUrl);
        String text1 = item.text.substring(0, indexStart);
        String text2 = item.text.substring(indexStart + imageUrl.length());

        return new InlineModel(text1, text2, imageUrl, convertTimestamp(item.time));
    }

}
