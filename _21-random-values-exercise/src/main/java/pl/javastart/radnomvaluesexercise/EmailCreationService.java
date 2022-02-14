package pl.javastart.radnomvaluesexercise;

public class EmailCreationService {

    private final RandomProvider randomProvider;

    public EmailCreationService(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public String createResetMailContent() {
        String generatedCode = randomProvider.randomGenerator();
        String template = "Cześć, aby przejść do resetowania hasła naciśnij<a href=https://example.com/reset?key=" + "%s" + ">ten link</a>";
        return String.format(template, generatedCode);
    }

    public String createResetMailContentByUUID() {
        String generatedCode = randomProvider.randomGeneratorUUID();
        String template = "Cześć, aby przejść do resetowania hasła naciśnij<a href=\"https://example.com/reset?key=%s\">ten link</a>";
        return String.format(template, generatedCode);
    }

}
