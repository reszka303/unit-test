package pl.javastart.exceptiontesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class ExceptionExamplesWithAssertJTest {

    private void divideByZero() {
        int notGreatIdea = 5 / 0;
    }

    private void divideByOne() {
        int notGreatIdea = 5 / 1;
    }
// assertThatThrownBy - sprawdź, że rzucony przez metodę divideByOne()
// jest instancją .isInstanceOf(ArithmeticException)
// i posiada wiadomość .hasMessage("/ by zero")
// i kończy się z ("zero")

    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJ() {
        assertThatThrownBy(() -> divideByZero())
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");

    }

    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJFail() {
        assertThatThrownBy(() -> divideByOne())
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");

    }

          /*
            Inne przykładowe asercje
            .hasMessage("")
            .hasMessageStartingWith("/ by")
            .hasMessageContaining("zero")
            .hasCauseInstanceOf(ArithmeticException.class)
            .hasStackTraceContaining("ArithmeticException");
         */

    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJLessFluentThrowable() {
        Throwable throwable = Assertions.catchThrowable(() -> divideByZero());

        assertThat(throwable)
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("/ by zero")
                .hasMessageEndingWith("zero");
    }

    @Test
    public void shouldVerifyThatExceptionIsThrownWithAssertJLessFluentArithmeticException() {
        ArithmeticException arithmeticException = catchThrowableOfType(() -> divideByZero(), ArithmeticException.class);

        assertThat(arithmeticException)
                .isInstanceOf(ArithmeticException.class)
                .hasMessageStartingWith("/ by")
                .hasMessageContaining("zero")
                .hasStackTraceContaining("ArithmeticException");
    }

// Do zastosowania jak się tworzy customową assercję
    @Test
    public void shouldThrow() {
        shouldHaveThrown(FileNotFoundException.class);
        failBecauseExceptionWasNotThrown(RuntimeException.class);
        shouldHaveThrown(IOException.class);
    }

}
