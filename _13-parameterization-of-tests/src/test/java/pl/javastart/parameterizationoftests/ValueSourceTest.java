package pl.javastart.parameterizationoftests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValueSourceTest {

    @DisplayName("should be a valid email")
    @ValueSource(strings = {"example@xample.com", "example2@example.com", "example@example.pl"})
    @ParameterizedTest
    public void shouldBeValidEmail(String email) {
        // given
        EmailValidator emailValidator = new EmailValidator();

        // when
//        boolean isValid = emailValidator.isValid("example@example.com");
        boolean isValid = emailValidator.isValid(email);


        // then
//        List<String> emails = Arrays.asList("example@xample.com", "example2@example.com", "example@example.pl");
        assertThat(isValid).isEqualTo(true);

    }

    @DisplayName("should not be a valid email")
    @ValueSource(strings = {"example@", "example2@example", "example@example"})
    @ParameterizedTest
    public void shouldNotBeValidEmail(String email) {
        // given
        EmailValidator emailValidator = new EmailValidator();

        // when
//        boolean isValid = emailValidator.isValid("example@example.com");
        boolean isValid = emailValidator.isValid(email);


        // then
//        List<String> emails = Arrays.asList("example@xample.com", "example2@example.com", "example@example.pl");
        assertThat(isValid).isFalse();
    }

    @DisplayName("method -> isFibonacciNumber()")
    @ValueSource(ints = {0, 1, 3, 5, 8, 13, 21, 34})
    @ParameterizedTest(name = "{arguments} is Fibonacci number" )
    public void isFibonacciNumber(int number) {
        // given
        FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();

        // when
        boolean isFibonacci = fibonacciGenerator.isFibonacciNumber(number);

        // then
        assertThat(isFibonacci).isTrue();
    }






}