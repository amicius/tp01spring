package fr.dta.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.dta.modele.Employee;

public final class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow( ResultSet rs, int rowNum ) throws SQLException {
        Employee e = new Employee();
        e.setIdentifiant( rs.getLong( "id" ) );
        e.setNom( rs.getString( "lastname" ) );
        e.setPrenom( rs.getString( "firstname" ) );
        e.setSecu( rs.getString( "ssn" ) );
        e.setSalaire( rs.getBigDecimal( "salary" ) );
        e.setEmbauche( rs.getDate( "hiredate" ).toLocalDate() );
        return e;
    }

}
