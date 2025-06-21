package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
final class aa implements com.anythink.expressad.exoplayer.k.c {
    @Override // com.anythink.expressad.exoplayer.k.c
    public final long a() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.anythink.expressad.exoplayer.k.c
    public final com.anythink.expressad.exoplayer.k.k a(android.os.Looper looper, @androidx.annotation.Nullable android.os.Handler.Callback callback) {
        return new com.anythink.expressad.exoplayer.k.ab(new android.os.Handler(looper, callback));
    }

    @Override // com.anythink.expressad.exoplayer.k.c
    public final void a(long j) {
        android.os.SystemClock.sleep(j);
    }

    @Override // com.anythink.expressad.exoplayer.k.c
    public final long b() {
        return android.os.SystemClock.uptimeMillis();
    }
}
