package pl.javastart.multipleassertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SuperherosTest {

    @DisplayName("create Hulk by AssertJ")
    @Test
    public void shouldCorrectlyCreateHulk() {
        // when
        Superhero hulk = Superheros.getHulk();

        // then
        assertThat(hulk.getAbilities()).contains("intelligence");
        assertThat(hulk.getColor()).isEqualTo("blue");
        assertThat(hulk.getPublisher()).isEqualTo("Disney");
    }

    @DisplayName("create Hulk by AssertJ and JUnit")
    @Test
    public void multipleAssertionsTogetherWithAssertJAndJUnit() {
        // when
        Superhero hulk = Superheros.getHulk();

        //then
        assertAll(
                () -> assertThat(hulk.getAbilities()).contains("intelligence"),
                () -> assertThat(hulk.getColor()).isEqualTo("blue"),
                () -> assertThat(hulk.getPublisher()).isEqualTo("Disney")
        );
    }

    @DisplayName("create Hulk by SoftAssertion in AssertJ")
    @Test
    public void multipleAssertionsWithAssertJ() {
        // when
        Superhero hulk = Superheros.getHulk();

        // then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(hulk.getAbilities()).contains("intelligence");
        softAssertions.assertThat(hulk.getColor()).isEqualTo("blue");
        softAssertions.assertThat(hulk.getPublisher()).isEqualTo("Disney");
        softAssertions.assertAll();
    }

}