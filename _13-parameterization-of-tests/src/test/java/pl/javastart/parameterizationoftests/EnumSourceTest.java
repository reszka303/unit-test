package pl.javastart.parameterizationoftests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumSourceTest {

    @DisplayName("No access for PAID")
    @EnumSource(value = SignupStatus.class, mode = EnumSource.Mode.EXCLUDE, names = "PAID")
    @ParameterizedTest
    public void shouldNotHaveAccess(SignupStatus signupStatus) {
        // given
        AccessController accessController = new AccessController();

        // when
        boolean hasAccess = accessController.checkAccessForSignupStatus(signupStatus);

        // then
        assertThat(hasAccess).isFalse();
    }

    @DisplayName("status ok with -> 'A' or 'ED'")
    @EnumSource(value = SignupStatus.class, mode = EnumSource.Mode.MATCH_ANY, names = {".*A.*", ".*ED"})
    @ParameterizedTest
    public void shouldNotHaveAccessMatching(SignupStatus signupStatus) {
        // given
        AccessController accessController = new AccessController();

        // when
        boolean hasAccess = accessController.checkAccessForSignupStatus(signupStatus);

        // then
        assertThat(hasAccess).isFalse();

    }

}
