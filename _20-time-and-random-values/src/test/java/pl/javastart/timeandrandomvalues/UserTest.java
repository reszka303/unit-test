package pl.javastart.timeandrandomvalues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


class UserTest {

    @Mock DateTimeProvider dateTimeProvider;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldBeOlderThanAYear() {
        // given
        ZonedDateTime creationDate = ZonedDateTime.of(
                2022,
                2,
                14,
                17,
                49,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));

        User user = new User("", creationDate);


        ZonedDateTime now = ZonedDateTime.of(
                2023,
                2,
                15,
                17,
                49,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));

        when(dateTimeProvider.nowAsZoneDateTime()).thenReturn(now);

        // when
        boolean olderThanAYear = user.isOlderThanAYear(dateTimeProvider);

        // then
        assertThat(olderThanAYear).isTrue();
    }

    @Test
    public void shouldNotBeOlderThanAYear() {
        // given
        ZonedDateTime creationDate = ZonedDateTime.of(
                2022,
                2,
                15,
                17,
                49,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));

        User user = new User("", creationDate);

        ZonedDateTime now = ZonedDateTime.of(
                2023,
                2,
                14,
                17,
                49,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));

        when(dateTimeProvider.nowAsZoneDateTime()).thenReturn(now);

        // when
        boolean olderThanAYear = user.isOlderThanAYear(dateTimeProvider);

        // then
        assertThat(olderThanAYear).isFalse();
    }

}