package Application.com.EmployeesService;

import Application.com.Exceptions.InvalidInputException;
import Application.com.skypro.EmployeeBook;
import Application.com.Exceptions.EmployeeAlreadyAddedException;
import Application.com.Exceptions.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

        private final Map<String, EmployeeBook> employeeBooks;

        public EmployeeServiceImpl() {
            this.employeeBooks = new HashMap<>();
        }

        @Override

        public EmployeeBook add(String firstname, String surname, Integer salary, Integer departmentID) {
            validate(firstname, surname);
            EmployeeBook employeeBook = new EmployeeBook(firstname, surname, salary, departmentID);
            if (employeeBooks.containsKey(employeeBook.getFullName())) {
                throw new EmployeeAlreadyAddedException("EmployeeAlreadyExists");
            }
            employeeBooks.put(employeeBook.getFullName(), employeeBook);
            return employeeBook;
        }

        @Override
        public EmployeeBook remove(String firstname, String surname, Integer salary, Integer departmentID) {
            validate(firstname, surname);
            EmployeeBook employeeBook = new EmployeeBook(firstname, surname, salary, departmentID);
            if (employeeBooks.containsKey(employeeBook.getFullName())) {
                return employeeBooks.remove(employeeBook.getFullName());
            }
            throw new EmployeeNotFoundException("EmployeeIsNotFound");
        }

        @Override
        public EmployeeBook find(String firstname, String surname, Integer salary, Integer departmentID) {
            validate(firstname, surname);
            EmployeeBook employeeBook = new EmployeeBook(firstname, surname, salary, departmentID);
            if (employeeBooks.containsKey(employeeBook.getFullName())) {
                return employeeBooks.get(employeeBook.getFullName());
            }
            throw new EmployeeNotFoundException("EmployeeIsNotFound");
        }

        @Override
        public Collection<EmployeeBook> findAll() {
            return Collections.unmodifiableCollection(employeeBooks.values());
        }

    private void validate(String firstname, String surname) {
//          public validate (String... names)
//          for(String name:names){
//          if(!StringUtils.isAlpha(name)){
// throw new InvalidInputException("wrong spelling, you can write only by alphabet");
//          / public method(Employee employee){
//          validate(employee.getFirstname,employee.getSurname)
//          employee.setFirstname(StringUtils.capitalize(employee.getFirstname.toLowerCase());)
//          employee.setFirstname(StringUtils.capitalize(employee.getFirstname.toLowerCase());)/
        if (!(isAlpha(firstname) && isAlpha(surname))) {
            throw new InvalidInputException("wrong spelling, you can write only by alphabet");
        }
    }

    }

