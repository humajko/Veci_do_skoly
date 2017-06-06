package sk.fri.uniza.microservice.login_screen;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Length;

/**
 * Trieda reprezentujuca prihlasovacie udaje
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
@Entity
public class Login {

    @Id
    @GeneratedValue
    private long id;

    @Length(max = 20)
    private String content;

    /**
     * Bezparametricky konstruktor
     *
     */
    public Login() {
    }

    /**
     * Parametricky konstruktor
     *
     * @param id
     * @param content
     */
    public Login(long id, String content) {
        this.id = id;
        this.content = content;
    }

    /**
     * Vracia ID konkretneho udaju
     *
     * @return id
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
}
