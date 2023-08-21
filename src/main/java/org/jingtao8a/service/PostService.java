package org.jingtao8a.service;


import org.jingtao8a.dao.PostDao;
import org.jingtao8a.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDao postDao;

    public List<Post> getPostByCat(String cat) {
        return postDao.getPostByCat(cat);
    }

    public List<Post> getAllPost() {
        return postDao.getAllPost();
    }

    public Post getPostById(Integer id) { return postDao.getPostById(id); }

    public void deletePostById(Integer id) { postDao.deletePostById(id); }
}
