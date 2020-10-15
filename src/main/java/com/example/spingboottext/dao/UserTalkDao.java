package com.example.spingboottext.dao;

import com.example.spingboottext.model.Talk;
import com.example.spingboottext.model.UserTalk;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTalkDao {
    int insert(UserTalk talk);
    int getSize(@Param("talkID") long talkID);
    int getSizeByStory(@Param("storyID") long storyID);
    List<UserTalk> getTalkTalks(@Param("talkID") long talkID);
    List<UserTalk> getSlefTalks(@Param("userID") long userID);
    List<UserTalk> getToSlefTalks(@Param("tUserID") long userID);
    Talk hasUser(@Param("userID") long userID,@Param("talkID") long talkID);
    int delete(@Param("id") long id);
    int deleteByTalk(@Param("talkID") long talkID);
}
