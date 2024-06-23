package com.codeground.codeground.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeground.codeground.Models.UserModel.UserModel;

@Repository
public interface UsersDao extends JpaRepository<UserModel, Integer> {
    UserModel findByEmailId(String emailId);
}
