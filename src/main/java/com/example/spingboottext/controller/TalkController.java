package com.example.spingboottext.controller;

import com.example.spingboottext.model.Stroy;
import com.example.spingboottext.model.Talk;
import com.example.spingboottext.service.stroy.StroyService;
import com.example.spingboottext.service.talk.TalkService;
import com.example.spingboottext.service.userTalk.UserTalkService;
import com.example.spingboottext.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "talk")
public class TalkController {

    @Autowired
    private TalkService talkService;

    @PostMapping("/add")
    @ResponseBody
    @CrossOrigin
    public Object addTalk(long stroyId,long userId,String username,String userPortrait,String text,String storyName){
        Talk  talk=new Talk();
        talk.setStoryID(stroyId);
        talk.setUserID(userId);
        talk.setText(text);
        talk.setUsername(username);
        talk.setUserPortrait(userPortrait);
        talk.setCreateTime(TimeUtil.dateToString(new Date(),TimeUtil.DATE_24));
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
        return talkService.findStoryTalks(pageNum,pageSize,storyId);
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
}
