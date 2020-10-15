package com.example.spingboottext.service.userFollower;

import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.UserFollower;

public interface UserFollowerService {
    Result addUserFollower(UserFollower userFollower);
    Result findFollower(int pageNum, int pageSize,long userId);
    Result findUser(int pageNum, int pageSize, long followerId);
    Result deleteUser(long id);
}
