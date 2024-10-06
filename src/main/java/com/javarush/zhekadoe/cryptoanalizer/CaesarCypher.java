package com.javarush.zhekadoe.cryptoanalizer;

public class CaesarCypher {
    private final Alphabet alphabet;
    private final int key;

    public CaesarCypher(Alphabet alphabet, int key)  {
        this.alphabet = alphabet;
        this.key = key;
    }

    public char encryptChar (int c) {
        var index = alphabet.getIndexByChar((char) c);
        return index == null ? (char) c : alphabet.getCharByIndex(index + key);
    }

    public String encrypt (String str) {
        StringBuilder builder = new StringBuilder();
        str.chars()
                .map(this::encryptChar)
                .forEach(x -> builder.append((char) x));
        return builder.toString();
    }
}
