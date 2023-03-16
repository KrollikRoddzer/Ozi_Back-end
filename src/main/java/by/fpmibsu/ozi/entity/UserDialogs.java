package by.fpmibsu.ozi.entity;

import java.util.ArrayList;
import java.util.Collection;

public class UserDialogs
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
