package consumer.impl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import config.Configuration;
import consumer.Consumer;
import util.Constants;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RequestConsumer implements Consumer {

    @Override
    public void readMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = Configuration.getConnection();

        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare(Constants.INPUT_REQUEST_QUEUE_NAME, false, false, false, null);
            System.out.println(" [*] Waiting for messages.");

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume(Constants.INPUT_REQUEST_QUEUE_NAME, true, deliverCallback, consumerTag -> {
            });
        }
    }
}
