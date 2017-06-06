package sk.fri.uniza.microservice;

import com.codahale.metrics.health.HealthCheck;

/**
 * Kontroluje funkcnost aplikacie prostrednictvom kontroly sablony.
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
public class TemplateHealthCheck extends HealthCheck {

    /* Sablona, ktorej format sa kontroluje. */
    private final String template;

    /**
     * Parametricky konstruktor s paramterom sablony.
     *
     * @param template Sablona
     */
    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    /**
     * Kontroluje ci sablona je spravneho formatu string a ci sablona skutocne
     * vracia pozadovany vystup.
     *
     * @return healthy Result bez pridavnej spravy alebo unhealthy Result s
     * pridavnou spravou
     * @throws Exception
     */
    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
