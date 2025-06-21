package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class m2 {

    @android.annotation.SuppressLint({"NewApi"})
    public class a extends android.net.ConnectivityManager.NetworkCallback {
        public android.net.ConnectivityManager a;
        public com.zx.a.I8b7.m2.b b;
        public java.util.TimerTask d;
        public final java.util.concurrent.atomic.AtomicBoolean e = new java.util.concurrent.atomic.AtomicBoolean(false);
        public java.util.Timer c = new java.util.Timer();

        /* renamed from: com.zx.a.I8b7.m2$a$a, reason: collision with other inner class name */
        public class C0538a extends java.util.TimerTask {
            public C0538a(com.zx.a.I8b7.m2 m2Var) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    com.zx.a.I8b7.m2.b bVar = com.zx.a.I8b7.m2.a.this.b;
                    if (bVar != null) {
                        bVar.a(1, "time out 7s!");
                    }
                } catch (java.lang.Throwable th) {
                    com.zx.a.I8b7.r2.a(th);
                }
            }
        }

        public a(com.zx.a.I8b7.m2 m2Var, android.net.ConnectivityManager connectivityManager, com.zx.a.I8b7.m2.b bVar) {
            this.a = connectivityManager;
            this.b = bVar;
            com.zx.a.I8b7.m2.a.C0538a c0538a = new com.zx.a.I8b7.m2.a.C0538a(m2Var);
            this.d = c0538a;
            this.c.schedule(c0538a, 7000L);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            try {
                if (this.e.getAndSet(true)) {
                    return;
                }
                this.d.cancel();
                this.c.cancel();
                this.b.a(network);
                this.a.unregisterNetworkCallback(this);
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
                com.zx.a.I8b7.m2.b bVar = this.b;
                if (bVar != null) {
                    try {
                        bVar.a(1, th.getMessage());
                        this.a.unregisterNetworkCallback(this);
                    } catch (java.lang.Throwable th2) {
                        com.zx.a.I8b7.r2.a(th2);
                    }
                }
            }
        }
    }

    public interface b {
        void a();

        void a(int i, java.lang.String str);

        void a(android.net.Network network);
    }

    public static final class c {
        public static final com.zx.a.I8b7.m2 a = new com.zx.a.I8b7.m2();
    }

    public void a(com.zx.a.I8b7.m2.b bVar) throws java.lang.Throwable {
        boolean a2 = com.zx.a.I8b7.w3.a(com.zx.a.I8b7.m3.a, "android.permission.ACCESS_WIFI_STATE", false);
        boolean a3 = com.zx.a.I8b7.w3.a(com.zx.a.I8b7.m3.a, "android.permission.CHANGE_NETWORK_STATE", false);
        if (a2 && a3 && a(com.zx.a.I8b7.m3.a)) {
            if (!b(com.zx.a.I8b7.m3.a)) {
                bVar.a();
                return;
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.zx.a.I8b7.m3.a.getSystemService("connectivity");
            android.net.NetworkRequest.Builder builder = new android.net.NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            connectivityManager.requestNetwork(builder.build(), new com.zx.a.I8b7.m2.a(this, connectivityManager, bVar));
        }
    }

    public boolean a(android.content.Context context) {
        try {
            if (android.os.Build.VERSION.SDK_INT < 24) {
                return true;
            }
            android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
            return ((java.lang.Boolean) telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new java.lang.Class[0]).invoke(telephonyManager, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception unused) {
            return true;
        }
    }

    public boolean b(android.content.Context context) {
        if (((android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI)).isWifiEnabled()) {
            android.net.wifi.WifiManager wifiManager = (android.net.wifi.WifiManager) context.getSystemService(com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI);
            android.net.wifi.WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (wifiManager.isWifiEnabled() && (connectionInfo == null ? 0 : connectionInfo.getIpAddress()) != 0) {
                return true;
            }
        }
        return false;
    }
}
