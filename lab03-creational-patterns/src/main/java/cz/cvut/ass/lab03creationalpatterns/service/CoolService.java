package cz.cvut.ass.lab03creationalpatterns.service;

import cz.cvut.ass.lab03creationalpatterns.model.Person;
import cz.cvut.ass.lab03creationalpatterns.model.Thing;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public abstract class CoolService {
    
    public abstract Person createPerson(String id, String name, List<Thing> things);
    
    public abstract Thing createThing(String id, String name, List<Person> persons);

    public abstract void wireUp(Person person, Thing thing);
}
