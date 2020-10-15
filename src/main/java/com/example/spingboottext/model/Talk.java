package com.example.spingboottext.model;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class Talk extends Point {
    String text;
    PageInfo<UserTalk> userTalks;

    public PageInfo getUserTalks() {
        return userTalks;
    }

    public void setUserTalks(PageInfo<UserTalk> userTalks) {
        this.userTalks = userTalks;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
