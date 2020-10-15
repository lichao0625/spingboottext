package com.example.spingboottext.service.role.impl;

import com.example.spingboottext.dao.RoleDao;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Role;
import com.example.spingboottext.service.role.RoleService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public Result addRole(Role role) {
        roleDao.insert(role);
        return ResultUtil.success(role);
    }

    @Override
    public Result findAllRole(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> roles=roleDao.selectRoles();
        PageInfo result=new PageInfo(roles);
        return ResultUtil.success(result.getList());
    }

    @Override
    public Result byIdGetRole(long id) {
        Role role=roleDao.byIdGetRole(id);
        return ResultUtil.success(role);
    }
}
