package by.academyit.itBootcampJavaTestTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.logging.LogManager;
import java.util.logging.Logger;


@SpringBootApplication
@EntityScan(basePackages = {"by.academyit.*"})
@EnableJpaRepositories(basePackages = {"by.academyit.*"})
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApplication.class, args);

    }

}
