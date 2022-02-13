package pl.javastart.argumentmatcher;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ArgumentMatcherTest {

    @Test
    public void shouldHandleVoidMethod() {
        // given
        User user = mock(User.class);

        // when
        Mockito.doThrow(new IllegalStateException()).when(user).setName(ArgumentMatchers.any());

        // then
        user.setName("Basia");
        user.setName("Kasia");

    }

    @Test
    public void shouldSendEmailOnlyToAdmin() {
        // given
        EmailService emailService = mock(EmailService.class);

        // when
        when(emailService.prepareEmailContentFormatting(eq("Treść Maila"), anyBoolean())).thenReturn("<b>Treść Maila</b>");

        // then
    }

    @Test
    public void shouldSendEmailOnlyToAdminFixed() {
        // given
        EmailService emailService = mock(EmailService.class);

        // when
        when(emailService.prepareEmailContentFormatting(ArgumentMatchers.any(), anyBoolean())).thenReturn("<b>Treść Maila</b>");

        String preparedContent = emailService.prepareEmailContentFormatting("Treść Maila", false);

        // then
        assertThat(preparedContent).isEqualTo("<b>Treść Maila</b>");
    }

    @Test
    public void shouldAlreadySentEmails() {
        // given
        EmailService emailService = mock(EmailService.class);
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("a"));
        emails.add(new Email("b"));

        // when
        when(emailService.filterOutAlreadySentEmails(any())).thenReturn(emails);

        List<Email> emails1 = emailService.filterOutAlreadySentEmails(null);

        // then
        assertThat(emails).isEqualTo(emails1);
    }

    @Test
    public void simpleTypeMatchers() {
        ArgumentMatchers.anyString();
        ArgumentMatchers.anyByte();
        ArgumentMatchers.anyShort();
        ArgumentMatchers.anyInt();
        ArgumentMatchers.anyLong();
        ArgumentMatchers.anyFloat();
        ArgumentMatchers.anyDouble();
        ArgumentMatchers.anyChar();
        ArgumentMatchers.anyString();
    }

    @Test
    public void collectionsMatchers() {
        ArgumentMatchers.anySet();
        ArgumentMatchers.anyList();
        ArgumentMatchers.anyMap();
        ArgumentMatchers.anyCollection();
        ArgumentMatchers.anyIterable();
    }

    @Test
    public void eqMatchers() {
        String text = "";

        ArgumentMatchers.eq("");
        ArgumentMatchers.refEq(text);
    }

    @Test
    public void stringMatchers() {
        ArgumentMatchers.contains("string part");
        ArgumentMatchers.startsWith("string start");
        ArgumentMatchers.endsWith("string end");
        ArgumentMatchers.matches("regex");
    }

    @Test
    public void shouldCheckIfAdult() {
        // given
        AdultChecker adultChecker = mock(AdultChecker.class);

        // when
        when(adultChecker.checkIfAdult(intThat(age -> age < 18))).thenReturn(false);
        when(adultChecker.checkIfAdult(intThat(age -> age >= 18))).thenReturn(true);

        // then
        assertThat(adultChecker.checkIfAdult(5)).isFalse();
        assertThat(adultChecker.checkIfAdult(30)).isTrue();
    }

    @Test
    public void customMatcher() {
        File file = new File("file.txt");
        File fileMatcher = ArgumentMatchers.argThat((ArgumentMatcher<File>) argument -> file.getName().endsWith(".txt"));

        ArgumentMatchers.argThat(new ArgumentMatcher<File>() {
            @Override
            public boolean matches(File argument) {
                return argument.getName().endsWith(".txt");
            }
        });
    }

    @Test
    public void nullMatchers() {
        ArgumentMatchers.notNull(); // to samo co ArgumentMatchers.isNotNull()
        ArgumentMatchers.isNotNull(); // to samo co ArgumentMatchers.notNull()
        ArgumentMatchers.isNull();
        ArgumentMatchers.nullable(Email.class); // null or type
    }

    @Test
    public void anyMatchers() {
        ArgumentMatchers.any();
        ArgumentMatchers.any(String.class);
    }

}