package pl.javastart.exceptionstestingexercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SalaryCalculatorServiceTest {

    @Mock TaskManagementSystem taskManagementSystem;

    private SalaryCalculatorService salaryCalculatorService;
    private Employee employee;

    @BeforeEach
    public void init() {
        salaryCalculatorService = new SalaryCalculatorService(taskManagementSystem);
        employee = new Employee("Bob", BigDecimal.ZERO);
    }

    @DisplayName("Employee no longer hired")
    @Test
    public void shouldThrowForNoLongerWorkingEmployee() {
        // given
//        when(salaryCalculatorService.calculateSalary(employee)).thenThrow(new EmployeeNoLongerWorkingException());
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenThrow(new EmployeeNoLongerWorkingException());

        // when, then
        assertThatThrownBy(() -> salaryCalculatorService.calculateSalary(employee))
                .isInstanceOf(SalaryCalculationFailedException.class)
                .hasCauseInstanceOf(EmployeeNoLongerWorkingException.class)
                .hasMessage("Could not calculate salary. Reason: Employee is no longer hired");
    }

    @DisplayName("Employee no in database")
    @Test
    public void shouldThrowForEmployeeNotInDb() {
        // given
//        when(salaryCalculatorService.calculateSalary(employee)).thenThrow(new EmployeeNotFoundException());
        when(taskManagementSystem.countFinishedTasksForEmployee(employee)).thenThrow(new EmployeeNotFoundException());


        // when, then
        assertThatThrownBy(() -> salaryCalculatorService.calculateSalary(employee))
                .isInstanceOf(SalaryCalculationFailedException.class)
                .hasCauseInstanceOf(EmployeeNotFoundException.class)
                .hasMessage("Could not calculate salary. Reason: Employee not found in database");
    }

}