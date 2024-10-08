package com.javarush.zhekadoe.cryptoanalizer;

import java.util.HashMap;
import java.util.Map;

/**
 * Алфавит для шифрования
 */
public class Alphabet {
    private static final String ALPHABET = " \\\"'"
            + ",.?!@*+-=1234567890№:;|~„"
            + "йцукенгшщзхъфывапролджэячсмитьбюё"
            + "qwertyuiopasdfghjklzxcvbnm";

    private final char[] chars;
    private final Map<Character, Integer> charIndexes = new HashMap<>();

    /**
     * Конструктор по предустановленной строке
     */
    Alphabet() {
        this(ALPHABET);
    }

    /**
     * Конструктор по предоставленной строке
     *
     * @param s строка символов
     */
    Alphabet(String s) {
        chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charIndexes.put(chars[i], i);
        }
    }

    /**
     * Получение символа по индексу.
     * Индекс обрезается по длине алфавита
     *
     * @param index индекс символа в алфавите
     * @return символ
     */
    public char getCharByIndex(int index) {
        return chars[index % chars.length];
    }

    /**
     * Получение индекса по символу
     *
     * @param c символ
     * @return индекс символа или null, если символа нет в алфавите
     */
    public Integer getIndexByChar(char c) {
        return charIndexes.getOrDefault(c, null);
    }
}
