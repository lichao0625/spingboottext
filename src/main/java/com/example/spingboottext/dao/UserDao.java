package com.example.spingboottext.dao;

import com.example.spingboottext.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    int insert(User user);

    List<User> selectUsers();

    User login(@Param("name") String name,@Param("pwd") String pwd);

    User byNameGetUser(@Param("name") String name);

    User byIdGetUser(@Param("id") long id);

    User updateUserInfo(@Param("nikeName") String nikeName,@Param("signature") String signature
            ,@Param("email") String email  ,@Param("phone") String phone,@Param("id") long userId);

    User updatePortrait(@Param("portrait") String portrait,@Param("id") long id);

    User updatePwd(@Param("pwd") String pwd,@Param("id") long id);
}
