package pl.javastart.multipleassertions;

import java.util.List;

public class Superhero {

    private List<String> abilities;
    private String color;
    private String publisher;

    public Superhero(List<String> abilities, String color, String publisher) {
        this.abilities = abilities;
        this.color = color;
        this.publisher = publisher;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
