package Application.com.controllers;

import Application.com.interfaces.EmployeeService;
import Application.com.skypro.EmployeeBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employeeService")
public class EmployeeServiceController {


        private final EmployeeService employeeService;
@Autowired
        public EmployeeServiceController(EmployeeService employeeService) {
            this.employeeService= employeeService;
        }

        @GetMapping("/add")
        public EmployeeBook addEmployee(@RequestParam String firstname, @RequestParam String surname,
                                        @RequestParam Integer salary, @RequestParam Integer departmentID) {
            return employeeService.add(firstname, surname, salary, departmentID);
        }
        @GetMapping("/remove")
        public EmployeeBook removeEmployee(@RequestParam String firstname, @RequestParam String surname,
        @RequestParam Integer salary, @RequestParam Integer departmentID) {
            return employeeService.remove(firstname, surname, salary, departmentID);
        }
        @GetMapping("/find")
        public EmployeeBook findEmployee(@RequestParam String firstname, @RequestParam String surname,
        @RequestParam Integer salary, @RequestParam Integer departmentID) {
            return employeeService.find(firstname, surname, salary, departmentID);
        }
        @GetMapping("/findAll")
        public Collection<EmployeeBook> findAll() {
            return employeeService.findAll();
        }
    }


