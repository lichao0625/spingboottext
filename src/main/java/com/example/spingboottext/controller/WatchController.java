package com.example.spingboottext.controller;


import com.example.spingboottext.model.Point;
import com.example.spingboottext.service.point.PointService;
import com.example.spingboottext.service.watch.WatchService;
import com.example.spingboottext.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "watch")
public class WatchController {
    @Autowired
    private WatchService pointService;
    @PostMapping("/add")
    @ResponseBody
    @CrossOrigin
    public Object addTalk(long stroyId,long userId,String username,String userPortrait,String storyName){
        Point point=new Point();
        point.setStoryID(stroyId);
        point.setUserID(userId);
        point.setUsername(username);
        point.setUserPortrait(userPortrait);
        point.setStoryName(storyName);
        point.setCreateTime(TimeUtil.dateToString(new Date(),TimeUtil.DATE_24));
        return pointService.addWatch(point);
    }

    @ResponseBody
    @GetMapping("/getStoryPoints")
    @CrossOrigin
    public Object getStoryTalks(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                        int pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                        int pageSize,long storyId){
        return pointService.findStoryWatchs(pageNum,pageSize,storyId);
    }

    @ResponseBody
    @GetMapping("/getUserWatchs")
    @CrossOrigin
    public Object getUserTalks(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                       int pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                       int pageSize,long userId){
        return pointService.findSlefWatchs(pageNum,pageSize,userId);
    }

    @ResponseBody
    @GetMapping("/hasUser")
    @CrossOrigin
    public Object hasUser(long userId,long stroyId){
        return pointService.byUserIdGetWatchs(userId,stroyId);
    }

    @ResponseBody
    @GetMapping("/getSize")
    @CrossOrigin
    public Object getSize(long storyId){
        return pointService.getWatchSize(storyId);
    }

    @ResponseBody
    @GetMapping("/delete")
    @CrossOrigin
    public Object delete(long id){
        return pointService.deleteWatch(id);
    }
}
