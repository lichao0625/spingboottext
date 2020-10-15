package com.example.spingboottext.dao;

import com.example.spingboottext.model.Address;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AddressDao {
    int insert(Address address);
    List<Address> selectAddresses();
    Address byIdGetAddress(@Param("id") long id);
}
