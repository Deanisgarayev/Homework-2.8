package EmployeesService;

import java.util.Objects;

public class EmployeeBook {

    private String firstname;

    private String surname;
    private Integer salary;
    private Integer departmentID;

    public EmployeeBook(String firstname, String surname, Integer salary, Integer departmentID) {
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
        this.departmentID = departmentID;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return departmentID;
    }

    public String getFullName() {
        return firstname + " " + surname;
    }

    public void setDepartment(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return firstname + " Имя " + surname + " фамилия " + salary + " зарплата " + departmentID + " отдел";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Objects.equals(salary, that.salary) && Objects.equals(departmentID, that.departmentID) && Objects.equals(firstname, that.firstname) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, surname, salary, departmentID);
    }

}


