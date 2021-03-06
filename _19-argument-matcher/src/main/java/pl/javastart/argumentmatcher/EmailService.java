package pl.javastart.argumentmatcher;

import java.util.List;

public interface EmailService {

    String prepareEmailContentFormatting(String content, boolean isHtml);
    List<Email> filterOutAlreadySentEmails(List<Email> allEmails);
}
