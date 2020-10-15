package com.example.spingboottext.service.userTalk.impl;

import com.example.spingboottext.dao.TalkDao;
import com.example.spingboottext.dao.UserTalkDao;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Talk;
import com.example.spingboottext.model.UserTalk;
import com.example.spingboottext.service.userTalk.UserTalkService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "UserTalkService")
public class UserTalkServiceImpl implements UserTalkService {
    @Autowired
    private UserTalkDao talkDao;

    @Override
    public Result addTalk(UserTalk talk) {
        int a = talkDao.insert(talk);
        return ResultUtil.success(talk);
    }

    @Override
    public Result findTalkTalks(int pageNum, int pageSize,long talkId) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTalk> talks = talkDao.getTalkTalks(talkId);
        PageInfo result = new PageInfo(talks);
        return ResultUtil.success(result.getList());
    }

    @Override
    public Result findSlefTalks(int pageNum, int pageSize, long userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTalk> talks = talkDao.getSlefTalks(userId);
        PageInfo result = new PageInfo(talks);
        return ResultUtil.success(result.getList());
    }

    @Override
    public Result findToSlefTalks(int pageNum, int pageSize, long userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserTalk> talks = talkDao.getToSlefTalks(userId);
        PageInfo result = new PageInfo(talks);
        return ResultUtil.success(result);
    }

    @Override
    public Result byUserIdGetTalks(long userId,long talkId) {
        Talk talk=talkDao.hasUser(userId,talkId);
        return ResultUtil.success(talk);
    }

    @Override
    public Result deleteTalk(long id) {
        talkDao.delete(id);
        return ResultUtil.success();
    }

    @Override
    public Result getTalkSize(long talkId) {
        int size = getSize(talkId);
        return ResultUtil.success(size);
    }

    @Override
    public int getSize(long talkId) {
        Integer size=talkDao.getSize(talkId);
        if(size==null)
            size=0;
        return size;
    }

    @Override
    public int getSizeByStory(long storyId) {
        Integer size=talkDao.getSizeByStory(storyId);
        if(size==null)
            size=0;
        return size;
    }

    @Override
    public Result deleteByTalk(long talkID) {
        talkDao.delete(talkID);
        return ResultUtil.success();
    }
}
