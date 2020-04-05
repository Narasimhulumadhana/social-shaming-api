package com.mnsd.social.service;

import com.mnsd.social.dto.UserLoginDto;
import com.mnsd.social.model.User;
import com.mnsd.social.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
       return userRepository.save(user);
    }

    public User loginUser(UserLoginDto user) {
        return userRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
    }

    public boolean isUserExists(Integer postedBy) {
        return this.userRepository.findById(postedBy).isPresent();
    }

    public List<User> findAllUsers(List<Integer> userIds) {
        return this.userRepository.findAllById(userIds);
    }

    public List<User> findRandomUsers(String userId) {
        return this.userRepository.findRandomUsersByUser(Integer.valueOf(userId), PageRequest.of(0,10));
    }

    public void setSocialScore(Integer userId) {
        Optional<User> user=this.userRepository.findById(userId);
        if(user.isPresent()){
            User u=user.get();
            u.setSocialScore(u.getSocialScore()-1);
            this.userRepository.save(u);
        }
    }
}
