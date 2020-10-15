package com.example.spingboottext.dao;

import com.example.spingboottext.model.Point;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WatchDao {
    Integer insert(Point point);
    Integer delete(@Param("id") long id);
    Integer getSize(@Param("storyID") long storyID);
    List<Point> getStoryWatchs(@Param("storyID") long storyID);
    List<Point> getUserWatchs(@Param("userID") long userID);
    Point hasUser(@Param("userID") long userID,@Param("storyID") long storyID);

}
