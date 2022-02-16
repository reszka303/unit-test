package pl.javastart.verificationofmethodcalls;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class PasswordCheckerTest {

    @Test
    public void shouldRunNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPassword("abc");

        // then
        verify(invalidPasswordService).notifyAboutInvalidPassword();
    }

    @Test
    public void shouldNotRunNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPassword("A123B32");

        // then
        verify(invalidPasswordService, never()).notifyAboutInvalidPassword();
    }

}