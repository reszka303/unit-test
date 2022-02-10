package pl.javastart.parameterizationoftestsexercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvSourceMonthCalculatorTest {

    private final MonthCalculator monthCalculator = new MonthCalculator();

    @DisplayName("length of month -> 31 days")
    @CsvSource({
            "2018, 7",
            "2012, 12",
            "2018, 8",
            "1956, 3",
            "2234, 1",
            "2014, 5",
            "2017, 10"
    })
    @ParameterizedTest
    public void shouldReturn31DaysOfTheMonthForBothYearAndMonth(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(31);
    }

    @DisplayName("length of month -> 30 days")
    @CsvSource(value = {
            "2018-04",
            "2018-06",
            "2012-9",
            "1956-11"
    },
            delimiter = '-')
    @ParameterizedTest
    public void shouldReturn30DaysOfTheMonthForBothYearAndMonth(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(30);
    }

    @DisplayName("length of month -> 29 days")
    @CsvSource(value = {
            "2016-02",
            "2000-02",
            "1956-02",
            "2248-02"
    },
            delimiter = '-' )
    @ParameterizedTest
    public void shouldReturn29DaysOfTheMonthForBothYearAndMonth(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(29);

    }

    @DisplayName("length of month -> 28 days")
    @CsvSource({
            "2018, 02",
            "2010, 02",
            "2003, 02",
            "2007, 02",
            "1959, 02"
    })
    @ParameterizedTest
    public void shouldReturn28DaysOfTheMonthForBothYearAndMonth(int year, int month) {
        // when
        int dayCount = monthCalculator.getDayCount(year, month);

        // then
        assertThat(dayCount).isEqualTo(28);
    }

}
