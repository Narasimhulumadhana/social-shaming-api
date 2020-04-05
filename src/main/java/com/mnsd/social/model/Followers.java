package com.mnsd.social.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followersId;

    private Integer follower;

    private Integer following;

    public Integer getFollowersId() {
        return followersId;
    }

    public void setFollowersId(Integer followersId) {
        this.followersId = followersId;
    }

    public Integer getFollower() {
        return follower;
    }

    public void setFollower(Integer follower) {
        this.follower = follower;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public Followers(Integer followersId, Integer follower, Integer following) {
        this.followersId = followersId;
        this.follower = follower;
        this.following = following;
    }

    public Followers() {
    }
}
