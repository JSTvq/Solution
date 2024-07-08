package com.kir138.lesson4.trainingSkills.task2;
import java.io.BufferedWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSTask {
    /**
     * Реализовать сохранение данных в csv файл;
     * Реализовать загрузку данных из csv файла. Файл читается целиком.
     */
    public static void main(String[] args) throws IOException {
        AppData appData = new AppData(
            new String[]{"Value 1", "Value 2", "Value 3"},
            new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            }
        );

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.csv"))) {
            bufferedWriter.write(String.join(";", appData.getHeader()));
            bufferedWriter.newLine();

            for (int[] mass : appData.getData()) {
                for (int i = 0; i < mass.length; i++) {
                    bufferedWriter.write(Integer.toString(mass[i]));
                    if (i < mass.length - 1) {
                        bufferedWriter.write(";");
                    }
                }
                bufferedWriter.newLine();
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test.csv"))) {
            String resLine = bufferedReader.readLine();
            String[] resMassLine = resLine.split(";");
            System.out.println(Arrays.toString(resMassLine));

            String line;
            List<int[]> list = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineMass = line.split(";");
                int[] massInt = Arrays.stream(lineMass)
                    .mapToInt(i -> Integer.parseInt(i))
                    .toArray();
                list.add(massInt);
            }

            int[][] massInt = list.toArray(new int[0][]);
            System.out.println("Data:");
            for (int[] mass : massInt) {
                System.out.println(Arrays.toString(mass));
            }
        }
    }
}
