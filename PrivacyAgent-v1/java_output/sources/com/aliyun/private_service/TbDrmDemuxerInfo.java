package com.aliyun.private_service;

/* loaded from: classes.dex */
public class TbDrmDemuxerInfo {
    private long contextAddr;
    private long createAddr;
    private long releaseAddr;

    private void setContextAddr(long j) {
        this.contextAddr = j;
    }

    private void setCreateAddr(long j) {
        this.createAddr = j;
    }

    private void setReleaseAddr(long j) {
        this.releaseAddr = j;
    }

    public long getContextAddr() {
        return this.contextAddr;
    }

    public long getCreateAddr() {
        return this.createAddr;
    }

    public long getReleaseAddr() {
        return this.releaseAddr;
    }
}
