package cz.cvut.ass.lab03creationalpatterns.model;

import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Teacher extends Person{

    public Teacher() {
    }

    public Teacher(String id, String name, List<Thing> things) {
        super(id, name, things);
    }
    
}
