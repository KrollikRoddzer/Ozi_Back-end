package by.fpmibsu.ozi.entity;

import java.util.Date;

public class Post
{
    private Integer id;

    private User user;

    private String text;

    private Date date;

    public Post()
    {

    }

    public Post(Integer id, User user, String text, Date date)
    {
        this.id = id;
        this.user = user;
        this.text = text;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }
}
