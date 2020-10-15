package com.example.spingboottext.service.point;

import com.example.spingboottext.model.Point;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Talk;

public interface PointService {
    Result addPoint(Point point);
    Result findStoryPoints(int pageNum, int pageSize,long stroyId);
    Result findSlefPoints(int pageNum, int pageSize,long userId);
    Result byUserIdGetPoints(long userId,long storyId);
    Result deletePoint(long id);
    Result getPointSize(long storyId);
    int getSize(long storyId);
    public boolean hasPoint(long userId,long storyId);
}
