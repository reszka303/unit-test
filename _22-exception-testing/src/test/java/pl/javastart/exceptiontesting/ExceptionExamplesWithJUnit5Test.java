package pl.javastart.exceptiontesting;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionExamplesWithJUnit5Test {

    private void divideByZero() {
        int notGreatIdea = 5 / 0;
    }

    @Test
    public void shouldFailBecauseOfAnException() {
//  java.lang.ArithmeticException: / by zero
        divideByZero();
    }

    @Test
    public void shouldFailBecauseOfAnExceptionWithExplicitTesting() {
//  org.opentest4j.AssertionFailedError: Unexpected exception thrown: java.lang.ArithmeticException: / by zero
        Assertions.assertDoesNotThrow(() -> divideByZero());
    }

    @Test
    public void shouldVerifyThatExceptionIsThrownWithoutFramework() {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            assertThat(e.getMessage()).isEqualTo("/ by zero");
            return;
        }
        fail("Expected exception was not thrown!");
    }

    @Test
    public void shouldThrowException() {
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> divideByZero());
        assertThat(arithmeticException).extracting(Throwable::getMessage).isEqualTo("/ by zero");
    }

    @Test
    public void shouldVerifyThatExceptionIsThrownWithJUnit5() {
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> divideByZero());
        assertThat(arithmeticException.getMessage()).isEqualTo("/ by zero");
    }

}