package com.example.spingboottext.dao;


import com.example.spingboottext.model.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDao {
    int insert(Tag desc);
    List<Tag> selectTag();
    Tag byIdGetTag(@Param("id") long id);
    Tag byTagGetTag(@Param("tag") String tag);
    int updateNumber(@Param("tag") String tag,@Param("number") long number);
}
