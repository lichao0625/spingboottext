package com.example.spingboottext.dao;

import com.example.spingboottext.model.Point;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PointDao {
    Integer insert(Point point);
    Integer getSize(@Param("storyID") long storyID);
    List<Point> getStoryPoints(@Param("storyID") long storyID);
    List<Point> getUserPoints(@Param("userID") long userID);
    Point hasUser(@Param("userID") long userID,@Param("storyID") long storyID);
    Integer delete(@Param("id") long id);
}
