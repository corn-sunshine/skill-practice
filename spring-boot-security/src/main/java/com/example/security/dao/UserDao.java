package com.example.security.dao;

import com.example.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/11/25
 * @Version: 1.0
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findUserByUsername(String username);

}