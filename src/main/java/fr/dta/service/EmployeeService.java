package fr.dta.service;

import java.util.List;
import java.util.Optional;

import fr.dta.exception.CustomRollbackException;
import fr.dta.exception.EmployeeNotFoundException;
import fr.dta.modele.Employee;

public interface EmployeeService {

   
        void saveEmployee(Employee employee);
        List<Employee> findAllEmployees();
        Optional<Employee> findBySsn(String ssn);
        void updateEmployee(Employee employee) throws EmployeeNotFoundException;
        Employee findLastHired();
        void updateEmployee(List<Employee> list) throws EmployeeNotFoundException;
     
}
