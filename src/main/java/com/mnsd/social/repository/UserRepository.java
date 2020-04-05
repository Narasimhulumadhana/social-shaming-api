package com.mnsd.social.repository;

import com.mnsd.social.model.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email, String password);

    @Query("select u from User u where u.userId not  in (select f.following from Followers f where f.follower=?1) and u.userId not in ?1  ")
    List<User> findRandomUsersByUser(Integer userId, PageRequest of);

    @Transactional
    @Modifying
    @Query("update User u set u.socialScore=u.socialScore-1 where u.userId=?1")
    void setSocialScore(Integer userId);
}
