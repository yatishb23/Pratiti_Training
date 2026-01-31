package com.yatish.ems.util;

public class ValidationUtil {

    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidType(int type) {
        return type == 1 || type == 2;
    }
}
