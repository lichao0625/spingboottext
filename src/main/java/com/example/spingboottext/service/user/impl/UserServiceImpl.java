package com.example.spingboottext.service.user.impl;

import com.example.spingboottext.dao.UserDao;
import com.example.spingboottext.dao.UserFollowerDao;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.User;
import com.example.spingboottext.model.UserFollower;
import com.example.spingboottext.service.user.UserService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    UserFollowerDao followerDao;
    @Override
    public Result addUser(User user) {
        User oldUser=userDao.byNameGetUser(user.getName());
        if(oldUser!=null){
            return ResultUtil.error(0,"用户已存在");
        }else {
            int a = userDao.insert(user);
            return ResultUtil.success(user);
        }
    }

    @Override
    public Result findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> userDomains = userDao.selectUsers();
        PageInfo result = new PageInfo(userDomains);
        return ResultUtil.success(result.getList());
    }

    @Override
    public Result login(String name, String pwd) {

        User user=userDao.login(name,pwd);
        user.setFollow(followerDao.byIdGetUserNum(user.getId()));
        user.setFollower(followerDao.byIdGetFollowerNum(user.getId()));
        if(user!=null)
            return ResultUtil.success(user);
        else
            return ResultUtil.error(0,"登录失败");
    }

    @Override
    public Result byNameGetUser(String name) {
        User user= userDao.byNameGetUser(name);
        if(user!=null) {
            user.setPwd("");
            return ResultUtil.success(user);
        }
        return ResultUtil.error(0,"未找到该用户");
    }

    @Override
    public Result byIdgetUser(long id,long followId) {
        User user=userDao.byIdGetUser(id);
        if(user!=null){
            Integer followNum=followerDao.byIdGetFollowerNum(user.getId());
            UserFollower userFollower=followerDao.getUserFollower(id,followId);
            if(userFollower==null)
                user.setFollowd(false);
            else
                user.setFollowd(true);
            user.setPwd("");
            if(followNum==null)
                followNum=0;
            user.setFollower(followNum);
            return ResultUtil.success(user);
        }
        return ResultUtil.error(0,"未找到该用户");
    }

    @Override
    public Result byIdgetUser(long id) {
        User user=userDao.byIdGetUser(id);
        if(user!=null){
            Integer followNum=followerDao.byIdGetFollowerNum(user.getId());
            Integer userNum=followerDao.byIdGetUserNum(user.getId());
            if(followNum==null)
                followNum=0;
            if(userNum==null)
                userNum=0;
            user.setFollow(userNum);
            user.setFollower(followNum);
            return ResultUtil.success(user);
        }
        return ResultUtil.error(0,"未找到该用户");
    }

    @Override
    public User updateUserInfo(String nikeName, String signature, String email, String phone,long userId) {
        User user=userDao.byIdGetUser(userId);
        user.setNikeName(nikeName);
        user.setSignature(signature);
        user.setEmail(email);
        user.setPhone(phone);
        userDao.updateUserInfo(nikeName,signature,email,phone,userId);
        return user;
    }

    @Override
    public User updatePortrait(String portrait,long id) {
        User user= userDao.byIdGetUser(id);
        user.setPortrait(portrait);
        userDao.updatePortrait(portrait,id);
        return user;
    }

    @Override
    public User updatePwd(String pwd,long id) {
        User user= userDao.byIdGetUser(id);
        user.setPwd(pwd);
        userDao.updatePwd(pwd,id);
        return user;
    }

}
