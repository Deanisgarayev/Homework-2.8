package com.skypro.homework28;

import java.util.Objects;

public class EmployeeBook {

    private String firstname;

    private String surname;
    private int salary;
    private int department;

    public EmployeeBook(String firstname, String surname, int salary, int department) {
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getFullName() {
        return firstname + " " + surname;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return firstname + " Имя " + surname + " фамилия " + salary + " зарплата " + department + " отдел";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return salary == that.salary && department == that.department && Objects.equals(firstname, that.firstname) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, surname, salary, department);
    }
}


