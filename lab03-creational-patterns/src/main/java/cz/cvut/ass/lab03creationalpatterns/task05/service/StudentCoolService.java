package cz.cvut.ass.lab03creationalpatterns.task05.service;

import cz.cvut.ass.lab03creationalpatterns.model.Person;
import cz.cvut.ass.lab03creationalpatterns.model.Student;
import cz.cvut.ass.lab03creationalpatterns.model.Thing;

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
    public Person createPerson() {
        return new Student();
    }

    @Override
    public Thing createThing() {
        return new Thing();
    }

}
