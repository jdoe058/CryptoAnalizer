package com.javarush.zhekadoe.cryptoanalizer;

public interface Cypher {
    String encrypt(String s);
    String decrypt(String s);
    void setKey(String key);
}
