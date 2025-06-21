package com.google.android.exoplayer2.scheduler;

/* loaded from: classes22.dex */
public final class RequirementsWatcher {
    public final android.content.Context a;
    public final com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener b;
    public final com.google.android.exoplayer2.scheduler.Requirements c;
    public final android.os.Handler d = com.google.android.exoplayer2.util.Util.createHandlerForCurrentOrMainLooper();

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.scheduler.RequirementsWatcher.DeviceStatusChangeReceiver e;
    public int f;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.scheduler.RequirementsWatcher.NetworkCallback g;

    public class DeviceStatusChangeReceiver extends android.content.BroadcastReceiver {
        public DeviceStatusChangeReceiver() {
        }

        public /* synthetic */ DeviceStatusChangeReceiver(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher, com.google.android.exoplayer2.scheduler.RequirementsWatcher.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.e();
        }
    }

    public interface Listener {
        void onRequirementsStateChanged(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher, int i);
    }

    @androidx.annotation.RequiresApi(24)
    public final class NetworkCallback extends android.net.ConnectivityManager.NetworkCallback {
        public boolean a;
        public boolean b;

        public NetworkCallback() {
        }

        public /* synthetic */ NetworkCallback(com.google.android.exoplayer2.scheduler.RequirementsWatcher requirementsWatcher, com.google.android.exoplayer2.scheduler.RequirementsWatcher.AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.g != null) {
                com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.g != null) {
                com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.f();
            }
        }

        public final void e() {
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.d.post(new com.google.android.exoplayer2.scheduler.b(this));
        }

        public final void f() {
            com.google.android.exoplayer2.scheduler.RequirementsWatcher.this.d.post(new com.google.android.exoplayer2.scheduler.a(this));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(android.net.Network network, boolean z) {
            if (z) {
                return;
            }
            f();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(android.net.Network network, android.net.NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (this.a && this.b == hasCapability) {
                if (hasCapability) {
                    f();
                }
            } else {
                this.a = true;
                this.b = hasCapability;
                e();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(android.net.Network network) {
            e();
        }
    }

    public RequirementsWatcher(android.content.Context context, com.google.android.exoplayer2.scheduler.RequirementsWatcher.Listener listener, com.google.android.exoplayer2.scheduler.Requirements requirements) {
        this.a = context.getApplicationContext();
        this.b = listener;
        this.c = requirements;
    }

    public final void e() {
        int notMetRequirements = this.c.getNotMetRequirements(this.a);
        if (this.f != notMetRequirements) {
            this.f = notMetRequirements;
            this.b.onRequirementsStateChanged(this, notMetRequirements);
        }
    }

    public final void f() {
        if ((this.f & 3) == 0) {
            return;
        }
        e();
    }

    @androidx.annotation.RequiresApi(24)
    public final void g() {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.google.android.exoplayer2.util.Assertions.checkNotNull((android.net.ConnectivityManager) this.a.getSystemService("connectivity"));
        com.google.android.exoplayer2.scheduler.RequirementsWatcher.NetworkCallback networkCallback = new com.google.android.exoplayer2.scheduler.RequirementsWatcher.NetworkCallback(this, null);
        this.g = networkCallback;
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }

    public com.google.android.exoplayer2.scheduler.Requirements getRequirements() {
        return this.c;
    }

    @androidx.annotation.RequiresApi(24)
    public final void h() {
        ((android.net.ConnectivityManager) com.google.android.exoplayer2.util.Assertions.checkNotNull((android.net.ConnectivityManager) this.a.getSystemService("connectivity"))).unregisterNetworkCallback((android.net.ConnectivityManager.NetworkCallback) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.g));
        this.g = null;
    }

    public int start() {
        this.f = this.c.getNotMetRequirements(this.a);
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        if (this.c.isNetworkRequired()) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 24) {
                g();
            } else {
                intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            }
        }
        if (this.c.isChargingRequired()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.c.isIdleRequired()) {
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.c.isStorageNotLowRequired()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        com.google.android.exoplayer2.scheduler.RequirementsWatcher.DeviceStatusChangeReceiver deviceStatusChangeReceiver = new com.google.android.exoplayer2.scheduler.RequirementsWatcher.DeviceStatusChangeReceiver(this, null);
        this.e = deviceStatusChangeReceiver;
        this.a.registerReceiver(deviceStatusChangeReceiver, intentFilter, null, this.d);
        return this.f;
    }

    public void stop() {
        this.a.unregisterReceiver((android.content.BroadcastReceiver) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.e));
        this.e = null;
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 24 || this.g == null) {
            return;
        }
        h();
    }
}
