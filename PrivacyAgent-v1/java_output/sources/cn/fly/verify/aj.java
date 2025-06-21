package cn.fly.verify;

/* loaded from: classes31.dex */
public class aj {
    private static java.util.List<android.net.Network> d = new java.util.ArrayList();
    private static java.util.List<android.net.ConnectivityManager.NetworkCallback> e = new java.util.ArrayList();
    private static java.util.HashMap<java.lang.String, android.net.Network> g = new java.util.HashMap<>();
    private android.net.Network b;
    private android.net.ConnectivityManager.NetworkCallback c;
    private long f = 3000;
    public android.net.ConnectivityManager a = (android.net.ConnectivityManager) cn.fly.verify.fh.d.a("connectivity");

    /* renamed from: cn.fly.verify.aj$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends cn.fly.verify.ar {
        public AnonymousClass1() {
        }

        @Override // cn.fly.verify.ar
        public void a() {
            synchronized (cn.fly.verify.aj.g) {
                java.lang.String d = cn.fly.verify.al.d();
                try {
                    if (!cn.fly.verify.aj.g.containsKey(d)) {
                        long uptimeMillis = android.os.SystemClock.uptimeMillis();
                        cn.fly.verify.f.a().a("switchNetworkAsync ");
                        android.net.Network c = cn.fly.verify.aj.this.c();
                        if (c != null) {
                            cn.fly.verify.aj.g.put(d, c);
                        }
                        cn.fly.verify.f.a().a("switchNetworkAsync complete " + (android.os.SystemClock.uptimeMillis() - uptimeMillis));
                    }
                } catch (cn.fly.verify.common.exception.VerifyException unused) {
                }
            }
        }
    }

    /* renamed from: cn.fly.verify.aj$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends android.net.ConnectivityManager.NetworkCallback {
        public AnonymousClass2() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            cn.fly.verify.aj.this.b = network;
            cn.fly.verify.aj.d.add(network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(android.net.Network network) {
        }
    }

    public static void b() {
        if (e.size() > 0) {
            try {
                android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) cn.fly.verify.fh.d.a("connectivity");
                java.util.Iterator<android.net.ConnectivityManager.NetworkCallback> it = e.iterator();
                while (it.hasNext()) {
                    connectivityManager.unregisterNetworkCallback(it.next());
                }
                e.clear();
                if (d.size() > 0) {
                    d.clear();
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.f.a().b(th);
            }
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "release");
        }
    }

    public void a() {
        new cn.fly.verify.aj.AnonymousClass1().b();
    }

    public android.net.Network c() throws cn.fly.verify.common.exception.VerifyException {
        try {
            cn.fly.verify.f.a().b("[FlyVerify] ==>%s", "Force switch network");
            if (!cn.fly.verify.fh.d.b("android.permission.CHANGE_NETWORK_STATE")) {
                cn.fly.verify.common.exception.VerifyException verifyException = new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_NO_SWITCH_PERMISSION_ERR);
                cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "switch no permission");
                throw verifyException;
            }
            this.b = null;
            android.net.NetworkRequest.Builder builder = new android.net.NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            android.net.NetworkRequest build = builder.build();
            cn.fly.verify.aj.AnonymousClass2 anonymousClass2 = new cn.fly.verify.aj.AnonymousClass2();
            this.c = anonymousClass2;
            this.a.requestNetwork(build, anonymousClass2);
            e.add(this.c);
            long j = 0;
            do {
                android.net.Network network = this.b;
                if (network != null) {
                    return network;
                }
                j++;
                android.os.SystemClock.sleep(50L);
            } while (j <= this.f / 50);
            cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "switch timeout");
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_SWITCH_EXCEPTION_ERR.getCode(), "switch_timeout");
        } catch (java.lang.Throwable th) {
            cn.fly.verify.f.a().c("[FlyVerify] ==>%s", "switch failure " + th);
            if (th instanceof cn.fly.verify.common.exception.VerifyException) {
                throw th;
            }
            throw new cn.fly.verify.common.exception.VerifyException(cn.fly.verify.common.exception.VerifyErr.INNER_SWITCH_EXCEPTION_ERR.getCode(), cn.fly.verify.as.a(th));
        }
    }
}
