package com.google.android.exoplayer2.util;

/* loaded from: classes22.dex */
public class SystemClock implements com.google.android.exoplayer2.util.Clock {
    @Override // com.google.android.exoplayer2.util.Clock
    public com.google.android.exoplayer2.util.HandlerWrapper createHandler(android.os.Looper looper, @androidx.annotation.Nullable android.os.Handler.Callback callback) {
        return new com.google.android.exoplayer2.util.SystemHandlerWrapper(new android.os.Handler(looper, callback));
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long currentTimeMillis() {
        return java.lang.System.currentTimeMillis();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public void sleep(long j) {
        android.os.SystemClock.sleep(j);
    }

    @Override // com.google.android.exoplayer2.util.Clock
    public long uptimeMillis() {
        return android.os.SystemClock.uptimeMillis();
    }
}
