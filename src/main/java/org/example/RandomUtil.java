package org.example;

import java.util.Random;

public class RandomUtil {

    public static Random random = new Random();


    public static int getRandomInt(int n) {
        return random.nextInt(n);
    }


    public static int getRandomInt(int a, int b) {
        return random.nextInt(a, b);
    }

}
