package by.fpmibsu.ozi.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class UserFriends implements Serializable, Cloneable
{
    private User user;

    private List<User> friends;

    public UserFriends()
    {

    }

    public UserFriends(User user, List<User> friends)
    {
        this.user = user;
        this.friends = friends;
    }

    public User getUser() {
        return this.user;
    }

    public List<User> getFriendsId() {
        return this.friends;
    }
}
