package com.aliyun.svideosdk.player;

/* loaded from: classes12.dex */
public class NativePasterPlayer extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader {
    public native void addTimeIndex(long j, long j2, int i);

    public native void draw(long j, long j2);

    public native long initialize();

    public native void release(long j);

    public native void setSource(long j, java.lang.String str);

    public native void setWindow(long j, android.view.Surface surface);
}
