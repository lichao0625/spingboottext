package com.example.spingboottext.controller;

import com.example.spingboottext.model.Stroy;
import com.example.spingboottext.service.stroy.StroyService;
import com.example.spingboottext.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "stroy")
public class StroyController {
    @Autowired
    private StroyService stroyService;

    @PostMapping("/add")
    @ResponseBody
    @CrossOrigin
    public Object addStroy(String title,String stroys,String tag,int type,int showType,long userId,boolean isBranch,boolean isEnd){
        Stroy stroy=new Stroy();
        stroy.setTitle(title);
        stroy.setStroys(stroys);
        stroy.setTag(tag);
        stroy.setType(type);
        stroy.setShowType(showType);
        stroy.setCreateBy(userId);
        stroy.setBranch(isBranch);
        stroy.setEnd(isEnd);
        stroy.setCreateTime(TimeUtil.dateToString(new Date(),TimeUtil.DATE_24));
        return stroyService.addStroy(stroy);
    }
    @PostMapping("/addBranch")
    @ResponseBody
    @CrossOrigin
    public Object addBranch(String title,String stroys,String tag,int type,int showType,long userId,boolean isBranch,long followId){
        Stroy stroy=new Stroy();
        stroy.setTitle(title);
        stroy.setStroys(stroys);
        stroy.setTag(tag);
        stroy.setType(type);
        stroy.setShowType(showType);
        stroy.setCreateBy(userId);
        stroy.setBranch(isBranch);
        stroy.setFollowId(followId);
        stroy.setCreateTime(TimeUtil.dateToString(new Date(),TimeUtil.DATE_24));
        return stroyService.addStroy(stroy);
    }
    @ResponseBody
    @GetMapping("/findStroy")
    @CrossOrigin
    public Object findAllStroy(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                           int pageNum,
                               @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                           int pageSize, int type, boolean point,long userId){
        return stroyService.findAllStroy(pageNum, pageSize, type, point,userId);
    }
    @ResponseBody
    @GetMapping("/findSelfStroy")
    @CrossOrigin
    public Object findUserStroy(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                            int pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                            int pageSize, long userId){
        return stroyService.findUserStroy(pageNum,pageSize,userId);
    }
    @ResponseBody
    @GetMapping("/findStroyByType")
    @CrossOrigin
    public Object findTypeStroy(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                            int pageNum,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                            int pageSize, int type,long userId){
        return stroyService.findTypeStroy(pageNum, pageSize, type,userId);
    }
    @ResponseBody
    @GetMapping("/getStroyById")
    @CrossOrigin
    public Object getStroyById(long id,long userId){
        return stroyService.getStroyById(id,userId);
    }
    @ResponseBody
    @GetMapping("/getFollowsById")
    @CrossOrigin
    public Object getFollowsById(int id,long userId){
        return stroyService.getFollowsById(id,userId);
    }

    @ResponseBody
    @PostMapping("/updateStroy")
    @CrossOrigin
    public Object updateStroy(String title,String stroy,int id){
        Stroy stroy1=new Stroy();
        stroy1.setTitle(title);
        stroy1.setStroys(stroy);
        stroy1.setId(id);
        stroy1.setUpdateTime(TimeUtil.dateToString(new Date(),TimeUtil.DATE_24));
        return stroyService.updateStroy(stroy1);
    }
    @ResponseBody
    @PostMapping("/deleteStroy")
    @CrossOrigin
    public Object deleteStroy(int id,long userId){
        Stroy stroy=new Stroy();
        stroy.setId(id);
        return stroyService.deleteStroy(stroy,userId);
    }
    @ResponseBody
    @PostMapping("/resetShowType")
    @CrossOrigin
    public Object resetShowType(int showType, long userId){
        return stroyService.resetShowType(showType, userId);
    }
    @ResponseBody
    @PostMapping("/resetEnd")
    @CrossOrigin
    public Object resetEnd(boolean end, long id){
        return stroyService.resetIsEnd(end, id);
    }

}
