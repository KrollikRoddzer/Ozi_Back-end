package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.entity.*;

import java.util.List;

public class ProfilePageService
{
    private final UserDao userDao;
    private final FriendDao friendDao;
    private final PostDao postDao;
    private final FriendRequestDao friendRequestDao;

    ProfilePageService(UserDao userDao, FriendDao friendDao, PostDao postDao, FriendRequestDao friendRequestDao)
    {
        this.userDao = userDao;
        this.friendDao = friendDao;
        this.postDao = postDao;
        this.friendRequestDao = friendRequestDao;
    }

    public Integer getFriendsCount(Integer userId) throws DaoException
    {
        UserFriends friends = friendDao.findFriendsByUserId(userId);
        return friends.getFriends().size();
    }

    public Integer getFollowersCount(Integer userId) throws DaoException
    {
        UserFriendsRequest followers = friendRequestDao.findAllByReceiverId(userId);
        return followers.getRequests().size();
    }

    public List<Post> getUserPost(Integer userId) throws DaoException
    {
        return postDao.findAllByUserId(userId);
    }

    public User getUserInfo(Integer userId) throws DaoException
    {
        return userDao.findById(userId);
    }

    public Status getStatus(Integer userId, Integer unknownId) throws DaoException
    {
        if (unknownId == null) return Status.NOT_REGISTERED;
        if (userId.equals(unknownId)) return Status.ME;
        List<User> users = friendDao.findFriendsByUserId(userId).getFriends();
        for (var user : users)
        {
            if (user.getId().equals(unknownId)) return Status.FRIEND;
        }
        users = friendRequestDao.findAllByReceiverId(userId).getRequests();
        for (var user : users)
        {
            if (user.getId().equals(unknownId)) return Status.FOLLOWER;
        }

        users = friendRequestDao.findAllByReceiverId(unknownId).getRequests();
        for (var user : users)
        {
            if (user.getId().equals(userId)) return Status.REQUEST_SEND;
        }

        return Status.NO_ONE;
    }

    public void editAbout(Integer userId, String about) throws DaoException
    {
        User user = userDao.findById(userId);
        if (user == null) return;
        user.setAbout(about);
        userDao.update(user);
    }
}
