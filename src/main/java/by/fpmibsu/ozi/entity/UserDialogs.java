package by.fpmibsu.ozi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class UserDialogs implements Serializable, Cloneable
{
    private final Collection<Dialog> dialogs;

    public UserDialogs()
    {
        dialogs = new ArrayList<>();
    }

    public UserDialogs(Collection<Dialog> dialogs)
    {
        this.dialogs = dialogs;
    }

    public Collection<Dialog> getDialogs() {
        return dialogs;
    }
}
