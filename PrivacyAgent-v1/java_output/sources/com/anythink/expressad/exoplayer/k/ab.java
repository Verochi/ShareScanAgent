package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
final class ab implements com.anythink.expressad.exoplayer.k.k {
    private final android.os.Handler a;

    public ab(android.os.Handler handler) {
        this.a = handler;
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final android.os.Looper a() {
        return this.a.getLooper();
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final android.os.Message a(int i) {
        return this.a.obtainMessage(i);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final android.os.Message a(int i, int i2) {
        return this.a.obtainMessage(i, i2, 0);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final android.os.Message a(int i, int i2, java.lang.Object obj) {
        return this.a.obtainMessage(0, i, i2, obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final android.os.Message a(int i, java.lang.Object obj) {
        return this.a.obtainMessage(i, obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final void a(java.lang.Object obj) {
        this.a.removeCallbacksAndMessages(obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(long j) {
        return this.a.sendEmptyMessageAtTime(2, j);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(java.lang.Runnable runnable) {
        return this.a.post(runnable);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(java.lang.Runnable runnable, long j) {
        return this.a.postDelayed(runnable, j);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final void b() {
        this.a.removeMessages(2);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean b(int i) {
        return this.a.sendEmptyMessage(i);
    }
}
