package com.example.demo.service;

import com.example.demo.entity.UserProfile;
import com.example.demo.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepository userProfileRepository;

    public void create(UserProfile userProfile){
        userProfileRepository.save(userProfile);
    }

    public List<UserProfile> findAll(){
        return userProfileRepository.findAll();
    }

    public UserProfile find(Long id){
        return userProfileRepository.getOne(id);
    }

    public void delete(Long id){ userProfileRepository.deleteById(id); }

}
