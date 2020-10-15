package com.example.spingboottext.dao;

import com.example.spingboottext.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    int insert(Role role);
    List<Role> selectRoles();
    Role byIdGetRole(@Param("id") long id);
}
