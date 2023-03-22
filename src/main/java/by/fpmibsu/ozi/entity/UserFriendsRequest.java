package by.fpmibsu.ozi.entity;

import java.io.Serializable;
import java.util.Collection;

public class UserFriendsRequest implements Serializable, Cloneable
{
    private User user;

    private Collection<User> requests;

    public UserFriendsRequest()
    {

    }

    public UserFriendsRequest(User user, Collection<User> requests)
    {
        this.user = user;
        this.requests = requests;
    }

    public User getUser() {
        return user;
    }

    public Collection<User> getRequests() {
        return requests;
    }
}
