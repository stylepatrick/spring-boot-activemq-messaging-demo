package stylepatrick.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import stylepatrick.activemq.entity.Response;

import java.util.Date;

@Component
public class ResponseListener {

    @JmsListener(destination = "response-car-topic")
    public void onCarResponse(Response response) {
        System.out.println(new Date(System.currentTimeMillis()) + ": " + response.state + ": " + response.name);
    }

    @JmsListener(destination = "response-film-topic")
    public void onFilmResponse(Response response) {
        System.out.println(new Date(System.currentTimeMillis()) + ": " + response.state + ": " + response.name);
    }
}
