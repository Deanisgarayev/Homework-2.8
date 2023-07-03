package com.skypro.homework28;

import Application.com.exceptions.EmployeeAlreadyAddedException;
import Application.com.exceptions.EmployeeNotFoundException;
import Application.com.interfaces.EmployeeService;
import Application.com.services.EmployeeServiceImpl;
import Application.com.skypro.EmployeeBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class employeeServiceImplTest {
    private EmployeeService out = new EmployeeServiceImpl();
@Test
    public void ShouldBeNotNullWhenWeAddEmployee() {
        EmployeeBook result = out.add ("Jackson", "Stone", 5555, 1);
        Assertions.assertNotNull(result);
    }
@Test
    public void ShouldThrowExceptionWhenWeAddEmployeeThatWeHave() {
    EmployeeBook result = out.add ("Jackson", "Stone", 5555, 1);
    Assertions.assertThrows(EmployeeAlreadyAddedException.class,
            ()->out.add("Jackson", "Stone", 5555, 1)
    );
    }
    @Test
    public void ShouldBeEqualWhenWeAddAndRemove() {
        EmployeeBook date = out.add("Katy", "Parry", 5000, 1);
        EmployeeBook result =out.remove("Katy", "Parry", 5000, 1);
        Assertions.assertEquals(result,date);
    }

@Test
    public void ShouldThrowExceptionWhenWeTryToRemoveEmployeeThatWeDoNotHave() {
        EmployeeBook result = out.add("Simon", "Parry", 5000, 1);
        Assertions.assertThrows(EmployeeNotFoundException.class,
                ()-> out.remove("Katy", "Parry", 5000, 1)
        );
    }

    @Test
    public void ShouldFindEmployeeWhenWeHave() {
    EmployeeBook result = out.add("Katy", "Parry", 5000, 1);
    EmployeeBook resultCopy = out.find("Katy", "Parry", 5000, 1);
    Assertions.assertEquals(result, resultCopy);
    }

    @Test
    public void ShouldThrowExceptionWhenWeTryToFindEmployeeThatWeDoNotHave() {
        EmployeeBook result = out.add("Simon", "Parry", 5000, 1);
        Assertions.assertThrows(EmployeeNotFoundException.class,
                ()->out.find("Katy", "Parry", 5000, 1)
        );
    }
}
