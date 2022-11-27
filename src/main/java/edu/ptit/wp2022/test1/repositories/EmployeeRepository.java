package edu.ptit.wp2022.test1.repositories;

import edu.ptit.wp2022.test1.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findEmployeeById(int id);

    void deleteById(int id);

    boolean existsEmployeeByNameAndDob(String name, Date dob);

    boolean existsEmployeeById(int id);
}
