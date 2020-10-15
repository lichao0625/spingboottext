package com.example.spingboottext.dao;

import com.example.spingboottext.model.Point;
import com.example.spingboottext.model.Talk;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TalkDao {
    int insert(Talk talk);
    int getSize(@Param("storyID") long storyID);
    List<Talk> getStoryTalks(@Param("storyID") long storyID);
    List<Talk> getSlefTalks(@Param("userID") long userID);
    Talk hasUser(@Param("userID") long userID,@Param("storyID") long storyID);
    int delete(@Param("id") long id);
}
