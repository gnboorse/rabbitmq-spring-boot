package co.boorse.rabbitlearning;

import co.boorse.rabbitlearning.component.Receiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitlearningApplication
{

    public static final String topicExchangeName = "spring-boot-exchange";
    public static final String queueName = "spring-queue";

    @Bean
    Queue queue()
    {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange()
    {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange)
    {
        return BindingBuilder.bind(queue).to(exchange).with("myTopic");
    }

    @Bean
    Receiver receiver()
    {
        return new Receiver();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(RabbitlearningApplication.class, args);
    }
}
