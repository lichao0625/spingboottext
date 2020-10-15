package com.example.spingboottext.service.userFollower.impl;

import com.example.spingboottext.dao.UserFollowerDao;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.UserFollower;
import com.example.spingboottext.service.userFollower.UserFollowerService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "UserFollowerService")
public class UserFollowerServiceImpl implements UserFollowerService {
    @Autowired
    UserFollowerDao userFollowerDao;
    @Override
    public Result addUserFollower(UserFollower userFollower) {
        UserFollower oldFollower=userFollowerDao.getUserFollower(userFollower.getUserId(),userFollower.getFollowerId());
        if(oldFollower==null){
            userFollowerDao.insert(userFollower);
        }else {
            userFollowerDao.deleteUser(oldFollower.getId());
        }
        long followNum=userFollowerDao.byIdGetFollowerNum(userFollower.getUserId());
        return ResultUtil.success(followNum);
    }

    @Override
    public Result findFollower(int pageNum, int pageSize, long userId) {
        List<UserFollower> userFollowers=userFollowerDao.byIdGetFollowers(userId);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo result = new PageInfo(userFollowers);
        return ResultUtil.success(result);
    }

    @Override
    public Result findUser(int pageNum, int pageSize, long followerId) {
        List<UserFollower> userFollowers=userFollowerDao.byIdGetUsers(followerId);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo result = new PageInfo(userFollowers);
        return ResultUtil.success(result);
    }

    @Override
    public Result deleteUser(long id) {
        userFollowerDao.deleteUser(id);
        return ResultUtil.success();
    }
}
