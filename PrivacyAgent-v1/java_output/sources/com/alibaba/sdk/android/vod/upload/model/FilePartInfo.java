package com.alibaba.sdk.android.vod.upload.model;

/* loaded from: classes.dex */
public class FilePartInfo {
    private int mPartNumber;
    private long mSeek;
    private long mSize;

    public int getPartNumber() {
        return this.mPartNumber;
    }

    public long getSeek() {
        return this.mSeek;
    }

    public long getSize() {
        return this.mSize;
    }

    public void setPartNumber(int i) {
        this.mPartNumber = i;
    }

    public void setSeek(long j) {
        this.mSeek = j;
    }

    public void setSize(long j) {
        this.mSize = j;
    }
}
