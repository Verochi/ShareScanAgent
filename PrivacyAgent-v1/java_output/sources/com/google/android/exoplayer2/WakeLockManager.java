package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class WakeLockManager {

    @androidx.annotation.Nullable
    public final android.os.PowerManager a;

    @androidx.annotation.Nullable
    public android.os.PowerManager.WakeLock b;
    public boolean c;
    public boolean d;

    public WakeLockManager(android.content.Context context) {
        this.a = (android.os.PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void a(boolean z) {
        if (z && this.b == null) {
            android.os.PowerManager powerManager = this.a;
            if (powerManager == null) {
                com.google.android.exoplayer2.util.Log.w("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                android.os.PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.b = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
        }
        this.c = z;
        c();
    }

    public void b(boolean z) {
        this.d = z;
        c();
    }

    @android.annotation.SuppressLint({"WakelockTimeout"})
    public final void c() {
        android.os.PowerManager.WakeLock wakeLock = this.b;
        if (wakeLock == null) {
            return;
        }
        if (this.c && this.d) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
