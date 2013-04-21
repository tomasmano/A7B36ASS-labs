package cz.cvut.ass.webserver.server.core;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public interface Server {

    void init();

    void serve();

    void stop();
}
