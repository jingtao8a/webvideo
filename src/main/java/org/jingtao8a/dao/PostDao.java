package org.jingtao8a.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    @Update("update posts set `title`=#{title},`desc`=#{desc},`img`=#{img},`cat`=#{cat} where `id`=#{id}")
    public void updatePostById(Post post);

    @Insert("insert into posts(`title`, `desc`, `img`, `cat`, `date`, `uid`) values(#{title}, #{desc}, #{img}, #{cat}, #{date, jdbcType=DATE}, #{uid})")
    public void addPost(Post post);
}
