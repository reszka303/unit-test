package pl.javastart.tj.assertionsinjunit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JUnit5AssertionsTest {

    private JUnit5Assertions jUnit5Assertions;

    @BeforeEach
    public void init() {
        jUnit5Assertions = new JUnit5Assertions();
    }

    @DisplayName("2 -> prime number")
    @Test
    public void shouldReturn2AsPrimeNumber() {
        // given
        int number = 2;

        // when
        boolean primeNumber = jUnit5Assertions.isPrimeNumber(number);

        // then
        Assertions.assertTrue(primeNumber, () -> number + " nie jest liczbą parzystą");
    }

    @DisplayName("5 -> prime number")
    @Test
    public void shouldReturn5AsPrimeNumber() {
        // given
        int number = 5;

        // when
        boolean primeNumber = jUnit5Assertions.isPrimeNumber(number);

        //then
        Assertions.assertTrue(primeNumber, () -> number + " nie jest liczbą pierwszą");

    }

    @DisplayName("6 -> no prime number")
    @Test
    public void shouldReturn6AsNoPrimeNumber() {
        // give
        int number = 6;

        // when
        boolean notPrimeNumber = jUnit5Assertions.isPrimeNumber(number);

        // then
        Assertions.assertFalse(notPrimeNumber, () -> number + " jest liczbą pierwszą");
    }

    @DisplayName("96 -> no prime number")
    @Test
    public void shouldReturn96AsNoPrimeNumber() {
        // given
        int number = 96;

        // when
        boolean primeNumber = jUnit5Assertions.isPrimeNumber(number);

        // then
        Assertions.assertFalse(primeNumber, () -> primeNumber + " jest liczbą pierwszą");

    }

    @DisplayName("97 -> prime number")
    @Test
    public void shouldReturn97AsPrimeNumber() {
        // given
        int number = 97;

        // when
        boolean primeNumber = jUnit5Assertions.isPrimeNumber(number);

        // then
        Assertions.assertTrue(primeNumber, () ->  number + " nie jest liczbą pierwszą");
    }

    @DisplayName("Return valid code from getCode()")
    @Test
    public void shouldReturnValidCode() {
        // when
        JUnit5Assertions.Code code = jUnit5Assertions.getCode("1");

        // then
        Assertions.assertEquals("1", code.getKey());
        Assertions.assertNotNull(code.getCode());
        Assertions.assertNotNull(code.getCreatedAtTimestamp());
    }

    @DisplayName("Return the same object")
    @Test
    public void shouldReturnSameObject() {
        // when
        JUnit5Assertions.Code code = jUnit5Assertions.getCode("1");
        JUnit5Assertions.Code code2 = jUnit5Assertions.getCode("1");

        // then
        Assertions.assertSame(code, code2);
    }

    @DisplayName("Return the different object")
    @Test
    public void shouldReturnDifferentObject() {
        // when
        JUnit5Assertions.Code code = jUnit5Assertions.getCode("1");
        JUnit5Assertions.Code code2 = jUnit5Assertions.getCode("2");

        // then
        Assertions.assertNotSame(code, code2);
    }

}