package com.bpm.kodilla.bytecode.reflection;

import java.util.Random;

public class RandomTextGenerator {

    public static String generateRandomText(int length) {
        Random random = new Random();
        int leftLimit = 97; // 'a'
        int rightLimit = 122; // 'z'
        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
