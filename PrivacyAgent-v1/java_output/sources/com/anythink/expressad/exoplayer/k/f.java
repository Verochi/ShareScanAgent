package com.anythink.expressad.exoplayer.k;

/* loaded from: classes12.dex */
public final class f {
    private boolean a;

    private synchronized boolean a(long j) {
        boolean z;
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j2 = j + elapsedRealtime;
        while (true) {
            z = this.a;
            if (z || elapsedRealtime >= j2) {
                break;
            }
            wait(j2 - elapsedRealtime);
            elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        }
        return z;
    }

    public final synchronized boolean a() {
        if (this.a) {
            return false;
        }
        this.a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean b() {
        boolean z;
        z = this.a;
        this.a = false;
        return z;
    }

    public final synchronized void c() {
        while (!this.a) {
            wait();
        }
    }
}
