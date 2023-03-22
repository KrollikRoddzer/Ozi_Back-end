package by.fpmibsu.ozi.entity;

import java.io.Serializable;
import java.util.Collection;

public class UserFriends implements Serializable, Cloneable
{
    private User user;

    private Collection<User> friends;

    public UserFriends()
    {

    }

    public UserFriends(User user, Collection<User> friends)
    {
        this.user = user;
        this.friends = friends;
    }

    public User getUser() {
        return this.user;
    }

    public Collection<User> getFriendsId() {
        return this.friends;
    }
}
