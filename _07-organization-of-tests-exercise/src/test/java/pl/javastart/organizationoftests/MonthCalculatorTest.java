package pl.javastart.organizationoftests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MonthCalculatorTest {

    private MonthCalculator monthCalculator;

    @BeforeEach
    public void init() {
        monthCalculator = new MonthCalculator();
    }

    @DisplayName("2018-06 -> 30")
    @Test
    void shouldReturn30For2018_06() {
        //rok: 2018, miesiąc: 06 ma dać wynik 30

        // when
        int lengthOfMonth = monthCalculator.getDayCount(2018, 6);

        // then
        Assertions.assertEquals(30, lengthOfMonth);
    }

    @DisplayName("2018-07 -> 31")
    @Test
    void shouldReturn31For2018_07() {
        //  rok: 2018, miesiąc: 07 ma dać wynik 31

        // when
        int lengthOfMonth = monthCalculator.getDayCount(2018, 7);

        // then
        Assertions.assertEquals(31, lengthOfMonth);

    }

    @DisplayName("2018-08 -> 31")
    @Test
    void shouldReturn31For2018_08() {
        //  rok: 2018, miesiąc: 08 ma dać wynik 31

        //when
        int lengthOfMonth = monthCalculator.getDayCount(2018, 8);

        //then
        Assertions.assertEquals(31, lengthOfMonth);

    }

    @DisplayName("2018-02 -> 28")
    @Test
    void shouldReturn28For2018_02() {
        //  rok: 2018, miesiąc: 02 ma dać wynik 28

        //when
        int lengthOfMonth = monthCalculator.getDayCount(2018, 2);

        //then
        Assertions.assertEquals(28, lengthOfMonth);

    }

    @DisplayName("2016-02 -> 29")
    @Test
    void shouldReturn29For2016_02() {
        //  rok: 2016, miesiąc: 02 ma dać wynik 29

        //when
        int lengthOfMonth = monthCalculator.getDayCount(2016, 2);

        //then
        Assertions.assertEquals(29, lengthOfMonth);
    }

    @DisplayName("2010-02 -> 28")
    @Test
    void shouldReturn28For2010_02() {
        //  rok: 2010, miesiąc: 02 ma dać wynik 28

        //when
        int lengthOfMonth = monthCalculator.getDayCount(2010, 2);

        //then
        Assertions.assertEquals(28, lengthOfMonth);
    }

    @DisplayName("2100-02 -> 28")
    @Test
    void shouldReturn28For2100_02() {
        //  rok: 2100, miesiąc: 02 ma dać wynik 28

        //when
        int lengthOfMonth = monthCalculator.getDayCount(2100, 2);

        //then
        Assertions.assertEquals(28, lengthOfMonth);
    }

    @DisplayName("2000-02 -> 29")
    @Test
    void shouldReturn29For2000_02() {
        //  rok: 2000, miesiąc: 02 ma dać wynik 29

        //when
        int lengthOfMonth = monthCalculator.getDayCount(2000, 2);

        //then
        Assertions.assertEquals(29, lengthOfMonth);
    }

}