package cz.cvut.ass.webserver.server.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tomas Mano <tomasmano@gmail.com>
 */
public class EchoRequestReader implements RequestReader {

    public static final Logger LOG = LoggerFactory.getLogger(EchoRequestReader.class);
    static private final int BUFSIZE = 4;
    private InputStream br;

    public EchoRequestReader() {
    }

    public EchoRequestReader(InputStream is) {
        br = new BufferedInputStream(is);
    }

    @Override
    public String read() throws IOException {
        byte[] echoBuffer = new byte[BUFSIZE];
        ByteArrayOutputStream baos = new ByteArrayOutputStream(BUFSIZE);
        br.read(echoBuffer);
        baos.write(echoBuffer, 0, echoBuffer.length);
        LOG.debug("Readed: input: [{}]", new Object[]{Arrays.toString(echoBuffer)});
        return baos.toString();
    }
}
