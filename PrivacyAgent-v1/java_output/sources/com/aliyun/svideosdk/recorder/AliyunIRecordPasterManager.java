package com.aliyun.svideosdk.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIRecordPasterManager {
    com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController addFacePaster(com.aliyun.svideosdk.common.struct.project.Source source);

    com.aliyun.svideosdk.recorder.impl.AliyunRecordWaterMarkController addImage(com.aliyun.svideosdk.common.struct.project.Source source);

    com.aliyun.svideosdk.recorder.impl.AliyunRecordPasterController addPaster(com.aliyun.svideosdk.common.struct.project.Source source);

    void remove(com.aliyun.svideosdk.recorder.impl.a aVar);
}
