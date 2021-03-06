package pl.javastart.exceptiontesting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class ExceptionThrowingExampleTest {

    @Test
    public void shouldThrowNoAccessException() {
        UserManager userManager = Mockito.mock(UserManager.class);
//        when(userManager.findById(1L)).thenThrow(new NoAccessException());

        when(userManager.findById(ArgumentMatchers.anyLong())).thenThrow(new NoAccessException());

        // to samo co wyżej, przydatne w przypadku gdyby metoda findById zwracała void
//        doThrow(new NoAccessException()).when(userManager).findById(1L);

        assertThatThrownBy(() -> userManager.findById(3L))
                .isInstanceOf(NoAccessException.class);
    }

    private interface UserManager {
        User findById(Long id);
    }

//    private interface UserManager {
//        void findById(Long id);
//    }

    private static interface User {}
        private static class NoAccessException extends RuntimeException {}

}
