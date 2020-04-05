package com.mnsd.social.service;

import com.mnsd.social.model.Followers;
import com.mnsd.social.model.User;
import com.mnsd.social.repository.FollowersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {
    private FollowersRepository followersRepository;
    private UserService userService;

    public FollowerService(FollowersRepository followersRepository, UserService userService) {
        this.followersRepository = followersRepository;
        this.userService = userService;
    }

    public Followers startFollowing(Followers followers) {
        return this.followersRepository.save(followers);
    }

    public boolean unFollowing(Followers followers) {
        try {
            this.followersRepository.deleteByFollowerAndFollowing(followers.getFollower(), followers.getFollowing());
            return true;
        }catch (Exception ex){
            return false;
        }
    }

    public Long getFollowingCount(Integer userId) {
        return this.followersRepository.countByFollower(userId);
    }

    public Long getFollowersCount(Integer userId) {
        return this.followersRepository.countByFollowing(userId);
    }

    public List<User> getFollowingUsers(Integer userId) {
        List<Integer> userIds= this.followersRepository.findFollowingByUserId(userId);
        return this.userService.findAllUsers(userIds);
    }

    public List<User> getFollowers(Integer userId) {
        List<Integer> userIds= this.followersRepository.findFollowiersByUserId(userId);
        return this.userService.findAllUsers(userIds);
    }
}
