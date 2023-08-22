package org.jingtao8a.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.jingtao8a.model.User;
import java.util.*;

public interface UserDao {
    @Select("select * from users where id=#{id}")
    public User getUserById(Integer id);

    @Select("select * from users where username=#{userName}")
    public List<User> getUsersByUserName(String UserName);

    @Select("select * from users where email=#{email}")
    public List<User> getUsersByEmail(String email);

    @Insert("insert into users(`username`, `email`, `password`, `img`) values(#{userName}, #{email}, #{password}, #{img})")
    public void addUser(User user);
}
