package com.ray.appchallenge.model;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ray.appchallenge.http.dto.Msg;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

/**
 * @author  Raymond Chenon
 */

public class MsgTransformer {

    private static final String HTTPS = "https://";
    private static final String SEPARATOR = " ";

    private int currentEntryDay;
    private int previousEntryDay;
    private Calendar calendar;

    public MsgTransformer() {

        calendar = Calendar.getInstance();
    }

    public List<AbstractModel> transform(@NonNull final List<Msg> items) {

        LinkedList<AbstractModel> list = new LinkedList();

        for (Msg msg : items) {
            currentEntryDay = getDay(msg.time);
            if (currentEntryDay != previousEntryDay) {
                list.add(transformToTimeHeaderModel(msg.time));
            }

            if (msg.text.startsWith(HTTPS)) {
                list.add(transformToImageModel(msg));
            } else if (msg.text.contains(HTTPS)) {
                list.add(transformToInlineModel(msg));
            } else {
                list.add(transformToMessageModel(msg));
            }

            previousEntryDay = currentEntryDay;
        }

        return list;
    }

    private int getDay(final long timestamp) {
        calendar.setTimeInMillis(timestamp);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    private String convertTimestamp(final long timestamp) {
        Date date = new Date(timestamp);

        SimpleDateFormat timeFormat = new SimpleDateFormat("H:mm:ss");
        return timeFormat.format(date);

    }

    @VisibleForTesting
    DateHeaderModel transformToTimeHeaderModel(final long timestamp) {
        Date date = new Date(timestamp);

        SimpleDateFormat timeFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
        return new DateHeaderModel(timeFormat.format(date));
// return date.toString();
    }

    @VisibleForTesting
    ImageModel transformToImageModel(final Msg msg) {
        return new ImageModel(msg.text, convertTimestamp(msg.time));
    }

    @VisibleForTesting
    MessageModel transformToMessageModel(final Msg msg) {
        return new MessageModel(msg.text, convertTimestamp(msg.time));
    }

    @VisibleForTesting
    InlineImageModel transformToInlineModel(final Msg item) {

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

        return new InlineImageModel(text1, text2, imageUrl, convertTimestamp(item.time));
    }

}
