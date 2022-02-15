package pl.javastart.exceptionstestingexercise;

public class EmployeeNoLongerWorkingException extends RuntimeException {

    public EmployeeNoLongerWorkingException() {
        super("Employee is no longer hired");
    }
}
