package stylepatrick.activemq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import stylepatrick.activemq.entity.Car;
import stylepatrick.activemq.entity.Film;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ReceiveListenerConverter {

    @Bean
    MessageConverter filmReturnedEventConverter(
            final ObjectMapper objectMapper
    ) {
        MappingJackson2MessageConverter converter
                = new MappingJackson2MessageConverter();
        converter.setObjectMapper(objectMapper);
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("eventType");
        final Map<String, Class<?>> t
                = new HashMap<>();
        t.put("Car",
                Car.class);
        t.put("Film",
                Film.class);
        converter.setTypeIdMappings(t);
        return converter;
    }
}
