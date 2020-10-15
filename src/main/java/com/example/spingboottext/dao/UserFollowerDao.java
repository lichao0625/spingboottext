package com.example.spingboottext.dao;

import com.example.spingboottext.model.UserFollower;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserFollowerDao {
    int insert(UserFollower userFollower);
    List<UserFollower> byIdGetFollowers(@Param("userId") long userId);
    List<UserFollower> byIdGetUsers(@Param("followerId") long followerId);
    Integer byIdGetUserNum(@Param("followerId") long followerId);
    Integer byIdGetFollowerNum(@Param("userId") long userId);
    Integer deleteUser(@Param("id") long id);
    UserFollower getUserFollower(@Param("userId") long userId,@Param("followerId") long followerId);
}
