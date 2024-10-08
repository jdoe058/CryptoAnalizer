package com.javarush.zhekadoe.cryptoanalizer;

/**
 * Шифрование методом Цезаря
 */
public class CaesarCypher implements Cypher {
    private final Alphabet alphabet;
    private int key;

    public CaesarCypher(Alphabet alphabet, int key)  {
        this.alphabet = alphabet;
        this.key = key;
    }

    private char encryptChar (int c) {
        var index = alphabet.getIndexByChar((char) c);
        return index == null ? (char) c : alphabet.getCharByIndex(index + key);
    }

    private char decryptChar (int c) {
        var index = alphabet.getIndexByChar((char) c);
        return index == null ? (char) c : alphabet.getCharByIndex(index - key);
    }

    @Override
    public String encrypt (String str) {
        StringBuilder builder = new StringBuilder();
        str.chars()
                .map(this::encryptChar)
                .forEach(x -> builder.append((char) x));
        return builder.toString();
    }

    @Override
    public String decrypt (String str) {
        StringBuilder builder = new StringBuilder();
        str.chars()
                .map(this::decryptChar)
                .forEach(x -> builder.append((char) x));
        return builder.toString();
    }

    @Override
    public void setKey(String key) {
        this.key = Integer.parseInt(key);
    }
}
