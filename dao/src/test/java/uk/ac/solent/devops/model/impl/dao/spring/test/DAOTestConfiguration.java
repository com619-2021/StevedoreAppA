/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.solent.devops.model.impl.dao.spring.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import uk.ac.solent.devops.impl.dao.spring.PersistenceJPAConfig;


/**
 *
 * @author cgallen
 */
@Configuration
@Import(PersistenceJPAConfig.class)
@PropertySource("classpath:persistence-test.properties")
public class DAOTestConfiguration {
    
}
