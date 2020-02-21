package kd.develop.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import javax.xml.bind.Marshaller;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {


    @Bean
    public Jaxb2Marshaller createMarshaller(@Value("${context.path}") final String context,
                                            @Value("${schema.location}") final Resource schemaResource){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(context);
        marshaller.setSchema(schemaResource);
        Map<String, Object> properties = new HashMap<>();
        properties.put(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setMarshallerProperties(properties);
        return marshaller;
    }

 }
