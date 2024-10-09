package com.javarush.zhekadoe.cryptoanalizer;

import java.io.PrintStream;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Команды
 */
public enum Commands implements Runnable {
    /**
     * Зашифровать
     */
    ENCRYPT {
        Commands algorithm(Algorithms algorithm) {
            var res = super.algorithm(algorithm);
            this.exec = algorithm.cypher::encrypt;
            return res;
        }
    },

    /**
     * Расшифровать
     */
    DECRYPT {
    },

    /**
     * Перебор
     */
    BRUTE_FORCE {
    },

    /**
     * Статический анализ
     */
    STAT_ANALYSIS {

    };

    private Stream<String> in;
    private PrintStream out;

    // TO-DO private
    protected Algorithms algorithm;

    Function<String, String> exec;

    /**
     * Установка алгоритма шифрования
     *
     * @param algorithm алгоритм
     * @return текущая команда
     */
    Commands algorithm(Algorithms algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    /**
     * Установка ключа шифрования
     *
     * @param key ключ
     * @return текущая команда
     */
    Commands key(String key) {
        algorithm.cypher.key(key);
        return this;
    }

    /**
     * Установка источника
     *
     * @param in источник
     * @return текущая команда
     */
    Commands in(Stream<String> in) {
        this.in = in;
        return this;
    }

    /**
     * Установка получателя
     *
     * @param out получатель
     * @return текущая команда
     */
    Commands out(PrintStream out) {
        this.out = out;
        return this;
    }

    /**
     * Запуск
     */
    @Override
    public void run() {
        in.map(exec).forEach(out::println);
    }
}
