package com.example.quiz.model;

public class StartQuizDTO {
    private String userName;
    private int sessionId;

    public StartQuizDTO(){}

    public StartQuizDTO(String userName,int sessionId) {
        this.userName = userName;
        this.sessionId = sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }
}
