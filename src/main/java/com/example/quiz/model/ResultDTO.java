package com.example.quiz.model;

public class ResultDTO {
    private int sessionId;

    public ResultDTO(){}

    public ResultDTO(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}
