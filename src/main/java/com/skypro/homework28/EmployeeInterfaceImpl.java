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

    public EmployeeBook add(String firstname, String surname) {
        EmployeeBook employeeBook = new EmployeeBook(firstname, surname);
        if (employeeBooks.containsKey(employeeBook.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeBooks.put(employeeBook.getFullName(), employeeBook);
        return employeeBook;
    }

    @Override
    public EmployeeBook remove(String firstname, String surname) {
        EmployeeBook employeeBook = new EmployeeBook(firstname, surname);
        if (employeeBooks.containsKey(employeeBook.getFullName())) {
            return employeeBooks.remove(employeeBook.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public EmployeeBook find(String firstname, String surname) {
        EmployeeBook employeeBook = new EmployeeBook(firstname, surname);
        if (employeeBooks.containsKey(employeeBook.getFullName())) {
            return employeeBooks.get(employeeBook.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<EmployeeBook> findAll() {
        return Collections.unmodifiableCollection(employeeBooks.values());
    }

}
