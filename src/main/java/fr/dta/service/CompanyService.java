package fr.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.modele.Employee;

@Service
public class CompanyService {

    @Autowired
    private EmployeeMockService service;
    
    public List<Employee> findEmployees(){
        return service.findAllEmployees();
    }
}
