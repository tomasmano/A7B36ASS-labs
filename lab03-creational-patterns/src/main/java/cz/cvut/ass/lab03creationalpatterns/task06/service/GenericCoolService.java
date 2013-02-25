package cz.cvut.ass.lab03creationalpatterns.task06.service;

import cz.cvut.ass.lab03creationalpatterns.model.Person;
import cz.cvut.ass.lab03creationalpatterns.model.Thing;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class GenericCoolService<P extends Person, T extends Thing> extends CoolService {

    private Class<P> personClass;
    private Class<T> thingClass;

    public GenericCoolService(Class<P> personClass, Class<T> thingClass) {
        this.personClass = personClass;
        this.thingClass = thingClass;
    }

    @Override
    public P createPerson() {
        try {
            return personClass.newInstance();
        } catch (Exception ex) {
            System.err.println("error occured..." + ex);
        }
        return null;
    }

    @Override
    public T createThing() {
        try {
            return thingClass.newInstance();
        } catch (Exception ex) {
            System.err.println("error occured..."+ex);
        } 
        return null;
    }

}
