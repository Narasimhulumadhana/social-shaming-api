package com.mnsd.social.repository;

import com.mnsd.social.model.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FollowersRepository extends JpaRepository<Followers,Integer> {
    @Transactional
    @Modifying
    void deleteByFollowerAndFollowing(Integer follower, Integer following);

    Long countByFollower(Integer userId);

    Long countByFollowing(Integer userId);

    @Query("select f.following from Followers f where f.follower=?1")
    List<Integer> findFollowingByUserId(Integer userId);

    @Query("select f.follower from Followers f where f.following=?1")
    List<Integer> findFollowiersByUserId(Integer userId);
}
