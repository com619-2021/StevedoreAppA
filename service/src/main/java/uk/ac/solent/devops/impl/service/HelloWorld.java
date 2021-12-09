package uk.ac.solent.devops.impl.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Properties;

public class HelloWorld {

    final static Logger LOG = LogManager.getLogger(HelloWorld.class);

    private Properties properties;

    @Autowired(required = false)
    @Qualifier("appProperties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        LOG.debug("init() Application context started HelloWorld " + message);

        if (properties == null) {
            LOG.debug("---- appProperties is null ---- ");
        } else {
            StringBuilder msg = new StringBuilder("---- appProperties ---- \n");
            properties.forEach((key, value) -> msg.append("    ").append(key).append("   ").append(value).append("\n"));
            msg.append("---- end of appProperties ---- \n");
            LOG.debug(msg.toString());
        }

        String[] beanNames = applicationContext.getBeanDefinitionNames();

        StringBuilder msg = new StringBuilder("\n---- beans in applicationContext " + beanNames.length + " ----\n");
        for (String b : beanNames) {
            msg.append("\n ").append(b).append(", ");
        }

        ConfigurableEnvironment env = applicationContext.getEnvironment();
        msg.append(printSources(env));
        msg.append("\n---- System properties (java) -----\n");
        msg.append(printMap(env.getSystemProperties()));
        msg.append("\n---- System Env properties -----\n");
        msg.append(printMap(env.getSystemEnvironment()));

        LOG.debug(msg.toString());

    }

    public void destroy() {
        LOG.debug("destroy() Application context stopped HelloWorld " + message);
    }

    private String printSources(ConfigurableEnvironment env) {
        StringBuilder msg = new StringBuilder("\n---- property sources ----\n");
        env.getPropertySources().forEach(x -> msg.append("   name =  ").append(x.getName()).append("   source = ").append(x
                .getSource().getClass()).append("\n"));
        return msg.toString();
    }

    private String printMap(Map<?, ?> map) {
        StringBuilder msg = new StringBuilder();
        map.forEach((key, value) -> msg.append("   ").append(key).append(" = ").append(value).append("\n"));
        return msg.toString();
    }

}
