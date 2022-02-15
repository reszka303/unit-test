package pl.javastart.exceptionstestingexercise;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super("Employee not found in database");
    }
}
