package co.boorse.rabbitlearning.model;

import java.io.Serializable;

public class Message implements Serializable
{
    private String message;

    private String routingKey;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getRoutingKey()
    {
        return routingKey;
    }

    public void setRoutingKey(String routingKey)
    {
        this.routingKey = routingKey;
    }

    public Message()
    {

    }

    public Message(String message)
    {
        this.message = message;
    }

    public Message(String message, String routingKey)
    {
        this.message = message;
        this.routingKey = routingKey;
    }

}
