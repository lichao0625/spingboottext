package com.example.spingboottext.service.desc.impl;

import com.example.spingboottext.dao.AddressDao;
import com.example.spingboottext.dao.DescDao;
import com.example.spingboottext.model.Address;
import com.example.spingboottext.model.Desc;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.service.desc.DescService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service(value = "descService")
public class DescServiceImpl implements DescService {
    @Autowired
    DescDao descDao;
    @Override
    public Result addDesc(Desc desc) {
        int a=descDao.insert(desc);
        if(a==1)
            return ResultUtil.success(desc);
        else
            return ResultUtil.error(0,"添加失败");
    }

    @Override
    public Result findAllDesc(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Desc> descs=descDao.selectDesc();
        PageInfo pageInfo=new PageInfo(descs);
        return ResultUtil.success(pageInfo.getList());
    }

    @Override
    public Result byIdGetDesc(long id) {
        Desc desc=descDao.byIdGetDesc(id);
        return ResultUtil.success(desc);
    }
}
