package com.valence.vue.t1demo.bean;

public class BasicBean {
    public int tokenCode;
    public int errCode;
    public String errMsg;
    public String tokenMsg;

    public String clerkId;
    public String token;
    public String refreshToken;
    public long authTime;

    public BasicBean(int errCode, int tokenCode) {
        this.tokenCode = tokenCode;
        this.errCode = errCode;
        this.errMsg = "错误码信息: " + errCode;
        this.tokenMsg = "token 信息: " + tokenCode;
        clerkId = "admin";
        token = "token";
        refreshToken = "refreshToken";
        authTime = System.currentTimeMillis();

    }
}
