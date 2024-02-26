package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
