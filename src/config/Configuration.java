package config;

import com.rabbitmq.client.ConnectionFactory;
import util.Constants;

public class Configuration {

    public static ConnectionFactory getConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.MQ_HOST_NAME);
        return factory;
    }
}
