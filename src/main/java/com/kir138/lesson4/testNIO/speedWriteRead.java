package com.kir138.lesson4.testNIO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class speedWriteRead {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Games\\Книга3.csv");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.WRITE)) {
            String content = "id;name;age;salary;rolen123;John Doe;30;"
                + "50000;Developern456;Jane Smith;28;60000;Designern";
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
