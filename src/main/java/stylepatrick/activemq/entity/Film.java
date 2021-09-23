package stylepatrick.activemq.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Film implements Serializable {

    public String name;
    public Integer releaseYear;
}
