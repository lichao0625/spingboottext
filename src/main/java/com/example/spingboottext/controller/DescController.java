package com.example.spingboottext.controller;

import com.example.spingboottext.model.Address;
import com.example.spingboottext.model.Desc;
import com.example.spingboottext.service.address.AddressService;
import com.example.spingboottext.service.desc.DescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "desc")
public class DescController {
    @Autowired
    DescService descService;

    @PostMapping("add")
    @ResponseBody
    @CrossOrigin
    public Object addDesc(String name,String dec,long createBy){
        Desc desc=new Desc();
        desc.setName(name);
        desc.setDes(dec);
        desc.setCreateBy(createBy);
        return descService.addDesc(desc);
    }
    @GetMapping("getDesc")
    @ResponseBody
    @CrossOrigin
    public Object getDesc(long id){
        return descService.byIdGetDesc(id);
    }
    @GetMapping("getDesces")
    @ResponseBody
    @CrossOrigin
    public Object getdesces(int pageNum,int pageSize){
        return descService.findAllDesc(pageNum, pageSize);
    }
}
