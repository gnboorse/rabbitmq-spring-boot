package co.boorse.rabbitlearning.controller;

import co.boorse.rabbitlearning.RabbitlearningApplication;
import co.boorse.rabbitlearning.model.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController
{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/broadcast")
    public ResponseEntity<Message> broadcastMessage(@RequestBody Message msg)
    {
        if (msg != null)
        {
            rabbitTemplate.convertAndSend(RabbitlearningApplication.fanoutExchangeName, "", msg.getMessage());
            return ResponseEntity.ok(new Message("Success"));

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

    }


    @PostMapping("/message")
    public ResponseEntity<Message> sendMessage(@RequestBody Message msg)
    {
        if (msg != null)
        {
            if (msg.getRoutingKey() != null
                    && !msg.getRoutingKey().equals("")
                    && (msg.getRoutingKey().equals(RabbitlearningApplication.directExchangeRoutingKey1)
                    || msg.getRoutingKey().equals(RabbitlearningApplication.directExchangeRoutingKey2)
                    || msg.getRoutingKey().equals(RabbitlearningApplication.directExchangeRoutingKey4)))
            {
                rabbitTemplate.convertAndSend(RabbitlearningApplication.directExchangeName, msg.getRoutingKey(), msg);
                return ResponseEntity.ok(new Message("Success"));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message("Invalid Routing Key"));
    }
}
