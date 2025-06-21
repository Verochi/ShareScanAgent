package cn.fly.verify;

/* loaded from: classes.dex */
public class fo {
    private static cn.fly.verify.fo a;
    private android.content.Context b;
    private android.content.BroadcastReceiver c;
    private java.lang.String d;
    private java.lang.Integer e;

    /* renamed from: cn.fly.verify.fo$1, reason: invalid class name */
    public class AnonymousClass1 extends android.net.ConnectivityManager.NetworkCallback {
        public AnonymousClass1() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            cn.fly.verify.fo.this.e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(android.net.Network network, android.net.NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(android.net.Network network, android.net.LinkProperties linkProperties) {
            super.onLinkPropertiesChanged(network, linkProperties);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(android.net.Network network, int i) {
            super.onLosing(network, i);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(android.net.Network network) {
            super.onLost(network);
            cn.fly.verify.fo.this.e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
        }
    }

    /* renamed from: cn.fly.verify.fo$2, reason: invalid class name */
    public class AnonymousClass2 extends android.content.BroadcastReceiver {
        public AnonymousClass2() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            try {
                if (intent.getAction().equalsIgnoreCase(cn.fly.verify.bj.a("036ef*edekfeejedgeBfgj]ge<d0fe2ff!gehlhhfifihihlflfjhkfjfljleihlgkfmfijehi"))) {
                    cn.fly.verify.fo.this.e();
                }
            } catch (java.lang.Throwable th) {
                cn.fly.verify.ed.a().a(th);
            }
        }
    }

    private fo(android.content.Context context) {
        this.b = context;
        c();
    }

    public static cn.fly.verify.fo a(android.content.Context context) {
        if (a == null) {
            synchronized (cn.fly.verify.fo.class) {
                if (a == null) {
                    a = new cn.fly.verify.fo(context);
                }
            }
        }
        return a;
    }

    private boolean a(int i) {
        java.lang.Object a2 = cn.fly.verify.fh.d.a(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        if (a2 == null) {
            return false;
        }
        if (a(a2) || b(a2)) {
            return true;
        }
        return b(i);
    }

    private boolean a(java.lang.Object obj) {
        java.lang.Object n;
        if (obj != null && cn.fly.verify.fh.d.b(cn.fly.verify.bj.a("035efGedekfeejedge$kg3ekegejgigiejfeJfSgehjhifmgleihmgkhhfihieifkflfmflhi"))) {
            if (cn.fly.verify.az.a().f()) {
                java.lang.String k = cn.fly.verify.fh.d.k();
                n = null;
                if (!android.text.TextUtils.isEmpty(k) && ((k.contains(cn.fly.verify.bj.a("006i@eh.e(gg gYej")) || k.contains(cn.fly.verify.bj.a("006Ggkeh)e.ggUg5ej")) || k.contains(cn.fly.verify.bj.a("006Zgkfhfmhfhifj"))) && android.os.Build.VERSION.SDK_INT >= 29)) {
                    n = cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("015*ff9gj7fk5g;ekeeej dg(fkDjejg"), (java.lang.Object) null, new java.lang.Object[0]);
                }
            } else {
                n = cn.fly.verify.az.a().n();
            }
            if (n != null && ((java.lang.Integer) cn.fly.verify.fp.a(n, cn.fly.verify.bj.a("016Nff!gj-gkggfi+gjSggfeekemflel=kg"), 0, new java.lang.Object[0])).intValue() == 20) {
                return true;
            }
        }
        return false;
    }

    private boolean b(int i) {
        return i == 20;
    }

    private boolean b(java.lang.Object obj) {
        if (obj != null && cn.fly.verify.fh.d.b(cn.fly.verify.bj.a("035efHedekfeejedgeXkg-ekegejgigiejfe*fSgehjhifmgleihmgkhhfihieifkflfmflhi")) && android.os.Build.VERSION.SDK_INT >= 26) {
            java.lang.Object a2 = cn.fly.verify.az.a().f() ? cn.fly.verify.fp.a(obj, cn.fly.verify.bj.a("015Vff8gj$fk.g(ekeeejXdgTfkDjejg"), (java.lang.Object) null, new java.lang.Object[0]) : cn.fly.verify.az.a().n();
            if (a2 != null && ((java.lang.Integer) cn.fly.verify.fp.a(a2, cn.fly.verify.bj.a("010*ff gj4fiekfk^jejg"), 0, new java.lang.Object[0])).intValue() == 3) {
                return true;
            }
        }
        return false;
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    private void c() {
        try {
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) cn.fly.verify.fh.d.a("connectivity");
            if (android.os.Build.VERSION.SDK_INT >= 26 && cn.fly.verify.fh.d.b(cn.fly.verify.bj.a("039ef:edekfeejedgeUkg(ekegejgigiejfe3fPgefmhlhlhifkfkeifihiflhfhhhjjdeifkflfmflhi"))) {
                connectivityManager.registerDefaultNetworkCallback(d());
            } else if (cn.fly.verify.fh.d.b(cn.fly.verify.bj.a("039ef8edekfeejedgeXkg:ekegejgigiejfe,fFgefmhlhlhifkfkeifihiflhfhhhjjdeifkflfmflhi"))) {
                connectivityManager.registerNetworkCallback(new android.net.NetworkRequest.Builder().build(), d());
            } else {
                g();
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().a(th);
        }
    }

    private boolean c(int i) {
        return i == 13;
    }

    @android.annotation.TargetApi(21)
    private android.net.ConnectivityManager.NetworkCallback d() {
        return new cn.fly.verify.fo.AnonymousClass1();
    }

    private boolean d(int i) {
        switch (i) {
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            case 4:
            case 7:
            case 11:
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.d = h();
        this.e = java.lang.Integer.valueOf(f());
    }

    private int f() {
        if (cn.fly.verify.fh.d.a(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE) != null && cn.fly.verify.fh.d.b(cn.fly.verify.bj.a("035ef+edekfeejedge%kg7ekegejgigiejfeCfKgehjhifmgleihmgkhhfihieifkflfmflhi"))) {
            return android.os.Build.VERSION.SDK_INT >= 24 ? cn.fly.verify.ej.a(this.b).c() : cn.fly.verify.ej.a(this.b).b();
        }
        return -1;
    }

    private void g() {
        this.c = new cn.fly.verify.fo.AnonymousClass2();
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction(cn.fly.verify.bj.a("036ef-edekfeejedge2fgjXgeId?fe=ff,gehlhhfifihihlflfjhkfjfljleihlgkfmfijehi"));
        cn.fly.verify.dw.a(this.c, intentFilter);
    }

    private java.lang.String h() {
        java.lang.Object a2;
        android.net.NetworkInfo activeNetworkInfo;
        try {
            if (cn.fly.verify.fh.d.b(cn.fly.verify.bj.a("039ef^edekfeejedge7kg>ekegejgigiejfe^fCgefmhlhlhifkfkeifihiflhfhhhjjdeifkflfmflhi")) && (a2 = cn.fly.verify.fh.d.a("connectivity")) != null && (activeNetworkInfo = ((android.net.ConnectivityManager) a2).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    int b = cn.fly.verify.ej.a(this.b).b();
                    if (a(b)) {
                        return cn.fly.verify.bj.a("002,ijje");
                    }
                    if (c(b)) {
                        return cn.fly.verify.bj.a("0024imje");
                    }
                    return cn.fly.verify.bj.a(d(b) ? "002Ukgje" : "0026ifje");
                }
                if (type == 1) {
                    return cn.fly.verify.bj.a("004%ggejfgej");
                }
                switch (type) {
                    case 6:
                        return cn.fly.verify.bj.a("005,ggejegSe'fd");
                    case 7:
                        return cn.fly.verify.bj.a("009UgfYhQeh3gjLfefeQji");
                    case 8:
                        return cn.fly.verify.bj.a("005Qedehegegel");
                    case 9:
                        return cn.fly.verify.bj.a("008gjigHekTfgj");
                    default:
                        return java.lang.String.valueOf(type);
                }
            }
        } catch (java.lang.Throwable th) {
            cn.fly.verify.ed.a().b(th);
        }
        return cn.fly.verify.bj.a("004fYfeMfg");
    }

    public synchronized java.lang.String a() {
        if (android.text.TextUtils.isEmpty(this.d)) {
            this.d = h();
        }
        return this.d;
    }

    public synchronized int b() {
        if (this.e == null) {
            this.e = java.lang.Integer.valueOf(f());
        }
        return this.e.intValue();
    }
}
