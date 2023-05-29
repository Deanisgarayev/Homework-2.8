package com.skypro.homework28;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeInterfaceImpl implements EmployeeInterface {
    private final Map<String, EmployeeBook> employeeBooks;

    public EmployeeInterfaceImpl() {
        this.employeeBooks = new HashMap<>();
    }


     @Override
    public  findEmployeeWithMinSalary(Employee[] employees) {
        int minSalary = Integer.MAX_VALUE;
        Employee resultedEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                resultedEmployee = employee;
            }
        }
        System.out.println(resultedEmployee);
    }
 @Override
    public findEmployeeWithMaxSalary(Employee[] employees) {
        int maxSalary = Integer.MIN_VALUE;
        Employee resultedEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                resultedEmployee = employee;
            }
        }
        System.out.println(resultedEmployee);
    }
@Override
    public backAllEmployeeByDepartment(Employee[] employees) {
        int middleSum = 0;
        int sum = 0;
        int day = 30;
        for (Employee employee : employees) {
            sum += employee.getSalary();
            middleSum = sum / day;

        }
        System.out.println("Сумма трат на зарплаты составила =  " + middleSum);
    }

    @Override
    public Collection<EmployeeBook> findAll() {
        return Collections.unmodifiableCollection(employeeBooks.values());
    }

}
