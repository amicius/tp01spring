package fr.dta.service;

import java.util.List;

import fr.dta.exception.CustomRollbackException;
import fr.dta.modele.Employee;

public interface EmployeeService {

   
        void saveEmployee(Employee employee);
        List<Employee> findAllEmployees();
        Employee findBySsn(String ssn);
        void updateEmployee(Employee employee) throws CustomRollbackException;
        Employee findLastHired();
        void updateEmployee(List<Employee> list) throws CustomRollbackException;
     
}
