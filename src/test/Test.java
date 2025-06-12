package test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int [] temper = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Random r = new Random();

        for (int i = 0; i < temper.length; i++) {
            int index = r.nextInt(temper.length);
            int temp = temper[i];
            temper[i] = temper[index];
            temper[index] = temp;
        }

        for (int j : temper) {

            System.out.print(j + " ");

        }

        int [][] data = new int [4][4];
        for (int i = 0; i < temper.length; i++) {
            data[i/4][i%4] = temper[i];
        }

        System.out.println();

    }
}
