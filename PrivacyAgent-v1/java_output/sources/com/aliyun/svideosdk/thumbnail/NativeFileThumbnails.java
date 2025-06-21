package com.aliyun.svideosdk.thumbnail;

/* loaded from: classes12.dex */
public class NativeFileThumbnails extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader {
    public static native long alivcNativeCreate();

    public static native int alivcNativeInit(long j, java.lang.String str, long j2, long j3);

    public static native int alivcNativeRelease(long j);

    public static native int alivcNativeRequest(long j, long j2, int i, int i2, int i3, int i4, int i5, java.lang.Object obj);

    public static native synchronized void nativeAddPicTime(long[] jArr, int i, long j);

    public static native synchronized void nativeCancel(long j);

    public static native synchronized long nativeInit();

    public static native synchronized long nativePrepare(java.lang.String str, com.aliyun.svideosdk.thumbnail.FileThumbnailsCallback fileThumbnailsCallback, long j);

    public static native synchronized void nativeRelease(long j, long j2);

    public static native synchronized void nativeSetCutSize(int i, int i2, int i3, int i4, int i5, long j);

    public static native synchronized int nativeSetDstSize(int i, int i2, long j);

    public static native synchronized int nativeSetFastMode(boolean z, long j);

    public static native synchronized void nativeStart(long j);
}
