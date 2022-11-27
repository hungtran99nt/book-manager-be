package edu.ptit.wp2022.test1.controllers;

import edu.ptit.wp2022.test1.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/emps")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{name}/{dob}/exist")
    public void existsEmployeeByNameAndDob(@PathVariable(value = "name") String name, @PathVariable(value = "dob") long dob) {
        employeeService.existsEmployeeByNameAndDob(name, dob);
    }

    @GetMapping("/{id}/exist")
    public void existsEmployeeById(@PathVariable(value = "id") int id) {
        employeeService.existsEmployeeById(id);
    }
}
