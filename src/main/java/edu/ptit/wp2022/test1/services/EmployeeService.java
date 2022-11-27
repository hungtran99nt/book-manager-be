package edu.ptit.wp2022.test1.services;

import edu.ptit.wp2022.test1.models.Employee;
import edu.ptit.wp2022.test1.models.EmployeeDto;
import edu.ptit.wp2022.test1.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeDto getEmployeeById(int id) {
        Employee emp = employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(emp.getId());
        employeeDto.setName(emp.getName());
        employeeDto.setDepartment(emp.getDepartment());
        employeeDto.setDob(dateFormat.format(emp.getDob()));

        return employeeDto;
    }

    public Employee addEmployee(EmployeeDto emp) throws ParseException {
        Employee newEmp = new Employee();
        newEmp.setId(emp.getId());
        newEmp.setName(emp.getName());
        newEmp.setDepartment(emp.getDepartment());
        newEmp.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(emp.getDob()));
        newEmp.setHired(emp.isHired());

        return employeeRepository.save(newEmp);
    }

    public void updateEmployee(EmployeeDto emp) throws ParseException {
        Employee desEmployee = employeeRepository.findEmployeeById(emp.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        desEmployee.setId(emp.getId());
        desEmployee.setName(emp.getName());
        desEmployee.setDepartment(emp.getDepartment());
        desEmployee.setDob(new SimpleDateFormat("YYYY-MM-DD").parse(emp.getDob()));
        desEmployee.setHired(emp.isHired());

        employeeRepository.save(desEmployee);
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employeeRepository.deleteById(id);
    }

    public void existsEmployeeByNameAndDob(String name, long dob) {
        Date dobParse = new Date(dob * 1000);
        if (employeeRepository.existsEmployeeByNameAndDob(name, dobParse))
            throw new RuntimeException("Employee exists");
    }

    public void existsEmployeeById(int id) {
        if (employeeRepository.existsEmployeeById(id))
            throw new RuntimeException("Employee ID duplicates");
    }
}
