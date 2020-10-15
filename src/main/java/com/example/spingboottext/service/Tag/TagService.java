package com.example.spingboottext.service.Tag;

import com.example.spingboottext.model.Desc;
import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.Tag;

public interface TagService {
    Result addTag(Tag tag);
    Result findAllTag(int pageNum, int pageSize);
    Result byIdGetTag(long id);
    Result updateNumber(String tag);
}
