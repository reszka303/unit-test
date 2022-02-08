package pl.javastart.multipleassertions;

import java.util.ArrayList;

public class Superheros {

    static Superhero getHulk() {
        ArrayList<String> abilitiesHulk = new ArrayList<>();
        abilitiesHulk.add("regeneration");
        abilitiesHulk.add("agility");
        abilitiesHulk.add("superStrength");
        return new Superhero(abilitiesHulk, "green", "Marvel");
    }

}
