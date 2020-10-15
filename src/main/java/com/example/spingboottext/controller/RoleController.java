package com.example.spingboottext.controller;

import com.example.spingboottext.model.Role;
import com.example.spingboottext.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("add")
    @ResponseBody
    @CrossOrigin
    public Object addRole(int age,String name,int str,int gender,long userId){
        Role role=new Role();
        role.setName(name);
        role.setAge(age);
        role.setStr(str);
        role.setGender(gender);
        role.setCreateBy(userId);
        return roleService.addRole(role);
    }

    @GetMapping("getRoleById")
    @ResponseBody
    @CrossOrigin
    public Object getRoleById(long id){
        return roleService.byIdGetRole(id);
    }

    @GetMapping("getRoles")
    @ResponseBody
    @CrossOrigin
    public Object getRoles(int pageNum,int pageSize){
        return roleService.findAllRole(pageNum, pageSize);
    }
}
