package by.fpmibsu.ozi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dialog implements Serializable, Cloneable
{
    private final List<Message> messages;

    public Dialog()
    {
        messages = new ArrayList<>();
    }

    public Dialog(List<Message> messages)
    {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
