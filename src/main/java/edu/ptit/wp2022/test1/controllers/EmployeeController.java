package edu.ptit.wp2022.test1.controllers;

import edu.ptit.wp2022.test1.models.Employee;
import edu.ptit.wp2022.test1.models.EmployeeDto;
import edu.ptit.wp2022.test1.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/v2/emps")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String getAllEmployee(Model model) {
        List<Employee> emps = employeeService.getAllEmployees();
        model.addAttribute("emps", emps);
        return "emp_pages/index";
    }

    @GetMapping("/add")
    public String showFormCreate(Model model) {
        Employee newEmp = new Employee();
        model.addAttribute("newEmp", newEmp);
        return "emp_pages/create";
    }

    @PostMapping("/add")
    public String createEmp(@ModelAttribute("emp") EmployeeDto emp) throws ParseException {
        Employee newEmp = employeeService.addEmployee(emp);
        System.out.println(newEmp);
        return "redirect:/v2/emps";
    }

    @GetMapping("/{id}/edit")
    public String showFormEdit(Model model, @PathVariable(value = "id") int id) {
        EmployeeDto emp = employeeService.getEmployeeById(id);
        model.addAttribute("emp", emp);
        return "emp_pages/edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute("emp") EmployeeDto emp) throws ParseException {
        employeeService.updateEmployee(emp);
        return "redirect:/v2/emps";
    }

    @GetMapping("/{id}/delete")
    public String deleteEmp(@PathVariable(value = "id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/v2/emps";
    }
}
