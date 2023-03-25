package by.fpmibsu.ozi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDialogs implements Serializable, Cloneable
{
    private final List<Dialog> dialogs;

    public UserDialogs()
    {
        dialogs = new ArrayList<>();
    }

    public UserDialogs(List<Dialog> dialogs)
    {
        this.dialogs = dialogs;
    }

    public List<Dialog> getDialogs() {
        return dialogs;
    }
}
