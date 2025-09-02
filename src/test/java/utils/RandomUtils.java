package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static void main(String[] args) {
        System.out.println(randomData(10));
        System.out.println(randomInt(10,100));
        System.out.println(randomEmail());

        String[] names = {"a","b","c"};
        System.out.println(randomItem(names));
    }

    public static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


    public static String randomData(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return  sb.toString();
    }

    public static String randomEmail() {
        return randomData(15) + "@mail.com";
    }

    public static String randomItem(String[] values) {
        int index = randomInt(0, values.length - 1);
        return  values[index];
    }
}
