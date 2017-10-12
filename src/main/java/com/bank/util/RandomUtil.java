package com.bank.util;

import com.bank.entity.EventType;

import java.util.Random;

public class RandomUtil {

    public static EventType randomEvent() {
        EventType[] values = EventType.values();
        return values[new Random().nextInt(values.length)];
    }

    public static Double randomAmount() {
        return Math.random() *100;
    }

    public static Double randomBalance() {
        return Math.random();
    }

}
