package com.aws.avidfullstack.model;

public class UserRequest {
    String mailId;
    String mobileNumber;
    String name;

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(mailId).append(",").append(mobileNumber).append(",").append(name).append("\n");
        return sb.toString();
    }
}
