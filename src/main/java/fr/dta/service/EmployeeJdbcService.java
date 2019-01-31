package fr.dta.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeJdbcRepository;

@Service
@Transactional
public class EmployeeJdbcService implements EmployeeService{
    
    @Autowired
    private EmployeeJdbcRepository employeeJdbcRepository;

    @Override
    public void saveEmployee( Employee employee ) {
        employeeJdbcRepository.saveEmployee( employee );
        
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeJdbcRepository.findAllEmployees();
    }

    @Override
    public Employee findBySsn( String ssn ) {
           return employeeJdbcRepository.findBySsn( ssn );
    }

    @Override
    public void updateEmployee( Employee employee ) {
        try {
            employeeJdbcRepository.updateEmployee( employee );
        } catch ( Exception e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    @Override
    public Employee findLastHired() {
        return employeeJdbcRepository.findAllEmployees().stream().max( Comparator.comparing( Employee::getEmbauche ) ).get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateEmployee( List<Employee> list ) {
        for ( Employee employee : list ) {
          updateEmployee( employee );
      }
        
    }
    
    
}
