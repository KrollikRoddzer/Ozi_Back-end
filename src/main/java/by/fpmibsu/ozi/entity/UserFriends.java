package by.fpmibsu.ozi.entity;

import java.util.Collection;

public class UserFriends
{
    private Integer userId;

    private Collection<Integer> friendsId;

    public UserFriends()
    {

    }

    public UserFriends(Integer userId, Collection<Integer> friendsId)
    {
        this.userId = userId;
        this.friendsId = friendsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Collection<Integer> getFriendsId() {
        return friendsId;
    }
}
