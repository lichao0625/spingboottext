package com.example.spingboottext.controller;

import com.example.spingboottext.model.Address;
import com.example.spingboottext.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping("add")
    @ResponseBody
    @CrossOrigin
    public Object addAddress(String name,String dec,int eco,int tec,int rel,long createBy){
        Address address=new Address();
        address.setName(name);
        address.setDes(dec);
        address.setTec(tec);
        address.setEco(eco);
        address.setRel(rel);
        address.setCreateBy(createBy);
        return addressService.addAddress(address);
    }
    @GetMapping("getAddress")
    @ResponseBody
    @CrossOrigin
    public Object getAddress(long id){
        return addressService.byIdGetAddress(id);
    }
    @GetMapping("getAddresses")
    @ResponseBody
    @CrossOrigin
    public Object getAddresses(int pageNum,int pageSize){
        return addressService.findAllAddress(pageNum, pageSize);
    }
}
