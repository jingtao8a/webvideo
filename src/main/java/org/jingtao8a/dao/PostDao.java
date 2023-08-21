package org.jingtao8a.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.jingtao8a.model.Post;
import java.util.*;

public interface PostDao {
    @Select("select * from posts where cat=#{cat}")
    public List<Post> getPostByCat(String cat);

    @Select("select * from posts")
    public List<Post> getAllPost();

    @Select("select * from posts where id=#{id}")
    public Post getPostById(Integer id);

    @Delete("delete from posts where id=#{id}")
    public void deletePostById(Integer id);
}
