package pl.javastart.parameterizationoftestsexercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.*;

class CsvFileSourceMonthCalculatorTest {

    private final MonthCalculator monthCalculator = new MonthCalculator();

    @DisplayName("length of month -> 31 days")
    @CsvFileSource(resources = "date-data-31-days-of-month.csv", numLinesToSkip = 1)
    @ParameterizedTest
    public void shouldReturn31DaysOfTheMonthForBothYearAndMonth(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        //then
        assertThat(dayCount).isEqualTo(31);
    }

    @DisplayName("length of month -> 30 days")
    @CsvFileSource(resources = "date-data-30-days-of-month.csv", numLinesToSkip = 1)
    @ParameterizedTest
    public void shouldReturn30DaysOfTheMonthForBothYearAndMonth(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(30);
    }

    @DisplayName("length of month -> 29 days")
    @CsvFileSource(resources = "date-data-29-days-of-month.csv", numLinesToSkip = 1)
    @ParameterizedTest
    public void shouldReturn29DaysOfTheMonthForBothYearAndMonth(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(29);
    }

    @DisplayName("length of month -> 28 days")
    @CsvFileSource(resources = "date-data-28-days-of-month.csv", numLinesToSkip = 1)
    @ParameterizedTest
    public void shouldReturn28DaysOfTheMonthForBothYearAndMonth(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(28);
    }

}