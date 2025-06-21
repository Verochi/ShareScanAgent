package com.aliyun.svideo.editor.msg;

/* loaded from: classes12.dex */
public class Message<T> {
    private com.aliyun.svideo.editor.msg.MessageHandler mHandler;
    private com.aliyun.svideo.editor.msg.MessageInfo mInfo;
    private T mMessageBody;

    public Message(com.aliyun.svideo.editor.msg.MessageInfo messageInfo, T t, com.aliyun.svideo.editor.msg.MessageHandler messageHandler) {
        this.mInfo = messageInfo;
        this.mMessageBody = t;
        this.mHandler = messageHandler;
    }

    public com.aliyun.svideo.editor.msg.MessageHandler getHandler() {
        return this.mHandler;
    }

    public com.aliyun.svideo.editor.msg.MessageInfo getInfo() {
        return this.mInfo;
    }

    public T getMessageBody() {
        return this.mMessageBody;
    }

    public void setInfo(com.aliyun.svideo.editor.msg.MessageInfo messageInfo) {
        this.mInfo = messageInfo;
    }

    public void setMessageBody(T t) {
        this.mMessageBody = t;
    }
}
