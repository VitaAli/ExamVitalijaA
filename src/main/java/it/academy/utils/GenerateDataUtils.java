package it.academy.utils;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateDataUtils {

    public static Integer generateRandomNumber() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 9999);
        return randomNum;
    }
}
