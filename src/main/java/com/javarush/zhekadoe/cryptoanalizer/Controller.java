package com.javarush.zhekadoe.cryptoanalizer;

import java.util.stream.Stream;

public class Controller {
    private Commands cmd;
    private Stream<String> src;

    public Controller(Commands cmd, Stream<String> src) {
        this.cmd = cmd;
        this.src = src;
    }

    void run() {
        src.map(cmd::exec).forEach(System.out::println);
    }
}
