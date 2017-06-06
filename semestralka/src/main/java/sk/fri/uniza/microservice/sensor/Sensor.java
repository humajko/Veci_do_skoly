package sk.fri.uniza.microservice.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;

/**
 * Trieda reprezentujuca senzor
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
public class Sensor {

    @Id
    @GeneratedValue
    private long id;

    /**
     * Vracia ID konkretneho udaju
     *
     * @return id
     */
    @JsonProperty
    public long getId() {
        return id;
    }

    @Length(max = 20)
    private String fname;

    /**
     * Vracia fname
     *
     * @return fname
     */
    @JsonProperty
    public String getFname() {
        return fname;
    }

    /**
     * Bezparametricky konstruktor
     *
     */
    public Sensor() {

    }

    /**
     * Parametricky konstruktor
     *
     * @param fname
     */
    public Sensor(String fname) {
        this.fname = fname;
    }

    /**
     * Parametricky konstruktor
     *
     * @param id
     * @param content
     */
    public Sensor(long id, String content) {
        this.id = id;
        this.fname = content;
    }

}
