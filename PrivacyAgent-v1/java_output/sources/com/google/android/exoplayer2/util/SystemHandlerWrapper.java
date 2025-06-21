package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
final class SystemHandlerWrapper implements com.google.android.exoplayer2.util.HandlerWrapper {
    public final android.os.Handler a;

    public SystemHandlerWrapper(android.os.Handler handler) {
        this.a = handler;
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Looper getLooper() {
        return this.a.getLooper();
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Message obtainMessage(int i) {
        return this.a.obtainMessage(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Message obtainMessage(int i, int i2, int i3) {
        return this.a.obtainMessage(i, i2, i3);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Message obtainMessage(int i, int i2, int i3, @androidx.annotation.Nullable java.lang.Object obj) {
        return this.a.obtainMessage(i, i2, i3, obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public android.os.Message obtainMessage(int i, @androidx.annotation.Nullable java.lang.Object obj) {
        return this.a.obtainMessage(i, obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean post(java.lang.Runnable runnable) {
        return this.a.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean postDelayed(java.lang.Runnable runnable, long j) {
        return this.a.postDelayed(runnable, j);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeCallbacksAndMessages(@androidx.annotation.Nullable java.lang.Object obj) {
        this.a.removeCallbacksAndMessages(obj);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public void removeMessages(int i) {
        this.a.removeMessages(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessage(int i) {
        return this.a.sendEmptyMessage(i);
    }

    @Override // com.google.android.exoplayer2.util.HandlerWrapper
    public boolean sendEmptyMessageAtTime(int i, long j) {
        return this.a.sendEmptyMessageAtTime(i, j);
    }
}
