package pl.javastart.parameterizationoftests;

public class AccessController {

    boolean checkAccessForSignupStatus(SignupStatus signupStatus) {
        return signupStatus == SignupStatus.PAID;
    }

}
