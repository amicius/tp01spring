package fr.dta.repository;

import java.util.List;

import fr.dta.exception.CustomRollbackException;
import fr.dta.modele.Employee;

public interface EmployeeRepository {
    void saveEmployee( Employee employee );

    List<Employee> findAllEmployees();

    Employee findBySsn( String ssn );

    void updateEmployee( Employee employee ) throws CustomRollbackException ;
    
    void deleteAllEmployees();
    
}
