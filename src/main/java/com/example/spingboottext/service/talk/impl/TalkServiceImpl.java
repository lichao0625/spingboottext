package com.example.spingboottext.service.talk.impl;

import com.example.spingboottext.dao.TalkDao;
import com.example.spingboottext.dao.UserDao;
import com.example.spingboottext.dao.UserTalkDao;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Talk;
import com.example.spingboottext.model.User;
import com.example.spingboottext.model.UserTalk;
import com.example.spingboottext.service.talk.TalkService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "TalkService")
public class TalkServiceImpl implements TalkService {

    @Autowired
    private TalkDao talkDao;
    @Autowired
    private UserTalkDao userTalkDao;
    @Override
    public Result addTalk(Talk talk) {
        int a = talkDao.insert(talk);
        a=talkDao.getSize(talk.getStoryID());
        return ResultUtil.success(a);
    }

    @Override
    public Result findStoryTalks(int pageNum, int pageSize,long storyId) {
        List<Talk> talks = talkDao.getStoryTalks(storyId);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Talk> result = new PageInfo(talks);
        for(Talk talk:result.getList()){
            PageHelper.startPage(1, 5);
            List<UserTalk> userTalks=userTalkDao.getTalkTalks(talk.getId());
            PageInfo<UserTalk> userResult=new PageInfo(userTalks);
            talk.setUserTalks(userResult);
        }
        return ResultUtil.success(result);
    }

    @Override
    public Result findSlefTalks(int pageNum, int pageSize, long userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Talk> talks = talkDao.getSlefTalks(userId);
        PageInfo result = new PageInfo(talks);
        return ResultUtil.success(result);
    }

    @Override
    public Result byUserIdGetTalks(long userId,long stroyId) {
        Talk talk=talkDao.hasUser(userId,stroyId);
        return ResultUtil.success(talk);
    }

    @Override
    public Result deleteTalk(long id) {
        talkDao.delete(id);
        userTalkDao.deleteByTalk(id);
        return ResultUtil.success();
    }

    @Override
    public Result getTalkSize(long storyId) {
        int size = getSize(storyId);
        return ResultUtil.success(size);
    }

    @Override
    public int getSize(long storyId) {
        Integer size=talkDao.getSize(storyId);
        if(size==null)
            size=0;
        return size;
    }
}
