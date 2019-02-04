package fr.dta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.exception.CustomRollbackException;
import fr.dta.exception.EmployeeNotFoundException;
import fr.dta.modele.Employee;
import fr.dta.service.EmployeeService;

@Configuration
@ComponentScan( basePackages = "fr.dta" )
// @ImportResource("classpath:database.xml") // utile uniquement en xml
public class App {

    public static void main( String[] args ){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext( App.class );

        EmployeeService serv = (EmployeeService) context.getBean( "employeeJpaService" );
        Employee emp1 = new Employee( "aria", "asigard", "0960629", new BigDecimal( 22000 ),
                LocalDate.of( 2010, 7, 25 ) );
        Employee emp2 = new Employee( "amicius", "asigard", "1940544", new BigDecimal( 24000 ),
                LocalDate.of( 2012, 5, 12 ) );
        Employee emp3 = new Employee( "freya", "asigard", "0990129", new BigDecimal( 22000 ),
                LocalDate.of( 2015, 10, 13 ) );
        serv.saveEmployee( emp1 );
        serv.saveEmployee( emp2 );
        serv.saveEmployee( emp3 );

        List<Employee> list;
        list = serv.findAllEmployees();
        for ( Employee e : list ) {
            System.out.println( e.toString() );
        }
        Optional<Employee> temp;
        temp = serv.findBySsn( "1940544" );
        System.out.println( temp.toString() );
        if ( temp.isPresent() ) {
            Employee temp2 = temp.get();
            temp2.setSalaire( new BigDecimal( "30000" ) );

            try {
                serv.updateEmployee( temp2 );
            } catch ( EmployeeNotFoundException e1 ) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if ( temp.isPresent() ) {
            temp = serv.findBySsn( "1940544" );
            System.out.println( temp.toString() );
        }
        for ( Employee e : list ) {
            e.setSalaire( e.getSalaire().add( new BigDecimal( 500 ) ) );
        }
        list.add( new Employee( 2L, "test", "test", "123456", new BigDecimal( 100 ), LocalDate.now() ) );

        try {
            serv.updateEmployee( list );
        } catch ( EmployeeNotFoundException e1 ) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        list = serv.findAllEmployees();
        for ( Employee e : list ) {
            System.out.println( e.toString() );
        }

        context.close();

    }

}
