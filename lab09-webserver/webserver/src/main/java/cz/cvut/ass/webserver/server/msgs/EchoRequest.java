package cz.cvut.ass.webserver.server.msgs;

import cz.cvut.ass.webserver.server.support.Request;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class EchoRequest implements Request{
    
    private String payload;

    public EchoRequest(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
    
    
}
