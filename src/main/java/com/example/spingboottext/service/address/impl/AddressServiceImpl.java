package com.example.spingboottext.service.address.impl;

import com.example.spingboottext.dao.AddressDao;
import com.example.spingboottext.model.Address;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.service.address.AddressService;
import com.example.spingboottext.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressDao addressDao;
    @Override
    public Result addAddress(Address address) {
        int a=addressDao.insert(address);
        if(a==1)
            return ResultUtil.success(address);
        else
            return ResultUtil.error(0,"添加失败");
    }

    @Override
    public Result findAllAddress(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Address> addresses=addressDao.selectAddresses();
        PageInfo pageInfo=new PageInfo(addresses);
        return ResultUtil.success(pageInfo.getList());
    }

    @Override
    public Result byIdGetAddress(long id) {
        Address address=addressDao.byIdGetAddress(id);
        return ResultUtil.success(address);
    }
}
