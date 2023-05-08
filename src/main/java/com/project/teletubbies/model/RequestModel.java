package com.project.teletubbies.model;

import com.project.teletubbies.model.SessionInfo;

public class RequestModel {

    //인증된 사용자 정보를 저장합니다.
    private SessionInfo sessionInfo;

    //요청 데이터를 저장합니다.
    private Object data;

    public SessionInfo getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(SessionInfo sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}