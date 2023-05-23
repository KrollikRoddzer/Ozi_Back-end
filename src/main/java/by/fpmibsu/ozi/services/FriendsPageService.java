package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.FriendDao;
import by.fpmibsu.ozi.entity.User;

import java.util.List;

public class FriendsPageService
{
    FriendDao friendDao;

    public FriendsPageService(FriendDao friendDao)
    {
        this.friendDao = friendDao;
    }

    public List<User> getAllFriends(Integer userId) throws DaoException
    {
        return friendDao.findFriendsByUserId(userId).getFriends();
    }
}
