package com.example.interpark.myapp;

import java.io.Serializable;

public class Event implements Serializable {
    private String title;
    private boolean checked;

    public Event(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
