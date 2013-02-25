package cz.cvut.ass.lab03creationalpatterns.task05.service;

import cz.cvut.ass.lab03creationalpatterns.model.Kniha;
import cz.cvut.ass.lab03creationalpatterns.model.Person;
import cz.cvut.ass.lab03creationalpatterns.model.Teacher;
import cz.cvut.ass.lab03creationalpatterns.model.Thing;

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
    public Person createPerson() {
        return new Teacher();
    }

    @Override
    public Thing createThing() {
        return new Kniha();
    }

}
