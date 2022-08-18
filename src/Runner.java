import consumer.Consumer;
import consumer.impl.RequestConsumer;
import consumer.impl.ResponseConsumer;
import producer.Producer;
import producer.impl.ResponseProducerImpl;

import java.nio.charset.StandardCharsets;

public class Runner {

    public static void main(String[] argv) throws Exception {

        String reqMsg = "create report req";
        String resMsg = "report created successfully";

        Consumer requestConsumer = new RequestConsumer();
        Consumer responseConsumer = new ResponseConsumer();

        Producer requestProducer = new ResponseProducerImpl();
        Producer responseProducer = new ResponseProducerImpl();

        //read request msg
        requestProducer.publishMessage(reqMsg.getBytes(StandardCharsets.UTF_8));
        requestConsumer.readMessage();

        //read response msg
        responseProducer.publishMessage(resMsg.getBytes(StandardCharsets.UTF_8));
        responseConsumer.readMessage();
    }
}
