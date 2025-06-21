package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public interface HandlerWrapper {
    android.os.Looper getLooper();

    android.os.Message obtainMessage(int i);

    android.os.Message obtainMessage(int i, int i2, int i3);

    android.os.Message obtainMessage(int i, int i2, int i3, @androidx.annotation.Nullable java.lang.Object obj);

    android.os.Message obtainMessage(int i, @androidx.annotation.Nullable java.lang.Object obj);

    boolean post(java.lang.Runnable runnable);

    boolean postDelayed(java.lang.Runnable runnable, long j);

    void removeCallbacksAndMessages(@androidx.annotation.Nullable java.lang.Object obj);

    void removeMessages(int i);

    boolean sendEmptyMessage(int i);

    boolean sendEmptyMessageAtTime(int i, long j);
}
