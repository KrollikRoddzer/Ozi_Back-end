package by.fpmibsu.ozi.dbtest;

import by.fpmibsu.ozi.db.ConnectionCreator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class MessagePageServiceTest
{
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

            ArrayList<Integer> mustBe = new ArrayList<>(Arrays.asList(5, 4, 6, 8, 4));

            Assert.assertEquals(list.toArray(), mustBe.toArray());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @After
    public void tearDown() {
        new DataDestructor();
    }
}
