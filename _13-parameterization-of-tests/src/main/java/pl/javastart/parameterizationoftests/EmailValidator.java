package pl.javastart.parameterizationoftests;

public class EmailValidator {

    boolean isValid(String email) {
        return true;
    }

    EmailProviderType determineProviderType(String domain) {
        if (domain.equals("gmail.com") || domain.equals("outlook.com")) {
            return EmailProviderType.PROVIDER;
        } else if (domain.equals("trash-mail.com") || domain.equals("byom.de")) {
            return EmailProviderType.TRASHMAIL;
        } else {
            return EmailProviderType.PRIVATE;
        }
    }

}
