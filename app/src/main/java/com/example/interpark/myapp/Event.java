package com.example.interpark.myapp;

import java.io.Serializable;

public class Event implements Serializable {
    private String title;
    private String body;
    private boolean checked;

    public Event(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
