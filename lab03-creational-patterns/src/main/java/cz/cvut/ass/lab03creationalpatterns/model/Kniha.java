package cz.cvut.ass.lab03creationalpatterns.model;

import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Kniha extends Thing{

    public Kniha() {
    }

    public Kniha(String id, String name, List<Person> persons) {
        super(id, name, persons);
    }
    
}
