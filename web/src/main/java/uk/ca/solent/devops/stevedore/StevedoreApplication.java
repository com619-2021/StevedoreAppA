package uk.ca.solent.devops.stevedore;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {"uk.ca.solent.devops.stevedore.*"})
@EntityScan(basePackages = {"uk.ca.solent.devops.stevedore.*"})
@EnableJpaRepositories(basePackages = {"uk.ca.solent.devops.stevedore.*"})
public class StevedoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StevedoreApplication.class, args);
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
