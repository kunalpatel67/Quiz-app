package com.example.quiz.model;

import jakarta.persistence.*;

@Entity
@Table (name = "submission")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int subId;

    @Column
    private int sessionId;

    @Column
    private int queId;

    @Column
    private String answer;

    @Column
    private String correct;

    public Submission(){}

    public Submission(int subId, int sessionId, int queId, String answer, String correct) {
        this.subId = subId;
        this.sessionId = sessionId;
        this.queId = queId;
        this.answer = answer;
        this.correct = correct;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getQueId() {
        return queId;
    }

    public void setQueId(int queId) {
        this.queId = queId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
