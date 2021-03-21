package com.translation.rxjava1;

import java.util.ArrayList;
import java.util.List;

class Plan {
    private int targetId;
    private String time;
    private String content;
    private List<String> actionList = new ArrayList<>();

    public Plan() {
    }

    public Plan(String time, String content) {
        this.time = time;
        this.content = content;
    }

    public Plan(int id, String time, String content) {
        this.targetId = id;
        this.time = time;
        this.content = content;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getActionList() {
        return actionList;
    }

    public void setActionList(List<String> actionList) {
        this.actionList = actionList;
    }

}
