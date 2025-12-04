package com.example.quiz.model;

import jakarta.persistence.*;

@Entity
@Table (name = "quiz_session")
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int sessionId;

    @Column
    private String userName;

    @Column
    private int score = 0;

    @Column
    private int totalQuestions = 5;

    @Column
    private int answered = 0;

    public QuizSession() {}

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getAnswered() {
        return answered;
    }

    public void setAnswered(int answered) {
        this.answered = answered;
    }
}
