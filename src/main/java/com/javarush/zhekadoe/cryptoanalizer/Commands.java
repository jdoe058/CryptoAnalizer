package com.javarush.zhekadoe.cryptoanalizer;

import java.util.function.Function;

/**
 * Команды
 */
public enum Commands {
    /**
     * Зашифровать
     */
    ENCRYPT {
        Commands algorithm (Algorithms algorithm) {
            var res = super.algorithm(algorithm);
            this.exec = _algorithm.cypher::encrypt;
            return res;
        }
    },

    /**
     * Расшифровать
     */
    DECRYPT{
    },

    /**
     * Перебор
     */
    BRUTE_FORCE{
    },

    /**
     * Статический анализ
     */
    STAT_ANALYSIS{

    };

    // TO-DO private
    protected Algorithms _algorithm;

    Function<String, String> exec;

    /**
     * Установка алгоритма шифрования
     *
     * @param algorithm алгоритм
     * @return текущая команда
     */
    Commands algorithm (Algorithms algorithm) {
        this._algorithm = algorithm;
        return this;
    }

    /**
     * Установка ключа шифрования
     *
     * @param key ключ
     * @return текущая команда
     */
    Commands key(String key) {
        _algorithm.cypher.key(key);
        return this;
    };
}
