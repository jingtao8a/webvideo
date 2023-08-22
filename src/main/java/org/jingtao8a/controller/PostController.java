package org.jingtao8a.controller;

import org.jingtao8a.model.Post;
import org.jingtao8a.model.Result;
import org.jingtao8a.service.PostService;
import org.jingtao8a.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @RequestMapping(value="/post", method= RequestMethod.GET, params="cat")
    @ResponseBody
    public Result getPostByCategory(@RequestParam  String cat) {
        Result res = new Result(200, "getPostsByCategory");
        res.setExtentPack(postService.getPostByCat(cat));
        return res;
    }

    @RequestMapping(value="/post", method= RequestMethod.GET)
    @ResponseBody
    public Result getAllPost() {
        Result res = new Result(200, "getAllPosts");
        res.setExtentPack(postService.getAllPost());
        return res;
    }

    @RequestMapping(value="/post/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result getPostById(@PathVariable String id) {
        Integer postId = Integer.valueOf(id);
        Result res = new Result(200, "getPostById");
        Post post = postService.getPostById(postId);
        post.setUser(userService.getUserById(post.getUid()));
        res.setExtentPack(post);
        return res;
    }


    @RequestMapping(value = "/post/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public  Result deletePostById(@PathVariable String id) {
        Integer postId = Integer.valueOf(id);
        postService.deletePostById(postId);
        return new Result(200, "deletePostById");
    }

    @RequestMapping(value="/post/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePostById(@PathVariable String id, @RequestBody Post post) {
        Integer postId = Integer.valueOf(id);
        postService.updatePostById(postId, post);
        return new Result(200, "updatePostById");
    }

    @RequestMapping(value="/post", method = RequestMethod.POST)
    @ResponseBody
    public Result addPost(@RequestBody Post post) {
        if (post.getUid() == null ) {
            return new Result(400, "uid not found");
        }
        System.out.println(post);
        postService.addPost(post);
        return new Result(200, "addPost");
    }
}
