package at.wortha.dezsys09;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry Point of the application
 *
 * @author Simon Wortha 5BHIT
 * @version 20160311.1
 */
@SpringBootApplication
public class Application {
    /**
     * Main method
     * @param args none
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}