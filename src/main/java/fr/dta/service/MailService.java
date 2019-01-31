package fr.dta.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.dta.modele.Employee;

@Service
@Scope("prototype")
public class MailService {
    private String message;

    public void setMessage( String message ) {
        this.message = message;
    }

    public String sendMail(Employee e) {
        System.out.println(message +" "+ e.getPrenom());
        return message +" "+ e.getPrenom();         
    }
}
