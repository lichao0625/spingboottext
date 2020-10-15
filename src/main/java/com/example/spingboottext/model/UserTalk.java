package com.example.spingboottext.model;

public class UserTalk {
    long id;
    long talkID;
    long userID;
    String username;
    String userPortrait;
    String createTime;
    String text;
    long tUserID;
    long storyID;
    String storyName;

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public long getStoryID() {
        return storyID;
    }

    public void setStoryID(long storyID) {
        this.storyID = storyID;
    }

    public long gettUserID() {
        return tUserID;
    }

    public void settUserID(long tUserID) {
        this.tUserID = tUserID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTalkID() {
        return talkID;
    }

    public void setTalkID(long talkID) {
        this.talkID = talkID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
