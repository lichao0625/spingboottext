package com.example.spingboottext.service.watch.impl;

import com.example.spingboottext.dao.PointDao;
import com.example.spingboottext.dao.WatchDao;
import com.example.spingboottext.model.Point;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.service.watch.WatchService;
import com.example.spingboottext.util.ResultUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "WatchService")
public class WatchServiceImpl implements WatchService {

    @Autowired
    private WatchDao watchDao;

    @Override
    public Result addWatch(Point point) {
        Point oldPoint = watchDao.hasUser(point.getUserID(),point.getStoryID());
        boolean isAdd=false;
        if(oldPoint==null) {
            watchDao.insert(point);
            isAdd=true;
        }else{
            watchDao.delete(oldPoint.getId());
        }
        int size=getSize(point.getStoryID());
        HashMap<String,Object> map=new HashMap<>();
        map.put("isAdd",isAdd);
        map.put("size",size);
        String json= null;
        try {
            json = new ObjectMapper().writeValueAsString(map);
            return ResultUtil.success(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResultUtil.error(0,e.toString());
        }

    }

    public boolean hasWatch(long userId,long storyId){
        Point oldPoint = watchDao.hasUser(userId,storyId);
        if(oldPoint==null)
            return false;
        else
            return true;
    }

    @Override
    public Result findStoryWatchs(int pageNum, int pageSize, long storyId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Point> points = watchDao.getStoryWatchs(storyId);
        PageInfo result = new PageInfo(points);
        return ResultUtil.success(result.getList());
    }

    @Override
    public Result findSlefWatchs(int pageNum, int pageSize, long userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Point> points = watchDao.getUserWatchs(userId);
        PageInfo result = new PageInfo(points);
        return ResultUtil.success(result.getList());
    }

    @Override
    public Result byUserIdGetWatchs(long userId, long storyId) {
        Point point=watchDao.hasUser(userId,storyId);
        if(point!=null){
            return ResultUtil.success(true);
        }else{
            return ResultUtil.success(false);
        }
    }

    @Override
    public Result deleteWatch(long id) {
        int a=watchDao.delete(id);
        return ResultUtil.success();
    }

    @Override
    public Result getWatchSize(long storyId) {
        int size=getSize(storyId);
        return ResultUtil.success(size);
    }

    @Override
    public int getSize(long storyId) {
        return watchDao.getSize(storyId);
    }
}
