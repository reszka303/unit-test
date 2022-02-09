package pl.javastart.parameterizationoftests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvFileSourceTest {

    @DisplayName("should properly recognize email provider")
    @CsvFileSource(resources = "email-data.csv", numLinesToSkip = 1)
    @ParameterizedTest
    public void shouldProperlyRecognizeEmailProvider(String domain, EmailProviderType expectedProviderType) {
        // given
        EmailValidator emailValidator = new EmailValidator();

        // when
        EmailProviderType providerType = emailValidator.determineProviderType(domain);

        // then
        assertThat(providerType).isEqualTo(expectedProviderType);
    }

}
