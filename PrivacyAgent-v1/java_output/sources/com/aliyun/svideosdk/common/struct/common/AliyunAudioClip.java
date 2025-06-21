package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunAudioClip {
    private long mEndTime;
    private java.lang.String mFilePath;
    private int mId;
    private long mStartTime;

    public AliyunAudioClip(int i, long j, java.lang.String str) {
        this.mId = i;
        this.mStartTime = j;
        this.mFilePath = str + ".aac";
    }

    public long getDuration() {
        return this.mEndTime - this.mStartTime;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public java.lang.String getFilePath() {
        return this.mFilePath;
    }

    public int getId() {
        return this.mId;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public void setEndTime(long j) {
        this.mEndTime = j;
    }

    public void setFilePath(java.lang.String str) {
        this.mFilePath = str;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public java.lang.String toString() {
        return "AliyunAudioClip{mId=" + this.mId + ", mStartTime=" + this.mStartTime + ", mEndTime=" + this.mEndTime + ", mPcmFilePath='" + this.mFilePath + "'}";
    }
}
