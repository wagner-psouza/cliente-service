package br.com.psouza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("br.com.psouza")
@EntityScan("br.com.psouza.entity")
@EnableJpaRepositories("br.com.psouza.repository")
public class ClienteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClienteServiceApplication.class, args);
    }

}
