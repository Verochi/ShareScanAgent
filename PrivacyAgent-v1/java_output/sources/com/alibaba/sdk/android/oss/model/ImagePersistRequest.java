package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ImagePersistRequest extends com.alibaba.sdk.android.oss.model.OSSRequest {
    public java.lang.String mAction;
    public java.lang.String mFromBucket;
    public java.lang.String mFromObjectkey;
    public java.lang.String mToBucketName;
    public java.lang.String mToObjectKey;

    public ImagePersistRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.mFromBucket = str;
        this.mFromObjectkey = str2;
        this.mToBucketName = str3;
        this.mToObjectKey = str4;
        this.mAction = str5;
    }
}
