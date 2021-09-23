package stylepatrick.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import stylepatrick.activemq.entity.Car;
import stylepatrick.activemq.entity.Film;
import stylepatrick.activemq.entity.Response;

import java.util.Date;

@Component
public class ReceiveListener {

    @JmsListener(destination = "car-topic")
    @SendTo("response-car-topic")
    public Response onCarReceived(Car car) {
        System.out.println(new Date(System.currentTimeMillis()) + ": " + car.name + ' ' + car.brand);
        return new Response("received", car.name);
    }

    @JmsListener(destination = "film-topic")
    @SendTo("response-film-topic")
    public Response onFilmReceived(Film film) {
        System.out.println(new Date(System.currentTimeMillis()) + ": " + film.name + ' ' + film.releaseYear);
        return new Response("received", film.name);
    }
}
