package com.jnit.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jnit.app.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
