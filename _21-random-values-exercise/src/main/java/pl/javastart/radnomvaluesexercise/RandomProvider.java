package pl.javastart.radnomvaluesexercise;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomProvider {

    public String randomGenerator() {
        return Stream.generate(new Generator())
                .limit(20)
                .collect(Collectors.joining());
    }

    public String randomGeneratorUUID() {
        return UUID.randomUUID().toString();
    }

}
