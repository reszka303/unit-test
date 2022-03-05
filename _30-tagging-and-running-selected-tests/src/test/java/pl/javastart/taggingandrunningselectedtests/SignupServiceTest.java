package pl.javastart.taggingandrunningselectedtests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignupServiceTest {

    @Mock SignupRepository signupRepository;
    @Mock DateTimeProvider dateTimeProvider;
    @Captor ArgumentCaptor<Signup> captor;
    @InjectMocks SignupService signupService;

    @BeforeEach
    public void init() {
        ZonedDateTime now = ZonedDateTime.of(
                2022,
                2,
                28,
                21,
                25,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));
        lenient().when(dateTimeProvider.now()).thenReturn(now);
    }

    @Test
    public void shouldSetUserId() {
        // when
        signupService.createSignup(1L, 2L);

        // then
        ArgumentCaptor<Signup> captor = ArgumentCaptor.forClass(Signup.class);
        verify(signupRepository).save(captor.capture());

        Signup signup = captor.getValue();
        assertThat(signup.getUserId()).isEqualTo(1L);
    }

    @Fast
    @Test
    public void shouldSetCourseId() {
        // when
        signupService.createSignup(1L, 2L);

        // then
        verify(signupRepository).save(captor.capture());

        Signup signup = captor.getValue();
        assertThat(signup.getUserId()).isEqualTo(1L);
    }

    @Test
    public void shouldAddOneYear() {
        // given
        ZonedDateTime now = ZonedDateTime.of(
                2022,
                2,
                28,
                21,
                25,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));

        ZonedDateTime inYear = ZonedDateTime.of(
                2023,
                2,
                28,
                21,
                25,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));
        when(dateTimeProvider.now()).thenReturn(now);

        // when
        signupService.createSignup(1L, 2L);

        // then
        verify(signupRepository).save(captor.capture());

        Signup signup = captor.getValue();
        assertThat(signup.getFrom()).isEqualTo(now);
        assertThat(signup.getTo()).isEqualTo(inYear);
    }

    @Test
    public void shouldAddOneYearIfAlreadyExists() {
        // given
        ZonedDateTime end = ZonedDateTime.of(
                2023,
                2,
                28,
                21,
                25,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));

        Signup signup = mock(Signup.class);
        when(signup.getCourseId()).thenReturn(2L);
        when(signup.getTo()).thenReturn(end);

        Set<Signup> signups = new HashSet<>(Collections.singletonList(signup));

        when(signupRepository.findByUserId(1L)).thenReturn(signups);

        // when
        signupService.createSignup(1L, 2L);

        // then
        verify(signupRepository).save(captor.capture());

        Signup signupCaptor = captor.getValue();
        assertThat(signupCaptor.getFrom()).isEqualTo(end);

        ZonedDateTime inYear = ZonedDateTime.of(
                2024,
                2,
                28,
                21,
                25,
                0,
                0,
                ZoneId.of("Europe/Warsaw"));
        assertThat(signupCaptor.getTo()).isEqualTo(inYear);
    }

}