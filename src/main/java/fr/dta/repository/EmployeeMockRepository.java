package fr.dta.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import fr.dta.modele.Employee;

@Repository 
public class EmployeeMockRepository implements EmployeeRepository {

    private List<Employee> list;
    
    public EmployeeMockRepository() {
        list = new ArrayList();
    }
    
    @PostConstruct
    public void init() {
        
        list.add( new Employee( 0L, "aria", "asigard", "0960629", new BigDecimal( 22000 ), LocalDate.of( 2010, 7, 25 ) ) );
        list.add( new Employee( 1L, "amicius", "asigard", "1940544", new BigDecimal( 24000 ), LocalDate.of( 2012, 5, 12 ) ) );
        list.add( new Employee( 2L, "freya", "asigard", "0990129", new BigDecimal( 22000 ), LocalDate.of( 2015, 10, 13 ) ) );

    }

    public void saveEmployee( Employee employee ) {
        list.add( employee );
    }

    public List<Employee> findAllEmployees() {
        
        return list;
    }

    public Optional<Employee> findBySsn( String ssn ) {
        
        for(Employee employ : list) {
            if (employ.getSecu().equals( ssn)) return Optional.of( employ);
        }
        return null;
    }

    public void updateEmployee( Employee employee ) {
        if(list.contains( employee )) {
            list.set( list.indexOf( employee ), employee );
        }
        
    }

    @Override
    public void deleteAllEmployees() {
        // TODO Auto-generated method stub
        
    }

//    @Override
//    public void updateEmployee( List<Employee> list ) {
//        // TODO Auto-generated method stub
//        
//    }

}
