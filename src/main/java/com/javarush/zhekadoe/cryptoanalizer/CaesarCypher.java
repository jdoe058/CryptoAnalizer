package com.javarush.zhekadoe.cryptoanalizer;

/**
 * Шифрование методом Цезаря
 * <p>
 * шифр, при использовании которого каждая буква из открытого текста заменяется на такую букву,
 * которая в алфавите находится на некотором постоянном числе позиций левее или правее от рассматриваемой буквы
 */
public class CaesarCypher implements Cypher {
    private final Alphabet alphabet;
    private int key;

    public CaesarCypher(Alphabet alphabet, int key) {
        this.alphabet = alphabet;
        this.key = key;
    }

    private char encryptChar(int c) {
        var index = alphabet.getIndexByChar((char) c);
        return index == null ? (char) c : alphabet.getCharByIndex(index + key);
    }

    private char decryptChar(int c) {
        var index = alphabet.getIndexByChar((char) c);
        return index == null ? (char) c : alphabet.getCharByIndex(index - key);
    }

    @Override
    public String encrypt(String str) {
        StringBuilder builder = new StringBuilder();
        str.chars()
                .map(this::encryptChar)
                .forEach(x -> builder.append((char) x));
        return builder.toString();
    }

    @Override
    public String decrypt(String str) {
        StringBuilder builder = new StringBuilder();
        str.chars()
                .map(this::decryptChar)
                .forEach(x -> builder.append((char) x));
        return builder.toString();
    }

    @Override
    public Cypher key(String key) {
        this.key = Integer.parseInt(key);
        return this;
    }
}
