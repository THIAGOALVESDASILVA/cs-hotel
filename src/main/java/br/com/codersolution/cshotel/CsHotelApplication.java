package br.com.codersolution.cshotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@EnableConfigurationProperties
@SpringBootApplication
public class CsHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsHotelApplication.class, args);
    }

}
