package sk.fri.uniza.microservice.login_screen;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sk.fri.uniza.microservice.sensor.SensorView;

/**
 * Reprezentuje cestu k webovej stranke na prihlasovania uzivatelov.
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
@Path("/login")
@Produces(MediaType.TEXT_HTML)
public class LoginResource {

    /**
     * Vytvori instanciu LoginView, ktora reprezentuje webovu stranku na
     * prihlasovanie pouzivatelov.
     *
     * @return Vracia vytvorenu instanciu triedy LoginView.
     */
    @GET
    public LoginView getLogin() {
        return new LoginView();
    }

    /**
     * Posiela meno a heslo.
     *
     * @param name
     * @param pass
     * @return SensorView(1)
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public SensorView putSensor(@FormParam("fname") String name, @FormParam("pass") String pass) {

        if (equals(name, pass)) {
            return new SensorView();
        }
        return new SensorView(1);
    }

    /**
     * Overuje prihlasenie do systemu.
     *
     * @param a
     * @param b
     * @return true or false
     */
    public boolean equals(String a, String b) {
        if ((("tomas".equals(a)) && ("12345".equals(b)))
                || (("jozef".equals(a)) && ("98765".equals(b)))
                || (("matus".equals(a)) && ("11111".equals(b)))) {
            return true;
        } else {
            return false;
        }
    }
}
