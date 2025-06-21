package com.aliyun.svideosdk.multirecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIBaseCapture {
    int captureId();

    void removeBorder();

    void setBorderParam(com.aliyun.svideosdk.common.struct.common.AliyunBorderParam aliyunBorderParam);

    int setProperty(java.lang.String str, java.lang.String str2);

    void updateLayout(com.aliyun.svideosdk.common.struct.common.AliyunLayoutParam aliyunLayoutParam);
}
