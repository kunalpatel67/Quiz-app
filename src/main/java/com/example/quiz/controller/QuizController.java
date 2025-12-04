package com.example.quiz.controller;


import com.example.quiz.model.*;
import com.example.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("start")
    public QuizSession startQuiz(@RequestBody StartQuizDTO req) {
        return quizService.startQuiz(req.getUserName());
    }

    @PostMapping("question")
    public Object getQuestion(@RequestBody SessionDTO req) {
        try {
            return quizService.getRandomQuestion(req.getSessionId());
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PostMapping("submit")
    public String submitAnswer(@RequestBody SubmitAnswerDTO req) {
        return quizService.submitAnswer(req.getSessionId(),req.getQueId(),req.getAnswer());
    }

    @PostMapping("result")
    public Object getResult(@RequestBody ResultDTO req) {
        return quizService.getResult(req.getSessionId());
    }
}
