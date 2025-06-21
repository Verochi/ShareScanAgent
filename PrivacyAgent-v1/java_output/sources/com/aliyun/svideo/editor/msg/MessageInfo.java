package com.aliyun.svideo.editor.msg;

/* loaded from: classes12.dex */
public class MessageInfo {
    public static final int MSG_BACKGROUND = 1;
    public static final int MSG_HANDLER = 3;
    public static final int MSG_SYNC = 2;
    private int mId;
    private java.lang.Class<?> mMessageBody;
    private int mMsgId;
    private int mMsgType;

    public boolean equals(java.lang.Object obj) {
        if (obj == null || !(obj instanceof com.aliyun.svideo.editor.msg.MessageInfo)) {
            return false;
        }
        com.aliyun.svideo.editor.msg.MessageInfo messageInfo = (com.aliyun.svideo.editor.msg.MessageInfo) obj;
        return messageInfo.mId == this.mId && messageInfo.mMsgId == this.mMsgId && messageInfo.mMsgType == this.mMsgType && messageInfo.getMessageBody().getName() == this.mMessageBody.getName();
    }

    public int getId() {
        return this.mId;
    }

    public java.lang.Class<?> getMessageBody() {
        return this.mMessageBody;
    }

    public int getMsgId() {
        return this.mMsgId;
    }

    public int getMsgType() {
        return this.mMsgType;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setMessageBody(java.lang.Class<?> cls) {
        this.mMessageBody = cls;
    }

    public void setMsgId(int i) {
        this.mMsgId = i;
    }

    public void setMsgType(int i) {
        this.mMsgType = i;
    }
}
