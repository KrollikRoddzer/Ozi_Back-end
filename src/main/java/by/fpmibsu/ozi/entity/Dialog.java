package by.fpmibsu.ozi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Dialog implements Serializable, Cloneable
{
    private final Collection<Message> messages;

    public Dialog()
    {
        messages = new ArrayList<>();
    }

    public Dialog(Collection<Message> messages)
    {
        this.messages = messages;
    }

    public Collection<Message> getMessages() {
        return messages;
    }
}
