package com.example.spingboottext.controller;

import com.example.spingboottext.model.Talk;
import com.example.spingboottext.model.UserTalk;
import com.example.spingboottext.service.talk.TalkService;
import com.example.spingboottext.service.userTalk.UserTalkService;
import com.example.spingboottext.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "userTalk")
public class UserTalkController {
    @Autowired
    private UserTalkService talkService;
    @PostMapping("/add")
    @ResponseBody
    @CrossOrigin
    public Object addTalk(long talkId,long userId,String username,String userPortrait,String text,long tUserID,long storyID,String storyName){
        UserTalk talk=new UserTalk();
        talk.setTalkID(talkId);
        talk.setUserID(userId);
        talk.setText(text);
        talk.setUsername(username);
        talk.setUserPortrait(userPortrait);
        talk.setCreateTime(TimeUtil.dateToString(new Date(),TimeUtil.DATE_24));
        talk.settUserID(tUserID);
        talk.setStoryID(storyID);
        talk.setStoryName(storyName);
        return talkService.addTalk(talk);
    }

    @ResponseBody
    @GetMapping("/getStoryTalks")
    @CrossOrigin
    public Object getStoryTalks(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                        int pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                        int pageSize,long storyId){
        return talkService.findTalkTalks(pageNum,pageSize,storyId);
    }

    @ResponseBody
    @GetMapping("/getUserTalks")
    @CrossOrigin
    public Object getUserTalks(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                       int pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                       int pageSize,long userId){
        return talkService.findSlefTalks(pageNum,pageSize,userId);
    }
    @ResponseBody
    @GetMapping("/getTalkToSelf")
    @CrossOrigin
    public Object getSelfTalks(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                       int pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                       int pageSize,long tUserId){
        return talkService.findToSlefTalks(pageNum,pageSize,tUserId);
    }

    @ResponseBody
    @GetMapping("/hasUser")
    @CrossOrigin
    public Object hasUser(long userId,long stroyId){
        return talkService.byUserIdGetTalks(userId,stroyId);
    }

    @ResponseBody
    @GetMapping("/getSize")
    @CrossOrigin
    public Object getSize(long storyId){
        return talkService.getTalkSize(storyId);
    }

    @ResponseBody
    @GetMapping("/delete")
    @CrossOrigin
    public Object delete(long id){
        return talkService.deleteTalk(id);
    }
    @ResponseBody
    @GetMapping("/deleteByTalk")
    @CrossOrigin
    public Object deleteByTalk(long userTalk){
        return talkService.deleteTalk(userTalk);
    }
}
