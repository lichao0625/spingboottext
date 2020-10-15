package com.example.spingboottext.service.talk;

import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Talk;

public interface TalkService {
    Result addTalk(Talk talk);
    Result findStoryTalks(int pageNum, int pageSize,long userId);
    Result findSlefTalks(int pageNum, int pageSize,long userId);
    Result byUserIdGetTalks(long userId,long storyId);
    Result deleteTalk(long id);
    Result getTalkSize(long storyId);
    int getSize(long storyId);
}
