package cz.cvut.ass.webserver;

import cz.cvut.ass.webserver.server.core.EchoServer;
import cz.cvut.ass.webserver.server.core.Server;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class Bootstrap {

    // http://cs.baylor.edu/~donahoo/practical/JavaSockets/code/TCPEchoServerPool.java
    // http://cs.baylor.edu/~donahoo/practical/JavaSockets/code/EchoProtocol.java
    // 3 theady - kazdy odpovi v jinem jazyce (Cau, Hola, Hello)
    // jestli posle neco jineho nez ahoj, klienta zabyje

    public static Properties properties = new Properties();
    public static final String CONFIG_PROPERTIES_LOCATION = "server-config.properties";
    public static final Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        try {
            properties.load(Bootstrap.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES_LOCATION));
        } catch (IOException ex) {
            LOG.error("An error occured during loading properties: {}", ex);
        }
        Server server = new EchoServer();
        server.serve();
    }
}
