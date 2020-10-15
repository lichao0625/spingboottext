package com.example.spingboottext.service.desc;

import com.example.spingboottext.model.Address;
import com.example.spingboottext.model.Desc;
import com.example.spingboottext.model.Result;

public interface DescService {
    Result addDesc(Desc desc);
    Result findAllDesc(int pageNum, int pageSize);
    Result byIdGetDesc(long id);
}
