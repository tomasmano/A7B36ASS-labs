package cz.cvut.ass.webserver.server.support;

import java.io.IOException;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class DefaultServerTask implements ServerTask, Runnable {
    
    public static final Logger LOG = LoggerFactory.getLogger(DefaultServerTask.class);
    
    private Socket client;
    
    private ServerJobTemplate template;

    public DefaultServerTask(Socket client, ServerJobTemplate template) {
        this.client = client;
        this.template = template;
    }

    public void run() {
        process();
    }

    public void process() {
        try {
            Response res = template.processJob();
        } catch (IllegalArgumentException e) {
            try {
                client.close();
            } catch (IOException ex) {
                LOG.error("An error occured during closing socket");
            }
        }
        LOG.debug("Job finished: Request processing succesfully finished");
    }
    
}
