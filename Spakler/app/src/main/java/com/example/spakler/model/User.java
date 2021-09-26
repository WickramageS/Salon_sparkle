package com.example.spakler.model;

public class User {

    private String userID;

    private String userName;

    private String userEmail;

    private String userContact;

    private String userPassword;


    public User() {
    }

    public User(String userID, String userName, String userEmail, String userContact, String userPassword) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userContact = userContact;
        this.userPassword = userPassword;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
