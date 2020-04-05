package com.mnsd.social.dto;

import com.mnsd.social.model.Posts;
import com.mnsd.social.model.User;

import java.sql.Timestamp;

public class PostsDto {
    private Integer postId;

    private String post;

    private User postedBy;

    private Timestamp postedOn;

    private Boolean isAbusive;

    private Boolean isDeleted;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public Timestamp getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Timestamp postedOn) {
        this.postedOn = postedOn;
    }

    public Boolean getAbusive() {
        return isAbusive;
    }

    public void setAbusive(Boolean abusive) {
        isAbusive = abusive;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public PostsDto(Posts post, User user) {
        this.postId = post.getPostId();
        this.post = post.getPost();
        this.postedBy = user;
        this.postedOn = post.getPostedOn();
        this.isAbusive = post.isAbusive();
        this.isDeleted = post.isDeleted();
    }
}
