# RabbitMQ with Spring Boot

Spring Boot offers a really nice integration with RabbitMQ. 

This project creates a simple REST API endpoint at `/message` that you can POST to with JSON like this:

```json
{
    "message":"this is a test"
}
```

And you can see in the application console output that it will print: `Received Message: This is a test` or something of the like.

The `MessageController` handles POST requests to `/message` and forwards the `message` JSON property to RabbitMQ.

The `Receiver` class defines our RabbitMQ listener that waits for messages to appear on the queue. It uses the nice and handy `@RabbitListener` attribute.

The main application `RabbitlearningApplication` defines a `Queue` and `TopicExchange` so that `MessageController` knows where to send messages and `Receiver` knows where to get them.

`Message` is just a POJO. Could be anything really.

Be sure to set the right RabbitMQ url and port in `application.properties`.

