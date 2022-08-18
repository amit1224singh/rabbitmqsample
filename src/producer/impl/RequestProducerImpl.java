package producer.impl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import config.Configuration;
import producer.Producer;
import util.Constants;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RequestProducerImpl implements Producer {

    public String publishMessage(byte[] message) throws IOException, TimeoutException {

        ConnectionFactory factory = Configuration.getConnection();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(Constants.INPUT_REQUEST_QUEUE_NAME, false, false, false, null);

            channel.basicPublish("", Constants.INPUT_REQUEST_QUEUE_NAME, null, message);
            System.out.println(" [x] Sent '" + message + "'");

        }
        return "success";
    }

}
