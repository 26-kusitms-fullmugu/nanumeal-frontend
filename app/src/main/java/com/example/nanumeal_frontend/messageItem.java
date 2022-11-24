package com.example.nanumeal_frontend;

public class messageItem {

    String icon_state; //icon 상태(행복해요)
    String message; //message


    int resourceId; //icon_image

    public messageItem(String icon_state, String message, int resourceId)
    {
        this.icon_state = icon_state;
        this.message = message;
        this.resourceId = resourceId;
    }

    public String getIconState() {
        return icon_state;
    }

    public String getMessage() {
        return message;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setIcon_state(String icon_state) {
        this.icon_state = icon_state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }



}
