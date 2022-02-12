package pl.javastart.assigningbehaviortomocks;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("should always return given name")
    @Test
    public void shouldAlwaysReturnGivenName() {
        // given
        User user = Mockito.mock(User.class);

        // when
        Mockito.when(user.getName()).thenReturn("Kasia");

        // then
        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Kasia");
    }

    @DisplayName("test Mockito when values")
    @Test
    public void testMockitoWhenValues() {
        // given
        User user = Mockito.mock(User.class);

        // when
        Mockito.when(user.getName()).thenReturn("Kasia", "Basia", "Krysia", "Tomek");

        // then
        assertThat(user.getName()).isEqualTo("Kasia");
        assertThat(user.getName()).isEqualTo("Basia");
        assertThat(user.getName()).isEqualTo("Krysia");
        assertThat(user.getName()).isEqualTo("Tomek");
        assertThat(user.getName()).isEqualTo("Tomek");
    }

    @DisplayName("should always return given name lazy way")
    @Test
    public void shouldAlwaysReturnGivenNameLazyWay() {
        // given
        User user = Mockito.mock(User.class);

        // when
        Mockito.when(user.getName()).then(i -> {
            System.out.println("Liczenie wartości wynikowej");
            return "Kasia";
        });

        // then
        System.out.println("Zaraz będę sprawdzał po raz #1");
        assertThat(user.getName()).isEqualTo("Kasia");
        System.out.println("Zaraz będę sprawdzał po raz #2");
        assertThat(user.getName()).isEqualTo("Kasia");
        System.out.println("Zaraz będę sprawdzał po raz #3");
        assertThat(user.getName()).isEqualTo("Kasia");
    }

    @DisplayName("should throw exception on getter")
    @Test
    public void shouldThrowExceptionOnGetter() {
        // given
        User user = Mockito.mock(User.class);

        // when
        Mockito.when(user.getName()).thenThrow(new IllegalStateException());

        // then
        assertThat(user.getName());
    }

    @DisplayName("should throw exception on setter")
    @Test
    public void shouldThrowExceptionOnSetter() {
        // given
        User user = Mockito.mock(User.class);

        // when
        Mockito.doThrow(new IllegalStateException()).when(user).setName("Kasia");

        // then
        user.setName("Basia");
//        user.setName("Kasia");
    }

}