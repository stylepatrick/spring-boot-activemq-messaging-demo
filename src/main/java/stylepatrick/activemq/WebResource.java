package stylepatrick.activemq;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import stylepatrick.activemq.entity.Car;
import stylepatrick.activemq.entity.Film;

@RestController
@AllArgsConstructor
@RequestMapping("api/message")
public class WebResource {

    private final JmsTemplate jmsTemplate;

    @GetMapping("car/{name}/{brand}")
    public ResponseEntity<Object> messageCar(
            @PathVariable("name") String name,
            @PathVariable("brand") String brand
    ) {
        jmsTemplate.convertAndSend("car-topic", new Car(name, brand));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("film/{name}/{year}")
    public ResponseEntity<Object> messageFilm(
            @PathVariable("name") String name,
            @PathVariable("year") Integer year
    ) {
        jmsTemplate.convertAndSend("film-topic", new Film(name, year));
        return ResponseEntity.noContent().build();
    }


}
