package cz.cvut.ass.twitterobserver;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Twitter extends Observable {
    
    private Set<Observer> users = new HashSet<Observer>();
    
    public void tweet(Tweet t){
        for (Observer o : users) {
            if (!o.equals(t.getUser())) {
                o.update(this, t);
            }
        }
        System.out.println(t);
    }

    @Override
    public synchronized void addObserver(Observer o) {
        users.add(o);
    }
    
    

}
