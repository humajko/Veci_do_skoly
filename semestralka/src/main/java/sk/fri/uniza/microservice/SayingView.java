/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.microservice;

import io.dropwizard.views.View;

/**
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
public class SayingView extends View {

    private final Saying saying;

    /**
     *
     * @return saying
     */
    public Saying getSaying() {
        return saying;
    }

    /**
     * Parametricky konstruktor s parametrom person. Nastavi, aby sa zo
     * suboru saying.ftl nacitala sablona webovej stranky
     *
     * @param person
     */
    public SayingView(Saying person) {
        super("saying.ftl");
        this.saying = person;
    }
}
