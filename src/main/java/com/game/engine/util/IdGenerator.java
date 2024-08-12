package com.game.engine.util;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IdGenerator {

     public static String generateIdString(int length) {
        SecureRandom random = new SecureRandom();
        return IntStream.range(0, length)
                .map(i -> random.nextInt(62))
                .mapToObj(i -> "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(i))
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
