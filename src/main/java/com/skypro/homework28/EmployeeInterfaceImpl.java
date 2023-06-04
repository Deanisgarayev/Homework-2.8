package com.skypro.homework28;

import EmployeesService.EmployeeBook;
import EmployeesService.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeInterfaceImpl implements EmployeeInterface {
    private final EmployeeService employeeService;

    public EmployeeInterfaceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public EmployeeBook findEmployeeWithMaxSalary(Integer departmentID) {
       return employeeService.findAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentID(), departmentID))
                .max(Comparator.comparingInt(EmployeeBook::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("there's not employee in the department"));
    }


    @Override
    public EmployeeBook findEmployeeWithMinSalary(Integer departmentID) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentID(),departmentID))
                .min(Comparator.comparingInt(EmployeeBook :: getSalary))
                .orElseThrow(() -> new IllegalArgumentException("there's not employee in the department"));
    }

    @Override
    public Collection<EmployeeBook> findAllEmployeesByDepartment (Integer departmentID) {
        return employeeService.findAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentID(), departmentID))
                .collect(Collectors.toList());
    }


    @Override
    public  Map<Integer, List<EmployeeBook>> findAll() {
        return employeeService.findAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentID(),departmentID))
                .collect(Collectors.groupingBy(e->e.getDepartmentID()));
    }
}

