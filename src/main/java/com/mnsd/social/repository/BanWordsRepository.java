package com.mnsd.social.repository;

import com.mnsd.social.model.BanWords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanWordsRepository extends JpaRepository<BanWords,Integer> {
}
