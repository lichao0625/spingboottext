package com.example.spingboottext.service.user;

import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    Result addUser(User user);
    Result findAllUser(int pageNum, int pageSize);
    Result login(String name, String pwd);
    Result byNameGetUser(String name);
    Result byIdgetUser(long id,long followId);
    Result byIdgetUser(long id);
    User updateUserInfo( String nikeName, String signature ,String email,String phone,long userId);
    User updatePortrait( String portrait,long id);
    User updatePwd(String pwd,long id);
}
