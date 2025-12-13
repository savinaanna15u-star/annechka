package org.example.lesson25.task;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM = new Random();
    private static final int DEFAULT_BOUND = 10;

    private RandomUtil() {

    }

    public static int getRandom(int bound) {
        return RANDOM.nextInt (bound);
    }
}
