package com.example.order.utils;

import java.util.Random;

public class KeyUtil {

    /**
     * generate primary key
     */
    public static synchronized String genUniqueKey() {
        Random r = new Random();
        Integer number = r.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
