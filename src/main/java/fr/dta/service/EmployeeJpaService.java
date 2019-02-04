package fr.dta.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.exception.CustomRollbackException;
import fr.dta.exception.EmployeeNotFoundException;
import fr.dta.modele.Employee;
import fr.dta.repository.EmployeeJpaRepository;
import fr.dta.repository.EmployeeRepository;

@Service
@Transactional( rollbackFor = EmployeeNotFoundException.class )
public class EmployeeJpaService implements EmployeeService {

    @Autowired
    EmployeeRepository employeeJpaRepository;

    @Override
    public void saveEmployee( Employee employee ) {
        employeeJpaRepository.saveEmployee( employee );

    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeJpaRepository.findAllEmployees();
    }

    @Override
    public Optional<Employee> findBySsn( String ssn ) {
        return employeeJpaRepository.findBySsn( ssn );
    }

    @Override
    public void updateEmployee( Employee employee ) throws EmployeeNotFoundException{
        employeeJpaRepository.updateEmployee( employee );
//        else throw new EmployeeNotFoundException( "Employee inextistant" );
    }

    @Override
    public Employee findLastHired() {
        return employeeJpaRepository.findAllEmployees().stream().max(  Comparator.comparing( Employee::getEmbauche ) )
                .get();
    }

    @Override
    public void updateEmployee( List<Employee> list ) throws EmployeeNotFoundException {
        for ( Employee e : list ) {
            updateEmployee( e );
        }

    }

}
