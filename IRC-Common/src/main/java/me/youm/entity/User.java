package me.youm.entity;

import java.io.Serializable;
import java.util.Objects;
@SuppressWarnings("all")
public class User implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
    private String userName = "";
    private String passWord= "";
    private String nickName= "";
    private Status status;


    public User() {
    }

    public User(String userName, String passWord, String nickName,Status status) {
        this.userName = userName;
        this.passWord = passWord;
        this.nickName = nickName;
        this.status = status;
    }

    public User(String userName, String passWord, String nickName) {
        this(userName,passWord,nickName,Status.PERSON);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(passWord, user.passWord) && Objects.equals(nickName, user.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, passWord, nickName);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", Stauts='" + status.name()  + '\'' +
                '}';
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public boolean isLogin(){
        if(this.userName.equals("") || this.nickName.equals("") || this.passWord.equals("")) {
            return false;
        }
        return true;
    }
}
