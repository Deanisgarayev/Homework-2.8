package com.skypro.homework28;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeInterface {

        EmployeeBook findEmployeeWithMinSalary (  int departmentID);

        EmployeeBook findEmployeeWithMaxSalary (int departmentID);
        Collection<EmployeeBook>  findAllEmployeesByDepartment ( int departmentID);

        Map<Integer, List<EmployeeBook>> findAll();

}
