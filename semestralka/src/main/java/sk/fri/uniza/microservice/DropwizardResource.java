/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import com.codahale.metrics.annotation.Timed;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Umoznuje posielat data zo senzora do databazy.
 * 
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class DropwizardResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public DropwizardResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    /**
 * Vrati vsetky hodnoty z databazy.
 * 
 * @param name
 * @return list
 */
    @GET
    @Timed
    public List<Saying> sayHello(@QueryParam("name") Optional<String> name) {

        Session session = DropwizardApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Saying");
        List<Saying> list = query.list();

        session.getTransaction().commit();
        session.close();
        
        return list;
    }

    
    /**
     * Vrati vysledok z databazy Saying, kde id = param. Ak nenajde ziadny
     * zaznam, vrati status NOT_FOUND.
     *
     * @param id
     * @return uniqueResult
     */
    @GET
    @Path("/{id}")
    @Timed
    public Saying sayHello(@PathParam("id") String id) {

        Session session = DropwizardApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Saying where id=" + id);
        Saying uniqueResult = (Saying) query.uniqueResult();
        

        session.getTransaction().commit();
        session.close();
        if (uniqueResult == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
         }

        return uniqueResult;
    }

/**
 * Prida zaznam do databazy.
 * 
 * @param input
 * @return input
 */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Saying sayHello(Saying input) {

        Session session = DropwizardApplication.buildSessionFactory.openSession();
        session.beginTransaction();
        session.save(input);
        session.getTransaction().commit();
        session.close();

        return input;
    }
}
