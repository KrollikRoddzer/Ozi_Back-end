package by.fpmibsu.ozi.entity;

import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class User implements Serializable, Cloneable
{
    private Integer id;

    private String phone;

    private String email;

    private String password;

    private String name;

    private String surname;

    private Date birthday;

    private String sex;

    private String country;

    private String city;

    private String about;

    private Image image;

    public User()
    {

    }

    public User(
            Integer id,
            String phone,
            String email,
            String password,
            String name,
            String surname,
            Date birthday,
            String sex
            ) throws NoSuchAlgorithmException {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.password = User.makeHash(password);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.sex = sex;
        this.country = "";
        this.city = "";
        this.about = "";
        this.image = null;
    }

    public Integer getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException{
        this.password = User.makeHash(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public static @NotNull String makeHash(String password) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return new String(Hex.encode(hash));
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
