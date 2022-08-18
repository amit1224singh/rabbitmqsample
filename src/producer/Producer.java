package producer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface Producer {
    String publishMessage(byte[] message) throws IOException, TimeoutException;
}
