package com.example.spingboottext.service.address;

import com.example.spingboottext.model.Address;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Role;

public interface AddressService {
    Result addAddress(Address address);
    Result findAllAddress(int pageNum, int pageSize);
    Result byIdGetAddress(long id);
}
