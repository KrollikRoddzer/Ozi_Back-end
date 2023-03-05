package by.fpmibsu.ozi.entity;

import java.util.Date;

public class Post
{
    private Integer id;

    private Integer userId;

    private String text;

    private Date date;

    public Post()
    {

    }

    public Post(Integer id, Integer userId, String text, Date date)
    {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.date = date;
    }
}
