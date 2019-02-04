package fr.dta.repository;

import java.util.List;
import java.util.Optional;

import fr.dta.exception.CustomRollbackException;
import fr.dta.exception.EmployeeNotFoundException;
import fr.dta.modele.Employee;

public interface EmployeeRepository {
    void saveEmployee( Employee employee );

    List<Employee> findAllEmployees();

    Optional<Employee> findBySsn( String ssn );

    void updateEmployee( Employee employee ) throws  EmployeeNotFoundException ;
    
    void deleteAllEmployees();
    
}
