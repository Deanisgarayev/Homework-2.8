package com.skypro.homework28;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeInterfaceImpl implements EmployeeInterface {


    List<EmployeeBook> employees = new ArrayList<>(List.of(
            new EmployeeBook("Иван", "Иванов", 90000, 1),
            new EmployeeBook("Жан", "Ренно", 80000, 2),
            new EmployeeBook("Люк", "Бессон", 85000, 3),
            new EmployeeBook("Жерар", "Депардье", 75000, 4),
            new EmployeeBook("Джейсон", "Стетхем", 95000, 5)
    ));

    @Override
    public EmployeeBook findEmployeeWithMinSalary( String firstname, String surname, Integer salary, Integer departmentID) {
       return employees getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentID(), departmentID))
                .max(Comparator.comparingInt(EmployeeBook::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("there's not employee in the department"));
    }


    @Override
    public EmployeeBook findEmployeeWithMaxSalary( Integer departmentID) {
        return employees.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentID(),departmentID))
                .min(Comparator.comparingInt(EmployeeBook :: getSalary))
                .orElseThrow(() -> new IllegalArgumentException("there's not employee in the department"));
    }

    @Override
    public EmployeeBook findAllEmployeesByDepartment ( Integer departmentID) {
        return employees.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentID(), departmentID))
                .collect(Collectors.toList());
    }

    @Override
    public  Map<Integer, List<EmployeeBook>> findAll() {
        return employees.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentID(),departmentID))
                .collect(Collectors.groupingBy(e->e.getDepartmentID()));
    }
}

