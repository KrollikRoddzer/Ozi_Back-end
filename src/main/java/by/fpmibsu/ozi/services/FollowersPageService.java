package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.FriendRequestDao;
import by.fpmibsu.ozi.entity.User;

import java.util.List;

public class FollowersPageService
{
    FriendRequestDao friendRequestDao;

    public FollowersPageService(FriendRequestDao friendRequestDao)
    {
        this.friendRequestDao = friendRequestDao;
    }

    public List<User> getFollowers(Integer userId) throws DaoException
    {
        return friendRequestDao.findAllByReceiverId(userId).getRequests();
    }
}
