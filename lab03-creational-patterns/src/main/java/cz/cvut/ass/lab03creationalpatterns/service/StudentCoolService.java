package cz.cvut.ass.lab03creationalpatterns.service;

import cz.cvut.ass.lab03creationalpatterns.model.Person;
import cz.cvut.ass.lab03creationalpatterns.model.Thing;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class StudentCoolService extends CoolService {

    protected static StudentCoolService INSTANCE = new StudentCoolService();

    private StudentCoolService() {
        // prevent instiation
    }

    @Override
    public Person createPerson(String id, String name, List<Thing> things) {
        return new Person(id, name, things);
    }

    @Override
    public Thing createThing(String id, String name, List<Person> persons) {
        return new Thing(id, name, persons);
    }

    @Override
    public void wireUp(Person person, Thing thing) {
        person.addThing(thing);
        thing.addPerson(person);
    }
}
