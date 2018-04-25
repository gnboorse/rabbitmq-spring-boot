package co.boorse.rabbitlearning;

import co.boorse.rabbitlearning.component.Receiver;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitlearningApplication
{

    public static final String fanoutExchangeName = "spring-boot-exchange-fanout";
    public static final String directExchangeName = "spring-boot-exchange-direct";
    public static final String directExchangeRoutingKey1 = "key1";
    public static final String directExchangeRoutingKey2 = "key2";
    public static final String directExchangeRoutingKey4 = "key4";
    public static final String queueName1 = "spring-queue1";
    public static final String queueName2 = "spring-queue2";
    public static final String queueName3 = "spring-queue3";

    @Bean
    Queue queue1()
    {
        return new Queue(queueName1, false);
    }
    @Bean
    Queue queue2()
    {
        return new Queue(queueName2, false);
    }

    @Bean
    Queue queue3()
    {
        return new Queue(queueName3, false);
    }

    @Bean
    Queue queue4()
    {
        return new Queue("nothing should send here", false);
    }


    @Bean
    FanoutExchange exchange1()
    {
        return new FanoutExchange(fanoutExchangeName);
    }

    @Bean
    DirectExchange exchange2()
    {
        return new DirectExchange(directExchangeName);
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
        return BindingBuilder.bind(queue1).to(exchange2).with(directExchangeRoutingKey1);
    }

    @Bean
    Binding binding5(Queue queue2, DirectExchange exchange2)
    {
        return BindingBuilder.bind(queue2).to(exchange2).with(directExchangeRoutingKey2);
    }

    @Bean
    Binding binding6(Queue queue4, DirectExchange exchange2)
    {
        return BindingBuilder.bind(queue4).to(exchange2).with(directExchangeRoutingKey4);
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
