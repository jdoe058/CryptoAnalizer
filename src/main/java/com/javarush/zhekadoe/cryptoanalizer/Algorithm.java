package com.javarush.zhekadoe.cryptoanalizer;

public enum Algorithm {
    CAESAR(new CaesarCypher(new Alphabet(),0));

    public Cypher cypher;

    Algorithm(Cypher cypher) {
        this.cypher = cypher;
    }
}
