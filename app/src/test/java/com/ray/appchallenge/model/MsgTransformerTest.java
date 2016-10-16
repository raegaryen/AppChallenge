package com.ray.appchallenge.model;

import org.junit.Before;
import org.junit.Test;

import com.ray.appchallenge.dto.Msg;

import junit.framework.Assert;

/**
 * @author  Raymond Chenon
 */

public class MsgTransformerTest {

    private MsgTransformer transformer;

    private final String IMAGE_URL = "https://hd.unsplash.com/1/work-station-straight-on-view.jpg";

    @Before
    public void init() {
        transformer = new MsgTransformer();
    }

    @Test
    public void checkInlineTransformer() {

        Msg item = getInlineImageMsg();

        InlineImageModel model = transformer.transformToInlineModel(item);

        Assert.assertEquals("Ray likes ", model.text1);
        Assert.assertEquals(" and drinks some tea", model.text2);
        Assert.assertEquals("https://stackoverflow.com/", model.imageUrl);
    }

    @Test
    public void checkMessageTransformer() {

        String text = "I am Ray";
        Msg item = getTextMsg(text);

        MessageModel model = transformer.transformToMessageModel(item);
        Assert.assertEquals(text, model.text);
    }

    @Test
    public void checkMessageTransformerWhenTextNull() {

        String text = null;
        Msg item = getTextMsg(text);
        MessageModel model = transformer.transformToMessageModel(item);
        Assert.assertEquals(text, model.text);
    }

    @Test
    public void checkImageTransformer() {

        Msg item = getImageMsg();
        ImageModel model = transformer.transformToImageModel(item);
        Assert.assertEquals(IMAGE_URL, model.imageUrl);
    }

    private Msg getInlineImageMsg() {
        return new Msg("dfjfgj", "Ray likes https://stackoverflow.com/ and drinks some tea", getTimestamp());
    }

    private Msg getImageMsg() {
        return new Msg("ggdh", IMAGE_URL, getTimestamp());
    }

    private Msg getTextMsg(final String text) {
        return new Msg("whateverid", text, getTimestamp());
    }

    private long getTimestamp() {
        return System.currentTimeMillis();
    }

    private long getId() {
        return System.currentTimeMillis();
    }

}
