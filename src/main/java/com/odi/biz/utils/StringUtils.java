package com.odi.biz.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static String nullToEmpty(String value) {
        if (value == null)
            return "";
        else
            return value;
    }
}
