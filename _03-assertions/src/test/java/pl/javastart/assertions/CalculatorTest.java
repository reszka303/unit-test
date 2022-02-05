package pl.javastart.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;


class CalculatorTest {

    @Test
    void shouldAdd1To1AndReturn2() {

        // given
        int a = 1;
        int b = 1;
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertEquals(3, result);

//        Assertions.assertTrue(result == 3);

//        if (result != 3) {
//            throw new AssertionFailedError("Expected: " + 3 + " " + "result: " + result);
//        }
    }

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

}