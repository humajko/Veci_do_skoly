/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sk.fri.uniza.microservice.sensor.SensorView;

/**
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
@Path("/saying/{id}")
@Produces(MediaType.TEXT_HTML)
public class SayingResource {

    /**
     * Vrati vysledok z databazy Saying, kde id = param. Ak nenajde ziadny
     * zaznam, vrati status NOT_FOUND.
     *
     * @param id
     * @return uniqueResult
     */
    @GET
    public SayingView getSaying(@PathParam("id") String id) {
        Session session = DropwizardApplication.buildSessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();

        Query query = session.createQuery("from Saying where id=" + id);
        Saying uniqueResult = (Saying) query.uniqueResult();

        session.getTransaction().commit();
        session.close();
        if (uniqueResult == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }

        return new SayingView(uniqueResult);
    }
}
