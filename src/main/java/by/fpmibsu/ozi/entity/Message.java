package by.fpmibsu.ozi.entity;

import java.util.Date;
public class Message
{
    private Integer id;

    private Integer sentId;

    private Integer receiveId;

    private Date messageDate;

    private String text;

    public Message()
    {

    }

    public Message(
            Integer id,
            Integer sentId,
            Integer receiveId,
            Date messageDate,
            String text
    )
    {
        this.id = id;
        this.sentId = sentId;
        this.receiveId = receiveId;
        this.messageDate = messageDate;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSentId() {
        return sentId;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public String getText() {
        return text;
    }
}
