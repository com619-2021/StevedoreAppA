package uk.ac.solent.devops.impl.web;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import uk.ac.solent.devops.impl.service.ServiceConfiguration;

@Configuration
@Import(ServiceConfiguration.class)
@PropertySource("classpath:persistence-app.properties")
public class SpringBootJspConfiguration {


}
