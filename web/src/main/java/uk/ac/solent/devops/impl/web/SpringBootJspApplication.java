package uk.ac.solent.devops.impl.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"uk.ac.solent.devops.impl.web",
        "uk.ac.solent.devops.impl.rest",
        "uk.ac.solent.devops.impl.validator" })
@EnableSwagger2
public class SpringBootJspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootJspApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJspApplication.class);
    }
}