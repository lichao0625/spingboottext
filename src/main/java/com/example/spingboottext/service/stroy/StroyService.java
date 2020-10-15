package com.example.spingboottext.service.stroy;

import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Stroy;
import com.example.spingboottext.util.ResultUtil;

public interface StroyService {
    Result addStroy(Stroy stroy);
    Result findAllStroy(int pageNum, int pageSize, int type, boolean point,long userId);
    Result findUserStroy(int pageNum, int pageSize, long userId);
    Result findTypeStroy(int pageNum, int pageSize, int type,long userId);
    Result getStroyById(long id,long userId);
    Result getFollowsById(long id,long userId);
    Result updateStroy(Stroy stroy);
    Result deleteStroy(Stroy stroy,long userId);
    Result resetShowType(int showType, long userId);
    Result resetIsEnd(boolean isEnd, long id);
}
