package sk.fri.uniza.microservice.login_screen;

import io.dropwizard.views.View;

/**
 * Reprezentuje webovu stranku na prihlasovanie pouzivatelov. Nacitava zo suboru
 * login.ftl HTML sablonu webovej stranky.
 *
 * @author Matus Humaj, Jozef Magdolen, Tomas Urban
 */
public class LoginView extends View {

    /**
     * Bezparametricky konstruktor. Nastavi, aby sa zo suboru login.ftl
     * nacitala sablona webovej stranky na prihlasovanie pouzivatelov.
     */
    public LoginView() {
        super("login.ftl");
    }

}
