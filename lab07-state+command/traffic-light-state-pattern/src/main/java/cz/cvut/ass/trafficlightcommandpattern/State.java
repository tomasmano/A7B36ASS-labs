package cz.cvut.ass.trafficlightcommandpattern;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public interface State {
    boolean isOpen();
    void tick();
}
