package com.tanx.exposer.tanxc_do.tanxc_if;

/* loaded from: classes19.dex */
public class tanxc_do {
    public android.content.Context a;
    public java.util.List<com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.InterfaceC0493tanxc_do> b;
    public android.net.ConnectivityManager c;
    public int d;
    public int e;
    public final android.content.BroadcastReceiver f;

    @android.annotation.TargetApi(21)
    public android.net.ConnectivityManager.NetworkCallback g;

    /* renamed from: com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do$1, reason: invalid class name */
    public class AnonymousClass1 extends android.content.BroadcastReceiver {
        public AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            java.lang.String action = intent.getAction();
            if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "onReceive: action = " + action);
            }
            if (android.text.TextUtils.equals(action, com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.b();
                com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do tanxc_doVar = com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this;
                if (tanxc_doVar.d != tanxc_doVar.e) {
                    tanxc_doVar.a();
                    com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do tanxc_doVar2 = com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this;
                    tanxc_doVar2.d = tanxc_doVar2.e;
                }
            }
        }
    }

    /* renamed from: com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do$2, reason: invalid class name */
    public class AnonymousClass2 extends android.net.ConnectivityManager.NetworkCallback {
        public AnonymousClass2() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(android.net.Network network, android.net.NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(16)) {
                if (networkCapabilities.hasTransport(1)) {
                    com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.e = 1;
                } else if (networkCapabilities.hasTransport(0)) {
                    com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.b();
                } else if (networkCapabilities.hasTransport(3)) {
                    com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.e = 9;
                }
            }
            if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "onCapabilitiesChanged: cap = " + networkCapabilities + ", network = " + network + ", currentType = " + com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.e + ", prevType = " + com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.d);
            }
            com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do tanxc_doVar = com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this;
            if (tanxc_doVar.d != tanxc_doVar.e) {
                tanxc_doVar.a();
                com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do tanxc_doVar2 = com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this;
                tanxc_doVar2.d = tanxc_doVar2.e;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(android.net.Network network) {
            super.onLost(network);
            if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "onLost: currentType = " + com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.e + ", prev = " + com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.d + ", network = " + network);
            }
            com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this.b();
            com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do tanxc_doVar = com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this;
            if (tanxc_doVar.d != tanxc_doVar.e) {
                tanxc_doVar.a();
                com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do tanxc_doVar2 = com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.this;
                tanxc_doVar2.d = tanxc_doVar2.e;
            }
        }
    }

    /* renamed from: com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do$tanxc_do, reason: collision with other inner class name */
    public interface InterfaceC0493tanxc_do {
        void tanxc_do(int i);
    }

    public static class tanxc_if {
        public static final com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do tanxc_do = new com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do((byte) 0);
    }

    public tanxc_do() {
        this.d = -1;
        this.e = -1;
        this.f = new com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.AnonymousClass1();
        this.a = com.tanx.exposer.tanxc_for.tanxc_do().tanxc_for();
        this.b = new java.util.LinkedList();
        try {
            this.c = (android.net.ConnectivityManager) this.a.getSystemService("connectivity");
        } catch (java.lang.Exception e) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "get ConnectivityManager exception", e);
        }
        c();
        b();
    }

    public /* synthetic */ tanxc_do(byte b) {
        this();
    }

    public synchronized void a() {
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "notifyNetworkStateChanged: mPrevNetworkType = " + this.d + ", mCurrentNetworkType = " + this.e);
        }
        java.util.Iterator<com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.InterfaceC0493tanxc_do> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().tanxc_do(this.e);
        }
    }

    public void b() {
        android.net.NetworkInfo networkInfo;
        try {
            networkInfo = this.c.getActiveNetworkInfo();
        } catch (java.lang.Exception e) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "getActiveNetworkType exception.", e);
            networkInfo = null;
        }
        if (networkInfo == null) {
            this.e = -1;
            if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
                com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "getActiveNetworkType with null network info.");
                return;
            }
            return;
        }
        if (networkInfo.getType() == 1 && networkInfo.isConnected()) {
            this.e = 1;
        } else if (networkInfo.getType() == 0 && networkInfo.isConnected()) {
            this.e = 0;
        } else if (networkInfo.getType() == 9 && networkInfo.isConnected()) {
            this.e = 9;
        } else {
            this.e = -1;
        }
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "getActiveNetworkType: mPrevNetworkType = " + this.d + ", mCurrentNetworkType = " + this.e + ", networkInfo = " + networkInfo);
        }
    }

    public final void c() {
        try {
            if (android.os.Build.VERSION.SDK_INT < 23) {
                android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                this.a.registerReceiver(this.f, intentFilter);
            } else {
                android.net.NetworkRequest build = new android.net.NetworkRequest.Builder().build();
                if (this.g == null) {
                    this.g = new com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.AnonymousClass2();
                }
                this.c.registerNetworkCallback(build, this.g);
            }
        } catch (java.lang.Throwable th) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "registerNetworkState exception.", th);
        }
    }

    public synchronized void tanxc_do(com.tanx.exposer.tanxc_do.tanxc_if.tanxc_do.InterfaceC0493tanxc_do interfaceC0493tanxc_do) {
        if (com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do) {
            com.tanx.exposer.tanxc_if.tanxc_do.tanxc_do("NetworkStateObserver", "addNetworkChangeListener: listener = " + interfaceC0493tanxc_do);
        }
        this.b.add(interfaceC0493tanxc_do);
        interfaceC0493tanxc_do.tanxc_do(this.e);
    }

    public boolean tanxc_do() {
        return this.e != -1;
    }
}
