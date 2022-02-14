package pl.javastart.radnomvaluesexercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class EmailCreationServiceTest {

    @Mock RandomProvider randomProvider;

    private EmailCreationService emailCreationService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        emailCreationService = new EmailCreationService(randomProvider);
    }

    @DisplayName("return link with generated value by Generator implements Supplier<T>")
    @Test
    public void shouldReturnLinkWithGeneratedValue() {
        // given
//        RandomProvider randomProvider = mock(RandomProvider.class);
//        EmailCreationService emailCreationService = new EmailCreationService(randomProvider);

        when(randomProvider.randomGenerator()).thenReturn("eVtHd6iur4jY1jO5r0FC");

        // when
        String resetMailContent = emailCreationService.createResetMailContent();

        // then
        assertThat(resetMailContent).isEqualTo("Cześć, aby przejść do resetowania hasła naciśnij" +
                "<a href=https://example.com/reset?key=eVtHd6iur4jY1jO5r0FC>ten link</a>");
    }

    @DisplayName("return link with generated value by UUID")
    @Test
    public void shouldReturnLinkWithGeneratedValueByUUID() {
        // given
        when(randomProvider.randomGeneratorUUID()).thenReturn("eVtHd6iur4jY1jO5r0FC");

        // when
        String resetMailContentByUUID = emailCreationService.createResetMailContentByUUID();

        // then
        assertThat(resetMailContentByUUID).isEqualTo("Cześć, aby przejść do resetowania hasła naciśnij" +
                "<a href=\"https://example.com/reset?key=eVtHd6iur4jY1jO5r0FC\">ten link</a>");
    }

}