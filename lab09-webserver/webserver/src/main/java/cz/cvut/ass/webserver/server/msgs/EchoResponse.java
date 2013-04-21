package cz.cvut.ass.webserver.server.msgs;

import cz.cvut.ass.webserver.server.support.Response;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class EchoResponse implements Response{

    private String payload;

    public EchoResponse(String payload) {
        this.payload = payload;
    }

    public byte[] getPayload() {
        return payload.getBytes();
    }
}
