package cz.cvut.ass.webserver.server.io;

import cz.cvut.ass.webserver.server.msgs.EchoResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class EchoResponseOutputStream extends OutputStream {

    private OutputStream os;

    public EchoResponseOutputStream(OutputStream os) {
        this.os = os;
    }

    @Override
    public void write(int b) throws IOException {
        os.write(b);
    }

    public void write(EchoResponse res) throws IOException {
        os.write(res.getPayload());
        os.close();
    }
}