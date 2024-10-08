package com.javarush.zhekadoe.cryptoanalizer;

/**
 * Алгоритмы шифрования
 */
public enum Algorithm {
    /**
     * Шифрование методом Цезаря
     */
    CAESAR(new CaesarCypher(new Alphabet(),0));

    public final Cypher cypher;

    Algorithm(Cypher cypher) {
        this.cypher = cypher;
    }
}
