package com.niraj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niraj.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
