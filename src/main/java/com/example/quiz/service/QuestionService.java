package com.example.quiz.service;

import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    public List<Question> addAll(List<Question> questions) {
        return questionRepo.saveAll(questions);
    }
}
