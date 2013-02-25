package cz.cvut.ass.lab03creationalpatterns.model;

import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Student extends Person{

    public Student() {
    }

    public Student(String id, String name, List<Thing> things) {
        super(id, name, things);
    }
    
    
}
