package by.fpmibsu.ozi.services;

import by.fpmibsu.ozi.dao.*;
import by.fpmibsu.ozi.entity.Message;
import by.fpmibsu.ozi.entity.User;

import java.sql.Date;
import java.util.List;

public class MessageService
{
    private final UserDao userDao;

    private final MessageDao messageDao;

    private final FriendDao friendDao;

    public MessageService(UserDao userDao, MessageDao messageDao, FriendDao friendDao)
    {
        this.userDao = userDao;
        this.friendDao = friendDao;
        this.messageDao = messageDao;
    }

    public List<User> getFriends(Integer userId) throws DaoException
    {
        return friendDao.findFriendsByUserId(userId).getFriends();
    }

    public List<Message> getMessages(Integer userId, Integer messagePersonId) throws DaoException
    {
        return messageDao.findBySenderAndReceiverId(userDao.findById(userId), userDao.findById(messagePersonId));
    }

    public void sendMessage(Integer userId, Integer messagePersonId, String text, Date messageDate) throws DaoException
    {
        messageDao.create(new Message(0, userDao.findById(userId), userDao.findById(messagePersonId), messageDate, text));
    }
}
