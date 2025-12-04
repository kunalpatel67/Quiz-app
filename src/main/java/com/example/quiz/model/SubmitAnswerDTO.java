package com.example.quiz.model;

public class SubmitAnswerDTO {
    private int sessionId;
    private int queId;
    private int answer;

    public SubmitAnswerDTO(){}

    public SubmitAnswerDTO(int sessionId, int queId, int answer) {
        this.sessionId = sessionId;
        this.queId = queId;
        this.answer = answer;
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

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
