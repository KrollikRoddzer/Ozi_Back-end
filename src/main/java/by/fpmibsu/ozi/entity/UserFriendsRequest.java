package by.fpmibsu.ozi.entity;

import java.util.Collection;

public class UserFriendsRequest
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

    public User getUserId() {
        return user;
    }

    public Collection<User> getRequestsId() {
        return requests;
    }
}
