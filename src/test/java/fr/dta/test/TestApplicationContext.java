package fr.dta.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.App;
import fr.dta.repository.EmployeeMockRepository;
import fr.dta.service.CompanyService;
import fr.dta.service.EmployeeMockService;

public class TestApplicationContext {
    AbstractApplicationContext context;
    EmployeeMockRepository rep;
    
    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(App.class);
        rep = (EmployeeMockRepository) context.getBean("employeeMockRepository");
    }
    
    @Test
    public void testContext() {
       assertNotNull( context );
       assertNotNull( rep );
    }
    @Test
    public void testLastHired() {
        EmployeeMockService service = (EmployeeMockService) context.getBean("employeeMockService");
        assertNotNull( service );
        assertEquals(service.findLastHired().getIdentifiant(), 2L );
        
    }
    @Test
    public void testFindEmployees() {
        CompanyService company = (CompanyService) context.getBean( "companyService" );
        assertNotNull( company );
        assertEquals( company.findEmployees(), rep.findAllEmployees() );
        
    }
    
    @After
    public void close() {
        context.close();
    }
    
    
}
