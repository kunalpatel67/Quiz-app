package com.example.quiz.repository;

import com.example.quiz.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepo extends JpaRepository<Submission,Integer> {

}
