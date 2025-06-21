package com.aliyun.svideosdk.thumbnail;

/* loaded from: classes12.dex */
public interface FileThumbnailsCallback {
    void onError(int i);

    void onExit();

    void onPicAvailable(java.nio.ByteBuffer byteBuffer, long j, int i, int i2);

    void onPicError(int i, long j, boolean z);
}
