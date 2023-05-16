package springframework.guru.springjms.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import springframework.guru.springjms.config.JMSConfig;
import springframework.guru.springjms.model.HelloWorldMessage;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("I'm sending a message");
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .message("Hello World")
                .id(UUID.randomUUID())
                .build();

        jmsTemplate.convertAndSend(JMSConfig.MY_QUEUE,message);

        System.out.println("Message sent");
    }

}
