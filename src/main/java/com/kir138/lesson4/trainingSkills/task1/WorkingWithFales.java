package com.kir138.lesson4.trainingSkills.task1;

import java.io.*;
import java.util.Arrays;

public class WorkingWithFales {
    public static void main(String[] args) {

        /*byte[] arr = {1, 4, 7, 3};
        ByteArrayInputStream bai = new ByteArrayInputStream(arr);
        ByteArrayOutputStream byo = new ByteArrayOutputStream();
        int x;

        while ((x = bai.read()) > 0) {
            byo.write(x);
        }

        byte[] arr1 = byo.toByteArray();
        System.out.println(Arrays.toString(arr1));*/

        /*byte[] res = "Kirill".getBytes();
        try (FileOutputStream fos = new FileOutputStream("file.txt")) {
            fos.write(res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        byte[] res = new byte[20];
        try (FileInputStream fis = new FileInputStream("file.txt")) {
            int count = 0;
            while ((count = fis.read(res)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print((char) res[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
