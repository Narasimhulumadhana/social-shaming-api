package com.mnsd.social.controller;

import com.mnsd.social.dto.PostsDto;
import com.mnsd.social.model.Posts;
import com.mnsd.social.service.PostService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiOperation("controller related to posts")
@CrossOrigin
public class PostsController {

    private PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts/add")
    public Posts addPosts(@RequestBody Posts posts){
        return this.postService.addPosts(posts);
    }

    @GetMapping("/posts/{userId}")
    public List<PostsDto> getAllPostsByUser(@PathVariable("userId") String  userId) throws NumberFormatException{
        return this.postService.getAllPostsByUser(userId);
    }

    @PutMapping("/posts/{postId}")
    public boolean reportAbusivePost(@PathVariable("postId") String postId){
        return this.postService.reportAbusivePost(postId);
    }

    @PutMapping("/posts/{postId}/notabusive")
    public boolean reportnotAbusivePost(@PathVariable("postId") String postId){
        return this.postService.reportNotAbusivePost(postId);
    }

    @GetMapping("/posts/all")
    public List<Posts> getAllPosts(){
        return this.postService.getAllPosts();
    }

    @GetMapping("/posts/all/abusive")
    public List<PostsDto> getAllAbusivePosts(){
        return this.postService.getAllAbusivePosts();
    }

    @GetMapping("/posts/{postId}/user/{userId}")
    public boolean deletePost(@PathVariable("postId") Integer postId, @PathVariable("userId") Integer userId){
        return this.postService.deletePost(postId,userId);
    }
}
