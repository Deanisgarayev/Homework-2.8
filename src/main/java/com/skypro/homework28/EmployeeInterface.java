package com.skypro.homework28;

import java.util.Collection;

public interface EmployeeInterface {

        EmployeeBook findEmployeeWithMinSalary (String firstname, String surname, int salary, int department);

        EmployeeBook findEmployeeWithMaxSalary (String firstname, String surname, int salary, int department);
        EmployeeBook backAllEmployeeByDepartment (String firstname, String surname, int salary, int department);

        Collection<EmployeeBook> findAll();

}
