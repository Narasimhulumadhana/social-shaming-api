package com.mnsd.social.service;

import com.mnsd.social.dto.PostsDto;
import com.mnsd.social.model.BanWords;
import com.mnsd.social.model.Posts;
import com.mnsd.social.repository.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    private PostsRepository postsRepository;
    private UserService userService;
    private BanWordService banWordService;

    public PostService(PostsRepository postsRepository, UserService userService, BanWordService banWordService) {
        this.postsRepository = postsRepository;
        this.userService = userService;
        this.banWordService = banWordService;
    }

    public Posts addPosts(Posts posts) {
        if(this.userService.isUserExists(posts.getPostedBy())){
            List<BanWords> banWords=this.banWordService.getAllWords();
            List<String> words= Arrays.asList(posts.getPost().split(" "));
            posts.setAbusive(this.setAbusivePost(banWords,words));
             return this.postsRepository.save(posts);
        }
        return null;
    }

    private boolean setAbusivePost(List<BanWords> banWords, List<String> words) {
        for(BanWords b:banWords){
            for (String s: words){
                if(b.getWord().contains(s)){
                    return true;
                }
            }
        }
        return false;
    }

    public List<PostsDto> getAllPostsByUser(String userId) {
        return this.postsRepository.findByPostedByAndIsDeleted(Integer.valueOf(userId),false);
    }

    public List<Posts> getAllPosts() {
        return this.postsRepository.findAll();
    }

    public List<PostsDto> getAllAbusivePosts() {
        return this.postsRepository.findByIsAbusive(true);
    }

    public boolean deletePost(Integer postId, Integer userId) {
        try {
            this.postsRepository.deleteById(postId);
            this.userService.setSocialScore(userId);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean reportAbusivePost(String postId) {
        try {
            Posts p = this.postsRepository.findById(Integer.valueOf(postId)).get();
            p.setAbusive(true);
            this.postsRepository.save(p);
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public boolean reportNotAbusivePost(String postId) {
        try {
            Posts p = this.postsRepository.findById(Integer.valueOf(postId)).get();
            p.setAbusive(false);
            this.postsRepository.save(p);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
