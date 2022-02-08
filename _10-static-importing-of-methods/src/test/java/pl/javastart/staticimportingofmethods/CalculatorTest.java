package pl.javastart.staticimportingofmethods;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @DisplayName("2 + 2 = 4")
    @Test
    public void shouldAdd2To2Return4() {
        // given
        Calculator calculator = new Calculator();

        // when
        int result = calculator.add(2, 2);

        // then
        assertEquals(4, result);
        assertTrue(result == 4);
    }

}