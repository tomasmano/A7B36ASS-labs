package cz.cvut.ass.lab03creationalpatterns.task06.service;

import cz.cvut.ass.lab03creationalpatterns.model.Person;
import cz.cvut.ass.lab03creationalpatterns.model.Thing;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public abstract class CoolService implements WiringService{
    
    public abstract Person createPerson();
    
    public abstract Thing createThing();

    public void wireUp() {
        Person p = createPerson();
        Thing t = createThing();
        p.addThing(t);
        t.addPerson(p);
    }
    
}
