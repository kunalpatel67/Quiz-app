package com.example.quiz.repository;

import com.example.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepo extends JpaRepository<Question,Integer> {
    @Query(value = "SELECT * FROM question WHERE que_id NOT IN " +
            "(SELECT que_id FROM submission WHERE session_id = :sid) ORDER BY RAND() LIMIT 1",
            nativeQuery = true)
    Question getRandomQuestion(@Param("sid") int sessionId);
}
