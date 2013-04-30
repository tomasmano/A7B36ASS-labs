package cz.cvut.ass.twitterobserver;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class User implements Observer{
    
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void tweet(String msg){

    }

    public void update(Observable o, Object arg) {
        System.out.println(String.format("%s you have a new msg from %s", name, ((Tweet)arg).getUser().getName()));
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "User{" + "name=" + name + '}';
    }
    
    
}
