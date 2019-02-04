package fr.dta.repository;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.dta.exception.CustomRollbackException;
import fr.dta.mapper.EmployeeMapper;
import fr.dta.modele.Employee;

@Repository
public class EmployeeJdbcRepository extends AbstractJdbcRepository implements EmployeeRepository {
    
    @Override
    public void saveEmployee( Employee employee ) {
        this.getJdbcTemplate().update(
                "insert into employee (firstname, lastname, ssn, salary, hiredate) values (?,?,?,?,?)",
                employee.getPrenom(), employee.getNom(), employee.getSecu(), employee.getSalaire(),
                Date.from( employee.getEmbauche().atStartOfDay( ZoneId.systemDefault() ).toInstant() ) );

    }

    @Override
    public List<Employee> findAllEmployees() {
        return this.getJdbcTemplate().query( "Select * from employee", new EmployeeMapper() );
    }

    @Override
    public Employee findBySsn( String ssn ) {
        return this.getJdbcTemplate().queryForObject( "Select * from employee where ssn = ?", new Object[] { ssn },
                new EmployeeMapper() );
    }

    @Override
    public void updateEmployee( Employee employee ) throws CustomRollbackException {
       if( this.getJdbcTemplate().update(
                "update employee set firstname = ?, lastname = ?, ssn = ?, salary = ?, hiredate = ? where id = ?  ",
                employee.getPrenom(), employee.getNom(), employee.getSecu(), employee.getSalaire(),
                Date.from( employee.getEmbauche().atStartOfDay( ZoneId.systemDefault() ).toInstant() ),
                employee.getIdentifiant() ) != 1){
                    throw new CustomRollbackException( "Employee inexistant" );
                }
        
        

    }

    @Override
    public void deleteAllEmployees() {
        // TODO Auto-generated method stub
        
    }

////    public void updateEmployee( List<Employee> list ) {
////        
////            
////        
////        for ( Employee employee : list ) {
////            updateEmployee( employee );
////        }
////        
//
//    }

}
