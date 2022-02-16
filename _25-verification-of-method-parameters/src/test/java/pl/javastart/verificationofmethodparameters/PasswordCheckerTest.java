package pl.javastart.verificationofmethodparameters;

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

    @Test
    public void shouldTriggerNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("abc", "127.0.0.1");

        // then
        verify(invalidPasswordService).notifyAboutInvalidPassword(anyInt(),eq("Próba włamania z ip: 127.0.0.1"));
    }

    @Test
    public void shouldNotTriggerNotificationService() {
        // given
        InvalidPasswordService invalidPasswordService = mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("A123B32", "127.0.0.1");

        // then
        verify(invalidPasswordService, never()).notifyAboutInvalidPassword(anyInt(), any());
    }

    @Test
    public void shouldTriggerNotificationServiceStartingWithRightMessage() {
        // given
        InvalidPasswordService invalidPasswordService = mock(InvalidPasswordService.class);
        PasswordChecker mockitoVerifyExample = new PasswordChecker(invalidPasswordService);

        // when
        mockitoVerifyExample.checkPasswordNew("abc", "127.0.0.1");

        // then
        verify(invalidPasswordService).notifyAboutInvalidPassword(anyInt(), startsWith("Próba włamania z ip: "));
    }

}