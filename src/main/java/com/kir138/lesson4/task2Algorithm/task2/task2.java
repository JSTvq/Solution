package com.kir138.lesson4.task2Algorithm.task2;

public class task2 {
    public static void main(String[] args) {
        String line = "abcdcba";
        String res = palindrome(line);
        System.out.println(res);
    }

    public static String palindrome(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = line.length() - 1; i >= 0; i--) {
            stringBuilder.append(line.charAt(i));
        }
        return stringBuilder.toString();
    }
}
