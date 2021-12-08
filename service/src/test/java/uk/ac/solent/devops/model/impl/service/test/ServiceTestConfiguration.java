/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.impl.service.test;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import uk.ac.solent.devops.impl.service.ServiceConfiguration;


/**
 *
 * @author cgallen
 */
@Configuration
@Import(ServiceConfiguration.class)
@PropertySource("classpath:service-test.properties")
public class ServiceTestConfiguration {
    
}
