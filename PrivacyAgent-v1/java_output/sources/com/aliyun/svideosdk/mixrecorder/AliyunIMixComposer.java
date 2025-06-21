package com.aliyun.svideosdk.mixrecorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIMixComposer {
    int cancel();

    com.aliyun.svideosdk.mixrecorder.AliyunMixTrack createTrack(com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam aliyunMixTrackLayoutParam);

    int pause();

    int release();

    int resume();

    int setBackgroundColor(int i);

    int setBackgroundImage(android.graphics.Bitmap bitmap, int i);

    int setBackgroundImage(java.lang.String str, int i);

    int setOutputParam(com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam aliyunMixOutputParam);

    int start(com.aliyun.svideosdk.mixrecorder.AliyunMixCallback aliyunMixCallback);
}
