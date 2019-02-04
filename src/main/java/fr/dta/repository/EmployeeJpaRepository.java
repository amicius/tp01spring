package fr.dta.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.dta.exception.EmployeeNotFoundException;
import fr.dta.modele.Employee;

@Repository
public class EmployeeJpaRepository extends AbstractJpaRepository<Employee> implements EmployeeRepository {

    @Override
    protected Class<Employee> getEntityClass() {
        return Employee.class;
    }

    @Override
    public void saveEmployee( Employee employee ) {
        save( employee );

    }

    @Override
    public List<Employee> findAllEmployees() {
        return findAll();
    }

    @Override
    public Optional<Employee> findBySsn( String ssn ) {
        Employee e = (Employee) getSession().createCriteria( entityClass ).add( Restrictions.eq( "secu", ssn ) )
                .uniqueResult();
        return Optional.of( e );
    }

    @Override
    public void updateEmployee( Employee employee ) throws EmployeeNotFoundException {
        if ( this.isNew( employee ) ) {
            save( employee );
        } else {
            throw new EmployeeNotFoundException( "Inexistant" );
        }

    }

    @Override
    public void deleteAllEmployees() {

        em.createQuery("delete from Employee").executeUpdate();

    }

}
