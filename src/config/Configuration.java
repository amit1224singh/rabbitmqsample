package config;

import com.rabbitmq.client.ConnectionFactory;
import util.Constants;

public class Configuration {

    /**
     * returns MQ connection factory object
     *
     * @return
     */
    public static ConnectionFactory getConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.MQ_HOST_NAME);

        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        return factory;
    }
}
