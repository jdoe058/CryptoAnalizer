package com.javarush.zhekadoe.cryptoanalizer;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Command(name = "cypher",
        subcommands = {CommandLine.HelpCommand.class },
        description = "Caesar cypher command")
public class Runner implements Runnable {
    @Spec CommandSpec spec;

    @Command(name = "encrypt", description = "Encrypt from file to file using key")
    void encrypt(
        @Parameters(paramLabel = "", description = "source file with text to encrypt")
        Path src,
        @Parameters(paramLabel = "", description = "dest file which should have encrypted text")
        Path dest,
        @Parameters(paramLabel = "", description = "key for encryption")
        int key) {
        // TODO
        var cmd = Commands.ENCRYPT;
        cmd.algorithm = Algorithm.CAESAR;
        cmd.algorithm.cypher.setKey(String.valueOf(key));

        try (var lines = Files.lines(src)) {
            var cont = new Controller(cmd, lines);
            cont.run();
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
