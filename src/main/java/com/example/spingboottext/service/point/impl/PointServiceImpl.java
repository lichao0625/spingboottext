package com.example.spingboottext.service.point.impl;

import com.example.spingboottext.dao.PointDao;
import com.example.spingboottext.dao.TalkDao;
import com.example.spingboottext.model.Point;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Talk;
import com.example.spingboottext.service.point.PointService;
import com.example.spingboottext.util.ResultUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "PointService")
public class PointServiceImpl implements PointService {

    @Autowired
    private PointDao pointDao;

    @Override
    public Result addPoint(Point point) {
        Point oldPoint = pointDao.hasUser(point.getUserID(),point.getStoryID());
        boolean isAdd=false;
        if(oldPoint==null) {
            isAdd=true;
            pointDao.insert(point);
        }else{
            pointDao.delete(oldPoint.getId());
        }
        Integer size=getSize(point.getStoryID());
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

    @Override
    public Result findStoryPoints(int pageNum, int pageSize, long storyId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Point> points = pointDao.getStoryPoints(storyId);
        PageInfo result = new PageInfo(points);
        return ResultUtil.success(result.getList());
    }

    @Override
    public Result findSlefPoints(int pageNum, int pageSize, long userId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Point> points = pointDao.getUserPoints(userId);
        PageInfo result = new PageInfo(points);
        return ResultUtil.success(result.getList());
    }

    @Override
    public Result byUserIdGetPoints(long userId, long storyId) {
        Point point=pointDao.hasUser(userId,storyId);
        if(point!=null){
            return ResultUtil.success(true);
        }else{
            return ResultUtil.success(false);
        }
    }

    @Override
    public Result deletePoint(long id) {
        int a=pointDao.delete(id);
        return ResultUtil.success();
    }

    @Override
    public Result getPointSize(long storyId) {
        int size=getSize(storyId);
        return ResultUtil.success(size);
    }

    @Override
    public int getSize(long storyId) {
        Integer size = pointDao.getSize(storyId);
        if(size==null)
            size=0;
        return size;
    }

    @Override
    public boolean hasPoint(long userId, long storyId) {
        Point oldPoint = pointDao.hasUser(userId,storyId);
        if(oldPoint!=null)
            return true;
        return false;
    }
}
