package sk.fri.uniza.microservice.sensor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sk.fri.uniza.microservice.DropwizardApplication;
import sk.fri.uniza.microservice.Saying;

/**
 * Reprezentuje cestu k webovej stranke na senzor.
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
@Path("/sensor")
@Produces(MediaType.TEXT_HTML)
public class SensorResource {

    /**
     * Metoda, ktora vrati vsetky hodnoty z databazy senzora.
     *
     * @return SensorView(list) - vsetky hodnoty
     */
    @GET
    public SensorView getALL() {

        Session session = DropwizardApplication.getBuildSessionFactory().openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Saying");
        List<Saying> list = query.list();

        session.getTransaction().commit();
        session.close();
        return new SensorView(list);
    }

    /**
     * Metoda, ktora vlozi hodnotu - hodnota - do databazy senzora.
     *
     * @param hodnota
     * @return SensorView() - vracia prazdny zoznam
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public SensorView putSensor(@FormParam("newContent") String hodnota) {

        Session session = DropwizardApplication.getBuildSessionFactory().openSession();
        session.beginTransaction();

        Saying input = new Saying();
        input.setContent(hodnota);

        session.save(input);
        session.getTransaction().commit();
        session.close();

        return new SensorView();
    }

    /**
     * Metoda, ktora vrati jednu hodnotu zo senzora podla jeho id, teda pozicii. 
     * v databaze. Odkazuje sa na cestu vebovej stranky senzor/{id}.
     *
     * @param id
     * @return SensorView(list) - vysledok ulozeny do listu
     */
    @GET
    @Path("/{id}")
    public SensorView getSensorById(@PathParam("id") String id) {
        Session session = DropwizardApplication.getBuildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Saying where id=" + id);
        List<Saying> list = query.list();

        session.getTransaction().commit();
        session.close();

        return new SensorView(list);
    }

    /**
     * Metoda, ktora vymaze hodnotu z databazy senzora podla konkretneho id.
     * Odkazyje sa na novu cestu vebovej stranky senzor/delete/{id}.
     *
     * @param id
     * @return SensorView() - vracia prazdny zoznam
     */
    @GET
    @Path("/delete/{id}")
    public SensorView deleteSensorById(@PathParam("id") String id) {

        Session session = DropwizardApplication.getBuildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("delete from Saying where id=" + id);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();

        return new SensorView();
    }
}
