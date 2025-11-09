package br.com.faesa.monitorweb.vacinawebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Aplicação principal do projeto.
 * Aqui é onde tudo começa a rodar.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"controller"})
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"repository"})
public class VacinaWebappApplication {

    public static void main(String[] args) {
        // inicia o servidor Spring Boot
        SpringApplication.run(VacinaWebappApplication.class, args);
    }
}
