package fr.dta.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeMockRepository;

@Service
public class EmployeeMockService implements EmployeeService {

    @Autowired
    private EmployeeMockRepository repo;

    // public EmployeeMockRepository getRepo() {
    // return repo;
    // }
    //
    // public void setRepo( EmployeeMockRepository repo ) {
    // this.repo = repo;
    // }

    @Override
    public void saveEmployee( Employee employee ) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Employee> findAllEmployees() {
        // TODO Auto-generated method stub
        return repo.findAllEmployees();
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
        return repo.findAllEmployees().stream().max( Comparator.comparing( Employee::getEmbauche ) ).get();
    }

}
