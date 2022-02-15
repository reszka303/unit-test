package pl.javastart.exceptionstestingexercise;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private BigDecimal baseSalary;

    public Employee(String name, BigDecimal baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return name + " - " + baseSalary;
    }

}
