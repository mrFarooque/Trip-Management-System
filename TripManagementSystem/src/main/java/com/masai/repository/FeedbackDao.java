package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Integer> {

}
