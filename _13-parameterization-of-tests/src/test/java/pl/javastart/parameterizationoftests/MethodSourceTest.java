package pl.javastart.parameterizationoftests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MethodSourceTest {

    @DisplayName("should properly recognize email provider")
    @MethodSource("provideTestData")
    @ParameterizedTest
    public void shouldProperlyRecognizeEmailProvider(String domain, EmailProviderType expectedProviderType) {
        // given
        EmailValidator emailValidator = new EmailValidator();

        // when
        EmailProviderType providerType = emailValidator.determineProviderType(domain);

        // then
        assertThat(providerType).isEqualTo(expectedProviderType);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("gmail.com", EmailProviderType.PROVIDER),
                Arguments.of("trash-mail.com", EmailProviderType.TRASHMAIL),
                Arguments.of("outlook.com", EmailProviderType.PROVIDER),
                Arguments.of("kowalski.pl", EmailProviderType.PRIVATE)
        );
    }

}
