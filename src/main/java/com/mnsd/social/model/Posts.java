package com.mnsd.social.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private String post;

    private Integer postedBy;

    private Timestamp postedOn;

    private Boolean isAbusive=false;

    private Boolean isDeleted=false;

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

    public Integer getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Integer postedBy) {
        this.postedBy = postedBy;
    }

    public Timestamp getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Timestamp postedOn) {
        this.postedOn = postedOn;
    }

    public Posts(Integer postId, String post, Integer postedBy, Timestamp postedOn, boolean isAbusive, boolean isDeleted) {
        this.postId = postId;
        this.post = post;
        this.postedBy = postedBy;
        this.postedOn = postedOn;
        this.isAbusive = isAbusive;
        this.isDeleted = isDeleted;
    }

    public Posts() {
    }

    public boolean isAbusive() {
        return isAbusive;
    }

    public void setAbusive(boolean abusive) {
        isAbusive = abusive;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
