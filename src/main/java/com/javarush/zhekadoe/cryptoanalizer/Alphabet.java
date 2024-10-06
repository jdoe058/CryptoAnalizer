package com.javarush.zhekadoe.cryptoanalizer;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {
    private static final String ALPHABET = " \\\"'"
            + ",.?!@*+-=1234567890№:;|~„"
            + "йцукенгшщзхъфывапролджэячсмитьбюё"
            + "qwertyuiopasdfghjklzxcvbnm";

    private final char[] chars;
    private final Map<Character, Integer> charIndexes = new HashMap<>();

    Alphabet() {
        this(ALPHABET);
    }

    Alphabet(String s) {
        chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charIndexes.put(chars[i], i);
        }
    }

    public char getCharByIndex(int index) {
        return chars[index % chars.length];
    }

    public Integer getIndexByChar(char c) {
        return charIndexes.getOrDefault(c, null);
    }
}
