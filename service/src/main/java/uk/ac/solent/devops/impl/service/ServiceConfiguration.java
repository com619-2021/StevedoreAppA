/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.impl.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import uk.ac.solent.devops.impl.dao.spring.PersistenceJPAConfig;

/**
 *
 * @author cgallen
 */
@Configuration

@ComponentScan(basePackages = {"uk.ac.solent.devops.impl.party.service",
    "uk.ac.solent.devops.impl.service",
    "uk.ac.solent.devops.impl.user.service",
    "uk.ac.solent.devops.impl.resource.service",
    "uk.ac.solent.devops.impl.order.service"
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
