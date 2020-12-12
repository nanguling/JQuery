package com.mystudy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mystudy.entity.Province;

public class JsonUtil {
    //一个对象转json字符串
    public static String serialize(Province p) {
        ObjectMapper mapper = new ObjectMapper();
        String res = null;
        try {
            res = mapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return res;
    }
}
