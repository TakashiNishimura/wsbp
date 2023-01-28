package com.example.wsbp.data;

import java.io.Serializable;

public class Chat implements Serializable {

    private String userName;
    private String msgBody;

    public Chat() {
        userName = "";
        msgBody = "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

}
