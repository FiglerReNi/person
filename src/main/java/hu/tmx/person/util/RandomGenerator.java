package hu.tmx.person.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {

    public static boolean getRandomValue() {
        return ThreadLocalRandom.current().nextBoolean();
    }

}
