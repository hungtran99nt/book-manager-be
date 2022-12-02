package edu.ptit.wp2022;

import edu.ptit.wp2022.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class WebProgrammingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProgrammingApplication.class, args);
    }

}
