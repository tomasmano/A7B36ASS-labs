package cz.cvut.ass.trafficlightcommandpattern;

/**
 * Represents a Context.
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class TrafficLight {
    
    private State state;
    private State previous;
    
    private Green green = new Green(this);
    private Orange orange = new Orange(this);
    private Red red = new Red(this);

    public TrafficLight() {
        state = red;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setPrevious(State previous) {
        this.previous = previous;
    }

    public State getPrevious() {
        return previous;
    }
    
    public boolean isOpen(){
        return this.state.isOpen();
    }

    public Green getGreen() {
        return green;
    }

    public Orange getOrange() {
        return orange;
    }

    public Red getRed() {
        return red;
    }
    
    public void tick(){
        state.tick();
    }
}
