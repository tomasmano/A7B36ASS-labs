package cz.cvut.ass.lab03creationalpatterns.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Thing {

    private String id;
    private String name;
    private List<Person> persons;

    public Thing() {
    }

    public Thing(String id, String name, List<Person> persons) {
        this.id = id;
        this.name = name;
        this.persons = persons;
    }
    
    public void addPerson(Person p){
        if (persons == null) {
            persons = new ArrayList<Person>();
            persons.add(p);
        }
        persons.add(p);
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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Thing{" + "id=" + id + ", name=" + name + ", persons=" + persons + '}';
    }
    
}
