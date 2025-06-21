package com.loc;

/* loaded from: classes23.dex */
public final class n {
    private static volatile boolean D = false;
    public static int a = -1;
    public static java.lang.String b = "";
    public static android.content.Context c = null;
    private static java.lang.String k = "6";
    private static java.lang.String l = "4";
    private static java.lang.String m = "9";
    private static java.lang.String n = "8";
    private static volatile boolean o = true;
    private static java.util.Vector<com.loc.n.e> p = new java.util.Vector<>();
    private static java.util.Map<java.lang.String, java.lang.Integer> q = new java.util.HashMap();
    private static java.lang.String r = null;

    /* renamed from: s, reason: collision with root package name */
    private static long f415s = 0;
    public static volatile boolean d = false;
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.n.g> t = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> u = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.n.d> v = new java.util.concurrent.ConcurrentHashMap<>(8);
    private static boolean w = false;
    private static boolean x = false;
    public static int e = 5000;
    public static boolean f = true;
    public static boolean g = false;
    private static int y = 3;
    public static boolean h = true;
    public static boolean i = false;
    private static int z = 3;
    public static boolean j = false;
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> A = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> B = new java.util.concurrent.ConcurrentHashMap<>();
    private static java.util.ArrayList<com.loc.bs.a> C = new java.util.ArrayList<>();
    private static java.util.Queue<com.loc.bs.c> E = new java.util.LinkedList();

    /* renamed from: com.loc.n$1, reason: invalid class name */
    public class AnonymousClass1 extends com.loc.cu {
        final /* synthetic */ java.lang.String a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;
        final /* synthetic */ java.lang.String d;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // com.loc.cu
        public final void a() {
            com.loc.n.d dVar = (com.loc.n.d) com.loc.n.v.get(this.a);
            if (dVar == null) {
                return;
            }
            com.loc.n.a aVar = dVar.c;
            com.loc.n.b a = com.loc.n.a(com.loc.n.c, dVar.a, dVar.b, this.b, this.c, this.d);
            if (a == null || aVar == null) {
                return;
            }
            aVar.a(a);
        }
    }

    public interface a {
        void a(com.loc.n.b bVar);
    }

    public static class b {

        @java.lang.Deprecated
        public org.json.JSONObject a;

        @java.lang.Deprecated
        public org.json.JSONObject b;
        public java.lang.String c;
        public int d = -1;
        public long e = 0;
        public org.json.JSONObject f;
        public com.loc.n.b.a g;
        public com.loc.n.b.C0419b h;
        private boolean i;

        public static class a {
            public boolean a;
            public boolean b;
            public org.json.JSONObject c;
        }

        /* renamed from: com.loc.n$b$b, reason: collision with other inner class name */
        public static class C0419b {
            public boolean a;
        }
    }

    public static class c extends com.loc.bq {
        private java.lang.String d;
        private java.util.Map<java.lang.String, java.lang.String> e;
        private java.lang.String f;
        private java.lang.String g;
        private java.lang.String h;

        public c(android.content.Context context, com.loc.x xVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            super(context, xVar);
            this.d = str;
            this.e = null;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            a(com.loc.bu.c.HTTPS);
            a(com.loc.bu.a.FIX);
        }

        private static java.lang.String a(java.lang.String str, java.lang.String str2) {
            try {
                return !android.text.TextUtils.isEmpty(str2) ? android.net.Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (java.lang.Throwable unused) {
                return str;
            }
        }

        @Override // com.loc.bu
        public final java.util.Map<java.lang.String, java.lang.String> a() {
            if (android.text.TextUtils.isEmpty(this.h)) {
                return null;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.alipay.sdk.m.l.c.f, this.h);
            return hashMap;
        }

        @Override // com.loc.bq
        public final byte[] a_() {
            return null;
        }

        @Override // com.loc.bu
        public final java.lang.String b() {
            return a("https://restsdk.amap.com/v3/iasdkauth", this.f);
        }

        @Override // com.loc.bq
        public final byte[] b_() {
            java.lang.String p = com.loc.p.p(((com.loc.bq) this).a);
            if (!android.text.TextUtils.isEmpty(p)) {
                p = com.loc.t.a(new java.lang.StringBuilder(p).reverse().toString());
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("authkey", android.text.TextUtils.isEmpty(this.d) ? "" : this.d);
            hashMap.put("plattype", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            hashMap.put("ccver", "1");
            hashMap.put("product", ((com.loc.bq) this).b.a());
            hashMap.put("version", ((com.loc.bq) this).b.b());
            hashMap.put("output", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.os.Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", p);
            hashMap.put("manufacture", android.os.Build.MANUFACTURER);
            java.util.Map<java.lang.String, java.lang.String> map = this.e;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.e);
            }
            hashMap.put("abitype", com.loc.y.a(((com.loc.bq) this).a));
            hashMap.put("ext", ((com.loc.bq) this).b.d());
            return com.loc.y.a(com.loc.y.a(hashMap));
        }

        @Override // com.loc.s, com.loc.bu
        public final java.lang.String c() {
            return a("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.g);
        }

        @Override // com.loc.bq
        public final java.lang.String f() {
            return "3.0";
        }

        @Override // com.loc.bu
        public final java.lang.String g() {
            return !android.text.TextUtils.isEmpty(this.h) ? this.h : super.g();
        }
    }

    public static class d {
        com.loc.x a;
        java.lang.String b;
        com.loc.n.a c;

        private d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    public static class e {
        private java.lang.String a;
        private java.lang.String b;
        private java.util.concurrent.atomic.AtomicInteger c;

        public e(java.lang.String str, java.lang.String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = new java.util.concurrent.atomic.AtomicInteger(i);
        }

        public static com.loc.n.e b(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                return new com.loc.n.e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        public final int a() {
            java.util.concurrent.atomic.AtomicInteger atomicInteger = this.c;
            if (atomicInteger == null) {
                return 0;
            }
            return atomicInteger.get();
        }

        public final void a(java.lang.String str) {
            this.b = str;
        }

        public final java.lang.String b() {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("a", this.a);
                jSONObject.put("f", this.b);
                jSONObject.put("h", this.c.get());
                return jSONObject.toString();
            } catch (java.lang.Throwable unused) {
                return "";
            }
        }
    }

    public static class f {
        public static boolean a = true;
        public static boolean b = false;
        public static boolean c = true;
        public static int d;
        public static boolean e;
        public static int f;
    }

    public static class g {
        public long a;
        public java.lang.String b;

        public g(java.lang.Long l, java.lang.String str) {
            this.a = 0L;
            this.b = "";
            this.a = l.longValue();
            this.b = str;
        }
    }

    public static long a(java.util.List<java.lang.String> list) {
        if (list == null) {
            return 0L;
        }
        try {
            if (list.size() <= 0) {
                return 0L;
            }
            java.lang.String str = list.get(0);
            if (android.text.TextUtils.isEmpty(str)) {
                return 0L;
            }
            return java.lang.Long.valueOf(str).longValue();
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public static com.loc.n.b a(android.content.Context context, com.loc.x xVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return b(context, xVar, str, str2, str3, str4);
    }

    private static synchronized com.loc.n.e a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.loc.n.e eVar;
        synchronized (com.loc.n.class) {
            if (!android.text.TextUtils.isEmpty(str)) {
                for (int i2 = 0; i2 < p.size(); i2++) {
                    eVar = p.get(i2);
                    if (eVar != null && str.equals(eVar.a)) {
                        break;
                    }
                }
            }
            eVar = null;
            if (eVar != null) {
                return eVar;
            }
            if (context == null) {
                return null;
            }
            com.loc.n.e b2 = com.loc.n.e.b(com.loc.be.b(context, str2, str, ""));
            java.lang.String a2 = com.loc.y.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
            if (b2 == null) {
                b2 = new com.loc.n.e(str, a2, 0);
            }
            if (!a2.equals(b2.b)) {
                b2.a(a2);
                b2.c.set(0);
            }
            p.add(b2);
            return b2;
        }
    }

    public static java.lang.String a(java.lang.String str) {
        com.loc.n.d dVar;
        if (!v.containsKey(str) || (dVar = v.get(str)) == null) {
            return null;
        }
        return dVar.b;
    }

    public static void a(android.content.Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    private static void a(android.content.Context context, com.loc.x xVar, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", xVar.a());
        hashMap.put("amap_sdk_version", xVar.c());
        java.lang.String jSONObject = new org.json.JSONObject(hashMap).toString();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.loc.cb cbVar = new com.loc.cb(context, "core", "2.0", "O001");
            cbVar.a(jSONObject);
            com.loc.cc.a(cbVar, context);
        } catch (com.loc.l unused) {
        }
    }

    public static synchronized void a(android.content.Context context, com.loc.x xVar, java.lang.String str, com.loc.n.a aVar) {
        synchronized (com.loc.n.class) {
            if (context == null || xVar == null) {
                return;
            }
            try {
                if (c == null) {
                    c = context.getApplicationContext();
                }
                java.lang.String a2 = xVar.a();
                if (android.text.TextUtils.isEmpty(a2)) {
                    return;
                }
                a(xVar);
                if (v == null) {
                    v = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (u == null) {
                    u = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (t == null) {
                    t = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (!v.containsKey(a2)) {
                    com.loc.n.d dVar = new com.loc.n.d((byte) 0);
                    dVar.a = xVar;
                    dVar.b = str;
                    dVar.c = aVar;
                    v.put(a2, dVar);
                    t.put(a2, new com.loc.n.g(java.lang.Long.valueOf(com.loc.be.a(c, "open_common", a2, 0L)), com.loc.be.b(c, "open_common", a2 + "lct-info", "")));
                    d(c);
                    e(c);
                }
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "at", "rglc");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x02ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0299 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(android.content.Context context, com.loc.x xVar, java.lang.String str, com.loc.n.b bVar, org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.lang.String str2;
        java.lang.String str3;
        org.json.JSONObject jSONObject2;
        boolean a2;
        android.content.Context context2;
        org.json.JSONObject jSONObject3;
        com.loc.n.b.a aVar = new com.loc.n.b.a();
        aVar.a = false;
        aVar.b = false;
        bVar.g = aVar;
        try {
            java.lang.String[] split = str.split(com.alipay.sdk.m.u.i.b);
            if (split != null && split.length > 0) {
                for (java.lang.String str4 : split) {
                    if (jSONObject.has(str4)) {
                        bVar.f.putOpt(str4, jSONObject.get(str4));
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "at", "co");
        }
        if (com.loc.y.a(jSONObject, "16H")) {
            try {
                bVar.i = a(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (java.lang.Throwable th2) {
                com.loc.at.a(th2, "AuthConfigManager", "load 16H");
            }
        }
        if (com.loc.y.a(jSONObject, "11K")) {
            try {
                org.json.JSONObject jSONObject4 = jSONObject.getJSONObject("11K");
                aVar.a = a(jSONObject4.getString("able"), false);
                if (jSONObject4.has(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    aVar.c = jSONObject4.getJSONObject(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
            } catch (java.lang.Throwable th3) {
                com.loc.at.a(th3, "AuthConfigManager", "load 11K");
            }
        }
        if (com.loc.y.a(jSONObject, "145")) {
            try {
                bVar.a = jSONObject.getJSONObject("145");
            } catch (java.lang.Throwable th4) {
                com.loc.at.a(th4, "AuthConfigManager", "load 145");
            }
        }
        if (com.loc.y.a(jSONObject, "14D")) {
            try {
                bVar.b = jSONObject.getJSONObject("14D");
            } catch (java.lang.Throwable th5) {
                com.loc.at.a(th5, "AuthConfigManager", "load 14D");
            }
        }
        if (com.loc.y.a(jSONObject, "151")) {
            try {
                org.json.JSONObject jSONObject5 = jSONObject.getJSONObject("151");
                com.loc.n.b.C0419b c0419b = new com.loc.n.b.C0419b();
                if (jSONObject5 != null) {
                    c0419b.a = a(jSONObject5.optString("able"), false);
                }
                bVar.h = c0419b;
            } catch (java.lang.Throwable th6) {
                com.loc.at.a(th6, "AuthConfigManager", "load 151");
            }
        }
        if (com.loc.y.a(jSONObject, "17S")) {
            try {
                jSONObject2 = jSONObject.getJSONObject("17S");
                if (jSONObject2 != null && (a2 = a(jSONObject2.optString("able"), false)) != o) {
                    o = a2;
                    if (context != null) {
                        android.content.SharedPreferences.Editor a3 = com.loc.be.a(context, "open_common");
                        com.loc.be.a(a3, "a2", a2);
                        com.loc.be.a(a3);
                    }
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                str2 = "ust";
            }
            if (jSONObject2 != null) {
                boolean a4 = a(jSONObject2.optString("static_enable"), true);
                boolean a5 = a(jSONObject2.optString("static_ip_direct_enable"), false);
                int optInt = jSONObject2.optInt("static_timeout", 5) * 1000;
                int optInt2 = jSONObject2.optInt("static_retry", 3);
                boolean a6 = a(jSONObject2.optString("bgp_enable"), true);
                str2 = "ust";
                try {
                    boolean a7 = a(jSONObject2.optString("bgp_ip_direct_enable"), false);
                    str3 = "umv";
                    try {
                        int optInt3 = jSONObject2.optInt("bgp_retry", 3);
                        boolean a8 = a(jSONObject2.optString("perf_data_upload_enable"), false);
                        if (a4 != f || a5 != g || optInt != e || optInt2 != y || a6 != h || a7 != i || optInt3 != z || a8 != j) {
                            f = a4;
                            g = a5;
                            e = optInt;
                            y = optInt2;
                            h = a6;
                            i = a7;
                            z = optInt3;
                            j = a8;
                            if (context != null) {
                                android.content.SharedPreferences.Editor a9 = com.loc.be.a(context, "open_common");
                                com.loc.be.a(a9, "a13", a4);
                                com.loc.be.a(a9, "a6", a6);
                                com.loc.be.a(a9, "a7", a5);
                                com.loc.be.a(a9, "a8", optInt);
                                com.loc.be.a(a9, "a9", optInt2);
                                com.loc.be.a(a9, "a10", a7);
                                com.loc.be.a(a9, "a11", optInt3);
                                com.loc.be.a(a9, "a12", a8);
                                com.loc.be.a(a9);
                            }
                        }
                        com.loc.bs.a();
                        com.loc.bs.a();
                        com.loc.bs.a();
                        com.loc.bs.a();
                        com.loc.bs.a();
                    } catch (java.lang.Throwable th8) {
                        th = th8;
                        com.loc.at.a(th, "AuthConfigManager", "load 17S");
                        if (com.loc.y.a(jSONObject, "15K")) {
                        }
                        context2 = context;
                        if (com.loc.y.a(jSONObject, "183")) {
                        }
                        if (com.loc.y.a(jSONObject, "17I")) {
                        }
                        if (com.loc.y.a(jSONObject, "1A4")) {
                        }
                    }
                } catch (java.lang.Throwable th9) {
                    th = th9;
                    str3 = "umv";
                    com.loc.at.a(th, "AuthConfigManager", "load 17S");
                    if (com.loc.y.a(jSONObject, "15K")) {
                    }
                    context2 = context;
                    if (com.loc.y.a(jSONObject, "183")) {
                    }
                    if (com.loc.y.a(jSONObject, "17I")) {
                    }
                    if (com.loc.y.a(jSONObject, "1A4")) {
                    }
                }
                if (com.loc.y.a(jSONObject, "15K")) {
                    try {
                        jSONObject3 = jSONObject.getJSONObject("15K");
                    } catch (java.lang.Throwable th10) {
                        context2 = context;
                        com.loc.at.a(th10, "AuthConfigManager", "load 15K");
                    }
                    if (jSONObject3 != null) {
                        boolean a10 = a(jSONObject3.optString("ucf"), com.loc.n.f.a);
                        boolean a11 = a(jSONObject3.optString("fsv2"), com.loc.n.f.b);
                        boolean a12 = a(jSONObject3.optString("usc"), com.loc.n.f.c);
                        java.lang.String str5 = str3;
                        int optInt4 = jSONObject3.optInt(str5, com.loc.n.f.d);
                        java.lang.String str6 = str2;
                        boolean a13 = a(jSONObject3.optString(str6), com.loc.n.f.e);
                        int optInt5 = jSONObject3.optInt("ustv", com.loc.n.f.f);
                        if (a10 != com.loc.n.f.a || a11 != com.loc.n.f.b || a12 != com.loc.n.f.c || optInt4 != com.loc.n.f.d || a13 != com.loc.n.f.e || optInt5 != com.loc.n.f.d) {
                            com.loc.n.f.a = a10;
                            com.loc.n.f.b = a11;
                            com.loc.n.f.c = a12;
                            com.loc.n.f.d = optInt4;
                            com.loc.n.f.e = a13;
                            com.loc.n.f.f = optInt5;
                            context2 = context;
                            try {
                                android.content.SharedPreferences.Editor a14 = com.loc.be.a(context2, "open_common");
                                com.loc.be.a(a14, "ucf", com.loc.n.f.a);
                                com.loc.be.a(a14, "fsv2", com.loc.n.f.b);
                                com.loc.be.a(a14, "usc", com.loc.n.f.c);
                                com.loc.be.a(a14, str5, com.loc.n.f.d);
                                com.loc.be.a(a14, str6, com.loc.n.f.e);
                                com.loc.be.a(a14, "ustv", com.loc.n.f.f);
                                com.loc.be.a(a14);
                            } catch (java.lang.Throwable unused) {
                            }
                            if (com.loc.y.a(jSONObject, "183")) {
                                try {
                                    com.loc.br.a(xVar, jSONObject.getJSONObject("183"));
                                } catch (java.lang.Throwable th11) {
                                    com.loc.at.a(th11, "AuthConfigManager", "load 183");
                                }
                            }
                            if (com.loc.y.a(jSONObject, "17I")) {
                                try {
                                    org.json.JSONObject jSONObject6 = jSONObject.getJSONObject("17I");
                                    boolean a15 = a(jSONObject6.optString("na"), false);
                                    boolean a16 = a(jSONObject6.optString(com.anythink.expressad.d.a.b.w), false);
                                    com.loc.ah.d = a15;
                                    com.loc.ah.e = a16;
                                    android.content.SharedPreferences.Editor a17 = com.loc.be.a(context2, "open_common");
                                    com.loc.be.a(a17, "a4", a15);
                                    com.loc.be.a(a17, "a5", a16);
                                    com.loc.be.a(a17);
                                } catch (java.lang.Throwable th12) {
                                    com.loc.at.a(th12, "AuthConfigManager", "load 17I");
                                }
                            }
                            if (com.loc.y.a(jSONObject, "1A4")) {
                                try {
                                    org.json.JSONObject jSONObject7 = jSONObject.getJSONObject("1A4");
                                    java.lang.String optString = jSONObject7.optString("ada");
                                    boolean a18 = a(optString, com.loc.aa.c);
                                    long optLong = jSONObject7.optLong("iv", com.loc.aa.a);
                                    com.loc.aa.d = a18;
                                    com.loc.aa.b = optLong;
                                    android.content.SharedPreferences.Editor a19 = com.loc.be.a(context2, "open_common");
                                    com.loc.be.a(a19, "a16", optString);
                                    com.loc.be.a(a19, "a17", optLong);
                                    com.loc.be.a(a19);
                                    return;
                                } catch (java.lang.Throwable th13) {
                                    com.loc.at.a(th13, "AuthConfigManager", "load 1A4");
                                    return;
                                }
                            }
                            return;
                        }
                    }
                }
                context2 = context;
                if (com.loc.y.a(jSONObject, "183")) {
                }
                if (com.loc.y.a(jSONObject, "17I")) {
                }
                if (com.loc.y.a(jSONObject, "1A4")) {
                }
            }
        }
        str2 = "ust";
        str3 = "umv";
        if (com.loc.y.a(jSONObject, "15K")) {
        }
        context2 = context;
        if (com.loc.y.a(jSONObject, "183")) {
        }
        if (com.loc.y.a(jSONObject, "17I")) {
        }
        if (com.loc.y.a(jSONObject, "1A4")) {
        }
    }

    private static void a(android.content.Context context, com.loc.x xVar, java.lang.Throwable th) {
        a(context, xVar, th.getMessage());
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.loc.m.a(context, str);
    }

    private static void a(android.content.Context context, java.lang.String str, java.lang.String str2, com.loc.n.e eVar) {
        if (eVar == null || android.text.TextUtils.isEmpty(eVar.a)) {
            return;
        }
        java.lang.String b2 = eVar.b();
        if (android.text.TextUtils.isEmpty(b2) || context == null) {
            return;
        }
        android.content.SharedPreferences.Editor a2 = com.loc.be.a(context, str2);
        a2.putString(str, b2);
        com.loc.be.a(a2);
    }

    public static void a(com.loc.bs.c cVar) {
        if (cVar == null || c == null) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("serverip", cVar.c);
        hashMap.put("hostname", cVar.e);
        hashMap.put("path", cVar.d);
        hashMap.put("csid", cVar.a);
        hashMap.put("degrade", java.lang.String.valueOf(cVar.b.a()));
        hashMap.put("errorcode", java.lang.String.valueOf(cVar.m));
        hashMap.put("errorsubcode", java.lang.String.valueOf(cVar.n));
        hashMap.put("connecttime", java.lang.String.valueOf(cVar.h));
        hashMap.put("writetime", java.lang.String.valueOf(cVar.i));
        hashMap.put("readtime", java.lang.String.valueOf(cVar.j));
        hashMap.put("datasize", java.lang.String.valueOf(cVar.l));
        hashMap.put("totaltime", java.lang.String.valueOf(cVar.f));
        java.lang.String jSONObject = new org.json.JSONObject(hashMap).toString();
        "--埋点--".concat(java.lang.String.valueOf(jSONObject));
        com.loc.bs.a();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.loc.cb cbVar = new com.loc.cb(c, "core", "2.0", "O008");
            cbVar.a(jSONObject);
            com.loc.cc.a(cbVar, c);
        } catch (com.loc.l unused) {
        }
    }

    private static void a(com.loc.x xVar) {
        if (xVar != null) {
            try {
                if (android.text.TextUtils.isEmpty(xVar.a())) {
                    return;
                }
                java.lang.String c2 = xVar.c();
                if (android.text.TextUtils.isEmpty(c2)) {
                    c2 = xVar.b();
                }
                if (android.text.TextUtils.isEmpty(c2)) {
                    return;
                }
                com.loc.ah.a(xVar.a(), c2);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    private static synchronized void a(java.lang.String str, long j2, java.lang.String str2) {
        synchronized (com.loc.n.class) {
            try {
                if (v != null && v.containsKey(str)) {
                    if (t == null) {
                        t = new java.util.concurrent.ConcurrentHashMap<>(8);
                    }
                    t.put(str, new com.loc.n.g(java.lang.Long.valueOf(j2), str2));
                    android.content.Context context = c;
                    if (context != null) {
                        android.content.SharedPreferences.Editor a2 = com.loc.be.a(context, "open_common");
                        com.loc.be.a(a2, str, j2);
                        com.loc.be.a(a2, str + "lct-info", str2);
                        com.loc.be.a(a2);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "at", "ucut");
            }
        }
    }

    private static void a(java.lang.String str, java.lang.String str2) {
        com.loc.n.e a2 = a(c, str, str2);
        java.lang.String a3 = com.loc.y.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
        if (!a3.equals(a2.b)) {
            a2.a(a3);
            a2.c.set(0);
        }
        a2.c.incrementAndGet();
        a(c, str, str2, a2);
    }

    public static synchronized void a(java.lang.String str, boolean z2, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        synchronized (com.loc.n.class) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return;
                }
                if (u == null) {
                    u = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                u.put(str, java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
                if (v == null) {
                    return;
                }
                if (v.containsKey(str)) {
                    if (android.text.TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (z2) {
                        com.loc.br.a(true, str);
                    }
                    com.loc.ct.a().b(new com.loc.n.AnonymousClass1(str, str2, str3, str4));
                }
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "at", "lca");
            }
        }
    }

    public static void a(java.lang.String str, boolean z2, boolean z3, boolean z4) {
        if (android.text.TextUtils.isEmpty(str) || c == null) {
            return;
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("url", str);
        hashMap.put("downLevel", java.lang.String.valueOf(z2));
        hashMap.put("ant", com.loc.p.j(c) == 0 ? "0" : "1");
        hashMap.put("type", z4 ? z2 ? m : n : z2 ? k : l);
        hashMap.put("status", z3 ? "0" : "1");
        java.lang.String jSONObject = new org.json.JSONObject(hashMap).toString();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.loc.cb cbVar = new com.loc.cb(c, "core", "2.0", "O002");
            cbVar.a(jSONObject);
            com.loc.cc.a(cbVar, c);
        } catch (com.loc.l unused) {
        }
    }

    public static void a(boolean z2, com.loc.bs.a aVar) {
        if (!D || aVar == null) {
            return;
        }
        synchronized (C) {
            if (z2) {
                java.util.Iterator<com.loc.bs.a> it = C.iterator();
                while (it.hasNext()) {
                    com.loc.bs.a next = it.next();
                    if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                        if (next.j == aVar.j) {
                            it.remove();
                        } else {
                            next.j.set(next.j.get() - aVar.j.get());
                        }
                        com.loc.bs.a();
                    }
                }
            }
            D = false;
            java.util.Iterator<com.loc.bs.a> it2 = C.iterator();
            while (true) {
                com.loc.bs.a();
                if (it2.hasNext()) {
                    com.loc.bs.a next2 = it2.next();
                    java.lang.String str = next2.e;
                    java.util.Objects.toString(next2.j);
                } else {
                    com.loc.bs.a();
                }
            }
        }
    }

    public static void a(boolean z2, java.lang.String str) {
        try {
            "--markHostNameFailed---hostname=".concat(java.lang.String.valueOf(str));
            com.loc.bs.a();
            if (f || z2) {
                if ((i || !z2) && !android.text.TextUtils.isEmpty(str)) {
                    if (z2) {
                        if (B.get(str) != null) {
                            return;
                        }
                        B.put(str, java.lang.Boolean.TRUE);
                        a(b(str, "a15"), "open_common");
                        return;
                    }
                    if (A.get(str) != null) {
                        return;
                    }
                    A.put(str, java.lang.Boolean.TRUE);
                    a(b(str, "a14"), "open_common");
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean a() {
        com.loc.n.e a2;
        if (c != null) {
            i();
            if (!c()) {
                return false;
            }
            if (b()) {
                return true;
            }
        }
        return o && (a2 = a(c, "IPV6_CONFIG_NAME", "open_common")) != null && a2.a() < 5;
    }

    public static synchronized boolean a(java.lang.String str, long j2) {
        synchronized (com.loc.n.class) {
            boolean z2 = false;
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            com.loc.n.g f2 = f(str);
            long j3 = 0;
            if (j2 != (f2 != null ? f2.a : 0L)) {
                if (u != null && u.containsKey(str)) {
                    j3 = u.get(str).longValue();
                }
                if (android.os.SystemClock.elapsedRealtime() - j3 > 30000) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    public static boolean a(java.lang.String str, boolean z2) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return z2;
            }
            java.lang.String[] split = java.net.URLDecoder.decode(str).split(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (java.lang.Throwable unused) {
            return z2;
        }
    }

    private static boolean a(java.net.InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0184 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0185  */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v14, types: [com.loc.n$b] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [com.loc.n$b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.loc.n.b b(android.content.Context context, com.loc.x xVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        com.loc.bv bvVar;
        byte[] bArr;
        com.loc.n.b bVar;
        java.lang.String str9;
        java.lang.String str10;
        boolean isEmpty;
        java.lang.String str11 = "infocode";
        ?? r12 = "result";
        java.lang.String str12 = "ver";
        com.loc.n.b bVar2 = new com.loc.n.b();
        bVar2.f = new org.json.JSONObject();
        if (context != null) {
            c = context.getApplicationContext();
        }
        e();
        java.lang.String str13 = null;
        try {
            a(xVar);
            new com.loc.bp();
            isEmpty = android.text.TextUtils.isEmpty(str);
            try {
                if (isEmpty) {
                    str8 = str;
                } else {
                    try {
                        str8 = c(str);
                    } catch (com.loc.l e2) {
                        e = e2;
                        throw e;
                    } catch (java.lang.Throwable unused) {
                        throw new com.loc.l(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                    }
                }
                try {
                    d(context);
                    e(context);
                    str6 = "result";
                    r12 = bVar2;
                    str7 = "ver";
                    str12 = "at";
                    str5 = "infocode";
                    str11 = "lc";
                    try {
                        bvVar = com.loc.bp.a(new com.loc.n.c(context, xVar, str8, str2, str3, str4));
                    } catch (com.loc.l e3) {
                        throw e3;
                    } catch (java.lang.Throwable unused2) {
                        throw new com.loc.l(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                    }
                } catch (com.loc.l e4) {
                    e = e4;
                    throw e;
                } catch (java.lang.Throwable unused3) {
                    throw new com.loc.l(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (com.loc.l e5) {
                e = e5;
                bvVar = null;
                bArr = null;
                r12.c = e.a();
                a(context, xVar, e.a());
                com.loc.aw.a(xVar, "/v3/iasdkauth", e);
                bVar = r12;
                java.lang.String str14 = str8;
                if (bArr != null) {
                }
            } catch (javax.crypto.IllegalBlockSizeException e6) {
                e = e6;
                bvVar = null;
                bArr = null;
                a(context, xVar, e);
                bVar = r12;
                java.lang.String str142 = str8;
                if (bArr != null) {
                }
            } catch (java.lang.Throwable th) {
                e = th;
                bvVar = null;
                bArr = null;
                com.loc.aw.b(e, str12, str11);
                a(context, xVar, e);
                bVar = r12;
                java.lang.String str1422 = str8;
                if (bArr != null) {
                }
            }
        } catch (com.loc.l e7) {
            e = e7;
            str5 = "infocode";
            str6 = "result";
            str7 = "ver";
            r12 = bVar2;
            str12 = "at";
            str11 = "lc";
            str8 = str;
        } catch (javax.crypto.IllegalBlockSizeException e8) {
            e = e8;
            str5 = "infocode";
            str6 = "result";
            str7 = "ver";
            r12 = bVar2;
            str12 = "at";
            str11 = "lc";
            str8 = str;
        } catch (java.lang.Throwable th2) {
            e = th2;
            str5 = "infocode";
            str6 = "result";
            str7 = "ver";
            r12 = bVar2;
            str12 = "at";
            str11 = "lc";
            str8 = str;
        }
        if (isEmpty) {
            return r12;
        }
        if (bvVar != null) {
            try {
                bArr = bvVar.a;
                try {
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = bvVar.b;
                    if (map != null && map.containsKey("lct")) {
                        java.util.List<java.lang.String> list = map.get("lct");
                        java.util.List<java.lang.String> list2 = map.get("lct-info");
                        r12.e = a(list);
                        java.lang.String b2 = b(list2);
                        if (r12.e != 0 && xVar != null) {
                            java.lang.String a2 = xVar.a();
                            if (!android.text.TextUtils.isEmpty(a2)) {
                                a(a2, r12.e, b2);
                            }
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    try {
                        th3.printStackTrace();
                        com.loc.aw.b(th3, str12, "lct");
                    } catch (com.loc.l e9) {
                        e = e9;
                        r12.c = e.a();
                        a(context, xVar, e.a());
                        com.loc.aw.a(xVar, "/v3/iasdkauth", e);
                        bVar = r12;
                        java.lang.String str14222 = str8;
                        if (bArr != null) {
                        }
                    } catch (javax.crypto.IllegalBlockSizeException e10) {
                        e = e10;
                        a(context, xVar, e);
                        bVar = r12;
                        java.lang.String str142222 = str8;
                        if (bArr != null) {
                        }
                    } catch (java.lang.Throwable th4) {
                        e = th4;
                        com.loc.aw.b(e, str12, str11);
                        a(context, xVar, e);
                        bVar = r12;
                        java.lang.String str1422222 = str8;
                        if (bArr != null) {
                        }
                    }
                }
            } catch (com.loc.l e11) {
                e = e11;
                bArr = null;
                r12.c = e.a();
                a(context, xVar, e.a());
                com.loc.aw.a(xVar, "/v3/iasdkauth", e);
                bVar = r12;
                java.lang.String str14222222 = str8;
                if (bArr != null) {
                }
            } catch (javax.crypto.IllegalBlockSizeException e12) {
                e = e12;
                bArr = null;
                a(context, xVar, e);
                bVar = r12;
                java.lang.String str142222222 = str8;
                if (bArr != null) {
                }
            } catch (java.lang.Throwable th5) {
                e = th5;
                bArr = null;
                com.loc.aw.b(e, str12, str11);
                a(context, xVar, e);
                bVar = r12;
                java.lang.String str1422222222 = str8;
                if (bArr != null) {
                }
            }
        } else {
            bArr = null;
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[bArr.length - 16];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, 16);
        java.lang.System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, com.loc.y.c("EQUVT"));
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.loc.y.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
        cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(com.loc.y.c()));
        str13 = com.loc.y.a(cipher.doFinal(bArr3));
        bVar = r12;
        java.lang.String str14222222222 = str8;
        if (bArr != null) {
            return bVar;
        }
        if (android.text.TextUtils.isEmpty(str13)) {
            str13 = com.loc.y.a(bArr);
        }
        java.lang.String str15 = str13;
        if (android.text.TextUtils.isEmpty(str15)) {
            a(context, xVar, "result is null");
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str15);
            if (jSONObject.has("status")) {
                int i2 = jSONObject.getInt("status");
                if (i2 == 1) {
                    a = 1;
                } else if (i2 == 0) {
                    if (bvVar != null) {
                        str9 = bvVar.c;
                        str10 = bvVar.d;
                    } else {
                        str9 = "authcsid";
                        str10 = "authgsid";
                    }
                    com.loc.y.a(context, str9, str10, jSONObject);
                    a = 0;
                    if (jSONObject.has("info")) {
                        b = jSONObject.getString("info");
                    }
                    java.lang.String str16 = str5;
                    com.loc.aw.a(xVar, "/v3/iasdkauth", b, str10, str9, jSONObject.has(str16) ? jSONObject.getString(str16) : "");
                    if (a == 0) {
                        bVar.c = b;
                        return bVar;
                    }
                }
                java.lang.String str17 = str7;
                try {
                    if (jSONObject.has(str17)) {
                        bVar.d = jSONObject.getInt(str17);
                    }
                } catch (java.lang.Throwable th6) {
                    com.loc.at.a(th6, str12, str11);
                }
                java.lang.String str18 = str6;
                if (com.loc.y.a(jSONObject, str18)) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(str18);
                    a(context, xVar, str14222222222, bVar, jSONObject2);
                    try {
                        org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("15K");
                        boolean a3 = a(jSONObject3.optString("isTargetAble"), false);
                        if (a(jSONObject3.optString("able"), false)) {
                            com.loc.r.a().a(context, a3);
                        } else {
                            com.loc.r.a();
                            com.loc.r.b(context);
                        }
                    } catch (java.lang.Throwable unused4) {
                    }
                }
            }
        } catch (java.lang.Throwable th7) {
            com.loc.at.a(th7, str12, str11);
        }
        return bVar;
    }

    public static com.loc.x b(java.lang.String str) {
        com.loc.n.d dVar = v.get(str);
        if (dVar != null) {
            return dVar.a;
        }
        return null;
    }

    private static java.lang.String b(java.lang.String str, java.lang.String str2) {
        return str2 + "_" + com.loc.t.a(str.getBytes());
    }

    private static java.lang.String b(java.util.List<java.lang.String> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            java.lang.String str = list.get(0);
            return !android.text.TextUtils.isEmpty(str) ? str : "";
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static void b(android.content.Context context) {
        if (context == null) {
            return;
        }
        o = com.loc.be.a(context, "open_common", "a2", true);
    }

    public static void b(com.loc.bs.c cVar) {
        synchronized (C) {
            boolean z2 = false;
            for (int i2 = 0; i2 < C.size(); i2++) {
                com.loc.bs.a aVar = C.get(i2);
                if (cVar.c.equals(aVar.b) && cVar.d.equals(aVar.e)) {
                    int i3 = cVar.m;
                    int i4 = aVar.f;
                    if (i3 == i4) {
                        z2 = true;
                        if (i4 == 1) {
                            aVar.i = ((aVar.j.get() * aVar.i) + cVar.f) / (aVar.j.get() + 1);
                        }
                        aVar.j.getAndIncrement();
                    }
                }
            }
            if (!z2) {
                C.add(new com.loc.bs.a(cVar));
            }
            com.loc.bs.a();
        }
    }

    public static synchronized void b(java.lang.String str, boolean z2) {
        synchronized (com.loc.n.class) {
            a(str, z2, (java.lang.String) null, (java.lang.String) null, (java.lang.String) null);
        }
    }

    public static boolean b() {
        java.lang.Integer num;
        android.content.Context context = c;
        if (context == null) {
            return false;
        }
        java.lang.String o2 = com.loc.p.o(context);
        return (android.text.TextUtils.isEmpty(o2) || (num = q.get(o2.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }

    public static java.lang.String c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        return str + ";15K;16H;17I;1A4;17S;183";
    }

    private static void c(android.content.Context context) {
        if (context == null) {
            return;
        }
        f = com.loc.be.a(context, "open_common", "a13", true);
        h = com.loc.be.a(context, "open_common", "a6", true);
        g = com.loc.be.a(context, "open_common", "a7", false);
        e = com.loc.be.a(context, "open_common", "a8", 5000);
        y = com.loc.be.a(context, "open_common", "a9", 3);
        i = com.loc.be.a(context, "open_common", "a10", false);
        z = com.loc.be.a(context, "open_common", "a11", 3);
        j = com.loc.be.a(context, "open_common", "a12", false);
    }

    public static void c(com.loc.bs.c cVar) {
        if (cVar != null && j) {
            synchronized (E) {
                E.offer(cVar);
                com.loc.bs.a();
            }
        }
    }

    public static boolean c() {
        java.lang.Integer num;
        android.content.Context context = c;
        if (context == null) {
            return false;
        }
        java.lang.String o2 = com.loc.p.o(context);
        return (android.text.TextUtils.isEmpty(o2) || (num = q.get(o2.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static void d() {
        try {
            com.loc.n.e a2 = a(c, "IPV6_CONFIG_NAME", "open_common");
            java.lang.String a3 = com.loc.y.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
            if (!a3.equals(a2.b)) {
                a2.a(a3);
                a2.c.set(0);
            }
            a2.c.incrementAndGet();
            a(c, "IPV6_CONFIG_NAME", "open_common", a2);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void d(android.content.Context context) {
        try {
            if (w) {
                return;
            }
            com.loc.ah.d = com.loc.be.a(context, "open_common", "a4", true);
            com.loc.ah.e = com.loc.be.a(context, "open_common", "a5", true);
            w = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static synchronized boolean d(java.lang.String str) {
        synchronized (com.loc.n.class) {
            try {
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "at", "cslct");
            }
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            if (v == null) {
                return false;
            }
            if (u == null) {
                u = new java.util.concurrent.ConcurrentHashMap<>(8);
            }
            if (v.containsKey(str) && !u.containsKey(str)) {
                u.put(str, java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()));
                return true;
            }
            return false;
        }
    }

    public static void e() {
        if (d) {
            return;
        }
        try {
            android.content.Context context = c;
            if (context == null) {
                return;
            }
            d = true;
            com.loc.r.a().a(context);
            b(context);
            c(context);
            com.loc.n.f.a = com.loc.be.a(context, "open_common", "ucf", com.loc.n.f.a);
            com.loc.n.f.b = com.loc.be.a(context, "open_common", "fsv2", com.loc.n.f.b);
            com.loc.n.f.c = com.loc.be.a(context, "open_common", "usc", com.loc.n.f.c);
            com.loc.n.f.d = com.loc.be.a(context, "open_common", "umv", com.loc.n.f.d);
            com.loc.n.f.e = com.loc.be.a(context, "open_common", "ust", com.loc.n.f.e);
            com.loc.n.f.f = com.loc.be.a(context, "open_common", "ustv", com.loc.n.f.f);
        } catch (java.lang.Throwable unused) {
        }
    }

    private static void e(android.content.Context context) {
        try {
            if (x) {
                return;
            }
            com.loc.aa.d = a(com.loc.be.b(context, "open_common", "a16", ""), true);
            com.loc.aa.b = com.loc.be.a(context, "open_common", "a17", com.loc.aa.a);
            x = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static synchronized void e(java.lang.String str) {
        synchronized (com.loc.n.class) {
            if (u == null) {
                return;
            }
            if (u.containsKey(str)) {
                u.remove(str);
            }
        }
    }

    public static com.loc.bs.a f() {
        if (D) {
            return null;
        }
        synchronized (C) {
            if (D) {
                return null;
            }
            java.util.Collections.sort(C);
            if (C.size() <= 0) {
                return null;
            }
            com.loc.bs.a clone = C.get(0).clone();
            D = true;
            return clone;
        }
    }

    public static synchronized com.loc.n.g f(java.lang.String str) {
        synchronized (com.loc.n.class) {
            try {
                if (t == null) {
                    t = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (t.containsKey(str)) {
                    return t.get(str);
                }
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "at", "glcut");
            }
            return new com.loc.n.g(0L, "");
        }
    }

    public static com.loc.bs.c g() {
        synchronized (E) {
            com.loc.bs.c poll = E.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    public static boolean g(java.lang.String str) {
        com.loc.n.e a2;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f) {
                return false;
            }
            if (!(A.get(str) == null)) {
                return false;
            }
            android.content.Context context = c;
            if (context == null || (a2 = a(context, b(str, "a14"), "open_common")) == null) {
                return true;
            }
            return a2.a() < y;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    public static boolean h(java.lang.String str) {
        com.loc.n.e a2;
        if (android.text.TextUtils.isEmpty(str) || !i) {
            return false;
        }
        if (!(B.get(str) == null)) {
            return false;
        }
        android.content.Context context = c;
        if (context == null || (a2 = a(context, b(str, "a15"), "open_common")) == null) {
            return true;
        }
        return a2.a() < z;
    }

    private static void i() {
        try {
            android.content.Context context = c;
            if (context != null) {
                java.lang.String o2 = com.loc.p.o(context);
                if (!android.text.TextUtils.isEmpty(r) && !android.text.TextUtils.isEmpty(o2) && r.equals(o2) && java.lang.System.currentTimeMillis() - f415s < 60000) {
                    return;
                }
                if (!android.text.TextUtils.isEmpty(o2)) {
                    r = o2;
                }
            } else if (java.lang.System.currentTimeMillis() - f415s < 10000) {
                return;
            }
            f415s = java.lang.System.currentTimeMillis();
            q.clear();
            if (!com.amap.apis.utils.core.api.AMapUtilCoreApi.getCollectIPEnable()) {
                q.put("WIFI", 3);
                q.put("MOBILE", 3);
                return;
            }
            java.util.Iterator it = java.util.Collections.list(java.net.NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                java.net.NetworkInterface networkInterface = (java.net.NetworkInterface) it.next();
                if (!networkInterface.getInterfaceAddresses().isEmpty()) {
                    java.lang.String displayName = networkInterface.getDisplayName();
                    java.util.Iterator<java.net.InterfaceAddress> it2 = networkInterface.getInterfaceAddresses().iterator();
                    int i2 = 0;
                    while (it2.hasNext()) {
                        java.net.InetAddress address = it2.next().getAddress();
                        if (address instanceof java.net.Inet6Address) {
                            if (!a((java.net.Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof java.net.Inet4Address) {
                            java.net.Inet4Address inet4Address = (java.net.Inet4Address) address;
                            if (!a(inet4Address) && !inet4Address.getHostAddress().startsWith(com.loc.y.c("FMTkyLjE2OC40My4"))) {
                                i2 |= 1;
                            }
                        }
                    }
                    if (i2 != 0) {
                        if (displayName != null && displayName.startsWith("wlan")) {
                            q.put("WIFI", java.lang.Integer.valueOf(i2));
                        } else if (displayName != null && displayName.startsWith("rmnet")) {
                            q.put("MOBILE", java.lang.Integer.valueOf(i2));
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "at", "ipstack");
        }
    }
}
