package pl.javastart.radnomvaluesexercise;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;

public class Generator implements Supplier<String> {

//    private Random random = new Random();
    private final SecureRandom secureRandom = new SecureRandom();
    private final char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz".toCharArray();

    @Override
    public String get() {
        return "" + letters[secureRandom.nextInt(letters.length)];
//        return "" + letters[random.nextInt(letters.length)];
    }

}
