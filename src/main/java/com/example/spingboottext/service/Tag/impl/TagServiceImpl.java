package com.example.spingboottext.service.Tag.impl;

import com.example.spingboottext.dao.DescDao;
import com.example.spingboottext.dao.TagDao;
import com.example.spingboottext.model.Desc;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Tag;
import com.example.spingboottext.service.Tag.TagService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "TagService")
public class TagServiceImpl implements TagService {
    @Autowired
    TagDao tagDao;
    @Override
    public Result addTag(Tag tag) {
        Tag oldTag=tagDao.byTagGetTag(tag.getTag());
        if(oldTag==null) {
            int a = tagDao.insert(tag);
            if (a == 1)
                return ResultUtil.success(tag);
            else
                return ResultUtil.error(0, "添加失败");
        }else
            return ResultUtil.error(0, "标签已存在");
    }

    @Override
    public Result findAllTag(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> tags=tagDao.selectTag();
        //PageInfo pageInfo=new PageInfo(tags);
        return ResultUtil.success(tags);
    }

    @Override
    public Result byIdGetTag(long id) {
        Tag tag=tagDao.byIdGetTag(id);
        return ResultUtil.success(tag);
    }

    @Override
    public Result updateNumber(String tagName) {
        Tag tag=tagDao.byTagGetTag(tagName);
        tag.setNumber(tag.getNumber()+1);
        tagDao.updateNumber(tagName,tag.getNumber());
        return ResultUtil.success();
    }
}
