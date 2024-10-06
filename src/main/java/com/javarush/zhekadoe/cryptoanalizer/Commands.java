package com.javarush.zhekadoe.cryptoanalizer;

public enum Commands {
    ENCRYPT {
        String exec (String s) {
            return algorithm.cypher.encrypt(s);
        }
    };
    public Algorithm algorithm;
    abstract String exec (String s);
}
