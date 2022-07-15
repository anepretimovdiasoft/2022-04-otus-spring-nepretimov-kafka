package ru.diasoft.kafka;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import ru.diasoft.domain.GreetingMessage;

@Configuration
public class MessageListener {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @StreamListener(ConsumerChannels.DIRECTED)
    public void directed(GreetingMessage message) {
        logger.info("Directed: " + message);
    }

    @StreamListener(ConsumerChannels.BROADCASTS)
    public void broadcasted(String message) {
        logger.info("Directed: " + message);
    }

}