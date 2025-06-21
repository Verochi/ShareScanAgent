package com.aliyun.svideosdk.multirecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface OnVideoRecordListener {
    void onClipComplete(boolean z, long j);

    void onError(int i);

    void onFinish(java.lang.String str);

    void onInitReady();

    void onMaxDuration();

    void onProgress(long j);
}
