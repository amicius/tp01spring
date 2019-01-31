package fr.dta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.dta.modele.Employee;

@Service
public class EmployeeStubService implements EmployeeService{

    @Override
    public void saveEmployee( Employee employee ) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Employee> findAllEmployees() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee findBySsn( String ssn ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateEmployee( Employee employee ) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Employee findLastHired() {
        // TODO Auto-generated method stub
        return null;
    }

}
