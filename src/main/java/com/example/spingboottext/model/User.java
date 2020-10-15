package com.example.spingboottext.model;

import java.util.List;

public class User {
    Long id;
    String name;
    String pwd;
    String portrait;
    String nikeName;
    String phone;
    String email;
    String signature;
    Double price;
    int stroysNum;//故事数量
    int branchNum;//分支数量
    boolean isFollowd;
    long follow;
    long follower;
    List<UserFollower> followerList;
    List<UserFollower> followList;

    public boolean isFollowd() {
        return isFollowd;
    }

    public void setFollowd(boolean followd) {
        isFollowd = followd;
    }

    public List<UserFollower> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(List<UserFollower> followerList) {
        this.followerList = followerList;
    }

    public List<UserFollower> getFollowList() {
        return followList;
    }

    public void setFollowList(List<UserFollower> followList) {
        this.followList = followList;
    }

    public long getFollow() {
        return follow;
    }

    public void setFollow(long follow) {
        this.follow = follow;
    }

    public long getFollower() {
        return follower;
    }

    public void setFollower(long follower) {
        this.follower = follower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStroysNum() {
        return stroysNum;
    }

    public void setStroysNum(int stroysNum) {
        this.stroysNum = stroysNum;
    }

    public int getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(int branchNum) {
        this.branchNum = branchNum;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }
}
