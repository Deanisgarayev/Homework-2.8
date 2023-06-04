package com.skypro.homework28;

import EmployeesService.EmployeeBook;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeInterface {

        EmployeeBook findEmployeeWithMinSalary (Integer departmentID);

        EmployeeBook findEmployeeWithMaxSalary (Integer departmentID);
        Collection<EmployeeBook>  findAllEmployeesByDepartment ( Integer departmentID);

        Map<Integer, List<EmployeeBook>> findAll();

}
