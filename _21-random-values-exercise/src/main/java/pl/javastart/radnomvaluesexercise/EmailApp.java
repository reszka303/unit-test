package pl.javastart.radnomvaluesexercise;

import java.util.UUID;

public class EmailApp {
    public static void main(String[] args) {
        RandomProvider randomProvider = new RandomProvider();
        EmailCreationService emailCreationService = new EmailCreationService(randomProvider);
        String resetMailContent = emailCreationService.createResetMailContent();
        System.out.println(resetMailContent);

//        String s = UUID.randomUUID().toString();
//        System.out.println(s);

//        Generator generator = new Generator();
//        String s = generator.get();
//        for (int i = 0; i < s.length(); i++) {
//            System.out.println(s.charAt(i));
//        }

//        RandomProvider randomProvider = new RandomProvider();
//
//        String s = randomProvider.randomGenerator();
//
//        for (int i = 0; i < s.length(); i++) {
//            System.out.print(s.charAt(i));
//        }

    }
}
