package com.mnsd.social.repository;

import com.mnsd.social.dto.PostsDto;
import com.mnsd.social.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {

    @Query("select new com.mnsd.social.dto.PostsDto(p,u) from Posts p left join User u on p.postedBy=u.userId where (p.postedBy in (select f.following from Followers f where f.follower=?1) or p.postedBy =?1) and p.isDeleted=?2 and p.isAbusive=?2 order by p.postedOn desc ")
    List<PostsDto> findByPostedByAndIsDeleted(Integer userId, boolean b);

    @Query("select new com.mnsd.social.dto.PostsDto(p,u) from Posts p left join User u on p.postedBy=u.userId where  p.isAbusive=?1 order by p.postedOn desc ")
    List<PostsDto> findByIsAbusive(boolean b);

    @Transactional
    @Modifying
    @Query("update Posts p set p.isAbusive=true where p.postId=?1")
    boolean repostAbusive(Integer valueOf);

    @Transactional
    @Modifying
    @Query("update Posts p set p.isAbusive=false where p.postId=?1")
    boolean repostNotAbusive(Integer valueOf);
}
