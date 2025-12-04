package com.example.quiz.controller;


import com.example.quiz.model.Question;
import com.example.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("addAllQue")
    public List<Question> addAll(@RequestBody List<Question> questions){
        return questionService.addAll(questions);
    }
}
