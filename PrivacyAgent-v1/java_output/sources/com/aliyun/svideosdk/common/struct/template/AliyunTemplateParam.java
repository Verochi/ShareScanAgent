package com.aliyun.svideosdk.common.struct.template;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunTemplateParam {

    @com.google.gson.annotations.SerializedName("Lock")
    private boolean mLock;

    @com.google.gson.annotations.SerializedName("NodeKey")
    private java.lang.String mNodeKey;
    private transient java.lang.Object mTarget;
    private transient float mTimelineIn;
    private transient float mTimelineOut;
    private transient com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type mType;

    public enum Type {
        text,
        image,
        video
    }

    public java.lang.String getNodeKey() {
        return this.mNodeKey;
    }

    public java.lang.Object getTarget() {
        return this.mTarget;
    }

    public float getTimelineIn() {
        return this.mTimelineIn;
    }

    public float getTimelineOut() {
        return this.mTimelineOut;
    }

    public com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type getType() {
        return this.mType;
    }

    public boolean isLock() {
        return this.mLock;
    }

    public void setLock(boolean z) {
        this.mLock = z;
    }

    public void setNodeKey(java.lang.String str) {
        this.mNodeKey = str;
    }

    public void setTarget(java.lang.Object obj) {
        this.mTarget = obj;
    }

    public void setTimelineIn(float f) {
        this.mTimelineIn = f;
    }

    public void setTimelineOut(float f) {
        this.mTimelineOut = f;
    }

    public void setType(com.aliyun.svideosdk.common.struct.template.AliyunTemplateParam.Type type) {
        this.mType = type;
    }
}
