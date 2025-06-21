package com.aliyun.svideosdk.editor;

/* loaded from: classes12.dex */
public interface b {
    int addAnimationEff(java.lang.String str, long j, long j2, java.lang.String str2);

    int addCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption);

    int addGifTextView(java.lang.String str, float f, float f2, float f3, float f4, float f5, boolean z, long j, long j2, boolean z2, com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, float f6, float f7, float f8, float f9, float f10, int i, int i2, long j3, long j4, boolean z3, long j5);

    int addGifView(java.lang.String str, float f, float f2, float f3, float f4, float f5, boolean z, long j, long j2, boolean z2);

    int addImgView(android.graphics.Bitmap bitmap, float f, float f2, float f3, float f4, float f5, long j, long j2, boolean z, long j3, int i);

    int addImgView(com.aliyun.svideosdk.nativerender.BitmapGenerator bitmapGenerator, float f, float f2, float f3, float f4, float f5, int i, int i2, long j, long j2, boolean z, long j3);

    int addImgView(java.lang.String str, float f, float f2, float f3, float f4, float f5, long j, long j2, boolean z, long j3, int i);

    int deleteView(int i, int i2);

    java.util.List<com.aliyun.svideosdk.common.AliyunCaption> findCaptions(long j);

    int removeCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption);

    int updateAnimationEff(int i, long j, long j2, java.lang.String str);

    int updateCaption(com.aliyun.svideosdk.common.AliyunCaption aliyunCaption);

    int updateTransition(int i, java.lang.String str);
}
