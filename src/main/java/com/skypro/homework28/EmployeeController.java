package com.skypro.homework28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeInterface employeeInterface;

    public EmployeeController(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    @GetMapping("/max-salary")
    public EmployeeBook findEmployeeWithMinSalary(String firstname, String surname, Integer salary,
                                                  @RequestParam("departmentID") Integer departmentID) {
        return employeeInterface.findEmployeeWithMinSalary(firstname, surname, salary, departmentID);
    }
    @GetMapping("/min-salary")
    public EmployeeBook findEmployeeWithMaxSalary(@RequestParam("departmentID") Integer departmentID) {
        return employeeInterface.findEmployeeWithMaxSalary(departmentID);
    }
    @GetMapping(value = "/all", params = "departmentID")
    public EmployeeBook findAllEmployeesByDepartment (@RequestParam("departmentID") Integer departmentID) {
        return employeeInterface.findAllEmployeesByDepartment (departmentID);
    }
    @GetMapping("/all")
    public Map<Integer, List<EmployeeBook>> findAll() {
        return employeeInterface.findAll();
    }
}

