package com.ray.appchallenge.model;

import org.junit.Test;

import com.ray.appchallenge.dto.Msg;

import junit.framework.Assert;

/**
 * @author  Raymond Chenon
 */

public class MsgTransformerTest {

    MsgTransformer transformer;

    @Test
    public void testInline() {
        transformer = new MsgTransformer();

        String testString = "Ray likes https://stackoverflow.com/ and drinks some tea";
        Msg item = new Msg("ggdh", testString, 5454);

        InlineImageModel model = transformer.transformToInlineModel(item);

        Assert.assertEquals("Ray likes ", model.text1);
        Assert.assertEquals(" and drinks some tea", model.text2);
        Assert.assertEquals("https://stackoverflow.com/", model.imageUrl);
    }

}
