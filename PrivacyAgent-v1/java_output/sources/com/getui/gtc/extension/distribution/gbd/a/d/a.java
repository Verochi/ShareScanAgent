package com.getui.gtc.extension.distribution.gbd.a.d;

/* loaded from: classes22.dex */
public final class a {
    private static final int A = 3;
    private static final int B = 0;
    private static final int C = 1;
    private static final int D = -1;
    private static final int E = -2;
    private static final int F = -3;
    private static final int G = -5;
    private static final int H = -6;
    private static final int I = -7;
    private static final int J = -8;
    private static final int K = -11;
    private static final int L = -12;
    private static final int M = -13;
    private static final long N = 86400000;
    static final java.lang.String a = "D79DC116C71DD4AD430F5F7CDC7DF142796234EDDC6BD332C8FAFE25CE287F1248CEBAB48650EDF6CC663D8D03B6030A05DB390C642D11DB";
    static final java.lang.String b = "D79DC116C71DD4AD430F5F7CDC79F54493996AA74727F7277AC333000534D4857078ECE4B31130A248D6DD57813DACAF";
    static final java.lang.String c = "D79DC116C71DD4AD430F0324DA40B661D3E67C956059A15CEDDC3533DE922170";
    static final java.lang.String d = "D79DC116C71DD4AD43087D7CDE20BD73C7FECA980AB1B725ABA34D39A6C38403EF5FAA90B55A7143A3A558A3114AB1B0";
    static final java.lang.String e = "D79DC116C71DD4AD430303259638F077580723EED944208D83EE00B250C37444D92580AD8671C5AC99A3B8021475D6DA57D3BFED719CA42D71260467E8A1936C348A24DC13C38AF6";
    static final java.lang.String f = "D79DC116C71DD4AD43087526DF20F07388C5A61D898D06A0B348F6E5B97B910CE31B11DB2A589C3159544F22CCBA9F4493D1C9DEF42FDF5A5ABDF34961E69152B9B2463E3655676F";
    public static final int g = -14;
    public static final int h = -15;
    public static final int i = -16;
    public static final int j = -17;
    public static final int k = -18;
    public static final int l = -19;
    public static final int m = -20;
    public static final int n = -21;
    public static final int o = -22;
    public static final int p = -30;
    public static final int q = -31;
    public static final int r = -32;
    private static final java.lang.String w = "GBD_PN";
    private static final int x = 0;
    private static final int y = 1;
    private static final int z = 2;
    private int O;
    private android.content.Context P;

    /* renamed from: s, reason: collision with root package name */
    int f317s;
    public int t = -18;
    java.util.concurrent.locks.ReentrantLock u;
    java.util.concurrent.locks.Condition v;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.d.a$1, reason: invalid class name */
    public class AnonymousClass1 extends android.net.ConnectivityManager.NetworkCallback {
        final /* synthetic */ java.util.concurrent.atomic.AtomicBoolean a;

        /* renamed from: com.getui.gtc.extension.distribution.gbd.a.d.a$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC03081 implements java.lang.Runnable {
            final /* synthetic */ android.net.Network a;

            public RunnableC03081(android.net.Network network) {
                this.a = network;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.getui.gtc.extension.distribution.gbd.a.d.a.this.a(this.a);
            }
        }

        public AnonymousClass1(java.util.concurrent.atomic.AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(android.net.Network network) {
            super.onAvailable(network);
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.d.a.w, "w2cu su.");
            if (this.a.getAndSet(false)) {
                com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.a.d.a.AnonymousClass1.RunnableC03081(network));
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(android.net.Network network, android.net.NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLinkPropertiesChanged(android.net.Network network, android.net.LinkProperties linkProperties) {
            super.onLinkPropertiesChanged(network, linkProperties);
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.d.a.w, "onLPChanged, if name = " + linkProperties.getInterfaceName());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLosing(android.net.Network network, int i) {
            super.onLosing(network, i);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(android.net.Network network) {
            super.onLost(network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onUnavailable() {
            super.onUnavailable();
            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.d.a.w, "w2cu f.");
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.d.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.g.c {
        final /* synthetic */ boolean a;

        public AnonymousClass2(boolean z) {
            this.a = z;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            int i;
            com.getui.gtc.extension.distribution.gbd.a.d.a.this.u.lock();
            try {
                com.getui.gtc.extension.distribution.gbd.a.d.a.this.v.signalAll();
                if (obj == null || !(obj instanceof com.getui.gtc.extension.distribution.gbd.c.n)) {
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.c.n nVar = (com.getui.gtc.extension.distribution.gbd.c.n) obj;
                com.getui.gtc.extension.distribution.gbd.a.d.a aVar = com.getui.gtc.extension.distribution.gbd.a.d.a.this;
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = nVar.a;
                java.lang.String str = nVar.b;
                int i2 = nVar.c;
                com.getui.gtc.extension.distribution.gbd.c.o oVar = nVar.d;
                boolean z = this.a;
                java.lang.String a = com.getui.gtc.extension.distribution.gbd.a.d.a.a(map, str, i2, oVar);
                if (!android.text.TextUtils.isEmpty(a)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.d.a.w, "p success parseData type=" + i2 + " data = release");
                    com.getui.gtc.extension.distribution.gbd.d.h.au = a;
                    com.getui.gtc.extension.distribution.gbd.d.h.o = com.getui.gtc.extension.distribution.gbd.d.h.o + 1;
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    try {
                        java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.h.au;
                        if (str2 != null) {
                            com.getui.gtc.extension.distribution.gbd.f.a.b.a(170, com.getui.gtc.extension.distribution.gbd.n.ad.a(str2.getBytes()));
                        }
                    } catch (java.lang.Exception e) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(e);
                    }
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.c();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a(java.lang.System.currentTimeMillis());
                    aVar.f317s = z ? -31 : 1;
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.d.a.w, "p failed parseData type=" + i2 + " data = release");
                try {
                    int[] iArr = oVar.b;
                    int i3 = oVar.c;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= iArr.length) {
                            break;
                        }
                        if (iArr[i4] != i3 || (i = i4 + 1) >= iArr.length) {
                            i4++;
                        } else {
                            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.a.d.a.a(i2, iArr[i]);
                            if (!android.text.TextUtils.isEmpty(a2) && iArr[0] != 0) {
                                oVar.c = iArr[i];
                                com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.d.a.w, "p failed, try next method methodType = " + iArr[i] + ", url = " + a2);
                                return;
                            }
                            com.getui.gtc.extension.distribution.gbd.n.j.b(com.getui.gtc.extension.distribution.gbd.a.d.a.w, "p http url == null or methodType == unkonw");
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
                com.getui.gtc.extension.distribution.gbd.d.h.o++;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.c();
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(java.lang.System.currentTimeMillis());
                aVar.f317s = z ? -32 : -12;
            } finally {
                com.getui.gtc.extension.distribution.gbd.a.d.a.this.u.unlock();
            }
        }
    }

    private a(android.content.Context context) {
        java.util.concurrent.locks.ReentrantLock reentrantLock = new java.util.concurrent.locks.ReentrantLock();
        this.u = reentrantLock;
        this.v = reentrantLock.newCondition();
        this.P = context;
    }

    private int a() {
        return this.f317s;
    }

    private static java.lang.Object a(java.lang.reflect.Method method, java.lang.Object obj) {
        if (android.os.Build.VERSION.SDK_INT >= 30) {
            return "";
        }
        try {
            if (com.getui.gtc.extension.distribution.gbd.f.g.a.a.a(com.getui.gtc.extension.distribution.gbd.f.e.a.m, com.getui.gtc.extension.distribution.gbd.f.e.a.n, com.getui.gtc.extension.distribution.gbd.d.h.bj, com.umeng.analytics.pro.bo.aa, "localSInfo")) {
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                com.getui.gtc.extension.distribution.gbd.d.h.bj = currentTimeMillis;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(364, java.lang.String.valueOf(currentTimeMillis));
                return method.invoke(obj, new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return "";
    }

    public static java.lang.String a(int i2, int i3) {
        java.lang.String str;
        if (i2 != 1) {
            return null;
        }
        if (i3 == 1) {
            str = a;
        } else {
            if (i3 != 2) {
                return null;
            }
            str = b;
        }
        return com.getui.gtc.extension.distribution.gbd.n.y.b(str);
    }

    private java.lang.String a(android.content.Context context) {
        java.lang.String str;
        com.getui.gtc.extension.distribution.gbd.a.d.a aVar = this;
        try {
            int i2 = android.os.Build.VERSION.SDK_INT;
            if (i2 < 22) {
                aVar.t = -20;
                return "";
            }
            if (!com.getui.gtc.extension.distribution.gbd.n.l.a(context, com.anythink.china.common.d.a)) {
                aVar.t = -14;
                return "";
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.Class<?> cls = java.lang.Class.forName("android.telephony.SubscriptionManager");
            java.lang.Class<?> cls2 = java.lang.Class.forName("android.telephony.SubscriptionInfo");
            java.lang.Object invoke = cls.getMethod("from", android.content.Context.class).invoke(null, context);
            java.util.List list = (java.util.List) cls.getMethod("getActiveSubscriptionInfoList", new java.lang.Class[0]).invoke(invoke, new java.lang.Object[0]);
            java.lang.reflect.Method method = cls2.getMethod("getSimSlotIndex", new java.lang.Class[0]);
            java.lang.reflect.Method method2 = cls2.getMethod("getSubscriptionId", new java.lang.Class[0]);
            java.lang.reflect.Method method3 = cls2.getMethod("getMcc", new java.lang.Class[0]);
            java.lang.reflect.Method method4 = cls2.getMethod("getMnc", new java.lang.Class[0]);
            str = "";
            try {
                java.lang.reflect.Method method5 = cls2.getMethod("getCountryIso", new java.lang.Class[0]);
                try {
                    java.lang.reflect.Method method6 = cls2.getMethod("getIccId", new java.lang.Class[0]);
                    java.lang.reflect.Method method7 = cls2.getMethod("getNumber", new java.lang.Class[0]);
                    java.lang.reflect.Method method8 = i2 >= 24 ? cls.getMethod("getDefaultDataSubscriptionId", new java.lang.Class[0]) : null;
                    java.lang.reflect.Method method9 = cls.getMethod("getActiveSubscriptionInfoCountMax", new java.lang.Class[0]);
                    java.lang.reflect.Method method10 = cls.getMethod("getActiveSubscriptionInfoCount", new java.lang.Class[0]);
                    if (list != null && list.size() > 0) {
                        for (java.util.Iterator it = list.iterator(); it.hasNext(); it = it) {
                            android.os.Parcelable parcelable = (android.os.Parcelable) it.next();
                            sb.append(method.invoke(parcelable, new java.lang.Object[0]));
                            sb.append("&");
                            sb.append(method2.invoke(parcelable, new java.lang.Object[0]));
                            sb.append("&");
                            sb.append(method3.invoke(parcelable, new java.lang.Object[0]));
                            sb.append("&");
                            sb.append(method4.invoke(parcelable, new java.lang.Object[0]));
                            sb.append("&");
                            sb.append(method5.invoke(parcelable, new java.lang.Object[0]));
                            sb.append("&");
                            sb.append(a(method6, parcelable));
                            sb.append("&");
                            sb.append(method7.invoke(parcelable, new java.lang.Object[0]));
                            sb.append("#");
                        }
                    }
                    if (sb.toString().endsWith("#")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append(",");
                    sb.append(android.os.Build.VERSION.SDK_INT >= 24 ? ((java.lang.Integer) method8.invoke(null, new java.lang.Object[0])).intValue() : -1);
                    sb.append(",");
                    sb.append(((java.lang.Integer) method9.invoke(invoke, new java.lang.Object[0])).intValue());
                    sb.append(",");
                    sb.append(((java.lang.Integer) method10.invoke(invoke, new java.lang.Object[0])).intValue());
                    aVar = this;
                    aVar.t = 1;
                    return sb.toString();
                } catch (java.lang.Throwable th) {
                    th = th;
                    aVar = this;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    aVar.t = -21;
                    return str;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            str = "";
        }
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.lang.String str, int i2, com.getui.gtc.extension.distribution.gbd.c.o oVar) {
        if (i2 != 1) {
            return null;
        }
        try {
            int i3 = oVar.c;
            if (i3 != 1) {
                if (i3 != 2 || android.text.TextUtils.isEmpty(str)) {
                    return null;
                }
                com.getui.gtc.extension.distribution.gbd.n.d.e.c a2 = com.getui.gtc.extension.distribution.gbd.n.d.e.a.a(new com.getui.gtc.extension.distribution.gbd.n.d.e.d.e("name", "ur"), com.getui.gtc.extension.distribution.gbd.n.d.c.f.b(str, ""));
                if (a2.size() > 0) {
                    return a2.get(0).p("value");
                }
                return null;
            }
            if (map == null) {
                return null;
            }
            for (java.lang.String str2 : map.get(com.google.common.net.HttpHeaders.SET_COOKIE)) {
                if (str2 != null && str2.contains("cmread_phone_no")) {
                    java.lang.String[] split = str2.substring(str2.indexOf("cmread_phone_no"), str2.indexOf(com.alipay.sdk.m.u.i.b)).split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split.length > 1) {
                        return split[1].trim();
                    }
                    return null;
                }
            }
            return null;
        } catch (java.lang.Throwable th) {
            try {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                return null;
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                return null;
            }
        }
    }

    private void a(com.getui.gtc.extension.distribution.gbd.c.o oVar, java.lang.String str, android.net.Network network) {
        boolean z2 = network != null;
        com.getui.gtc.extension.distribution.gbd.g.a.e eVar = new com.getui.gtc.extension.distribution.gbd.g.a.e(str, oVar, network);
        eVar.m = new com.getui.gtc.extension.distribution.gbd.a.d.a.AnonymousClass2(z2);
        new com.getui.gtc.extension.distribution.gbd.g.a(eVar).run();
    }

    private void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.lang.String str, int i2, com.getui.gtc.extension.distribution.gbd.c.o oVar, boolean z2) {
        int i3;
        java.lang.String a2 = a(map, str, i2, oVar);
        if (!android.text.TextUtils.isEmpty(a2)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, "p success parseData type=" + i2 + " data = release");
            com.getui.gtc.extension.distribution.gbd.d.h.au = a2;
            com.getui.gtc.extension.distribution.gbd.d.h.o = com.getui.gtc.extension.distribution.gbd.d.h.o + 1;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            try {
                java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.h.au;
                if (str2 != null) {
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a(170, com.getui.gtc.extension.distribution.gbd.n.ad.a(str2.getBytes()));
                }
            } catch (java.lang.Exception e2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(e2);
            }
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.c();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(java.lang.System.currentTimeMillis());
            this.f317s = z2 ? -31 : 1;
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(w, "p failed parseData type=" + i2 + " data = release");
        try {
            int[] iArr = oVar.b;
            int i4 = oVar.c;
            int i5 = 0;
            while (true) {
                if (i5 >= iArr.length) {
                    break;
                }
                if (iArr[i5] != i4 || (i3 = i5 + 1) >= iArr.length) {
                    i5++;
                } else {
                    java.lang.String a3 = a(i2, iArr[i3]);
                    if (!android.text.TextUtils.isEmpty(a3) && iArr[0] != 0) {
                        oVar.c = iArr[i3];
                        com.getui.gtc.extension.distribution.gbd.n.j.b(w, "p failed, try next method methodType = " + iArr[i3] + ", url = " + a3);
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(w, "p http url == null or methodType == unkonw");
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        com.getui.gtc.extension.distribution.gbd.d.h.o++;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.c();
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(java.lang.System.currentTimeMillis());
        this.f317s = z2 ? -32 : -12;
    }

    private static boolean a(int i2) {
        return ((1 << (i2 - 1)) & com.getui.gtc.extension.distribution.gbd.d.d.bU) != 0;
    }

    private static boolean a(android.net.ConnectivityManager connectivityManager) {
        try {
            java.lang.reflect.Method declaredMethod = android.net.ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new java.lang.Class[0]);
            declaredMethod.setAccessible(true);
            return ((java.lang.Boolean) declaredMethod.invoke(connectivityManager, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private int b() {
        return this.O;
    }

    @android.annotation.TargetApi(21)
    private void b(android.net.ConnectivityManager connectivityManager) {
        java.util.concurrent.locks.ReentrantLock reentrantLock;
        try {
            if (com.getui.gtc.extension.distribution.gbd.n.ab.b() != 1) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(w, "sc not cm.");
                this.f317s = -3;
                return;
            }
            if (com.getui.gtc.extension.distribution.gbd.d.d.cz && com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.CHANGE_NETWORK_STATE")) {
                if (!a(connectivityManager)) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(w, "sc no cu.");
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(w, "in w mode, attempt 2 cu.");
                java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(true);
                android.net.NetworkRequest.Builder builder = new android.net.NetworkRequest.Builder();
                builder.addCapability(12);
                builder.addTransportType(0);
                android.net.NetworkRequest build = builder.build();
                com.getui.gtc.extension.distribution.gbd.a.d.a.AnonymousClass1 anonymousClass1 = new com.getui.gtc.extension.distribution.gbd.a.d.a.AnonymousClass1(atomicBoolean);
                connectivityManager.requestNetwork(build, anonymousClass1);
                this.u.lock();
                try {
                    this.v.await(15000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                    reentrantLock = this.u;
                } catch (java.lang.Throwable th) {
                    try {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(th.toString());
                        reentrantLock = this.u;
                    } catch (java.lang.Throwable th2) {
                        this.u.unlock();
                        throw th2;
                    }
                }
                reentrantLock.unlock();
                connectivityManager.unregisterNetworkCallback(anonymousClass1);
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, "sc dy not allow or no net perm.");
            this.f317s = -30;
        } catch (java.lang.Throwable th3) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
        }
    }

    private void b(android.net.Network network) {
        int i2;
        try {
            int b2 = com.getui.gtc.extension.distribution.gbd.n.ab.b();
            com.getui.gtc.extension.distribution.gbd.n.j.a(w, "getForNetType() type:".concat(java.lang.String.valueOf(b2)));
            com.getui.gtc.extension.distribution.gbd.c.o oVar = new com.getui.gtc.extension.distribution.gbd.c.o();
            if (b2 != 1) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(w, "not cm, return");
                this.f317s = -3;
                return;
            }
            oVar.a = true;
            int[] i3 = i();
            java.lang.String a2 = a(1, i3[0]);
            if (!android.text.TextUtils.isEmpty(a2) && (i2 = i3[0]) != 0) {
                oVar.b = i3;
                oVar.c = i2;
                com.getui.gtc.extension.distribution.gbd.n.j.b(w, "from n t=1, mt=".concat(java.lang.String.valueOf(i2)));
                if (i2 == 1 || i2 == 2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(w, "cm go.");
                    a(oVar, a2, network);
                    return;
                }
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, "pn http url == null or methodType == unkonw");
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(w, th.toString());
        }
    }

    private static boolean b(int i2) {
        try {
            byte[] a2 = com.getui.gtc.extension.distribution.gbd.n.f.a(com.getui.gtc.extension.distribution.gbd.d.d.bV);
            if (i2 == 1) {
                return a2[4] == 1;
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private void c() {
        java.util.concurrent.locks.ReentrantLock reentrantLock;
        this.f317s = 0;
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService("connectivity");
        android.net.NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(w, "net info is null");
            return;
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, "in cellular.");
            a((android.net.Network) null);
            return;
        }
        if (type == 1) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, "in wi.");
            try {
                if (com.getui.gtc.extension.distribution.gbd.n.ab.b() != 1) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(w, "sc not cm.");
                    this.f317s = -3;
                    return;
                }
                if (com.getui.gtc.extension.distribution.gbd.d.d.cz && com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.CHANGE_NETWORK_STATE")) {
                    if (!a(connectivityManager)) {
                        com.getui.gtc.extension.distribution.gbd.n.j.b(w, "sc no cu.");
                        return;
                    }
                    com.getui.gtc.extension.distribution.gbd.n.j.b(w, "in w mode, attempt 2 cu.");
                    java.util.concurrent.atomic.AtomicBoolean atomicBoolean = new java.util.concurrent.atomic.AtomicBoolean(true);
                    android.net.NetworkRequest.Builder builder = new android.net.NetworkRequest.Builder();
                    builder.addCapability(12);
                    builder.addTransportType(0);
                    android.net.NetworkRequest build = builder.build();
                    com.getui.gtc.extension.distribution.gbd.a.d.a.AnonymousClass1 anonymousClass1 = new com.getui.gtc.extension.distribution.gbd.a.d.a.AnonymousClass1(atomicBoolean);
                    connectivityManager.requestNetwork(build, anonymousClass1);
                    this.u.lock();
                    try {
                        this.v.await(15000L, java.util.concurrent.TimeUnit.MILLISECONDS);
                        reentrantLock = this.u;
                    } catch (java.lang.Throwable th) {
                        try {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(th.toString());
                            reentrantLock = this.u;
                        } catch (java.lang.Throwable th2) {
                            this.u.unlock();
                            throw th2;
                        }
                    }
                    reentrantLock.unlock();
                    connectivityManager.unregisterNetworkCallback(anonymousClass1);
                    return;
                }
                com.getui.gtc.extension.distribution.gbd.n.j.b(w, "sc dy not allow or no net perm.");
                this.f317s = -30;
            } catch (java.lang.Throwable th3) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
            }
        }
    }

    private void d() {
        this.O = 0;
        if (!com.getui.gtc.extension.distribution.gbd.d.d.bW) {
            this.O = -13;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.g("");
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.h("");
            return;
        }
        boolean h2 = h();
        com.getui.gtc.extension.distribution.gbd.n.j.b(w, "in local pn bl: ".concat(java.lang.String.valueOf(h2)));
        if (h2) {
            this.O = -17;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.g("");
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.h("");
            return;
        }
        boolean a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, false);
        boolean b2 = com.getui.gtc.extension.distribution.gbd.n.l.b();
        com.getui.gtc.extension.distribution.gbd.n.j.b(w, "checkSafeForLocalPn: " + a2 + ", isDebug = " + b2);
        if (!a2 || b2) {
            this.O = -18;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.g("");
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.h("");
            return;
        }
        int i2 = com.getui.gtc.extension.distribution.gbd.d.c.d.getApplicationInfo().targetSdkVersion;
        if (android.os.Build.VERSION.SDK_INT >= 30 && i2 >= 30) {
            this.O = -19;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.g("");
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.h("");
            return;
        }
        if (!e()) {
            this.O = -1;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.g("");
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.h("");
            return;
        }
        if (!com.getui.gtc.extension.distribution.gbd.n.l.a(this.P, com.anythink.china.common.d.a)) {
            this.O = -14;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.g("");
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.h("");
            return;
        }
        if (!(com.getui.gtc.extension.distribution.gbd.n.ab.a(this.P) == 5)) {
            this.O = -15;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.g("");
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.h("");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.n.j.b(w, "l p safe check complete.");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.m < com.getui.gtc.extension.distribution.gbd.d.d.w * 1000) {
            this.O = -22;
            this.t = -22;
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, "l p, local subInfo from db.");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.d.h.m = currentTimeMillis;
        com.getui.gtc.extension.distribution.gbd.f.a.b.a(184, java.lang.String.valueOf(currentTimeMillis));
        com.getui.gtc.extension.distribution.gbd.d.h.av = com.getui.gtc.extension.distribution.gbd.n.ab.b(com.getui.gtc.extension.distribution.gbd.d.c.d);
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.g(com.getui.gtc.extension.distribution.gbd.d.h.av);
        com.getui.gtc.extension.distribution.gbd.n.j.b(w, "l p from api.");
        this.O = android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.av) ? -12 : 1;
        com.getui.gtc.extension.distribution.gbd.d.h.aw = a(this.P);
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.h(com.getui.gtc.extension.distribution.gbd.d.h.aw);
        com.getui.gtc.extension.distribution.gbd.n.j.b(w, "local subInfo from api.");
    }

    private static boolean e() {
        try {
            if ("0000".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.bT)) {
                return true;
            }
            int intValue = java.lang.Integer.valueOf(com.getui.gtc.extension.distribution.gbd.d.c.e.substring(r1.length() - 4), 16).intValue();
            int intValue2 = java.lang.Integer.valueOf(com.getui.gtc.extension.distribution.gbd.d.d.bT, 16).intValue();
            for (int i2 = 0; i2 < 16; i2++) {
                int i3 = 1 << i2;
                if ((intValue2 & i3) != 0 && (i3 & intValue) == 0) {
                    return false;
                }
            }
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private static int f() {
        if (g()) {
            com.getui.gtc.extension.distribution.gbd.d.h.o = 0;
            com.getui.gtc.extension.distribution.gbd.d.h.n = 0L;
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.c();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(0L);
        } else {
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.au)) {
                return -6;
            }
            if (com.getui.gtc.extension.distribution.gbd.d.h.o >= 24) {
                return -7;
            }
            if (java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.n <= 86400000) {
                return -5;
            }
        }
        return 0;
    }

    private static boolean g() {
        try {
            java.lang.String b2 = com.getui.gtc.extension.distribution.gbd.n.l.b(true);
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, "new s: " + b2 + ", old s: " + com.getui.gtc.extension.distribution.gbd.d.h.ax);
            if (android.text.TextUtils.isEmpty(b2)) {
                return true;
            }
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.ax)) {
                com.getui.gtc.extension.distribution.gbd.d.h.ax = b2;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(b2);
                return true;
            }
            if (b2.equals(com.getui.gtc.extension.distribution.gbd.d.h.ax)) {
                return false;
            }
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.a(b2);
            return true;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return true;
        }
    }

    private static boolean h() {
        java.lang.String[] split;
        try {
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.y) && !"none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.y) && (split = com.getui.gtc.extension.distribution.gbd.d.d.y.split(",")) != null && split.length > 0) {
                for (java.lang.String str : split) {
                    java.lang.String[] split2 = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    if (split2 != null && split2.length >= 3) {
                        if (com.getui.gtc.extension.distribution.gbd.n.l.w().equalsIgnoreCase(split2[0])) {
                            java.lang.String[] split3 = split2[1].split("&");
                            java.lang.String str2 = split2[2];
                            if (split3 != null && split3.length == 2 && !android.text.TextUtils.isEmpty(str2)) {
                                int parseInt = java.lang.Integer.parseInt(split3[0]);
                                int parseInt2 = java.lang.Integer.parseInt(split3[1]);
                                int i2 = android.os.Build.VERSION.SDK_INT;
                                boolean z2 = i2 >= parseInt && i2 <= parseInt2;
                                java.lang.String lowerCase = com.getui.gtc.extension.distribution.gbd.n.l.z().toLowerCase();
                                if (!z2) {
                                    continue;
                                } else {
                                    if ("*".equals(str2)) {
                                        return true;
                                    }
                                    java.lang.String[] split4 = str2.split("&");
                                    if (split4 != null && split4.length > 0) {
                                        for (java.lang.String str3 : split4) {
                                            if (lowerCase.contains(str3.toLowerCase())) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return true;
        }
    }

    private static int[] i() {
        byte[] bArr;
        byte b2;
        try {
            byte[] a2 = com.getui.gtc.extension.distribution.gbd.n.f.a(com.getui.gtc.extension.distribution.gbd.d.d.bV);
            bArr = new byte[3];
            for (int i2 = 7; i2 < 10; i2++) {
                bArr[i2 - 7] = a2[i2];
            }
            b2 = bArr[0];
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (b2 == 0 && bArr[1] == 0 && bArr[2] == 1) {
            return new int[]{1};
        }
        if (b2 == 0 && bArr[1] == 1 && bArr[2] == 0) {
            return new int[]{2};
        }
        if (b2 == 1 && bArr[1] == 0 && bArr[2] == 0) {
            return new int[]{3};
        }
        if (b2 == 0 && bArr[1] == 1 && bArr[2] == 1) {
            return new int[]{2, 1};
        }
        if (b2 == 1 && bArr[1] == 1 && bArr[2] == 1) {
            return new int[]{3, 2, 1};
        }
        if (b2 == 1 && bArr[1] == 0 && bArr[2] == 1) {
            return new int[]{3, 1};
        }
        if (b2 == 1 && bArr[1] == 1 && bArr[2] == 0) {
            return new int[]{3, 2};
        }
        return new int[]{0};
    }

    public final void a(android.net.Network network) {
        try {
            int b2 = com.getui.gtc.extension.distribution.gbd.n.ab.b();
            if (!a(b2)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(w, "GBDConfig.operatorMask unpass");
                this.f317s = -11;
                return;
            }
            if (!e()) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(w, "check cid unpass");
                this.f317s = -1;
                return;
            }
            if (!b(b2)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(w, "isEnable unpass, mobileType = ".concat(java.lang.String.valueOf(b2)));
                this.f317s = -13;
                return;
            }
            if (java.lang.System.currentTimeMillis() < com.getui.gtc.extension.distribution.gbd.d.h.p) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(w, "pn start time unpass");
                this.f317s = -8;
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, "netWorkType = " + com.getui.gtc.extension.distribution.gbd.n.l.j(com.getui.gtc.extension.distribution.gbd.d.c.d) + " mobileType = " + b2);
            this.f317s = f();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("get pn r code: ");
            sb.append(this.f317s);
            com.getui.gtc.extension.distribution.gbd.n.j.b(w, sb.toString());
            if (this.f317s != 0) {
                return;
            }
            b(network);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(w, th.toString());
        }
    }
}
