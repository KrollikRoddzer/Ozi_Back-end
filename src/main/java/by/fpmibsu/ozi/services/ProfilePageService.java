package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.entity.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.util.List;

public class ProfilePageService
{
    static Logger logger = LogManager.getLogger(ProfilePageService.class.getName());
    private final UserDao userDao;
    private final FriendDao friendDao;
    private final PostDao postDao;
    private final FriendRequestDao friendRequestDao;

    public ProfilePageService(UserDao userDao, FriendDao friendDao, PostDao postDao, FriendRequestDao friendRequestDao)
    {
        logger.log(Level.INFO, "Created ProfilePageService.");
        this.userDao = userDao;
        this.friendDao = friendDao;
        this.postDao = postDao;
        this.friendRequestDao = friendRequestDao;
    }

    public Integer getFriendsCount(Integer userId) throws DaoException, InterruptedException {
        logger.log(Level.INFO, "Getting friends count of user with id: " + userId + '.');
        UserFriends friends = friendDao.findFriendsByUserId(userId);
        return friends.getFriends().size();
    }

    public Integer getFollowersCount(Integer userId) throws DaoException, InterruptedException {
        logger.log(Level.INFO, "Getting all followers of user with id: " + userId + '.');
        UserFriendsRequest followers = friendRequestDao.findAllByReceiverId(userId);
        return followers.getRequests().size();
    }

    public List<Post> getUserPost(Integer userId) throws DaoException, InterruptedException {
        logger.log(Level.INFO, "Getting all posts of user with id: " + userId + '.');
        return postDao.findAllByUserId(userId);
    }

    public User getUserInfo(Integer userId) throws DaoException, InterruptedException {
        logger.log(Level.INFO, "Getting user information with id: " + userId + '.');
        return userDao.findById(userId);
    }

    public Status getStatus(Integer userId, Integer unknownId) throws DaoException, InterruptedException {
        logger.log(Level.INFO, "Getting guest status of page.");
        if (unknownId == null)
        {
            logger.log(Level.ERROR, "Page user id is null!");
            return Status.ERROR;
        }
        if (userId == null)
        {
            logger.log(Level.INFO, "Guest is not registered.");
            return Status.NOT_REGISTERED;
        }
        if (userId.equals(unknownId))
        {
            logger.log(Level.INFO, "Guest has got to his own page.");
            return Status.ME;
        }
        List<User> users = friendDao.findFriendsByUserId(unknownId).getFriends();
        for (var user : users)
        {
            if (user.getId().equals(userId)) {
                logger.log(Level.INFO, "Guest is friend of the page owner.");
                return Status.FRIEND;
            }
        }
        users = friendRequestDao.findAllByReceiverId(unknownId).getRequests();
        for (var user : users)
        {
            //System.out.println(user);
            if (user.getId().equals(userId)) {
                logger.log(Level.INFO, "Guest has sent friend request to this user.");
                return Status.REQUEST_SEND;
            }
        }

        users = friendRequestDao.findAllByReceiverId(userId).getRequests();
        for (var user : users)
        {
            //System.out.println(user);
            if (user.getId().equals(unknownId)) {
                logger.log(Level.INFO, "Page owner is follower of the guest.");
                return Status.FOLLOWER;
            }
        }

        logger.log(Level.INFO, "Page owner is no one to guest.");
        return Status.NO_ONE;
    }

    public void editAbout(Integer userId, String about) throws DaoException, InterruptedException {
        logger.log(Level.INFO, "Editing about of user with id: " + userId + '.');
        User user = userDao.findById(userId);
        if (user == null) {
            logger.log(Level.INFO, "User isn't found.");
            return;
        }
        user.setAbout(about);
        userDao.update(user);
        logger.log(Level.INFO, "About of user with id " + user + " is edited.");
    }
}
