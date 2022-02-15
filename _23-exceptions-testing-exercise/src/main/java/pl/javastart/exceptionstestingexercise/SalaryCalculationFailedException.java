package pl.javastart.exceptionstestingexercise;

public class SalaryCalculationFailedException extends RuntimeException {

    public SalaryCalculationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
