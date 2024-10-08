package com.javarush.zhekadoe.cryptoanalizer;

import java.util.stream.Stream;

public class Controller implements Runnable {
    private final Commands cmd;
    private final Stream<String> src;

    public Controller(Commands cmd, Stream<String> src) {
        this.cmd = cmd;
        this.src = src;
    }

    @Override
    public void run() {
        src.map(cmd.exec).forEach(System.out::println);
    }
}
