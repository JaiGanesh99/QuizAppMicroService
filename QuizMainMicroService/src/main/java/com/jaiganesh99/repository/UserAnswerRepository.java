package com.jaiganesh99.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jaiganesh99.entity.UserAnswerEntity;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswerEntity, Integer> {

}
