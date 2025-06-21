package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PartETag {
    private long crc64;
    private java.lang.String eTag;
    private int partNumber;
    private long partSize;

    public PartETag(int i, java.lang.String str) {
        setPartNumber(i);
        setETag(str);
    }

    public long getCRC64() {
        return this.crc64;
    }

    public java.lang.String getETag() {
        return this.eTag;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public void setCRC64(long j) {
        this.crc64 = j;
    }

    public void setETag(java.lang.String str) {
        this.eTag = str;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }
}
