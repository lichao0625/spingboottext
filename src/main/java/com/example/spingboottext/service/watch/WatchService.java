package com.example.spingboottext.service.watch;

import com.example.spingboottext.model.Point;
import com.example.spingboottext.model.Result;

public interface WatchService {
    Result addWatch(Point point);
    Result findStoryWatchs(int pageNum, int pageSize,long stroyId);
    Result findSlefWatchs(int pageNum, int pageSize,long userId);
    Result byUserIdGetWatchs(long userId,long storyId);
    Result deleteWatch(long id);
    Result getWatchSize(long storyId);
    int getSize(long storyId);
    public boolean hasWatch(long userId,long storyId);
}
