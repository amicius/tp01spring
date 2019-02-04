package fr.dta.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import fr.dta.App;
import fr.dta.repository.EmployeeRepository;
import fr.dta.service.CompanyService;
import fr.dta.service.EmployeeService;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = App.class )
@TestExecutionListeners( DependencyInjectionTestExecutionListener.class )
public class TestApplicationContext {

    @Autowired
    EmployeeRepository employeeMockRepository;

    @Autowired
    EmployeeService    employeeMockService;

    @Autowired
    CompanyService     companyService;

 
    @Test
    public void testContext() {
        assertNotNull( employeeMockRepository );
    }

    @Test
    public void testLastHired() {
        assertNotNull( employeeMockService );
        assertEquals( employeeMockService.findLastHired().getIdentifiant(), new Long( 2l ) );

    }

    @Test
    public void testFindEmployees() {
        assertNotNull( companyService );
        assertEquals( companyService.findEmployees(), employeeMockRepository.findAllEmployees() );

    }

}
