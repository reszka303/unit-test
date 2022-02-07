package pl.javastart.namingandorganizationoftests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NamingAndGroupingTest {

    @Nested
    class Calculator {

        @DisplayName("2 + 2 = 4")
        @Test
        public void shouldAdd2AndReturn4() {

        }

    }

    @DisplayName("Mailing tests")
    @Nested
    class Mails {

        @DisplayName("Mails only to subscribers")
        @Test
        public void shouldSendEmailOnlyToSubscribers() {

        }

    }


    @DisplayName("Should remove cache after invalidate")
    @Test
    public void shouldRemoveCacheAfterInvalidate() {

    }

}