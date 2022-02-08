package pl.javastart.assertjintro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class AssertJIntroTest {

    @DisplayName("end with A")
    @Test
    public void shouldEndWithA() {
        // when
        String name = "Dorota";

        // then
        assertThat(name).endsWith("a");
    }

    @DisplayName("equal with other")
    @Test
    public void shouldEqualWithOther() {
        // when
        String name = "Dorota";
        String otherName = "Anna";

        // then
//        assertThat(name).isEqualTo(otherName);

        assertThat(name)
                .isNotEqualTo(otherName)
                .endsWith("a")
                .hasSize(6);
    }

}