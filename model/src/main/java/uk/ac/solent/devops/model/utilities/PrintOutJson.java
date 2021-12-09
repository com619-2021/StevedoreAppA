package uk.ac.solent.devops.model.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;


public class PrintOutJson {

    public static String getJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();

        AnnotationIntrospector introSpector = new JaxbAnnotationIntrospector(mapper.getTypeFactory());
        mapper.setAnnotationIntrospector(introSpector);
        mapper.enable(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME);

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));

        String result;
        try {
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("problem converting object to json ", ex);
        }
        return result;
    }
}
