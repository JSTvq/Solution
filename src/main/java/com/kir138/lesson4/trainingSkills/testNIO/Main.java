package com.kir138.lesson4.trainingSkills.testNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
    /*writeTextToFile("text 1");
    writeTextToFile("text 2");
    writeTextToFile("text 3");
    //writeTextToFile("text 4");
    readTextToFile();*/
        Path path = Paths.get("C:\\Games\\Книга3.csv");
        try(FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            String line = "id; name; age; salary; role";
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(line.getBytes());

            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = fileChannel.read(byteBuffer);

            while ((read) != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
            byteBuffer.clear();
            read = fileChannel.read(byteBuffer);
            }
        }
    }

    /*public static void writeTextToFile(String message) throws IOException {
        Path path = Paths.get("C:\\Games\\Книга3.csv");
        String line = message + System.lineSeparator();
        Files.write(path, line.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }

    public static void readTextToFile() throws IOException {
        Path path = Paths.get("C:\\Games\\Книга3.csv");
        List<String> list = Files.readAllLines(path);
        for (String text : list) {
            System.out.println(text);
        }
    }*/
}
