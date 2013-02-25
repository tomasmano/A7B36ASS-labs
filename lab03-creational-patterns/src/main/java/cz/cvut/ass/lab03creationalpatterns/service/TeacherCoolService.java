package cz.cvut.ass.lab03creationalpatterns.service;

import cz.cvut.ass.lab03creationalpatterns.model.Kniha;
import cz.cvut.ass.lab03creationalpatterns.model.Person;
import cz.cvut.ass.lab03creationalpatterns.model.Teacher;
import cz.cvut.ass.lab03creationalpatterns.model.Thing;
import java.util.List;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class TeacherCoolService extends CoolService{
    
    protected static TeacherCoolService INSTANCE = new TeacherCoolService();
    
    private TeacherCoolService(){
        // prevent instiation
    }

    @Override
    public Person createPerson(String id, String name, List<Thing> things) {
        return new Teacher(id, name, things);
    }

    @Override
    public Thing createThing(String id, String name, List<Person> persons) {
        return new Kniha(id, name, persons);
    }

    @Override
    public void wireUp(Person person, Thing thing) {
        person.addThing(thing);
        thing.addPerson(person);
    }
}
