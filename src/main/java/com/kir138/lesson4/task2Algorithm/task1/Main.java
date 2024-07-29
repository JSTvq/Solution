package com.kir138.lesson4.task2Algorithm.task1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numMass1 = {2, 7, 11, 15};
        int target = 9;
        int[] indexMass1 = twoSum1(numMass1, target);
        System.out.println(Arrays.toString(indexMass1));
    }

    public static int[] twoSum1(int[] numMass, int target) {
        for (int i = 0; i < numMass.length - 1; i++) {
            for (int j = i + 1; j < numMass.length; j++) {
                if (numMass[i] + numMass[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
