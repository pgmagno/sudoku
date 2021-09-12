package com.example.sudoku;
import java.util.Arrays;

public class Sudoku {


    static int[][] quadrantTL = {{9, 2, 2}, {4, 2, 6}, {7,  8, 9}};

    public static void main(String[] args) {

        int intChecker;
        int[] cleanList = new int[9];
        int p = 0;
        for (int i = 0; i < quadrantTL.length; i++) {
            for (int j = 0; j < quadrantTL[0].length; j++) {
                cleanList[p] = quadrantTL[i][j];
                p++;

            }
        }
        System.out.println(Arrays.toString(cleanList));

        for(int k = 0; k < cleanList.length; k++) {
            intChecker = cleanList[k];
            p = 0;
            for(int m = 0; m < cleanList.length; m++) {
                if (intChecker == cleanList[m]) {
                    p++;
                }
            }
            if (p > 1) {
                System.out.println(intChecker + " duplicado " + p + " vezes.");
            }

        }

    }
}