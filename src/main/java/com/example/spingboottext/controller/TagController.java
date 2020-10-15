package com.example.spingboottext.controller;

import com.example.spingboottext.model.Desc;
import com.example.spingboottext.model.Tag;
import com.example.spingboottext.service.Tag.TagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "tag")
public class TagController {
    @Autowired
    TagService tagService;

    @PostMapping("add")
    @ResponseBody
    @CrossOrigin
    public Object addTag(String tag){
        Tag desc=new Tag();
        desc.setTag(tag);
        return tagService.addTag(desc);
    }

    @GetMapping("getTags")
    @ResponseBody
    @CrossOrigin
    public Object getTags(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                                      int pageNum,
                          @RequestParam(name = "pageSize", required = false, defaultValue = "20")
                                  int pageSize){
        return tagService.findAllTag(pageNum, pageSize);
    }

}
