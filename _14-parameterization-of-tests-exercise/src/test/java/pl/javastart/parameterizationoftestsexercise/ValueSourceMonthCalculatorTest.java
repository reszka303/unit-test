package pl.javastart.parameterizationoftestsexercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueSourceMonthCalculatorTest {

    private final MonthCalculator monthCalculator = new MonthCalculator();

    @DisplayName("length of month -> 31 days")
    @ValueSource(strings = {
            "2018-07",
            "2018-08",
            "2012-12",
            "1956-03",
            "2234-01",
            "2014-05",
            "2017-10"
    })
    @ParameterizedTest
    public void shouldReturn31DaysOfTheMonthForBothYearAndMonth(String yearAndMonth) {
        // given
        YearMonth yearMonth = YearMonth.parse(yearAndMonth);

        // when
        int dayCount = monthCalculator.getDayCount(yearMonth.getYear(), yearMonth.getMonthValue());

        // then
        assertThat(dayCount).isEqualTo(31);
    }

    @DisplayName("length of month -> 30 days")
    @ValueSource( strings = {
            "2018-04",
            "2018-06",
            "2012-09",
            "1956-11"
    })
    @ParameterizedTest
    public void shouldReturn30DaysOfTheMonthForBothYearAndMonth(String yearAndMonth) {
        // given
        YearMonth yearMonth = YearMonth.parse(yearAndMonth);

        // when
        int dayCount = monthCalculator.getDayCount(yearMonth.getYear(), yearMonth.getMonthValue());

        // then
        assertThat(dayCount).isEqualTo(30);
    }

    @DisplayName("length of month -> 29 days")
    @ValueSource(strings = {
            "2016-02",
            "2000-02",
            "1956-02",
            "2248-02"
    })
    @ParameterizedTest
    public void shouldReturn29DaysOfTheMonthForBothYearAndMonth(String yearAndMonth) {
        // given
        YearMonth yearMonth = YearMonth.parse(yearAndMonth);

        // when
        int dayCount = monthCalculator.getDayCount(yearMonth.getYear(), yearMonth.getMonthValue());

        // then
        assertThat(dayCount).isEqualTo(29);
    }

    @DisplayName("length of month -> 28 days")
    @ValueSource(strings = {
            "2018-02",
            "2010-02",
            "2003-02",
            "2007-02",
            "1959-02"
    })
    @ParameterizedTest
    public void shouldReturn28DaysOfTheMonthForBothYearAndMonth(String yearAndMonth) {
        // given
        YearMonth yearMonth = YearMonth.parse(yearAndMonth);

        // when
        int dayCount = monthCalculator.getDayCount(yearMonth.getYear(), yearMonth.getMonthValue());

        //then
        assertThat(dayCount).isEqualTo(28);
    }

}
