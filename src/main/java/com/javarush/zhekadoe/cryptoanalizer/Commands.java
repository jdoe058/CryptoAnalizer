package com.javarush.zhekadoe.cryptoanalizer;

/**
 * Команды
 */
public enum Commands {
    /**
     * Зашифровать
     */
    ENCRYPT {
        String exec (String s) {
            return algorithm.cypher.encrypt(s);
        }
    },
    /**
     * Расшифровать
     */
    DECRYPT{
        String exec (String s) {
            return algorithm.cypher.decrypt(s);
        }
    };

    public Algorithm algorithm;
    abstract String exec (String s);
}
