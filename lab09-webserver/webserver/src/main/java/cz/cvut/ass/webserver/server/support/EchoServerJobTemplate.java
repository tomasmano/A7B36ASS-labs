package cz.cvut.ass.webserver.server.support;

import cz.cvut.ass.webserver.server.io.EchoRequestReader;
import cz.cvut.ass.webserver.server.io.EchoResponseOutputStream;
import cz.cvut.ass.webserver.server.io.RequestReader;
import cz.cvut.ass.webserver.server.msgs.EchoRequest;
import cz.cvut.ass.webserver.server.msgs.EchoResponse;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents server job template. Example of Template Pattern.
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class EchoServerJobTemplate extends ServerJobTemplate {
    
    public static final Logger LOG = LoggerFactory.getLogger(EchoServerJobTemplate.class);
    
    private String validArg = "ahoj";

    public EchoServerJobTemplate(InputStream input, OutputStream output) {
        super(new EchoRequestReader(input), output);
    }
    
    public Request parse(RequestReader parser) {
        EchoRequest req = null;
        try {
            String payload = parser.read();
            req = new EchoRequest(payload);
        } catch (Exception e) {
            LOG.error("An error occured during serving: {}", e);
        }
        return req;
    }

    public void preProcess(Request req) {
        if (!req.getPayload().equals(validArg)) {
            throw new IllegalArgumentException(String.format("[%s] is not valid arg [%s]", req.getPayload(), validArg));
        }
    }

    public Response serve(Request req){
        LOG.debug("Serving request {}..", req);
        EchoResponse res = null;
        try {
            res = new EchoResponse(getRandomResponse());
            send(res);
        } catch (Exception ex) {
            LOG.error("An error occured during serving: {}", ex);
        }
        return res;
    }

    public void postProcess(Response res) {

    }
    
    private static String getRandomResponse(){
        String[] responds = new String[]{"cau", "hello", "hola"};
        Random r = new Random();
        return responds[r.nextInt(3)] + "\n";
    }

    public void send(Response res) {
        LOG.debug("Sending response [{}].. ", res);
        EchoResponseOutputStream writer = null;
        try {
            writer = new EchoResponseOutputStream(new BufferedOutputStream(getWriter()));
            writer.write((EchoResponse) res);
            writer.close();
        } catch (Exception ex) {
            LOG.error("An error occured while sending response: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
}
