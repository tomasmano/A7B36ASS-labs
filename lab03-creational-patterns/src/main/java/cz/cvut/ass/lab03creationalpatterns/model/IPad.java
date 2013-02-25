package cz.cvut.ass.lab03creationalpatterns.model;

import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class IPad extends Thing{

    public IPad() {
    }

    public IPad(String id, String name, List<Person> persons) {
        super(id, name, persons);
    }
    
}
