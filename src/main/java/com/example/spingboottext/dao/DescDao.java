package com.example.spingboottext.dao;

import com.example.spingboottext.model.Desc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DescDao {
    int insert(Desc desc);
    List<Desc> selectDesc();
    Desc byIdGetDesc(@Param("id") long id);
}
