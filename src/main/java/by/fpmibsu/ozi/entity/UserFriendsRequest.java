package by.fpmibsu.ozi.entity;

import java.util.Collection;

public class UserFriendsRequest
{
    private Integer userId;

    private Collection<Integer> requestsId;

    public UserFriendsRequest()
    {

    }

    public UserFriendsRequest(Integer userId, Collection<Integer> requestsId)
    {
        this.userId = userId;
        this.requestsId = requestsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Collection<Integer> getRequestsId() {
        return requestsId;
    }
}
