package cz.cvut.ass.robotcommandpattern.reciever;

/**
 * Represents a reciever.
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Material {

    private State state;

    public void launch() {
        this.state = State.launching;
    }

    public void prepare() {
        this.state = State.preparing;
    }

    private enum State {

        launching, preparing;
    }
}
