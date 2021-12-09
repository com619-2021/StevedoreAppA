package uk.ac.solent.devops.impl.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import uk.ac.solent.devops.impl.dao.spring.PersistenceJPAConfig;

@Configuration

@ComponentScan(basePackages = {
    "uk.ac.solent.devops.impl.service",
    "uk.ac.solent.devops.impl.user.service",
    "uk.ac.solent.devops.impl.resource.service"
})
@Import({PersistenceJPAConfig.class, SecurityServiceConfiguration.class})
public class ServiceConfiguration {

    @Bean
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("application starting");
        return helloWorld;
    }

}
