package com.aliyun.svideosdk.recorder.impl;

/* loaded from: classes12.dex */
public class f implements com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager {
    private java.util.List<com.aliyun.svideosdk.recorder.impl.a> a = new java.util.ArrayList();
    protected com.aliyun.svideosdk.recorder.impl.d b;

    public f(com.aliyun.svideosdk.recorder.impl.d dVar) {
        this.b = dVar;
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager
    public com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController addFacePaster(com.aliyun.svideosdk.common.struct.project.Source source) {
        return new com.aliyun.svideosdk.recorder.impl.AliyunRecordFacePasterController(source, this.b);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager
    public com.aliyun.svideosdk.recorder.impl.AliyunRecordWaterMarkController addImage(com.aliyun.svideosdk.common.struct.project.Source source) {
        return new com.aliyun.svideosdk.recorder.impl.AliyunRecordWaterMarkController(source, this.b);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager
    public com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController addPaster(com.aliyun.svideosdk.common.struct.project.Source source) {
        return new com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController(source, this.b);
    }

    @Override // com.aliyun.svideosdk.recorder.AliyunIRecordPasterManager
    public void remove(com.aliyun.svideosdk.recorder.impl.a aVar) {
        this.a.remove(aVar);
        this.b.b(aVar);
    }
}
