package com.example.quiz.service;

import com.example.quiz.model.*;
import com.example.quiz.repository.QuestionRepo;
import com.example.quiz.repository.QuizSessionRepo;
import com.example.quiz.repository.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {
    @Autowired
    QuizSessionRepo quizSessionRepo;

    @Autowired
    QuestionRepo questionRepo;

    @Autowired
    SubmissionRepo submissionRepo;

    public QuizSession startQuiz(String userName) {
        QuizSession session = new QuizSession();
        session.setUserName(userName);
        return quizSessionRepo.save(session);
    }

    public QuestionDTO getRandomQuestion(int sessionId) {
        QuizSession session = quizSessionRepo.findById(sessionId).orElse(null);

        if (session == null) return null;

        if (session.getAnswered() >= session.getTotalQuestions()) {
            throw new RuntimeException("Quiz already completed for this sessionId");
        }

        Question q = questionRepo.getRandomQuestion(sessionId);

        if (q == null) return null;

        return new QuestionDTO(
                q.getQueId(),
                q.getQuestion(),
                q.getOption1(),
                q.getOption2(),
                q.getOption3(),
                q.getOption4()
        );
    }

    public String submitAnswer(int sessionId, int qid, int answer) {
        QuizSession session = quizSessionRepo.findById(sessionId).orElse(null);
        Question q = questionRepo.findById(qid).orElse(null);

        String userAnswer;
        switch (answer) {
            case 1 -> userAnswer = q.getOption1();
            case 2 -> userAnswer = q.getOption2();
            case 3 -> userAnswer = q.getOption3();
            case 4 -> userAnswer = q.getOption4();
            default -> throw new RuntimeException("Invalid option number, should be 1-4");
        }

        boolean isCorrect = userAnswer.equalsIgnoreCase(q.getCorrectAnswer());

        Submission sub = new Submission();
        sub.setSessionId(sessionId);
        sub.setQueId(qid);
        sub.setAnswer(userAnswer);
        sub.setCorrect(isCorrect ? "YES" : "NO");

        submissionRepo.save(sub);

        if (isCorrect) {
            session.setScore(session.getScore() + 1);
        }

        session.setAnswered(session.getAnswered() + 1);
        quizSessionRepo.save(session);

        if (session.getAnswered() >= session.getTotalQuestions()) {
            return "Quiz Completed";
        }

        return "Answer Submitted";
    }

    public Object getResult(int sessionId) {
        QuizSession session = quizSessionRepo.findById(sessionId).orElseThrow();

        int correct = session.getScore();
        int total = session.getTotalQuestions();
        int incorrect = total - correct;

        return Map.of(
                "total", total,
                "correct", correct,
                "incorrect", incorrect
        );
    }
}
