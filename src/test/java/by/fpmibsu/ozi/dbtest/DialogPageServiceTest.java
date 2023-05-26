package by.fpmibsu.ozi.dbtest;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.FriendDao;
import by.fpmibsu.ozi.dao.MessageDao;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.db.ConnectionCreator;
import by.fpmibsu.ozi.entity.User;
import by.fpmibsu.ozi.services.DialogPageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class DialogPageServiceTest
{
    private final DialogPageService service = new DialogPageService(new UserDao(), new MessageDao(), new FriendDao());
    private static final String SQL_SELECT_USER = "SELECT count(*) as tmp FROM user;";
    private static final String SQL_SELECT_FRIENDS = "SELECT count(*) as tmp FROM friends;";
    private static final String SQL_SELECT_MESSAGES = "SELECT count(*) as tmp FROM messages;";
    private static final String SQL_SELECT_POSTS = "SELECT count(*) as tmp FROM posts;";
    private static final String SQL_SELECT_FRIEND_REQUEST = "SELECT count(*) as tmp FROM friend_requests;";

    @Before
    public void init() {
        new DataInitializer();
    }

    @Test
    public void initialTest()
    {
        if (!ConnectionCreator.PROPERTIES.getProperty("db.url").equals("jdbc:mysql://127.0.0.1:3306/ozitest")) throw new RuntimeException();

        try
        {
            PreparedStatement user = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_USER);
            PreparedStatement friends = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_FRIENDS);
            PreparedStatement messages = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_MESSAGES);
            PreparedStatement posts = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_POSTS);
            PreparedStatement friend_request = ConnectionCreator.createConnection().prepareStatement(SQL_SELECT_FRIEND_REQUEST);
            Integer userCount = -1, friendsCount = -1, messagesCount = -1, postsCount = -1, friend_requestCount = -1;
            ResultSet tmp = user.executeQuery();
            if (tmp.next()) userCount = tmp.getInt("tmp");
            tmp = friends.executeQuery();
            if (tmp.next()) friendsCount = tmp.getInt("tmp");
            tmp = messages.executeQuery();
            if (tmp.next()) messagesCount = tmp.getInt("tmp");
            tmp = posts.executeQuery();
            if (tmp.next()) postsCount = tmp.getInt("tmp");
            tmp = friend_request.executeQuery();
            if (tmp.next()) friend_requestCount = tmp.getInt("tmp");

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(userCount);
            list.add(friendsCount);
            list.add(messagesCount);
            list.add(postsCount);
            list.add(friend_requestCount);

            ArrayList<Integer> mustBe = new ArrayList<>(Arrays.asList(5, 8, 6, 8, 4));
            Assert.assertEquals(list.toArray(), mustBe.toArray());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getFriendsTest()
    {
        try {
            List<User> users = service.getFriends(1);
            ArrayList<Integer> mustBe = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
            Assert.assertEquals(users.size(), mustBe.size());
            if (users.size() == mustBe.size())
                for (int i = 0; i < mustBe.size(); ++i)
                {
                    Assert.assertEquals(mustBe.get(0), users.get(0).getId());
                }
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void getMessagesTest()
    {
        try
        {
            int ans = 3;
            Assert.assertEquals(ans, service.getMessages(1, 2).size());
            Assert.assertEquals(ans, service.getMessages(2, 1).size());
            ans = 2;
            Assert.assertEquals(ans, service.getMessages(2, 3).size());
            Assert.assertEquals(ans, service.getMessages(3, 2).size());
            ans = 0;
            Assert.assertEquals(ans, service.getMessages(3, 5).size());
            Assert.assertEquals(ans, service.getMessages(6, 8).size());
        }
        catch (DaoException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void sendMessageTest()
    {
        try
        {
            service.sendMessage(1, 2, "Hello michael!", new Date(java.util.Date.parse("2023/01/01")));
            int ans = 4;
            Assert.assertEquals(ans, service.getMessages(1, 2).size());
            Assert.assertEquals(ans, service.getMessages(2, 1).size());
            service.sendMessage(1, 10, "Hi", new Date(java.util.Date.parse("2023/01/01")));
            ans = 0;
            Assert.assertEquals(ans, service.getMessages(1, 10).size());
            Assert.assertEquals(ans, service.getMessages(10, 1).size());
        }
        catch (DaoException e)
        {
            e.printStackTrace();
        }
    }
    @After
    public void tearDown() {
        new DataDestructor();
    }
}
