package fr.dta;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "fr.dta")
@ImportResource("classpath:database.xml")
public class App {

    public static void main( String[] args ) {
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(App.class);

    }

}
