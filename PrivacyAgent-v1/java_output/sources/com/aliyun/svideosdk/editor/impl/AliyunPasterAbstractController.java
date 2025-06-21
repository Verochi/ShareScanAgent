package com.aliyun.svideosdk.editor.impl;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public abstract class AliyunPasterAbstractController<MODEL> extends com.aliyun.svideosdk.editor.impl.h implements com.aliyun.svideosdk.editor.AliyunIPasterController {
    protected MODEL mModel;
    protected com.aliyun.svideosdk.editor.AliyunPasterRender mRender;

    public AliyunPasterAbstractController(MODEL model, com.aliyun.svideosdk.editor.AliyunPasterRender aliyunPasterRender) {
        this.mModel = model;
        this.mRender = aliyunPasterRender;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getDuration(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getDuration(), java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getStartTime(java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(getStartTime(), java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j) {
        setDuration(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j) {
        setStartTime(j, java.util.concurrent.TimeUnit.MICROSECONDS);
    }
}
