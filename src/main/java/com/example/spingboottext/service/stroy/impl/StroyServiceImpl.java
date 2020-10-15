package com.example.spingboottext.service.stroy.impl;

import com.example.spingboottext.dao.*;
import com.example.spingboottext.model.Point;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Stroy;
import com.example.spingboottext.model.Tag;
import com.example.spingboottext.service.stroy.StroyService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "StroyService")
public class StroyServiceImpl implements StroyService {
    @Autowired
    private StroyDao stroyDao;
    @Autowired
    private TalkDao talkDao;
    @Autowired
    private UserTalkDao uTalkDao;
    @Autowired
    private WatchDao watchDao;
    @Autowired
    private PointDao pointDao;
    @Autowired
    private TagDao tagDao;
    @Override
    public Result addStroy(Stroy stroy) {
        Stroy stroy1=stroyDao.getStroyByName(stroy.getTitle());
        if(stroy1==null) {
            int i = stroyDao.addStroy(stroy);
            String tags[]=stroy.getTag().split(",");
            for(String tagName:tags){
                Tag tag=tagDao.byTagGetTag(tagName);
                long num=0;
                if(tag==null)
                    tagDao.insert(tag);
                else
                    num=tag.getNumber();
                tagDao.updateNumber(tagName,num+1);
            }
            return ResultUtil.success(stroy);
        }else
            return ResultUtil.error(0,"标题已存在");
    }

    @Override
    public Result findAllStroy(int pageNum, int pageSize, int type, boolean point,long userId) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Stroy> stroyDomains = stroyDao.getByPoint(pageNum, pageSize, type, point);
        setStoryPWT(stroyDomains,userId);
        PageInfo result = new PageInfo(stroyDomains);
        return ResultUtil.success(result);
    }

    @Override
    public Result findUserStroy(int pageNum, int pageSize, long userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Stroy> stroyDomains = stroyDao.getByCreateId(pageNum, pageSize, userId);
        setStoryPWT(stroyDomains,userId);
        PageInfo result = new PageInfo(stroyDomains);
        return ResultUtil.success(result);
    }
    @Override
    public Result findTypeStroy(int pageNum, int pageSize, int type,long userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Stroy> stroyDomains = stroyDao.getByType(pageNum, pageSize, type);
        setStoryPWT(stroyDomains,userId);
        PageInfo result = new PageInfo(stroyDomains);
        return ResultUtil.success(result);
    }

    @Override
    public Result getStroyById(long id,long userId) {
        Stroy stroy1=stroyDao.getStroyById(id);
        List<Stroy> stroys=stroyDao.getBrachByFollowId(stroy1.getId());
        if(stroys==null){
            stroys=new ArrayList<>();
            stroys.add(stroy1);
        }else{
            stroys.add(0,stroy1);
        }
        setStoryPWT(stroys,userId);
        return ResultUtil.success(stroys);
    }

    @Override
    public Result getFollowsById(long id,long userId) {
        List<Stroy> stroys=stroyDao.getBrachByFollowId(id);
        setStoryPWT(stroys,userId);
        return ResultUtil.success(stroys) ;
    }

    private void setStoryPWT(List<Stroy> stroys,long userId){
        for(Stroy story : stroys){
            int pSize=pointDao.getSize(story.getId());
            int wSize=watchDao.getSize(story.getId());
            int tSize=talkDao.getSize(story.getId());
            int uTSize=uTalkDao.getSizeByStory(story.getId());
            Point point=pointDao.hasUser(userId,story.getId());
            if(point==null)
                story.setHasPoint(false);
            else
                story.setHasPoint(true);
            Point watch=watchDao.hasUser(userId,story.getId());
            if(watch==null)
                story.setHasWatch(false);
            else
                story.setHasWatch(true);
            story.setPoint(pSize);
            story.setWatch(wSize);
            story.setTalk(tSize+uTSize);
        }
    }
    private int getSize(Integer size){
        if(size==null)
            return 0;
        return size;
    }
    @Override
    public Result resetShowType(int showType, long userId) {
        stroyDao.resetShowType(showType, userId);
        return ResultUtil.success(1);
    }

    @Override
    public Result resetIsEnd(boolean isEnd, long id) {
        stroyDao.resetIsEnd(isEnd, id);
        return ResultUtil.success(1);
    }

    @Override
    public Result updateStroy(Stroy stroy) {
        stroyDao.updateStroy(stroy.getTitle(),stroy.getStroys(),stroy.getUpdateTime(),stroy.getId());
        return ResultUtil.success(1);
    }

    @Override
    public Result deleteStroy(Stroy stroy,long userId) {
        List<Stroy> stroys=stroyDao.getBrachByFollowId(stroy.getId());
        for(Stroy stroy1:stroys)
            stroyDao.deleteStroy(stroy1.getId(),userId);
        int a=stroyDao.deleteStroy(stroy.getId(),userId);
        return ResultUtil.success(a);
    }
}
