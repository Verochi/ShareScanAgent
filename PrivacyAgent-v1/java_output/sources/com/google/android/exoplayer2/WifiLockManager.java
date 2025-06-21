package com.google.android.exoplayer2;

/* loaded from: classes22.dex */
final class WifiLockManager {

    @androidx.annotation.Nullable
    public final android.net.wifi.WifiManager a;

    @androidx.annotation.Nullable
    public android.net.wifi.WifiManager.WifiLock b;
    public boolean c;
    public boolean d;

    public WifiLockManager(android.content.Context context) {
        this.a = (android.net.wifi.WifiManager) context.getApplicationContext().getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
    }

    public void a(boolean z) {
        if (z && this.b == null) {
            android.net.wifi.WifiManager wifiManager = this.a;
            if (wifiManager == null) {
                com.google.android.exoplayer2.util.Log.w("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                android.net.wifi.WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.b = createWifiLock;
                createWifiLock.setReferenceCounted(false);
            }
        }
        this.c = z;
        c();
    }

    public void b(boolean z) {
        this.d = z;
        c();
    }

    public final void c() {
        android.net.wifi.WifiManager.WifiLock wifiLock = this.b;
        if (wifiLock == null) {
            return;
        }
        if (this.c && this.d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
