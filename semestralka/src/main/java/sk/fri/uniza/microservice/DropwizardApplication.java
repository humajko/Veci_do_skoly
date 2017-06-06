package sk.fri.uniza.microservice;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import sk.fri.uniza.microservice.login_screen.LoginResource;
import sk.fri.uniza.microservice.sensor.SensorResource;

/**
 * Spustanie serveru, registracia zdrojov, kontrola funkcnosti.
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
public class DropwizardApplication extends Application<DropwizardConfiguration> {

    static SessionFactory buildSessionFactory;

    /**
     *
     * @return
     */
    public static SessionFactory getBuildSessionFactory() {
        return buildSessionFactory;
    }

    /**
     * Metoda main, ktora spusta samotny server.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.configure();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        buildSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        new DropwizardApplication().run(args);
    }
/*
    @Override
    public String getName() {
        return "hello-world";
    }*/
    
    /**
     *
     * @param bootstrap
     */
    @Override
    public void initialize(Bootstrap<DropwizardConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<DropwizardConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(DropwizardConfiguration configuration) {

                return super.getViewConfiguration(configuration); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    /**
     * Vytvara instancie zdrojov a registruje ich do prostredia Jersey.
     * Kontroluje funkcnost sablony pomocou instancie triedy
     * TemplateHealthCheck.
     *
     * @param configuration
     * @param environment
     */
    @Override
    public void run(DropwizardConfiguration configuration,
            Environment environment) {

        final DropwizardResource resource = new DropwizardResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final SayingResource sayingResource = new SayingResource();
        final LoginResource loginResource = new LoginResource();
        final SensorResource sensorResource = new SensorResource();

        final TemplateHealthCheck healthCheck
                = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);

        environment.jersey().register(resource);
        environment.jersey().register(sayingResource);
        environment.jersey().register(loginResource);
        environment.jersey().register(sensorResource);

    }

}
