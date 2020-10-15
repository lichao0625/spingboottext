package com.example.spingboottext.controller;

import com.example.spingboottext.model.UserFollower;
import com.example.spingboottext.service.userFollower.UserFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "userFollower")
public class UserFollowerController {

    @Autowired
    UserFollowerService followerService;

    @RequestMapping(value = "addFollow")
    @ResponseBody
    @CrossOrigin
    public Object addUser(long userId,long followId,String followName,String followerName,String followPortrait,String followerPortrait){
        UserFollower userFollower=new UserFollower();
        userFollower.setFollowerId(followId);
        userFollower.setUserId(userId);
        userFollower.setFollowerName(followerName);
        userFollower.setFollowerPortrait(followerPortrait);
        userFollower.setFollowName(followName);
        userFollower.setFollowPortrait(followPortrait);
        return followerService.addUserFollower(userFollower);
    }

    @ResponseBody
    @GetMapping("/getFollower")
    @CrossOrigin
    public Object getFollower(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                          int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                          int pageSize,long userId){
        return followerService.findFollower(pageNum,pageSize,userId);
    }
    @ResponseBody
    @GetMapping("/getFollow")
    @CrossOrigin
    public Object getFollow(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                      int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                      int pageSize,long followerId){
        return followerService.findUser(pageNum,pageSize,followerId);
    }
    @RequestMapping(value = "deleteFollow")
    @ResponseBody
    @CrossOrigin
    public Object delete(long id){
        return followerService.deleteUser(id);
    }

}

