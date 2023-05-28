package com.skypro.homework28;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    private final EmployeeInterface employeeInterface;

    public EmployeeController(EmployeeInterface employeeInterface) {
        this.employeeInterface = employeeInterface;
    }

    @GetMapping("/add")
    public EmployeeBook addEmployee(@RequestParam String firstname, @RequestParam String surname) {
        return employeeInterface.add(firstname, surname);
    }
    @GetMapping("/remove")
    public EmployeeBook removeEmployee(@RequestParam String firstname, @RequestParam String surname) {
        return employeeInterface.remove(firstname, surname);
    }
    @GetMapping("/find")
    public EmployeeBook findEmployee(@RequestParam String firstname, @RequestParam String surname) {
        return employeeInterface.find(firstname, surname);
    }
    @GetMapping("/findAll")
    public Collection<EmployeeBook> findAll() {
        return employeeInterface.findAll();
    }
}

