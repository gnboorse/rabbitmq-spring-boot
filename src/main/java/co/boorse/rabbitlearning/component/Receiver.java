package co.boorse.rabbitlearning.component;

import co.boorse.rabbitlearning.RabbitlearningApplication;
import co.boorse.rabbitlearning.model.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.concurrent.CountDownLatch;

public class Receiver
{
    public CountDownLatch getLatch()
    {
        return latch;
    }

    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = RabbitlearningApplication.queueName)
    public void receiveMessage(Message message)
    {
        System.out.println("Received message: \"" + message.getMessage() + "\"");
        latch.countDown();
    }

    public Receiver()
    {

    }
}
