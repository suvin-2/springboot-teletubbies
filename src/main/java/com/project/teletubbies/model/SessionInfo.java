//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.project.teletubbies.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.teletubbies.dao.TbUserInfo;

import java.io.Serializable;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class SessionInfo implements Serializable {

    private String user_id;
    private String user_pw;
    private String user_name;
    private String nickName;
    private String phone;
    private String email;
    private String user_auth;
    private TbUserInfo tbUserInfo;

    public SessionInfo() {

    }

    public TbUserInfo getTbUserInfo() {
        return this.tbUserInfo;
    }

    public void setTbUserInfo(TbUserInfo tbUserInfo) {
        this.tbUserInfo = tbUserInfo;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return this.user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_auth() {
        return this.user_auth;
    }

    public void setUser_auth(String user_auth) {
        this.user_auth = user_auth;
    }

    public String toString() {
        return "SessionInfo(user_id=" + this.getUser_id() + ", user_pw=" + this.getUser_pw() + ", user_name=" + this.getUser_name() + ", nickName=" + this.getNickName()
                + ", phone=" + this.getPhone() + ", email=" + this.getEmail() + ", user_auth=" + this.getUser_auth() + ", tbUserInfo = " + this.getTbUserInfo() ;
    }
}
