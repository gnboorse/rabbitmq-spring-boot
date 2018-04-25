package co.boorse.rabbitlearning.controller;

import co.boorse.rabbitlearning.RabbitlearningApplication;
import co.boorse.rabbitlearning.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController
{
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping("/message")
    public ResponseEntity<Message> sendMessage(@RequestBody Message msg)
    {
        if (msg != null)
        {
//            System.out.println(msg.getMessage());
            rabbitTemplate.convertAndSend(RabbitlearningApplication.topicExchangeName, "myTopic", msg);

            return ResponseEntity.ok(new Message("Success"));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
