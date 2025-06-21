package com.anythink.core.common.b;

/* loaded from: classes12.dex */
public class o {
    public static final int a = 0;
    public static final int b = 1;
    private static volatile com.anythink.core.common.b.o j;
    private com.anythink.core.api.IExHandler A;
    private java.lang.String G;
    private java.lang.String H;
    private boolean J;
    private com.anythink.core.common.g.c L;
    private android.location.Location M;
    private org.json.JSONArray O;
    private java.util.List<java.lang.String> P;
    private java.lang.String R;
    private com.anythink.core.api.ATDebuggerConfig S;
    private boolean T;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.api.IATAdFilter> X;
    private com.anythink.core.api.ATPrivacyConfig Z;
    private com.anythink.core.common.f.ax ab;
    java.lang.Boolean c;
    java.lang.ref.WeakReference<android.app.Activity> e;
    private int f;
    private android.content.Context k;
    private java.lang.String l;
    private java.lang.String m;
    private java.lang.String o;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.api.ATCustomAdapterConfig> r;
    private java.lang.String t;
    private android.content.BroadcastReceiver w;
    private java.lang.String x;
    private java.lang.String y;
    private java.lang.String z;
    private final java.lang.String g = "SDK.init";
    private final java.lang.String h = "com.anythink.pd.ExHandler";
    private boolean i = false;
    private final java.lang.Object v = new java.lang.Object();
    private boolean C = false;
    private boolean D = false;
    private long E = 0;
    private long F = 0;
    private boolean K = false;
    private java.lang.String N = "";
    private int U = 1;
    private boolean V = false;
    private boolean W = false;
    private java.lang.String Y = "";
    private int aa = 1;
    private final java.lang.Object ad = new java.lang.Object();
    long d = 0;
    private android.os.Handler n = new android.os.Handler(android.os.Looper.getMainLooper());
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.Map<java.lang.String, java.lang.Object>> q = new java.util.concurrent.ConcurrentHashMap<>();
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> p = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.lang.String B = java.io.File.separator + "anythink.test";
    private boolean I = true;
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.List<java.lang.String>> Q = new java.util.concurrent.ConcurrentHashMap<>();
    private org.json.JSONObject u = new org.json.JSONObject();
    private long ac = java.lang.System.currentTimeMillis();

    /* renamed from: s, reason: collision with root package name */
    private final java.util.Map<java.lang.String, java.lang.Boolean> f166s = new java.util.concurrent.ConcurrentHashMap(2);

    /* renamed from: com.anythink.core.common.b.o$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ android.content.Context c;

        public AnonymousClass1(android.content.Context context, java.lang.String str, android.content.Context context2) {
            this.a = context;
            this.b = str;
            this.c = context2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.anythink.core.common.n.b.a().a(this.a);
                com.anythink.core.common.b.o.this.a(this.a, this.b, 0);
                com.anythink.core.common.b.o.a(com.anythink.core.common.b.o.this, this.c);
                com.anythink.core.common.b.i.a(this.a).a();
                com.anythink.core.common.b.o.a(com.anythink.core.common.b.o.this);
                com.anythink.core.common.b.o.b(com.anythink.core.common.b.o.this, this.a);
                com.anythink.core.common.a.k.a().b();
                com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.this.f()).b();
                com.anythink.core.common.res.d.a(com.anythink.core.common.b.o.this.f());
                com.anythink.core.common.res.d.c();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.o$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ android.content.Context b;

        public AnonymousClass10(android.content.Context context, android.content.Context context2) {
            this.a = context;
            this.b = context2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.b.o.this.b();
            if (com.anythink.core.common.b.o.this.A != null) {
                com.anythink.core.common.b.o.this.A.initDeviceInfo(this.a);
            }
            com.anythink.core.d.f.a(this.b).a();
            com.anythink.core.common.x.a(this.a);
            com.anythink.core.common.d.a().a(this.a);
            java.lang.String s2 = com.anythink.core.common.o.e.s(com.anythink.core.common.b.o.this.k);
            if (android.text.TextUtils.isEmpty(s2)) {
                return;
            }
            com.anythink.core.common.b.o.this.h(s2);
        }
    }

    /* renamed from: com.anythink.core.common.b.o$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATNetworkConfig a;

        public AnonymousClass11(com.anythink.core.api.ATNetworkConfig aTNetworkConfig) {
            this.a = aTNetworkConfig;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.b.o oVar = com.anythink.core.common.b.o.this;
            com.anythink.core.common.b.o.a(oVar, oVar.k, this.a);
        }
    }

    /* renamed from: com.anythink.core.common.b.o$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        public AnonymousClass12() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.widget.Toast.makeText(com.anythink.core.common.b.o.this.k, "There is a problem with the integrated resources of AT SDK, please check whether you have followed the steps of the integration document.", 1).show();
        }
    }

    /* renamed from: com.anythink.core.common.b.o$13, reason: invalid class name */
    public class AnonymousClass13 extends android.content.BroadcastReceiver {

        /* renamed from: com.anythink.core.common.b.o$13$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.t.a().b();
                com.anythink.core.common.s.a().b();
            }
        }

        public AnonymousClass13() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(android.content.Context context, android.content.Intent intent) {
            com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (com.anythink.core.common.o.i.a(context)) {
                com.anythink.core.common.b.o.a(new com.anythink.core.common.b.o.AnonymousClass13.AnonymousClass1());
                com.anythink.core.common.n.b.a().b();
                com.anythink.core.common.b.o oVar = com.anythink.core.common.b.o.this;
                oVar.a(context, oVar.o(), com.anythink.core.common.b.o.this.p());
            }
            if (android.text.TextUtils.equals(intent.getAction(), com.anythink.core.common.b.h.G)) {
                com.anythink.core.common.n.c.a(intent.getStringExtra(com.anythink.core.common.b.h.H));
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.o$14, reason: invalid class name */
    public class AnonymousClass14 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;

        public AnonymousClass14(android.content.Context context, java.lang.String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.d.a b = com.anythink.core.d.b.a(this.a.getApplicationContext()).b(this.b);
            if (b != null) {
                if (!b.O()) {
                    com.anythink.core.common.q.a(com.anythink.core.common.b.o.this.k).a(b);
                    com.anythink.core.common.w.a().a(b.b());
                }
                if (!com.anythink.core.d.b.a(this.a.getApplicationContext()).a(this.b)) {
                    com.anythink.core.d.b.a(this.a.getApplicationContext());
                }
                com.anythink.core.common.i.e.a().a(b);
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.o$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Enumeration<java.lang.String> entries = new dalvik.system.DexFile(this.a.getPackageCodePath()).entries();
                while (entries.hasMoreElements()) {
                    java.lang.String nextElement = entries.nextElement();
                    if (nextElement.contains("com.anythink.network") && nextElement.contains("InitManager") && !nextElement.contains("$")) {
                        arrayList.add(nextElement);
                    }
                }
                arrayList.size();
                java.util.Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        java.lang.Class<?> cls = java.lang.Class.forName((java.lang.String) it.next());
                        java.lang.Object obj = null;
                        try {
                            obj = cls.getDeclaredMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
                        } catch (java.lang.Throwable unused) {
                            java.lang.StringBuilder sb = new java.lang.StringBuilder("Cannot instantiate ");
                            sb.append(cls.getName());
                            sb.append(", please check if a third-party SDK is imported");
                        }
                        if (obj != null && (obj instanceof com.anythink.core.api.ATInitMediation)) {
                            com.anythink.core.api.ATInitMediation aTInitMediation = (com.anythink.core.api.ATInitMediation) obj;
                            java.lang.String networkName = aTInitMediation.getNetworkName();
                            if (!android.text.TextUtils.isEmpty(networkName)) {
                                java.lang.String networkVersion = aTInitMediation.getNetworkVersion();
                                if (android.text.TextUtils.isEmpty(networkVersion)) {
                                    "NetworkName: ".concat(java.lang.String.valueOf(networkName));
                                } else {
                                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder("NetworkName: ");
                                    sb2.append(networkName);
                                    sb2.append("  (v");
                                    sb2.append(networkVersion);
                                    sb2.append(")");
                                }
                                boolean i = com.anythink.core.common.b.o.i(aTInitMediation.getNetworkSDKClass());
                                boolean b = com.anythink.core.common.b.o.b(aTInitMediation.getPluginClassStatus());
                                boolean a = com.anythink.core.common.b.o.a(this.a, (java.util.List<java.lang.String>) aTInitMediation.getActivityStatus());
                                boolean b2 = com.anythink.core.common.b.o.b(this.a, (java.util.List<java.lang.String>) aTInitMediation.getServiceStatus());
                                boolean c = com.anythink.core.common.b.o.c(this.a, aTInitMediation.getProviderStatus());
                                boolean d = com.anythink.core.common.b.o.d(this.a, aTInitMediation.getMetaValutStatus());
                                boolean e = com.anythink.core.common.b.o.e(this.a, aTInitMediation.getPermissionStatus());
                                boolean a2 = com.anythink.core.common.b.o.a(this.a, (java.util.List<java.lang.String>) aTInitMediation.getResourceStatus(), false);
                                boolean r = com.anythink.core.common.b.o.r(aTInitMediation.getAdapterVersion());
                                try {
                                    if (!aTInitMediation.needCheckAdapterVersion()) {
                                        r = true;
                                    }
                                } catch (java.lang.Throwable unused2) {
                                }
                                if (i && b && a && b2 && c && d && e && a2 && !r) {
                                }
                            }
                        }
                    } catch (java.lang.Throwable unused3) {
                    }
                }
            } catch (java.lang.Exception unused4) {
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.o$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass3(android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.anythink.core.d.b.a(this.a).a(this.b)) {
                com.anythink.core.d.b.a(this.a).a(this.b, this.c);
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.o$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.anythink.core.api.DeviceInfoCallback b;

        public AnonymousClass4(android.content.Context context, com.anythink.core.api.DeviceInfoCallback deviceInfoCallback) {
            this.a = context;
            this.b = deviceInfoCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.d.a b = com.anythink.core.d.b.a(this.a).b(com.anythink.core.common.b.o.a().o());
            java.lang.String N = b != null ? b.N() : "";
            boolean z = true;
            if (!android.text.TextUtils.isEmpty(N)) {
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(N);
                    if (!jSONObject.isNull("a")) {
                        if (jSONObject.optInt("a") != 1) {
                            z = false;
                        }
                    }
                } catch (java.lang.Exception unused) {
                }
            }
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                com.anythink.core.api.IExHandler b2 = com.anythink.core.common.b.o.a().b();
                if (b2 != null) {
                    b2.fillTestDeviceData(jSONObject2, b);
                }
                jSONObject2.put("GAID", com.anythink.core.common.o.e.s(this.a));
                jSONObject2.put("AndroidID", z ? com.anythink.core.common.o.e.d(this.a) : "");
                jSONObject2.put("How to config TestMode", "Please visit the document center and learn more through: Integration(Basic) -> How To Test");
                com.anythink.core.common.o.o.a("testModeDeviceInfo", jSONObject2.toString());
                com.anythink.core.api.DeviceInfoCallback deviceInfoCallback = this.b;
                if (deviceInfoCallback != null) {
                    deviceInfoCallback.deviceInfo(jSONObject2.toString());
                }
            } catch (java.lang.Throwable unused2) {
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.o$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ com.anythink.core.common.f b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ com.anythink.core.common.f.b d;
        final /* synthetic */ java.util.Map e;
        final /* synthetic */ boolean f;
        final /* synthetic */ java.lang.String g;

        public AnonymousClass5(java.lang.String str, com.anythink.core.common.f fVar, java.lang.String str2, com.anythink.core.common.f.b bVar, java.util.Map map, boolean z, java.lang.String str3) {
            this.a = str;
            this.b = fVar;
            this.c = str2;
            this.d = bVar;
            this.e = map;
            this.f = z;
            this.g = str3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.d.e a = com.anythink.core.d.f.a(com.anythink.core.common.b.o.this.k).a(this.a);
            java.lang.String g = this.b.g();
            java.lang.String str = (android.text.TextUtils.isEmpty(this.c) || !com.anythink.core.common.o.h.c(this.c)) ? "" : this.c;
            com.anythink.core.common.f.b bVar = this.d;
            if (bVar != null) {
                com.anythink.core.common.f.h S = bVar.h().S();
                S.g(1);
                S.B = str;
                if (com.anythink.core.common.w.a().a(a)) {
                    com.anythink.core.common.o.u.a(this.a, a, S);
                }
                com.anythink.core.common.n.a.a(com.anythink.core.common.b.o.this.k).a(16, S);
                return;
            }
            com.anythink.core.common.f.h a2 = com.anythink.core.common.o.u.a(android.text.TextUtils.isEmpty(g) ? "" : g, this.a, a, 0, 0, this.e, null);
            a2.g(this.f ? 3 : 2);
            if (a == null) {
                a2.y(this.g);
            }
            a2.B = str;
            if (com.anythink.core.common.w.a().a(a)) {
                com.anythink.core.common.o.u.a(this.a, a, a2);
            }
            com.anythink.core.common.n.a.a(com.anythink.core.common.b.o.this.k).a(16, a2);
        }
    }

    /* renamed from: com.anythink.core.common.b.o$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ com.anythink.core.api.ATInitConfig a;
        final /* synthetic */ android.content.Context b;

        public AnonymousClass6(com.anythink.core.api.ATInitConfig aTInitConfig, android.content.Context context) {
            this.a = aTInitConfig;
            this.b = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0088 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[Catch: all -> 0x00d2, TryCatch #1 {all -> 0x00d2, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x0020, B:15:0x0057, B:18:0x0074, B:22:0x008b, B:24:0x009c, B:25:0x00c7, B:32:0x0054, B:38:0x0025), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            java.util.Map<java.lang.String, java.lang.Object> requestParamMap;
            boolean z;
            boolean z2;
            com.anythink.core.d.a b;
            try {
                com.anythink.core.api.ATInitMediation initMediation = this.a.getInitMediation();
                if (initMediation != null) {
                    java.lang.String networkName = initMediation.getNetworkName();
                    java.lang.String b2 = com.anythink.core.common.o.r.b(com.anythink.core.common.b.o.this.k, com.anythink.core.common.b.h.B, networkName, "");
                    if (android.text.TextUtils.isEmpty(b2)) {
                        requestParamMap = this.a.getRequestParamMap();
                        requestParamMap.put(com.anythink.core.api.ATInitMediation.KEY_LOCAL, java.lang.Boolean.TRUE);
                    } else {
                        requestParamMap = com.anythink.core.common.o.i.c(b2);
                    }
                    boolean z3 = false;
                    try {
                        z = com.anythink.core.common.b.r.a(this.b).c();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        z = false;
                    }
                    try {
                        z2 = com.anythink.core.common.b.r.a(this.b).d();
                        try {
                            initMediation.setUserDataConsent(this.b, z, z2);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                            b = com.anythink.core.d.b.a(this.b).b(com.anythink.core.common.b.o.this.l);
                            requestParamMap.put(com.anythink.core.common.b.h.o.c, java.lang.Boolean.valueOf(b.x() == 3));
                            boolean b3 = com.anythink.core.common.o.h.b();
                            if (b.y() == 2) {
                                z3 = true;
                            }
                            requestParamMap.put(com.anythink.core.common.b.h.o.d, java.lang.Boolean.valueOf(z3));
                            if (com.anythink.core.common.b.o.a().A()) {
                            }
                            initMediation.initSDK(com.anythink.core.common.b.o.this.k, requestParamMap, null);
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        z2 = false;
                        th.printStackTrace();
                        b = com.anythink.core.d.b.a(this.b).b(com.anythink.core.common.b.o.this.l);
                        requestParamMap.put(com.anythink.core.common.b.h.o.c, java.lang.Boolean.valueOf(b.x() == 3));
                        boolean b32 = com.anythink.core.common.o.h.b();
                        if (b.y() == 2) {
                        }
                        requestParamMap.put(com.anythink.core.common.b.h.o.d, java.lang.Boolean.valueOf(z3));
                        if (com.anythink.core.common.b.o.a().A()) {
                        }
                        initMediation.initSDK(com.anythink.core.common.b.o.this.k, requestParamMap, null);
                    }
                    b = com.anythink.core.d.b.a(this.b).b(com.anythink.core.common.b.o.this.l);
                    requestParamMap.put(com.anythink.core.common.b.h.o.c, java.lang.Boolean.valueOf(b.x() == 3));
                    boolean b322 = com.anythink.core.common.o.h.b();
                    if (b.y() == 2 && b322) {
                        z3 = true;
                    }
                    requestParamMap.put(com.anythink.core.common.b.h.o.d, java.lang.Boolean.valueOf(z3));
                    if (com.anythink.core.common.b.o.a().A()) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder("pre init network: [");
                        sb.append(networkName);
                        sb.append("], params: ");
                        sb.append(new org.json.JSONObject(requestParamMap).toString());
                        sb.append(", gdpr: ");
                        sb.append(z);
                        sb.append(", in eu: ");
                        sb.append(z2);
                    }
                    initMediation.initSDK(com.anythink.core.common.b.o.this.k, requestParamMap, null);
                }
            } catch (java.lang.Throwable th4) {
                th4.printStackTrace();
            }
        }
    }

    /* renamed from: com.anythink.core.common.b.o$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.b.o.this.t();
        }
    }

    /* renamed from: com.anythink.core.common.b.o$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        public AnonymousClass8() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.o.a().a(com.anythink.core.common.b.o.this.k);
        }
    }

    /* renamed from: com.anythink.core.common.b.o$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass9(android.content.Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.o.e.q(this.a);
        }
    }

    private o() {
    }

    private void N() {
        try {
            android.content.BroadcastReceiver broadcastReceiver = this.w;
            if (broadcastReceiver != null) {
                this.k.unregisterReceiver(broadcastReceiver);
                com.anythink.core.common.b.l.a(this.k).a(this.w);
            }
            this.w = null;
        } catch (java.lang.Throwable unused) {
        }
        try {
            this.w = new com.anythink.core.common.b.o.AnonymousClass13();
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addAction(com.anythink.core.common.b.h.G);
            this.k.registerReceiver(this.w, intentFilter);
            com.anythink.core.common.b.l.a(this.k).a(this.w, intentFilter);
        } catch (java.lang.Throwable unused2) {
        }
    }

    private void O() {
        java.lang.Throwable th;
        boolean z;
        boolean z2 = false;
        if (this.k != null) {
            try {
                z = new java.io.File(this.k.getExternalFilesDir(null), this.B).exists();
                if (!z) {
                    try {
                        z = new java.io.File(this.k.getFilesDir(), this.B).exists();
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        z2 = z;
                        this.C = z2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                z = false;
            }
            z2 = z;
        }
        this.C = z2;
    }

    private boolean P() {
        return this.I;
    }

    private long Q() {
        return this.ac;
    }

    private static long a(long j2) {
        java.util.Date date = new java.util.Date(j2);
        return new java.util.Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
    }

    public static com.anythink.core.common.b.o a() {
        if (j == null) {
            synchronized (com.anythink.core.common.b.o.class) {
                if (j == null) {
                    j = new com.anythink.core.common.b.o();
                }
            }
        }
        return j;
    }

    private void a(android.content.Context context, com.anythink.core.api.ATNetworkConfig aTNetworkConfig) {
        if (aTNetworkConfig == null) {
            aTNetworkConfig = new com.anythink.core.api.ATNetworkConfig();
        }
        java.util.List<com.anythink.core.api.ATInitConfig> aTInitConfigList = aTNetworkConfig.getATInitConfigList();
        if (aTInitConfigList == null) {
            aTInitConfigList = new java.util.ArrayList<>(2);
        }
        try {
            if (v()) {
                aTInitConfigList.clear();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            aTInitConfigList = new java.util.ArrayList<>(2);
        }
        boolean z = false;
        this.K = aTInitConfigList.size() > 0;
        com.anythink.core.api.ATInitConfig aTInitConfig = null;
        if (android.os.Build.VERSION.SDK_INT != 29) {
            try {
                java.lang.reflect.Constructor declaredConstructor = java.lang.Class.forName("com.anythink.network.facebook.FacebookATInitConfig").asSubclass(com.anythink.core.api.ATInitConfig.class).getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                com.anythink.core.api.ATInitConfig aTInitConfig2 = (com.anythink.core.api.ATInitConfig) declaredConstructor.newInstance(new java.lang.Object[0]);
                try {
                    aTInitConfigList.add(0, aTInitConfig2);
                } catch (java.lang.Throwable unused) {
                }
                aTInitConfig = aTInitConfig2;
            } catch (java.lang.Throwable unused2) {
            }
        }
        for (com.anythink.core.api.ATInitConfig aTInitConfig3 : aTInitConfigList) {
            if (aTInitConfig3 != null) {
                if (aTInitConfig != null && android.text.TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig3.getClass().getSimpleName())) {
                    if (!z) {
                        z = true;
                    }
                }
                a(new com.anythink.core.common.b.o.AnonymousClass6(aTInitConfig3, context));
            }
        }
    }

    public static void a(android.content.Context context, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.d.f.a(context.getApplicationContext()).h(str);
    }

    public static void a(com.anythink.core.api.ATSharedPlacementConfig aTSharedPlacementConfig) {
        com.anythink.core.common.w.a().a(aTSharedPlacementConfig);
    }

    public static /* synthetic */ void a(com.anythink.core.common.b.o oVar) {
        java.lang.Throwable th;
        boolean z;
        boolean z2 = false;
        if (oVar.k != null) {
            try {
                z = new java.io.File(oVar.k.getExternalFilesDir(null), oVar.B).exists();
                if (!z) {
                    try {
                        z = new java.io.File(oVar.k.getFilesDir(), oVar.B).exists();
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        z2 = z;
                        oVar.C = z2;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                z = false;
            }
            z2 = z;
        }
        oVar.C = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.anythink.core.common.b.o oVar, android.content.Context context) {
        long j2 = oVar.d;
        try {
            java.lang.String b2 = com.anythink.core.common.o.r.b(a().k, com.anythink.core.common.b.h.p, a().o() + "playRecord", "");
            if (!android.text.TextUtils.isEmpty(b2)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(b2);
                long optLong = jSONObject.optLong("start_time");
                long optLong2 = jSONObject.optLong("end_time");
                java.lang.String optString = jSONObject.optString(com.anythink.core.common.b.e.c);
                int optInt = jSONObject.optInt(com.anythink.core.common.b.e.d);
                if (j2 != 0) {
                    com.anythink.core.common.n.c.a(optInt == 1 ? 4 : 2, optLong, optLong2, optString);
                    long j3 = (optLong2 - optLong) / 1000;
                } else {
                    try {
                        long j4 = (optLong2 - optLong) / 1000;
                        j2 = optLong;
                    } catch (java.lang.Exception unused) {
                        j2 = optLong;
                        com.anythink.core.common.o.r.a(a().k, com.anythink.core.common.b.h.p, a().o() + "playRecord", "");
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        ((android.app.Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new com.anythink.core.common.b.e(j2));
                    }
                }
                com.anythink.core.common.o.r.a(a().k, com.anythink.core.common.b.h.p, a().o() + "playRecord", "");
            }
        } catch (java.lang.Exception unused2) {
        }
        if (j2 != 0) {
            j2 = com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.j, (java.lang.Long) 0L).longValue();
        }
        if (j2 == 0) {
            j2 = java.lang.System.currentTimeMillis();
        }
        ((android.app.Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new com.anythink.core.common.b.e(j2));
    }

    public static /* synthetic */ void a(com.anythink.core.common.b.o oVar, android.content.Context context, com.anythink.core.api.ATNetworkConfig aTNetworkConfig) {
        if (aTNetworkConfig == null) {
            aTNetworkConfig = new com.anythink.core.api.ATNetworkConfig();
        }
        java.util.List<com.anythink.core.api.ATInitConfig> aTInitConfigList = aTNetworkConfig.getATInitConfigList();
        if (aTInitConfigList == null) {
            aTInitConfigList = new java.util.ArrayList<>(2);
        }
        try {
            if (oVar.v()) {
                aTInitConfigList.clear();
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            aTInitConfigList = new java.util.ArrayList<>(2);
        }
        boolean z = false;
        oVar.K = aTInitConfigList.size() > 0;
        com.anythink.core.api.ATInitConfig aTInitConfig = null;
        if (android.os.Build.VERSION.SDK_INT != 29) {
            try {
                java.lang.reflect.Constructor declaredConstructor = java.lang.Class.forName("com.anythink.network.facebook.FacebookATInitConfig").asSubclass(com.anythink.core.api.ATInitConfig.class).getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                com.anythink.core.api.ATInitConfig aTInitConfig2 = (com.anythink.core.api.ATInitConfig) declaredConstructor.newInstance(new java.lang.Object[0]);
                try {
                    aTInitConfigList.add(0, aTInitConfig2);
                } catch (java.lang.Throwable unused) {
                }
                aTInitConfig = aTInitConfig2;
            } catch (java.lang.Throwable unused2) {
            }
        }
        for (com.anythink.core.api.ATInitConfig aTInitConfig3 : aTInitConfigList) {
            if (aTInitConfig3 != null) {
                if (aTInitConfig != null && android.text.TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig3.getClass().getSimpleName())) {
                    if (!z) {
                        z = true;
                    }
                }
                a(oVar.new AnonymousClass6(aTInitConfig3, context));
            }
        }
    }

    public static void a(java.lang.Runnable runnable) {
        com.anythink.core.common.o.b.b.a().a(runnable, 7, true);
    }

    public static boolean a(android.content.Context context, java.util.List<java.lang.String> list) {
        boolean z = true;
        if (list == null) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : list) {
            try {
            } catch (java.lang.Throwable th) {
                sb.append(", error: ");
                sb.append(th.getMessage());
            }
            if (context.getPackageManager().queryIntentActivities(new android.content.Intent(context, java.lang.Class.forName(str)), 131072).size() <= 0) {
                sb.append(", ");
                sb.append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (!z) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Activities : Missing ");
            sb2.append(sb.toString());
            sb2.append(" declare in AndroidManifest");
        }
        return z;
    }

    public static boolean a(android.content.Context context, java.util.List<java.lang.String> list, boolean z) {
        if (list == null || list.size() == 0) {
            return true;
        }
        java.lang.String str = "";
        boolean z2 = false;
        try {
            int size = list.size();
            int i = 0;
            boolean z3 = true;
            while (true) {
                if (i >= size) {
                    z2 = z3;
                    break;
                }
                java.lang.String str2 = list.get(i);
                try {
                    if (android.text.TextUtils.isEmpty(str)) {
                        str = str2.split("_")[0] + "_*";
                    }
                    int identifier = context.getResources().getIdentifier(str2, "layout", context.getPackageName());
                    if (identifier <= 0) {
                        break;
                    }
                    android.content.res.XmlResourceParser xmlResourceParser = null;
                    try {
                        xmlResourceParser = context.getResources().getLayout(identifier);
                        while (true) {
                            int next = xmlResourceParser.next();
                            if (next == 1) {
                                break;
                            }
                            if (next == 2) {
                                if ("x".equalsIgnoreCase(xmlResourceParser.getName())) {
                                    if (xmlResourceParser.getAttributeCount() == 0) {
                                        z3 = false;
                                        break;
                                    }
                                } else if (xmlResourceParser.getAttributeCount() >= 0) {
                                    break;
                                }
                            }
                        }
                    } finally {
                        try {
                            if (xmlResourceParser == null) {
                                i++;
                            }
                            xmlResourceParser.close();
                            i++;
                        } finally {
                        }
                    }
                    xmlResourceParser.close();
                    i++;
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (!z2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Resource: The ");
            sb.append(str);
            sb.append(" resources are missing. If shrinkResources is enabled, the ");
            sb.append(str);
            sb.append(" resources must be added to the whitelist (keep.xml)");
        }
        return z2;
    }

    private void b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        a(context.getApplicationContext(), str, str2);
        a(new com.anythink.core.common.b.o.AnonymousClass14(context, str));
    }

    public static /* synthetic */ void b(com.anythink.core.common.b.o oVar, android.content.Context context) {
        try {
            java.lang.Object obj = null;
            try {
                obj = com.anythink.network.adx.AdxATInitManager.class.getDeclaredMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            } catch (java.lang.Throwable unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Cannot instantiate ");
                sb.append(com.anythink.network.adx.AdxATInitManager.class.getName());
                sb.append(", please check if SDK is imported");
            }
            if (obj == null || !(obj instanceof com.anythink.core.api.ATInitMediation) || a(context, (java.util.List<java.lang.String>) ((com.anythink.core.api.ATInitMediation) obj).getResourceStatus(), true) || !com.anythink.core.api.ATCommonConfig.isShowInitErrorTips) {
                return;
            }
            oVar.a(oVar.new AnonymousClass12(), 500L);
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static void b(java.lang.Runnable runnable, long j2) {
        com.anythink.core.common.o.b.b.a().a(runnable, j2);
    }

    public static boolean b(android.content.Context context, java.util.List<java.lang.String> list) {
        boolean z = true;
        if (list == null) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        for (java.lang.String str : list) {
            try {
            } catch (java.lang.Throwable th) {
                sb.append(", error: ");
                sb.append(th.getMessage());
            }
            if (packageManager.queryIntentServices(new android.content.Intent(context, java.lang.Class.forName(str)), 131072).size() <= 0) {
                sb.append(", ");
                sb.append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (!z) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Services : Missing ");
            sb2.append(sb.toString());
            sb2.append(" declare in AndroidManifest");
        }
        return z;
    }

    public static boolean b(java.util.Map<java.lang.String, java.lang.Boolean> map) {
        boolean z = true;
        if (map == null) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : map.keySet()) {
            if (!map.get(str).booleanValue()) {
                sb.append(", ");
                sb.append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (!z) {
            "Dependence Plugin: Missing ".concat(java.lang.String.valueOf(sb));
        }
        return z;
    }

    private void c(android.content.Context context) {
        try {
            java.lang.Object obj = null;
            try {
                obj = com.anythink.network.adx.AdxATInitManager.class.getDeclaredMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            } catch (java.lang.Throwable unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Cannot instantiate ");
                sb.append(com.anythink.network.adx.AdxATInitManager.class.getName());
                sb.append(", please check if SDK is imported");
            }
            if (obj == null || !(obj instanceof com.anythink.core.api.ATInitMediation) || a(context, (java.util.List<java.lang.String>) ((com.anythink.core.api.ATInitMediation) obj).getResourceStatus(), true) || !com.anythink.core.api.ATCommonConfig.isShowInitErrorTips) {
                return;
            }
            a(new com.anythink.core.common.b.o.AnonymousClass12(), 500L);
        } catch (java.lang.Throwable unused2) {
        }
    }

    public static void c(java.lang.Runnable runnable) {
        com.anythink.core.common.o.b.b.a().a(runnable, 2, true);
    }

    public static boolean c(android.content.Context context, java.util.List<java.lang.String> list) {
        android.content.pm.PackageInfo packageInfo;
        boolean z;
        boolean z2;
        if (list == null) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
            z = true;
        } catch (java.lang.Throwable th) {
            sb.append(", error: ");
            sb.append(th.getMessage());
            packageInfo = null;
            z = false;
        }
        if (packageInfo == null) {
            return false;
        }
        android.content.pm.ProviderInfo[] providerInfoArr = packageInfo.providers;
        for (java.lang.String str : list) {
            int length = providerInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = false;
                    break;
                }
                if (android.text.TextUtils.equals(providerInfoArr[i].name, str)) {
                    z2 = true;
                    break;
                }
                i++;
            }
            if (!z2) {
                sb.append(", ");
                sb.append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (!z) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Providers : Missing ");
            sb2.append(sb.toString());
            sb2.append(" declare in AndroidManifest");
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r2.importance != 100) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean d(android.content.Context context) {
        try {
            java.util.Iterator<android.app.ActivityManager.RunningAppProcessInfo> it = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                android.app.ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.equals(context.getPackageName())) {
                    break;
                }
            }
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean d(android.content.Context context, java.util.List<java.lang.String> list) {
        boolean z = true;
        if (list == null || list.size() == 0) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z2 = false;
        try {
            android.content.pm.ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                java.lang.String str = list.get(i);
                if (android.text.TextUtils.isEmpty(applicationInfo.metaData.getString(str))) {
                    sb.append(", \"");
                    sb.append(str);
                    sb.append("\"");
                    z = false;
                }
            }
            if (sb.length() > 2) {
                sb.delete(0, 2);
            }
            z2 = z;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (!z2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("meta-data: Missing ");
            sb2.append(sb.toString());
            sb2.append(" declare in AndroidManifest");
        }
        return z2;
    }

    private void e(boolean z) {
        this.V = z;
    }

    private boolean e(android.content.Context context) {
        java.lang.String d = com.anythink.core.common.o.e.d(context);
        if (!android.text.TextUtils.isEmpty(d) && d.equals(this.R)) {
            return true;
        }
        java.lang.String f = com.anythink.core.common.o.e.f();
        if (!android.text.TextUtils.isEmpty(f) && f.equals(this.R)) {
            return true;
        }
        com.anythink.core.api.IExHandler b2 = a().b();
        return b2 != null && b2.checkDebuggerDevice(context, this.R);
    }

    public static boolean e(android.content.Context context, java.util.List<java.lang.String> list) {
        int size;
        boolean z;
        if (list == null || (size = list.size()) == 0) {
            return true;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z2 = false;
        try {
            java.lang.String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                boolean z3 = true;
                for (int i = 0; i < size; i++) {
                    java.lang.String str = list.get(i);
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = false;
                            break;
                        }
                        if (android.text.TextUtils.equals(str, strArr[i2])) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z) {
                        if (sb.length() == 0) {
                            sb.append(str);
                        } else {
                            sb.append(", ");
                            sb.append(str);
                        }
                        z3 = false;
                    }
                }
                z2 = z3;
            } else {
                for (int i3 = 0; i3 < size; i3++) {
                    java.lang.String str2 = list.get(i3);
                    if (i3 == 0) {
                        sb.append(str2);
                    } else {
                        sb.append(", ");
                        sb.append(str2);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        if (!z2) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Permission: Missing ");
            sb2.append(sb.toString());
            sb2.append(" declare in AndroidManifest");
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(android.content.Context context) {
        long j2 = this.d;
        try {
            java.lang.String b2 = com.anythink.core.common.o.r.b(a().k, com.anythink.core.common.b.h.p, a().o() + "playRecord", "");
            if (!android.text.TextUtils.isEmpty(b2)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(b2);
                long optLong = jSONObject.optLong("start_time");
                long optLong2 = jSONObject.optLong("end_time");
                java.lang.String optString = jSONObject.optString(com.anythink.core.common.b.e.c);
                int optInt = jSONObject.optInt(com.anythink.core.common.b.e.d);
                if (j2 != 0) {
                    com.anythink.core.common.n.c.a(optInt == 1 ? 4 : 2, optLong, optLong2, optString);
                    long j3 = (optLong2 - optLong) / 1000;
                } else {
                    try {
                        long j4 = (optLong2 - optLong) / 1000;
                        j2 = optLong;
                    } catch (java.lang.Exception unused) {
                        j2 = optLong;
                        com.anythink.core.common.o.r.a(a().k, com.anythink.core.common.b.h.p, a().o() + "playRecord", "");
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        ((android.app.Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new com.anythink.core.common.b.e(j2));
                    }
                }
                com.anythink.core.common.o.r.a(a().k, com.anythink.core.common.b.h.p, a().o() + "playRecord", "");
            }
        } catch (java.lang.Exception unused2) {
        }
        if (j2 != 0) {
            j2 = com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.j, (java.lang.Long) 0L).longValue();
        }
        if (j2 == 0) {
            j2 = java.lang.System.currentTimeMillis();
        }
        ((android.app.Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new com.anythink.core.common.b.e(j2));
    }

    private static void g(android.content.Context context) {
        com.anythink.core.common.e.c.a().a(context);
    }

    public static boolean i(java.lang.String str) {
        try {
            java.lang.Class.forName(str);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static void o(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            java.lang.Long.parseLong(str);
        } catch (java.lang.Exception unused) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("AdSourceId '");
            sb.append(str);
            sb.append("' is not compliant");
        }
    }

    public static /* synthetic */ boolean r(java.lang.String str) {
        java.lang.String a2 = com.anythink.core.common.o.h.a();
        boolean z = !android.text.TextUtils.isEmpty(str) && str.startsWith(a2);
        if (!z) {
            java.lang.String.format("Adapter Version: The current Adapter version(%s) does not apply to the SDK version(%s).", str, a2);
        }
        return z;
    }

    private java.util.Map<java.lang.String, java.lang.Object> s(java.lang.String str) {
        if (this.q == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return this.q.get(str);
    }

    private void t(java.lang.String str) {
        this.l = str;
        com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.q, str);
    }

    private void u(java.lang.String str) {
        this.m = str;
        com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.r, str);
    }

    @java.lang.Deprecated
    private void v(java.lang.String str) {
        this.R = str;
    }

    private java.lang.String w(java.lang.String str) {
        synchronized (this.v) {
            java.lang.String optString = this.u.optString(str);
            if (!android.text.TextUtils.isEmpty(optString)) {
                return optString;
            }
            java.lang.String x = x();
            java.lang.String str2 = "";
            if (android.text.TextUtils.isEmpty(x)) {
                x = com.anythink.core.common.o.e.d(this.k) + com.anythink.core.common.o.e.f();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(new java.util.Random().nextInt(com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION));
                str2 = sb.toString();
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String a2 = com.anythink.core.common.o.g.a(x + str + str2 + currentTimeMillis);
            try {
                this.u.put(str, a2);
            } catch (java.lang.Exception unused) {
            }
            com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.i, this.u.toString());
            if (!android.text.TextUtils.isEmpty(x())) {
                str2 = null;
            }
            com.anythink.core.common.n.c.a(str, "2", str2, java.lang.String.valueOf(currentTimeMillis));
            return a2;
        }
    }

    private static boolean x(java.lang.String str) {
        java.lang.String a2 = com.anythink.core.common.o.h.a();
        boolean z = !android.text.TextUtils.isEmpty(str) && str.startsWith(a2);
        if (!z) {
            java.lang.String.format("Adapter Version: The current Adapter version(%s) does not apply to the SDK version(%s).", str, a2);
        }
        return z;
    }

    public final boolean A() {
        return this.C || this.D;
    }

    public final com.anythink.core.common.g.c B() {
        if (this.L == null) {
            this.L = new com.anythink.core.common.k.d();
        }
        return this.L;
    }

    public final boolean C() {
        return this.V;
    }

    public final boolean D() {
        return this.W;
    }

    public final android.content.Context E() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.e;
        return (weakReference == null || weakReference.get() == null) ? this.k : this.e.get();
    }

    public final android.app.Activity F() {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.e.get();
    }

    public final java.lang.String G() {
        return this.Y;
    }

    public final boolean H() {
        java.lang.Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            java.lang.Class.forName("com.reyun.mobdna.MobDNA");
            this.c = java.lang.Boolean.TRUE;
        } catch (java.lang.Throwable unused) {
            this.c = java.lang.Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    public final boolean I() {
        return this.K;
    }

    public final com.anythink.core.api.ATPrivacyConfig J() {
        return this.Z;
    }

    public final int K() {
        return this.aa;
    }

    public final com.anythink.core.common.f.ax L() {
        if (this.ab == null) {
            this.ab = new com.anythink.core.common.f.ax();
        }
        try {
            this.ab.a(com.anythink.core.common.o.e.t(a().k));
            this.ab.b(com.anythink.core.common.o.e.k());
            this.ab.c(com.anythink.core.common.o.e.m());
            this.ab.d(com.anythink.core.common.o.e.b(com.anythink.core.common.o.e.l()));
        } catch (java.lang.Throwable unused) {
        }
        return this.ab;
    }

    public final void M() {
        this.ac = java.lang.System.currentTimeMillis();
    }

    public final synchronized long a(android.content.Context context, java.lang.String str, int i) {
        com.anythink.core.d.a b2 = com.anythink.core.d.b.a(context).b(str);
        java.lang.String b3 = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.h, "");
        java.lang.String b4 = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.i, "");
        long longValue = com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.j, (java.lang.Long) 0L).longValue();
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        if (currentTimeMillis - longValue < 0) {
            longValue = 0;
        }
        if (currentTimeMillis - longValue <= (i == 0 ? b2.X() : b2.J())) {
            b2.X();
            this.t = b3;
            if (!android.text.TextUtils.isEmpty(b4)) {
                synchronized (this.v) {
                    this.u = new org.json.JSONObject(b4);
                }
            }
            return 0L;
        }
        b2.X();
        java.lang.String x = x();
        java.lang.String str2 = "";
        if (android.text.TextUtils.isEmpty(x)) {
            x = com.anythink.core.common.o.e.d(context) + com.anythink.core.common.o.e.f();
            str2 = java.lang.String.valueOf(new java.util.Random().nextInt(com.huawei.hms.framework.common.ExceptionCode.CRASH_EXCEPTION));
        }
        this.t = com.anythink.core.common.o.g.a(x + str + str2 + currentTimeMillis);
        synchronized (this.v) {
            this.u = new org.json.JSONObject();
        }
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.h, this.t);
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.i, "");
        com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.j, currentTimeMillis);
        com.anythink.core.common.n.c.a((java.lang.String) null, "1", str2, java.lang.String.valueOf(currentTimeMillis));
        if (i == 0) {
            this.d = currentTimeMillis;
        }
        return currentTimeMillis;
    }

    public final void a(int i) {
        if (i == 2) {
            this.U = 2;
        } else {
            this.U = 1;
        }
    }

    public final void a(android.app.Activity activity) {
        java.lang.ref.WeakReference<android.app.Activity> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            this.e = new java.lang.ref.WeakReference<>(activity);
        }
    }

    public final void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        this.k = context;
    }

    public final void a(android.content.Context context, com.anythink.core.api.DeviceInfoCallback deviceInfoCallback) {
        if (this.J) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.b.o.AnonymousClass4(context, deviceInfoCallback), 2, true);
        } else if (deviceInfoCallback != null) {
            deviceInfoCallback.deviceInfo("You should init SDK first.");
        }
    }

    public final void a(android.content.Context context, java.lang.String str, com.anythink.core.api.ATDebuggerConfig aTDebuggerConfig) {
        com.anythink.core.api.IExHandler b2;
        if (context == null) {
            A();
            return;
        }
        if (a().k == null) {
            a().a(context.getApplicationContext());
        }
        this.R = str;
        this.S = aTDebuggerConfig;
        java.lang.String d = com.anythink.core.common.o.e.d(context);
        boolean z = true;
        if (android.text.TextUtils.isEmpty(d) || !d.equals(this.R)) {
            java.lang.String f = com.anythink.core.common.o.e.f();
            if ((android.text.TextUtils.isEmpty(f) || !f.equals(this.R)) && ((b2 = a().b()) == null || !b2.checkDebuggerDevice(context, this.R))) {
                z = false;
            }
        }
        this.T = z;
        if (android.text.TextUtils.isEmpty(this.R)) {
            A();
            this.T = false;
        } else {
            if (!this.T) {
                A();
                return;
            }
            A();
            if (this.S != null) {
                A();
            }
        }
    }

    public final void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.b.o.AnonymousClass3(context, str, str2), 13);
    }

    public final synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.anythink.core.api.ATNetworkConfig aTNetworkConfig) {
        if (context == null) {
            return;
        }
        this.k = context.getApplicationContext();
        if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
            if (this.J) {
                return;
            }
            this.J = true;
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                long longValue = com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.m, (java.lang.Long) 0L).longValue();
                this.E = longValue;
                if (longValue == 0) {
                    this.E = currentTimeMillis;
                    com.anythink.core.common.o.r.a(context, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.m, currentTimeMillis);
                }
                this.F = ((a(currentTimeMillis) - a(this.E)) / 86400000) + 1;
                this.d = 0L;
                com.anythink.core.a.a.a(context.getApplicationContext()).a();
                this.aa = com.anythink.core.common.o.r.b(context, com.anythink.core.common.b.h.p, "r", 1);
                android.content.Context applicationContext = context.getApplicationContext();
                a(applicationContext);
                this.l = str;
                com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.q, str);
                this.m = str2;
                com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.r, str2);
                this.V = com.anythink.core.common.o.i.a();
                com.anythink.core.common.e.c.a().a(context);
                try {
                    android.content.BroadcastReceiver broadcastReceiver = this.w;
                    if (broadcastReceiver != null) {
                        this.k.unregisterReceiver(broadcastReceiver);
                        com.anythink.core.common.b.l.a(this.k).a(this.w);
                    }
                    this.w = null;
                } catch (java.lang.Throwable unused) {
                }
                try {
                    this.w = new com.anythink.core.common.b.o.AnonymousClass13();
                    android.content.IntentFilter intentFilter = new android.content.IntentFilter();
                    intentFilter.addAction(com.igexin.sdk.PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                    intentFilter.addAction(com.anythink.core.common.b.h.G);
                    this.k.registerReceiver(this.w, intentFilter);
                    com.anythink.core.common.b.l.a(this.k).a(this.w, intentFilter);
                } catch (java.lang.Throwable unused2) {
                }
                a(new com.anythink.core.common.b.o.AnonymousClass1(applicationContext, str, context));
                a(new com.anythink.core.common.b.o.AnonymousClass7());
                a(new com.anythink.core.common.b.o.AnonymousClass8());
                ((android.app.Application) this.k).registerActivityLifecycleCallbacks(new com.anythink.core.common.b.f(d(this.k)));
                a(new com.anythink.core.common.b.o.AnonymousClass9(applicationContext), 5000L);
                a(new com.anythink.core.common.b.o.AnonymousClass10(context, applicationContext));
                a(new com.anythink.core.common.b.o.AnonymousClass11(aTNetworkConfig));
                a(context.getApplicationContext(), str, str2);
                a(new com.anythink.core.common.b.o.AnonymousClass14(context, str));
            } catch (java.lang.Exception e) {
                new java.lang.StringBuilder("init failed: ").append(e.getMessage());
            }
        }
    }

    public final synchronized void a(android.location.Location location) {
        this.M = location;
    }

    public final void a(com.anythink.core.api.ATPrivacyConfig aTPrivacyConfig) {
        this.Z = aTPrivacyConfig;
    }

    public final void a(java.lang.Runnable runnable, long j2) {
        if (j2 > 0 || android.os.Looper.getMainLooper() != android.os.Looper.myLooper()) {
            this.n.postDelayed(runnable, j2);
        } else {
            runnable.run();
        }
    }

    public final void a(java.lang.String str) {
        this.o = str;
    }

    public final synchronized void a(java.lang.String str, com.anythink.core.api.ATCustomAdapterConfig aTCustomAdapterConfig) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (this.r == null) {
            this.r = new java.util.concurrent.ConcurrentHashMap<>();
        }
        if (aTCustomAdapterConfig == null) {
            this.r.remove(str);
        } else {
            this.r.put(str, aTCustomAdapterConfig);
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (this.J && !android.text.TextUtils.isEmpty(str)) {
            com.anythink.core.common.f a2 = com.anythink.core.common.u.a().a(str, str3);
            if (a2 == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("The \"");
                sb.append(str);
                sb.append("\" object has not been created yet!");
            } else {
                boolean f = a2.f();
                com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.b.o.AnonymousClass5(str, a2, str2, a2.a(this.k, false, false, map, (com.anythink.core.common.f.c) null), map, f, str3), 2, true);
            }
        }
    }

    public final void a(java.lang.String str, java.util.List<java.lang.String> list) {
        this.Q.put(str, list);
    }

    public final void a(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null) {
            this.q.put(str, map);
        }
    }

    public final void a(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map, java.lang.String... strArr) {
        com.anythink.core.common.f.h hVar;
        if (map == null || map.containsKey(com.anythink.core.api.ATInitMediation.KEY_LOCAL)) {
            return;
        }
        try {
            hVar = (com.anythink.core.common.f.h) map.get(com.anythink.core.common.b.h.o.h);
        } catch (java.lang.Throwable unused) {
            hVar = null;
        }
        map.remove(com.anythink.core.common.b.h.o.h);
        java.lang.String jSONObject = new org.json.JSONObject(map).toString();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Mismatched initialization parameters! server params: [");
        sb.append(str);
        sb.append("], ");
        sb.append(jSONObject);
        com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.B, str, jSONObject);
        if (hVar == null || strArr == null) {
            return;
        }
        try {
            com.anythink.core.common.n.c.a(hVar, strArr[0], strArr.length > 1 ? strArr[1] : null);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(java.util.List<java.lang.String> list) {
        try {
            this.P = list;
            if (list == null || list.isEmpty()) {
                this.O = null;
            } else {
                this.O = new org.json.JSONArray((java.util.Collection) list);
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public final void a(java.util.Map<java.lang.String, java.lang.Object> map) {
        if (map != null && map.containsKey("channel")) {
            java.lang.Object obj = map.get("channel");
            java.lang.String obj2 = obj != null ? obj.toString() : "";
            this.G = obj2;
            if (!com.anythink.core.common.o.h.a(obj2)) {
                this.G = null;
                map.remove("channel");
            }
        }
        if (map != null && map.containsKey("sub_channel")) {
            java.lang.Object obj3 = map.get("sub_channel");
            java.lang.String obj4 = obj3 != null ? obj3.toString() : "";
            this.H = obj4;
            if (!com.anythink.core.common.o.h.b(obj4)) {
                this.H = null;
                map.remove("sub_channel");
            }
        }
        this.p.clear();
        if (map != null) {
            this.p.putAll(map);
        }
        if (!android.text.TextUtils.isEmpty(this.G)) {
            this.p.put("channel", this.G);
        }
        if (android.text.TextUtils.isEmpty(this.H)) {
            return;
        }
        this.p.put("sub_channel", this.H);
    }

    public final synchronized void a(boolean z) {
        this.N = z ? "1" : "2";
    }

    public final void a(java.lang.String... strArr) {
        synchronized (this.f166s) {
            if (strArr != null) {
                for (java.lang.String str : strArr) {
                    this.f166s.put(str, java.lang.Boolean.TRUE);
                }
            } else {
                this.f166s.clear();
            }
        }
    }

    public final void a(java.lang.String[] strArr, com.anythink.core.api.IATAdFilter iATAdFilter) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.api.IATAdFilter> concurrentHashMap = this.X;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        if (this.X == null) {
            this.X = new java.util.concurrent.ConcurrentHashMap<>();
        }
        for (java.lang.String str : strArr) {
            this.X.put(str, iATAdFilter);
        }
    }

    public final com.anythink.core.api.ATCustomAdapterConfig b(java.lang.String str) {
        if (this.r == null || android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        return this.r.get(str);
    }

    public final com.anythink.core.api.IExHandler b() {
        if (this.i) {
            return this.A;
        }
        synchronized (this.ad) {
            if (this.i) {
                return this.A;
            }
            try {
                java.lang.reflect.Constructor declaredConstructor = com.anythink.pd.ExHandler.class.asSubclass(com.anythink.core.api.IExHandler.class).getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                this.A = (com.anythink.core.api.IExHandler) declaredConstructor.newInstance(new java.lang.Object[0]);
            } catch (java.lang.Exception unused) {
            }
            this.i = true;
            return this.A;
        }
    }

    public final void b(int i) {
        this.f = i;
    }

    public final void b(android.content.Context context) {
        if (A()) {
            com.anythink.core.common.o.b.b.a().a((java.lang.Runnable) new com.anythink.core.common.b.o.AnonymousClass2(context), 2, true);
        }
    }

    public final void b(java.lang.Runnable runnable) {
        if (android.os.Looper.getMainLooper() == android.os.Looper.myLooper()) {
            runnable.run();
        } else {
            this.n.post(runnable);
        }
    }

    public final void b(java.lang.String str, java.util.List<java.lang.String> list) {
        this.Q.put(str + "_network_firm", list);
    }

    public final void b(boolean z) {
        this.D = z;
    }

    public final java.lang.String c() {
        return this.o;
    }

    public final void c(int i) {
        this.aa = i;
    }

    public final void c(boolean z) {
        this.I = z;
    }

    public final boolean c(java.lang.String str) {
        boolean containsKey;
        synchronized (this.f166s) {
            containsKey = this.f166s.containsKey(str);
        }
        return containsKey;
    }

    public final int d() {
        return this.U;
    }

    public final long d(int i) {
        if (i != 1 && i != 4) {
            return 26214400L;
        }
        com.anythink.core.d.b.a(this.k);
        return com.anythink.core.d.b.a() * 1024;
    }

    public final java.util.Map<java.lang.String, java.lang.Object> d(java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        java.util.Map<java.lang.String, java.lang.Object> map = this.q.get(str);
        java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> concurrentHashMap = this.p;
        if (concurrentHashMap != null) {
            hashMap.putAll(concurrentHashMap);
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.remove("channel");
        hashMap.remove("sub_channel");
        java.lang.Object obj = this.p.get("channel");
        java.lang.Object obj2 = this.p.get("sub_channel");
        if (obj != null) {
            hashMap.put("channel", obj);
        }
        if (obj2 != null) {
            hashMap.put("sub_channel", obj2);
        }
        return hashMap;
    }

    public final void d(java.lang.Runnable runnable) {
        this.n.removeCallbacks(runnable);
    }

    public final void d(boolean z) {
        this.W = z;
    }

    public final void e(java.lang.String str) {
        this.G = str;
        this.p.put("channel", str);
    }

    public final java.lang.String[] e() {
        synchronized (this.f166s) {
            java.util.Set<java.lang.String> keySet = this.f166s.keySet();
            int size = keySet.size();
            if (size <= 0) {
                return null;
            }
            java.lang.String[] strArr = new java.lang.String[size];
            keySet.toArray(strArr);
            return strArr;
        }
    }

    public final android.content.Context f() {
        return this.k;
    }

    public final void f(java.lang.String str) {
        this.H = str;
        this.p.put("sub_channel", str);
    }

    public final long g() {
        return this.E;
    }

    public final java.lang.String g(java.lang.String str) {
        java.lang.String optString;
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        synchronized (this.v) {
            optString = this.u.optString(str);
        }
        return android.text.TextUtils.isEmpty(optString) ? w(str) : optString;
    }

    public final long h() {
        return this.F;
    }

    public final void h(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(this.R)) {
            return;
        }
        if (android.text.TextUtils.equals(str, this.R)) {
            this.T = true;
        }
        if (this.T) {
            A();
        }
    }

    public final int i() {
        return this.f;
    }

    public final java.util.List<java.lang.String> j() {
        return this.P;
    }

    public final void j(java.lang.String str) {
        this.y = str;
        com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.A, com.anythink.core.common.b.h.u.n, str);
    }

    public final org.json.JSONArray k() {
        return this.O;
    }

    public final void k(java.lang.String str) {
        this.z = str;
        com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.A, com.anythink.core.common.b.h.u.o, str);
    }

    public final java.util.Map<java.lang.String, java.lang.Object> l() {
        return this.p;
    }

    public final void l(java.lang.String str) {
        com.anythink.core.common.o.r.a(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.k, str);
        this.x = str;
    }

    public final java.lang.String m() {
        java.lang.Object obj = this.p.get("channel");
        return obj != null ? obj.toString() : "";
    }

    public final java.util.List<java.lang.String> m(java.lang.String str) {
        return this.Q.get(str);
    }

    public final java.lang.String n() {
        java.lang.Object obj = this.p.get("sub_channel");
        return obj != null ? obj.toString() : "";
    }

    public final java.util.List<java.lang.String> n(java.lang.String str) {
        return this.Q.get(str + "_network_firm");
    }

    public final java.lang.String o() {
        if (android.text.TextUtils.isEmpty(this.l)) {
            this.l = com.anythink.core.common.o.r.b(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.q, "");
        }
        return this.l;
    }

    public final com.anythink.core.api.IATAdFilter p(java.lang.String str) {
        java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.api.IATAdFilter> concurrentHashMap;
        if (android.text.TextUtils.isEmpty(str) || (concurrentHashMap = this.X) == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public final java.lang.String p() {
        if (android.text.TextUtils.isEmpty(this.m)) {
            this.m = com.anythink.core.common.o.r.b(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.r, "");
        }
        return this.m;
    }

    public final java.lang.String q() {
        try {
            if (android.text.TextUtils.isEmpty(this.t)) {
                a(this.k, o(), 0);
            }
        } catch (java.lang.Exception unused) {
        }
        return this.t;
    }

    public final void q(java.lang.String str) {
        this.Y = str;
    }

    public final android.location.Location r() {
        return this.M;
    }

    public final java.lang.String s() {
        return this.N;
    }

    public final void t() {
        try {
            com.anythink.core.common.o.e.a(this.k);
            com.anythink.core.common.o.e.r(this.k);
        } catch (java.lang.Exception unused) {
        }
        if (A()) {
            java.lang.String d = com.anythink.core.common.o.e.d(this.k);
            java.lang.StringBuilder sb = new java.lang.StringBuilder("********************************** ");
            sb.append(com.anythink.core.common.o.h.a());
            sb.append(" *************************************");
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder("GAID(ADID): ");
            sb2.append(com.anythink.core.common.o.e.f());
            sb2.append(" , AndroidID: ");
            sb2.append(d);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder("********************************** ");
            sb3.append(com.anythink.core.common.o.h.a());
            sb3.append(" *************************************");
            if (android.text.TextUtils.isEmpty(d)) {
                return;
            }
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder("You can use \"ATSDK.setDebuggerConfig(context, \"");
            sb4.append(d);
            sb4.append("\",new ATDebuggerConfig.Builder(the NetworkFirmId you want to test).build());\" to open the debugger mode.");
        }
    }

    public final boolean u() {
        return this.T;
    }

    public final boolean v() {
        return this.T && this.S != null;
    }

    public final com.anythink.core.api.ATDebuggerConfig w() {
        return this.S;
    }

    public final java.lang.String x() {
        if (android.text.TextUtils.isEmpty(this.x)) {
            this.x = com.anythink.core.common.o.r.b(this.k, com.anythink.core.common.b.h.p, com.anythink.core.common.b.h.u.k, "");
        }
        return this.x;
    }

    public final java.lang.String y() {
        if (android.text.TextUtils.isEmpty(this.y)) {
            this.y = com.anythink.core.common.o.r.b(this.k, com.anythink.core.common.b.h.A, com.anythink.core.common.b.h.u.n, "");
        }
        return this.y;
    }

    public final java.lang.String z() {
        if (android.text.TextUtils.isEmpty(this.z)) {
            this.z = com.anythink.core.common.o.r.b(this.k, com.anythink.core.common.b.h.A, com.anythink.core.common.b.h.u.o, "");
        }
        return this.z;
    }
}
