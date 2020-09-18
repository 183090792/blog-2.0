package com.lyz.blog.common.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * 功能描述: 保留两位小数
 *
 * @Author: zhouchaobiao
 * @Date: 2020-07-14$ 14:39$
 */

public class DoubleSerialize extends JsonSerializer<Double> {

    private DecimalFormat df = new DecimalFormat("#0.00");

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        if (value != null) {
            gen.writeString(df.format(value));
        }
    }
}