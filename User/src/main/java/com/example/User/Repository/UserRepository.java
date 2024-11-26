package com.example.User.Repository;

import com.example.User.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findByEmail(String email);
    public List<UserEntity> findByName(String name); //considering people with the same name
    public UserEntity findByPhone(String phone);
    public UserEntity findByRut(String rut);
}
