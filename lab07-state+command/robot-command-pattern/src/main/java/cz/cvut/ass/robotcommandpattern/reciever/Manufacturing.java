package cz.cvut.ass.robotcommandpattern.reciever;

/**
 * Represents a reciever.
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class Manufacturing {

    private boolean on;

    public void switchOn() {
        on = true;
    }

    public void switchOff() {
        on = false;
    }
}
