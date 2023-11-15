package com.Foodease.FoodeaseApp.dao;

import com.Foodease.FoodeaseApp.POJO.User;
import com.Foodease.FoodeaseApp.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {

    User findByEmailId(@Param("email") String email);

    List<UserWrapper> getAllUser();
}
