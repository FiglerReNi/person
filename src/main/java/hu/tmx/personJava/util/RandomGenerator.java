package hu.tmx.personJava.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static int getRandomValue(int max) {
        return ThreadLocalRandom.current().nextInt(max);
    }

}
