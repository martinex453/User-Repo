package com.example.User.Service;

import com.example.User.Entity.UserEntity;
import com.example.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers() { return (ArrayList<UserEntity>) userRepository.findAll(); }

    public UserEntity getUserById(Long id){return userRepository.findById(id).get(); }

    public UserEntity getUserByEmail(String email){ return userRepository.findByEmail(email); }

    public UserEntity getUserByPhone(String phone){ return userRepository.findByPhone(phone); }

    public List<UserEntity> getUserByName(String name){ return userRepository.findByName(name); }

    public UserEntity saveUser(UserEntity user){
        if(user == null) return null;
        UserEntity exist_user1 = userRepository.findByEmail(user.getEmail());
        UserEntity exist_user2 = userRepository.findByRut(user.getRut());
        if(exist_user1 == null && exist_user2 == null) {
            return userRepository.save(user);
        }
        else{
            return null;
        }
    }

    public UserEntity updateUser(UserEntity user){
        if(user == null) return null;
        return userRepository.save(user); }

    public boolean deleteUser(Long id) throws Exception {
        try{
            userRepository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Long login(String email, String password){
        UserEntity user = userRepository.findByEmail(email);
        if(user == null){
            return 0L;
        }
        if(!user.getPassword().equals(password)){
            return 0L;
        }
        else{
            return user.getId();
        }
    }
}
