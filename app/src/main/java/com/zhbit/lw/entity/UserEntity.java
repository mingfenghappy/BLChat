package com.zhbit.lw.entity;

/**
 * Created by wjh on 17-5-13.
 */

public class UserEntity {

    private String userName, userHead, userSex, userAccount, userLocation, userSign;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public UserEntity(String userName, String userHead, String userSex, String userAccount, String userLocation, String userSign) {
        this.userName = userName;
        this.userHead = userHead;
        this.userSex = userSex;
        this.userAccount = userAccount;
        this.userLocation = userLocation;
        this.userSign = userSign;
    }

}
