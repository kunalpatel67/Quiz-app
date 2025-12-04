package com.example.quiz.model;

public class SessionDTO {
    private int sessionId;

    public SessionDTO(){}

    public SessionDTO(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}
