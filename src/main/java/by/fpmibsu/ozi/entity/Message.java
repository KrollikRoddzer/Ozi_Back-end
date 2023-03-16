package by.fpmibsu.ozi.entity;

import java.util.Date;
public class Message
{
    private Integer id;

    private User sentUser;

    private User receiveUser;

    private Date messageDate;

    private String text;

    public Message()
    {

    }

    public Message(
            Integer id,
            User sentUser,
            User receiveUser,
            Date messageDate,
            String text
    )
    {
        this.id = id;
        this.sentUser = sentUser;
        this.receiveUser = receiveUser;
        this.messageDate = messageDate;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public User getSentUser() {
        return sentUser;
    }

    public User getReceiveUser() {
        return receiveUser;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public String getText() {
        return text;
    }
}
