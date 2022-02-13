package pl.javastart.timeandrandomvalues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class UserCreationServiceTest {

    @Mock DateTimeProvider dateTimeProvider;

    private UserCreationService userCreationService;

    private ZonedDateTime now;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        userCreationService = new UserCreationService(dateTimeProvider);

        now = ZonedDateTime.now();
        when(dateTimeProvider.nowAsZoneDateTime()).thenReturn(now);
    }

    @Test
    public void shouldCreateUserWithValidName() {
        // given

        // when
        User user = userCreationService.createUser("Ania");

        // then
        assertThat(user.getName()).isEqualTo("Ania");
    }

    @Test
    public void shouldCreateUserWithNoNullCreationDate() {
        // given

        // when
        User user = userCreationService.createUser("Ania");

        // then
        assertThat(user.getCreationDate()).isNotNull();
    }

    @Test
    public void shouldCreateUserWithCurrentCreationDate() {
        // given

        // when
        User user = userCreationService.createUser("Ania");

        // then
        assertThat(user.getCreationDate()).isEqualTo(now);
    }

}