package com.techm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techm.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
