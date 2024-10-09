package com.javarush.zhekadoe.cryptoanalizer;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Command(name = "cypher",
        subcommands = {CommandLine.HelpCommand.class},
        description = "Caesar cypher command")
public class Runner implements Runnable {
    @Spec
    CommandSpec spec;

    @Command(name = "encrypt", description = "Encrypt from file to file using key")
    void encrypt(
            @Option(names = {"-i", "--input"}, description = "source file with text to encrypt")
            Path src,
            @Option(names = {"-o", "--output"}, description = "dest file which should have encrypted text")
            Path dest,
            @Parameters(paramLabel = "key", description = "key for encryption")
            String key) {

        try (var in = src != null ? Files.lines(src)
                : new BufferedReader(new InputStreamReader(System.in)).lines();
             PrintStream out = System.out
        ) {
            Commands.ENCRYPT.algorithm(Algorithms.CAESAR).key(key).in(in).out(out).run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        throw new CommandLine.ParameterException(spec.commandLine(), "Specify a subcommand");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Runner()).execute(args);
        System.exit(exitCode);
    }
}
