package org.jingtao8a.dao;

import org.apache.ibatis.annotations.Select;
import org.jingtao8a.model.User;

public interface UserDao {
    @Select("select * from users where id=#{id}")
    public User getUserById(Integer id);
}
