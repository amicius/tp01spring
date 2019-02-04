package fr.dta.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import fr.dta.App;
import fr.dta.service.EmployeeService;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = App.class )
@TestExecutionListeners( DependencyInjectionTestExecutionListener.class )
public class TestJpa {
    
    @Autowired
    EmployeeService employeJpaService;
    
    @Test
    public void testContext() {
        assertNotNull( employeJpaService );
    }
    
    

}
