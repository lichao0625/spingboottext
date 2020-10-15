package com.example.spingboottext.service.userTalk;

import com.example.spingboottext.model.Result;

import com.example.spingboottext.model.UserTalk;


public interface UserTalkService {
    Result addTalk(UserTalk talk);
    Result findTalkTalks(int pageNum, int pageSize,long talkId);
    Result findSlefTalks(int pageNum, int pageSize,long userId);
    Result findToSlefTalks(int pageNum, int pageSize,long userId);
    Result byUserIdGetTalks(long userId,long talkId);
    Result deleteTalk(long id);
    Result getTalkSize(long talkId);
    int getSize(long talkId);
    int getSizeByStory(long storyId);
    Result deleteByTalk(long talkID);
}
