package cz.cvut.ass.lab03creationalpatterns.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Person {

    private String id;
    private String name;
    private List<Thing> things;

    public Person() {
    }

    public Person(String id, String name, List<Thing> things) {
        this.id = id;
        this.name = name;
        this.things = things;
    }

    public void addThing(Thing t) {
        if (things == null) {
            things = new ArrayList<Thing>();
            things.add(t);
        } else {
            things.add(t);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", things=" + things + '}';
    }
    
}
