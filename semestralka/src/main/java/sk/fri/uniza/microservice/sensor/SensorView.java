package sk.fri.uniza.microservice.sensor;

import io.dropwizard.views.View;
import java.util.List;
import sk.fri.uniza.microservice.Saying;

/**
 *
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
public class SensorView extends View {

    public Sensor sensor;
    public List<Saying> list;

    /**
     * Metoda, ktora vrati hodnotz senzora a ulozi ich do listu.
     *
     * @return
     */
    public List<Saying> getList() {
        return list;
    }

    /**
     * Bezparametricky konstruktor. Nastavi, aby sa zo suboru sensor.ftl
     * nacitala sablona webovej stranky po uspesnom prihlaseni.
     */
    public SensorView() {
        super("sensor.ftl");
    }

    /**
     * Parametricky konstruktor. Nastavi, aby sa zo suboru sensor_bad.ftl
     * nacitala sablona webovej stranky po neuspesnom prihlaseni.
     *
     * @param id
     */
    public SensorView(int id) {
        super("sensor_bad.ftl");
    }

    /**
     * Parametricky konstruktor. Nastavi, aby sa zo suboru sensor2.ftl nacitala
     * sablona webovej stranky po nacitani udajov z databazy.
     *
     * @param list
     */
    public SensorView(List<Saying> list) {
        super("sensor2.ftl");
        this.list = list;
    }

    /**
     * Metoda vrati senzor.
     *
     * @return sensor
     */
    public Sensor getSsensor() {
        return sensor;
    }

    /**
     * Parametricky konstruktor. Nastavi, aby sa zo suboru sensor.ftl nacitala
     * sablona webovej stranky po uspesnom prihlaseni.
     *
     * @param person
     */
    public SensorView(Sensor person) {
        super("sensor.ftl");
        this.sensor = person;
    }
}
