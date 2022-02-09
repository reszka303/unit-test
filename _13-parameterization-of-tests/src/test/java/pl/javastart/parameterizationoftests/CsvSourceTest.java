package pl.javastart.parameterizationoftests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvSourceTest {

    @DisplayName("should properly recognize email provider")
    @CsvSource({
            "gmail.com, PROVIDER",
            "trash-mail.com, TRASHMAIL",
            "outlook.com, PROVIDER",
            "kowalski.pl, PRIVATE"})
    @ParameterizedTest
    public void shouldProperlyRecognizeEmailProvider(String domain, EmailProviderType expectedEmailProvider) {
        // given
        EmailValidator emailValidator = new EmailValidator();

        // when
        EmailProviderType providerType = emailValidator.determineProviderType(domain);

        // then
        assertThat(providerType).isEqualTo(expectedEmailProvider);
    }

}
