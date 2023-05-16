package springframework.guru.springjms.listener;

import jakarta.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import springframework.guru.springjms.config.JMSConfig;
import springframework.guru.springjms.model.HelloWorldMessage;

@Component
public class HelloMessageListener {

    @JmsListener(destination = JMSConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers,
                       Message message){
        System.out.println("I have got a message");

        System.out.println(helloWorldMessage);
    }

}
