package com.javarush.zhekadoe.cryptoanalizer;

/**
 * Алгоритмы шифрования
 */
public enum Algorithms {
    /**
     * Шифрование методом Цезаря
     */
    CAESAR(new CaesarCypher(new Alphabet(),0)),

    /**
     * Шифрование методом Вижинера
     */
    VIGENERE(null);

    public final Cypher cypher;

    Algorithms(Cypher cypher) {
        this.cypher = cypher;
    }
}
