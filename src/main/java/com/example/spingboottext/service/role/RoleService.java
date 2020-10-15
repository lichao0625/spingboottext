package com.example.spingboottext.service.role;

import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Role;


public interface RoleService {
    Result addRole(Role role);
    Result findAllRole(int pageNum, int pageSize);
    Result byIdGetRole(long id);
}
