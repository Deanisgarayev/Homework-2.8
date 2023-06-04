package EmployeesService;

import EmployeesService.EmployeeAlreadyAddedException;
import EmployeesService.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

        private final Map<String, EmployeeBook> employeeBooks;

        public EmployeeServiceImpl() {
            this.employeeBooks = new HashMap<>();
        }

        @Override

        public EmployeeBook add(String firstname, String surname, Integer salary, Integer departmentID) {
            EmployeeBook employeeBook = new EmployeeBook(firstname, surname, salary, departmentID);
            if (employeeBooks.containsKey(employeeBook.getFullName())) {
                throw new EmployeeAlreadyAddedException();
            }
            employeeBooks.put(employeeBook.getFullName(), employeeBook);
            return employeeBook;
        }

        @Override
        public EmployeeBook remove(String firstname, String surname, Integer salary, Integer departmentID) {
            EmployeeBook employeeBook = new EmployeeBook(firstname, surname, salary, departmentID);
            if (employeeBooks.containsKey(employeeBook.getFullName())) {
                return employeeBooks.remove(employeeBook.getFullName());
            }
            throw new EmployeeNotFoundException();
        }

        @Override
        public EmployeeBook find(String firstname, String surname, Integer salary, Integer departmentID) {
            EmployeeBook employeeBook = new EmployeeBook(firstname, surname, salary, departmentID);
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

