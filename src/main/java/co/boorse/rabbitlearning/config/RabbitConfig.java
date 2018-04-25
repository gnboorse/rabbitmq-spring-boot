package co.boorse.rabbitlearning.config;

import co.boorse.rabbitlearning.RabbitlearningApplication;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig
{

    @Bean
    Queue queue1()
    {
        return new Queue(RabbitlearningApplication.queueName1, false);
    }
    @Bean
    Queue queue2()
    {
        return new Queue(RabbitlearningApplication.queueName2, false);
    }

    @Bean
    Queue queue3()
    {
        return new Queue(RabbitlearningApplication.queueName3, false);
    }

    @Bean
    Queue queue4()
    {
        return new Queue("nothing should send here", false);
    }


    @Bean
    FanoutExchange exchange1()
    {
        return new FanoutExchange(RabbitlearningApplication.fanoutExchangeName);
    }

    @Bean
    DirectExchange exchange2()
    {
        return new DirectExchange(RabbitlearningApplication.directExchangeName);
    }

    @Bean
    Binding binding1(Queue queue1, FanoutExchange exchange1)
    {
        return BindingBuilder.bind(queue1).to(exchange1);

    }

    @Bean
    Binding binding2(Queue queue2, FanoutExchange exchange1)
    {
        return BindingBuilder.bind(queue2).to(exchange1);

    }

    @Bean
    Binding binding3(Queue queue3, FanoutExchange exchange1)
    {
        return BindingBuilder.bind(queue3).to(exchange1);

    }

    @Bean
    Binding binding4(Queue queue1, DirectExchange exchange2)
    {
        return BindingBuilder.bind(queue1).to(exchange2).with(RabbitlearningApplication.directExchangeRoutingKey1);
    }

    @Bean
    Binding binding5(Queue queue2, DirectExchange exchange2)
    {
        return BindingBuilder.bind(queue2).to(exchange2).with(RabbitlearningApplication.directExchangeRoutingKey2);
    }

    @Bean
    Binding binding6(Queue queue4, DirectExchange exchange2)
    {
        return BindingBuilder.bind(queue4).to(exchange2).with(RabbitlearningApplication.directExchangeRoutingKey4);
    }
}
