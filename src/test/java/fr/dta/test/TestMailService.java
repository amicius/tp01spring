package fr.dta.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import fr.dta.App;
import fr.dta.modele.Employee;
import fr.dta.service.MailService;

public class TestMailService {
    AbstractApplicationContext context;
    
    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(App.class);
        
    }
    
    @Test
    public void testMail() {
        MailService maila = (MailService) context.getBean("mailService");
        assertNotNull(maila);
        maila.setMessage( "Bonjour" );
        MailService mailb = (MailService) context.getBean("mailService");
        assertNotNull(mailb);
        mailb.setMessage( "Kenavo" );
        assertEquals( "Bonjour Aria", maila.sendMail( new Employee( 0L, "Aria", "ASIGARD", "0960644", new BigDecimal( 22000 ), LocalDate.of( 2014, 7, 25 )  ) ) );
        assertEquals( "Kenavo Freya", mailb.sendMail( new Employee( 0L, "Freya", "ASIGARD", "0921029", new BigDecimal( 24000 ), LocalDate.of( 2010, 7, 25 )  ) ));
        //mailb.sendMail( new Employee( 0L, "Freya", "ASIGARD", "0921029", new BigDecimal( 24000 ), LocalDate.of( 2010, 7, 25 )  ) );
    }
    
    
}
