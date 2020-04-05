package com.mnsd.social.controller;

import com.mnsd.social.model.Followers;
import com.mnsd.social.model.User;
import com.mnsd.social.service.FollowerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/follow")
@ApiOperation("controller related to followers")
@CrossOrigin
public class FollowersController {
    private FollowerService followerService;

    public FollowersController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @PostMapping("")
    public Followers startFollowing(@RequestBody Followers followers){
        return this.followerService.startFollowing(followers);
    }

    @PostMapping("/unfollow")
    public boolean unFollowing(@RequestBody Followers followers){
        return this.followerService.unFollowing(followers);
    }

    @GetMapping("/following/count/{userId}")
    public Long followingCount(@PathVariable("userId") String userId){
        return this.followerService.getFollowingCount(Integer.valueOf(userId));
    }

    @GetMapping("/followers/count/{userId}")
    public Long followersCount(@PathVariable("userId") String userId){
        return this.followerService.getFollowersCount(Integer.valueOf(userId));
    }

    @GetMapping("/following/users/{userId}")
    public List<User> getFollowingUsers(@PathVariable("userId") String userId){
        return this.followerService.getFollowingUsers(Integer.valueOf(userId));
    }

    @GetMapping("/followers/users/{userId}")
    public List<User> getFollowers(@PathVariable("userId") String userId){
        return this.followerService.getFollowers(Integer.valueOf(userId));
    }
}
