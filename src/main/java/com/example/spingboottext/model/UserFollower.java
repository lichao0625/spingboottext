package com.example.spingboottext.model;

public class UserFollower {
    long id;
    long userId;
    long followerId;
    String followName;
    String followerName;
    String followPortrait;
    String followerPortrait;

    public String getFollowName() {
        return followName;
    }

    public void setFollowName(String followName) {
        this.followName = followName;
    }

    public String getFollowerName() {
        return followerName;
    }

    public void setFollowerName(String followerName) {
        this.followerName = followerName;
    }

    public String getFollowPortrait() {
        return followPortrait;
    }

    public void setFollowPortrait(String followPortrait) {
        this.followPortrait = followPortrait;
    }

    public String getFollowerPortrait() {
        return followerPortrait;
    }

    public void setFollowerPortrait(String followerPortrait) {
        this.followerPortrait = followerPortrait;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(long followerId) {
        this.followerId = followerId;
    }
}
