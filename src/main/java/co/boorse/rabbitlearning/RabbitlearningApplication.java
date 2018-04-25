package co.boorse.rabbitlearning;

import co.boorse.rabbitlearning.component.Receiver;

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
    Receiver receiver()
    {
        return new Receiver();
    }

    public static void main(String[] args)
    {
        SpringApplication.run(RabbitlearningApplication.class, args);
    }
}
