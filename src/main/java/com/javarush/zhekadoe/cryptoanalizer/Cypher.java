package com.javarush.zhekadoe.cryptoanalizer;

/**
 * Интерфейс шифрования строки
 */
public interface Cypher {
    /**
     * Зашифровать
     * @param s исходная строка
     * @return зашифрованная строка
     */
    String encrypt(String s);

    /**
     * Расшифровать
     * @param s исходная строка
     * @return расшифрованная строка
     */
    String decrypt(String s);

    /**
     * Установить ключ шифрования
     * @param key
     */
    void setKey(String key);
}
