package consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface Consumer {
    void readMessage() throws IOException, TimeoutException;
}
