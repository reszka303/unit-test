package pl.javastart.firsttest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @Test
    void should5AddTo2AndResult7() {

        // given
        int a = 5;
        int b = 2;
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertEquals(7, result);

    }

    @Test
    void shouldAdd1To1AndReturn2() {

        // given
        int a = 1;
        int b = 1;
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertEquals(2, result);
    }

}