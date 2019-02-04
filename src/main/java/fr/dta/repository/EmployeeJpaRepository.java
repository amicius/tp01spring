package fr.dta.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.dta.modele.Employee;

@Repository
public class EmployeeJpaRepository extends AbstractJdbcRepository implements EmployeeRepository {

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
    public void updateEmployee( Employee employee ){
        // TODO Auto-generated method stub
        
    }
    
    public void updtaeEmployee( List<Employee> list) {
        for(Employee e : list) {
            updateEmployee( e );
        }
    }

    @Override
    public void deleteAllEmployees() {
        // TODO Auto-generated method stub
        
    }

}
