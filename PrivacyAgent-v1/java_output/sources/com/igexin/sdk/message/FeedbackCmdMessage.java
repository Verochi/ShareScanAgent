package com.igexin.sdk.message;

/* loaded from: classes23.dex */
public class FeedbackCmdMessage extends com.igexin.sdk.message.GTCmdMessage {
    private java.lang.String actionId;
    private java.lang.String result;
    private java.lang.String taskId;
    private long timeStamp;

    public FeedbackCmdMessage() {
    }

    public FeedbackCmdMessage(java.lang.String str, java.lang.String str2, java.lang.String str3, long j, int i) {
        super(i);
        this.taskId = str;
        this.actionId = str2;
        this.result = str3;
        this.timeStamp = j;
    }

    public java.lang.String getActionId() {
        return this.actionId;
    }

    public java.lang.String getResult() {
        return this.result;
    }

    public java.lang.String getTaskId() {
        return this.taskId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setActionId(java.lang.String str) {
        this.actionId = str;
    }

    public void setResult(java.lang.String str) {
        this.result = str;
    }

    public void setTaskId(java.lang.String str) {
        this.taskId = str;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }
}
