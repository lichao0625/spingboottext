package com.example.spingboottext.controller;


import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.User;
import com.example.spingboottext.service.user.UserService;
import com.example.spingboottext.util.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;



@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ResponseBody
    @CrossOrigin
    public Object addUser(String name,String pwd){
        //user.setName(userName);
            User user = new User();
            user.setName(name);
            user.setPwd(pwd);
            return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    @CrossOrigin
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                    int pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }
    @ResponseBody
    @GetMapping("/getUserById")
    @CrossOrigin
    public Object findUser(long id,long followId){
        return userService.byIdgetUser(id,followId);
    }

    @ResponseBody
    @GetMapping("/getSelfById")
    @CrossOrigin
    public Object findUser(long id){
        return userService.byIdgetUser(id);
    }

    @RequestMapping(value = "login")
    @ResponseBody
    @CrossOrigin
    public Object login(String name,String pwd){
        return userService.login(name,pwd);

    }
    @RequestMapping(value = "setUserInfo")
    @ResponseBody
    @CrossOrigin
    public Result setUserInfo(String nikeName, String signature, String email, String phone, long userId){
        return ResultUtil.success(userService.updateUserInfo(nikeName,signature,email,phone,userId));
    }
    @RequestMapping(value = "setPortrait")
    @ResponseBody
    @CrossOrigin
    public Object setPortrait(String portrait,long userId){
        return ResultUtil.success(userService.updatePortrait(portrait,userId));
    }
    @RequestMapping(value = "setPwd")
    @ResponseBody
    @CrossOrigin
    public Object setPwd(String pwd,long userId){
        return ResultUtil.success(userService.updatePwd(pwd,userId));
    }
}
