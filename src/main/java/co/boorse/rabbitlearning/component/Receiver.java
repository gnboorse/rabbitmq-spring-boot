package co.boorse.rabbitlearning.component;

import co.boorse.rabbitlearning.RabbitlearningApplication;
import co.boorse.rabbitlearning.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.concurrent.CountDownLatch;

public class Receiver
{

    @RabbitListener(queues = RabbitlearningApplication.queueName1)
    public void receiveMessage1(Message message)
    {
        System.out.println("Received message on Queue 1: \"" + message.getMessage() + "\"");
    }

    @RabbitListener(queues = RabbitlearningApplication.queueName2)
    public void receiveMessage2(Message message)
    {
        System.out.println("Received message on Queue 2: \"" + message.getMessage() + "\"");
    }

    @RabbitListener(queues = RabbitlearningApplication.queueName3)
    public void receiveMessage3(Message message)
    {
        System.out.println("Received message on Queue 3: \"" + message.getMessage() + "\"");
    }

    @RabbitListener(queues = "nothing should send here")
    public void receiveMessage4(Message message)
    {
        System.out.println("Received message on Queue 4: \"" + message.getMessage() + "\"");
    }

    public Receiver()
    {

    }
}
