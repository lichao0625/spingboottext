package com.example.spingboottext.dao;

import com.example.spingboottext.model.Stroy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StroyDao {
    int addStroy(Stroy stroy);
    List<Stroy> getByPoint(int pageSize, int pageNum, @Param("type") int type, @Param("point") boolean byPoint);
    List<Stroy> getByCreateId(int pageSize,int pageNum,@Param("createBy") long userId);
    List<Stroy> getByType(int pageSize,int pageNum,@Param("type") int type);
    List<Stroy> getBrachByFollowId(@Param("followId") long id);
    int deleteStroy(@Param("id") long id,@Param("userId") long userId);
    void updateStroy(@Param("title") String title,@Param("stroys") String stroys,@Param("updateTime") String updateTime,@Param("id") long id);
    Stroy getStroyByName(@Param("title") String title);
    Stroy getStroyById(@Param("id") long id);
    void resetShowType(@Param("showType") int showType,@Param("userId") long userId);
    void resetIsEnd(@Param("isEnd") boolean isEnd,@Param("id") long id);
}
