package com.anythink.expressad.exoplayer.scheduler;

/* loaded from: classes12.dex */
public final class b {
    private static final java.lang.String a = "RequirementsWatcher";
    private final android.content.Context b;
    private final com.anythink.expressad.exoplayer.scheduler.b.c c;
    private final com.anythink.expressad.exoplayer.scheduler.a d;
    private com.anythink.expressad.exoplayer.scheduler.b.C0206b e;
    private boolean f;
    private com.anythink.expressad.exoplayer.scheduler.b.a g;

    @androidx.annotation.RequiresApi(api = 21)
    public final class a extends android.net.ConnectivityManager.NetworkCallback {
        private a() {
        }

        public /* synthetic */ a(com.anythink.expressad.exoplayer.scheduler.b bVar, byte b) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            java.util.Objects.toString(com.anythink.expressad.exoplayer.scheduler.b.this);
            com.anythink.expressad.exoplayer.scheduler.b.this.a(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(android.net.Network network) {
            super.onLost(network);
            java.util.Objects.toString(com.anythink.expressad.exoplayer.scheduler.b.this);
            com.anythink.expressad.exoplayer.scheduler.b.this.a(false);
        }
    }

    /* renamed from: com.anythink.expressad.exoplayer.scheduler.b$b, reason: collision with other inner class name */
    public class C0206b extends android.content.BroadcastReceiver {
        private C0206b() {
        }

        public /* synthetic */ C0206b(com.anythink.expressad.exoplayer.scheduler.b bVar, byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (isInitialStickyBroadcast()) {
                return;
            }
            java.util.Objects.toString(com.anythink.expressad.exoplayer.scheduler.b.this);
            intent.getAction();
            com.anythink.expressad.exoplayer.scheduler.b.this.a(false);
        }
    }

    public interface c {
        void a();

        void b();
    }

    private b(android.content.Context context, com.anythink.expressad.exoplayer.scheduler.b.c cVar, com.anythink.expressad.exoplayer.scheduler.a aVar) {
        this.d = aVar;
        this.c = cVar;
        this.b = context.getApplicationContext();
        toString();
    }

    private void a() {
        com.anythink.expressad.exoplayer.k.a.a(android.os.Looper.myLooper());
        a(true);
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        if (this.d.a() != 0) {
            if (com.anythink.expressad.exoplayer.k.af.a >= 23) {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) this.b.getSystemService("connectivity");
                android.net.NetworkRequest build = new android.net.NetworkRequest.Builder().addCapability(16).build();
                com.anythink.expressad.exoplayer.scheduler.b.a aVar = new com.anythink.expressad.exoplayer.scheduler.b.a(this, (byte) 0);
                this.g = aVar;
                connectivityManager.registerNetworkCallback(build, aVar);
            } else {
                intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            }
        }
        if (this.d.b()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.d.c()) {
            if (com.anythink.expressad.exoplayer.k.af.a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        com.anythink.expressad.exoplayer.scheduler.b.C0206b c0206b = new com.anythink.expressad.exoplayer.scheduler.b.C0206b(this, (byte) 0);
        this.e = c0206b;
        this.b.registerReceiver(c0206b, intentFilter, null, new android.os.Handler());
        toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean a2 = this.d.a(this.b);
        if (z || a2 != this.f) {
            this.f = a2;
        }
    }

    private void b() {
        this.b.unregisterReceiver(this.e);
        this.e = null;
        if (this.g != null && com.anythink.expressad.exoplayer.k.af.a >= 21) {
            ((android.net.ConnectivityManager) this.b.getSystemService("connectivity")).unregisterNetworkCallback(this.g);
            this.g = null;
        }
        toString();
    }

    private com.anythink.expressad.exoplayer.scheduler.a c() {
        return this.d;
    }

    @android.annotation.TargetApi(23)
    private void d() {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) this.b.getSystemService("connectivity");
        android.net.NetworkRequest build = new android.net.NetworkRequest.Builder().addCapability(16).build();
        com.anythink.expressad.exoplayer.scheduler.b.a aVar = new com.anythink.expressad.exoplayer.scheduler.b.a(this, (byte) 0);
        this.g = aVar;
        connectivityManager.registerNetworkCallback(build, aVar);
    }

    private void e() {
        if (com.anythink.expressad.exoplayer.k.af.a >= 21) {
            ((android.net.ConnectivityManager) this.b.getSystemService("connectivity")).unregisterNetworkCallback(this.g);
            this.g = null;
        }
    }

    private static void f() {
    }

    private static /* synthetic */ void g() {
    }

    public final java.lang.String toString() {
        return super.toString();
    }
}
