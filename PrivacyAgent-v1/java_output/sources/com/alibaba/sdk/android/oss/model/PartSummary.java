package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class PartSummary {
    private java.lang.String eTag;
    private java.util.Date lastModified;
    private int partNumber;
    private long size;

    public java.lang.String getETag() {
        return this.eTag;
    }

    public java.util.Date getLastModified() {
        return this.lastModified;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getSize() {
        return this.size;
    }

    public void setETag(java.lang.String str) {
        this.eTag = str;
    }

    public void setLastModified(java.util.Date date) {
        this.lastModified = date;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public void setSize(long j) {
        this.size = j;
    }
}
