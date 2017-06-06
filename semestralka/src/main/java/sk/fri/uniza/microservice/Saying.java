package sk.fri.uniza.microservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
@Entity
public class Saying {

    @Id
    @GeneratedValue
    private long id;

    @Length(max = 20)
    private String content;

    /**
     * Bezparametricky konstruktor
     */
    public Saying() {
        // Jackson deserialization
    }

    /**
     * Parametricky konstruktor.
     *
     * @param id
     * @param content
     */
    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    /**
     * Vracia ID konkretneho udaju
     *
     * @return ID
     */
    @JsonProperty
    public long getId() {
        return id;
    }

    /**
     * Vracia hodnotu konkretneho udaju
     *
     * @return content
     */
    @JsonProperty
    public String getContent() {
        return content;
    }

    /**
     * Nastavi konkretneho udaju
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Nastavi id konkretneho udaju
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

}
