package ru.diasoft.kafka;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.diasoft.domain.GreetingMessage;

@MessagingGateway
public interface GreetingGateway {

    @Gateway(requestChannel = ProducerChannels.DIRECT)
    void directGreet(GreetingMessage msg);

    @Gateway(requestChannel = ProducerChannels.BROADCAST)
    void broadcastGreet(String msg);

}
