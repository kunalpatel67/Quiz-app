package com.example.quiz.repository;

import com.example.quiz.model.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizSessionRepo extends JpaRepository<QuizSession,Integer> {
}
