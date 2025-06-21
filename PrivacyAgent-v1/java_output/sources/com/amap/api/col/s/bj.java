package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class bj {
    public static volatile boolean C = false;
    public static int a = -1;
    public static java.lang.String b = "";
    public static android.content.Context c = null;
    public static java.lang.String k = "6";
    public static java.lang.String l = "4";
    public static java.lang.String m = "9";
    public static java.lang.String n = "8";
    public static volatile boolean o = true;
    public static java.util.Vector<com.amap.api.col.s.bj.e> p = new java.util.Vector<>();
    public static java.util.Map<java.lang.String, java.lang.Integer> q = new java.util.HashMap();
    public static java.lang.String r = null;

    /* renamed from: s, reason: collision with root package name */
    public static long f106s = 0;
    public static volatile boolean d = false;
    public static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> t = new java.util.concurrent.ConcurrentHashMap<>(8);
    public static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Long> u = new java.util.concurrent.ConcurrentHashMap<>(8);
    public static volatile java.util.concurrent.ConcurrentHashMap<java.lang.String, com.amap.api.col.s.bj.d> v = new java.util.concurrent.ConcurrentHashMap<>(8);
    public static boolean w = false;
    public static int e = 5000;
    public static boolean f = true;
    public static boolean g = false;
    public static int x = 3;
    public static boolean h = true;
    public static boolean i = false;
    public static int y = 3;
    public static boolean j = false;
    public static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> z = new java.util.concurrent.ConcurrentHashMap<>();
    public static java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> A = new java.util.concurrent.ConcurrentHashMap<>();
    public static java.util.ArrayList<com.amap.api.col.s.da.a> B = new java.util.ArrayList<>();
    public static java.util.Queue<com.amap.api.col.s.da.c> D = new java.util.LinkedList();

    /* renamed from: com.amap.api.col.s.bj$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.amap.api.col.s.ec {
        public final /* synthetic */ java.lang.String t;
        public final /* synthetic */ java.lang.String u;
        public final /* synthetic */ java.lang.String v;
        public final /* synthetic */ java.lang.String w;

        public AnonymousClass1(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            this.t = str;
            this.u = str2;
            this.v = str3;
            this.w = str4;
        }

        @Override // com.amap.api.col.s.ec
        public final void a() {
            com.amap.api.col.s.bj.d dVar = (com.amap.api.col.s.bj.d) com.amap.api.col.s.bj.v.get(this.t);
            if (dVar == null) {
                return;
            }
            com.amap.api.col.s.bj.a aVar = dVar.c;
            com.amap.api.col.s.bj.b a = com.amap.api.col.s.bj.a(com.amap.api.col.s.bj.c, dVar.a, dVar.b, this.u, this.v, this.w);
            if (a == null || aVar == null) {
                return;
            }
            aVar.a(a);
        }
    }

    public interface a {
        void a(com.amap.api.col.s.bj.b bVar);
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
        public com.amap.api.col.s.bj.b.a g;
        public com.amap.api.col.s.bj.b.C0115b h;
        public boolean i;

        public static class a {
            public boolean a;
            public boolean b;
            public org.json.JSONObject c;
        }

        /* renamed from: com.amap.api.col.s.bj$b$b, reason: collision with other inner class name */
        public static class C0115b {
            public boolean a;
        }
    }

    public static class c extends com.amap.api.col.s.cy {

        /* renamed from: s, reason: collision with root package name */
        public java.lang.String f107s;
        public java.util.Map<java.lang.String, java.lang.String> t;
        public java.lang.String u;
        public java.lang.String v;
        public java.lang.String w;

        public c(android.content.Context context, com.amap.api.col.s.bt btVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
            super(context, btVar);
            this.f107s = str;
            this.t = null;
            this.u = str2;
            this.v = str3;
            this.w = str4;
            a(com.amap.api.col.s.dd.c.HTTPS);
            a(com.amap.api.col.s.dd.a.FIX);
        }

        public static java.lang.String E(java.lang.String str, java.lang.String str2) {
            try {
                return !android.text.TextUtils.isEmpty(str2) ? android.net.Uri.parse(str).buildUpon().encodedAuthority(str2).build().toString() : str;
            } catch (java.lang.Throwable unused) {
                return str;
            }
        }

        @Override // com.amap.api.col.s.bp, com.amap.api.col.s.dd
        public final java.lang.String a() {
            return E("https://dualstack-arestapi.amap.com/v3/iasdkauth", this.v);
        }

        @Override // com.amap.api.col.s.cy
        public final byte[] b() {
            java.lang.String q = com.amap.api.col.s.bm.q(this.a);
            if (!android.text.TextUtils.isEmpty(q)) {
                q = com.amap.api.col.s.bq.a(new java.lang.StringBuilder(q).reverse().toString());
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("authkey", android.text.TextUtils.isEmpty(this.f107s) ? "" : this.f107s);
            hashMap.put("plattype", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
            hashMap.put("product", this.b.b());
            hashMap.put("version", this.b.c());
            hashMap.put("output", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_JSON);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.os.Build.VERSION.SDK_INT);
            hashMap.put("androidversion", sb.toString());
            hashMap.put("deviceId", q);
            hashMap.put("manufacture", android.os.Build.MANUFACTURER);
            java.util.Map<java.lang.String, java.lang.String> map = this.t;
            if (map != null && !map.isEmpty()) {
                hashMap.putAll(this.t);
            }
            hashMap.put("abitype", com.amap.api.col.s.bu.a(this.a));
            hashMap.put("ext", this.b.e());
            return com.amap.api.col.s.bu.a(com.amap.api.col.s.bu.a(hashMap));
        }

        @Override // com.amap.api.col.s.cy
        public final java.lang.String d() {
            return "3.0";
        }

        @Override // com.amap.api.col.s.dd
        public final java.util.Map<java.lang.String, java.lang.String> f() {
            if (android.text.TextUtils.isEmpty(this.w)) {
                return null;
            }
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.alipay.sdk.m.l.c.f, this.w);
            return hashMap;
        }

        @Override // com.amap.api.col.s.dd
        public final java.lang.String h() {
            return E("https://restsdk.amap.com/v3/iasdkauth", this.u);
        }

        @Override // com.amap.api.col.s.dd
        public final java.lang.String i() {
            return !android.text.TextUtils.isEmpty(this.w) ? this.w : super.i();
        }
    }

    public static class d {
        public com.amap.api.col.s.bt a;
        public java.lang.String b;
        public com.amap.api.col.s.bj.a c;

        public d() {
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    public static class e {
        public java.lang.String a;
        public java.lang.String b;
        public java.util.concurrent.atomic.AtomicInteger c;

        public e(java.lang.String str, java.lang.String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = new java.util.concurrent.atomic.AtomicInteger(i);
        }

        public static com.amap.api.col.s.bj.e b(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                return new com.amap.api.col.s.bj.e(jSONObject.optString("a"), jSONObject.optString("f"), jSONObject.optInt("h"));
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

    public static com.amap.api.col.s.bj.b a(android.content.Context context, com.amap.api.col.s.bt btVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        return j(context, btVar, str, str2, str3, str4);
    }

    public static void a(android.content.Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
    }

    public static synchronized void a(android.content.Context context, com.amap.api.col.s.bt btVar, java.lang.String str, com.amap.api.col.s.bj.a aVar) {
        synchronized (com.amap.api.col.s.bj.class) {
            if (context == null || btVar == null) {
                return;
            }
            try {
                if (c == null) {
                    c = context.getApplicationContext();
                }
                java.lang.String b2 = btVar.b();
                if (android.text.TextUtils.isEmpty(b2)) {
                    return;
                }
                g(btVar);
                if (v == null) {
                    v = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (u == null) {
                    u = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (t == null) {
                    t = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (!v.containsKey(b2)) {
                    com.amap.api.col.s.bj.d dVar = new com.amap.api.col.s.bj.d((byte) 0);
                    dVar.a = btVar;
                    dVar.b = str;
                    dVar.c = aVar;
                    v.put(b2, dVar);
                    t.put(b2, java.lang.Long.valueOf(com.amap.api.col.s.cm.b(c, "open_common", b2)));
                    o(c);
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cg.a(th, "at", "rglc");
            }
        }
    }

    public static void a(com.amap.api.col.s.da.c cVar) {
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
        com.amap.api.col.s.da.a();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.amap.api.col.s.dj djVar = new com.amap.api.col.s.dj(c, "core", "2.0", "O008");
            djVar.a(jSONObject);
            com.amap.api.col.s.dk.a(djVar, c);
        } catch (com.amap.api.col.s.bh unused) {
        }
    }

    public static synchronized void a(java.lang.String str, boolean z2, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        synchronized (com.amap.api.col.s.bj.class) {
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
                        com.amap.api.col.s.cz.a(true, str);
                    }
                    com.amap.api.col.s.eb.a().b(new com.amap.api.col.s.bj.AnonymousClass1(str, str2, str3, str4));
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cg.a(th, "at", "lca");
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
        hashMap.put("ant", com.amap.api.col.s.bm.n(c) == 0 ? "0" : "1");
        if (z4) {
            hashMap.put("type", z2 ? m : n);
        } else {
            hashMap.put("type", z2 ? k : l);
        }
        hashMap.put("status", z3 ? "0" : "1");
        java.lang.String jSONObject = new org.json.JSONObject(hashMap).toString();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.amap.api.col.s.dj djVar = new com.amap.api.col.s.dj(c, "core", "2.0", "O002");
            djVar.a(jSONObject);
            com.amap.api.col.s.dk.a(djVar, c);
        } catch (com.amap.api.col.s.bh unused) {
        }
    }

    public static void a(boolean z2, com.amap.api.col.s.da.a aVar) {
        if (!C || aVar == null) {
            return;
        }
        synchronized (B) {
            if (z2) {
                java.util.Iterator<com.amap.api.col.s.da.a> it = B.iterator();
                while (it.hasNext()) {
                    com.amap.api.col.s.da.a next = it.next();
                    if (next.b.equals(aVar.b) && next.e.equals(aVar.e) && next.f == aVar.f) {
                        if (next.j == aVar.j) {
                            it.remove();
                            com.amap.api.col.s.da.a();
                        } else {
                            next.j.set(next.j.get() - aVar.j.get());
                            com.amap.api.col.s.da.a();
                        }
                    }
                }
            }
            C = false;
            java.util.Iterator<com.amap.api.col.s.da.a> it2 = B.iterator();
            com.amap.api.col.s.da.a();
            while (it2.hasNext()) {
                com.amap.api.col.s.da.a next2 = it2.next();
                java.lang.String str = next2.e;
                java.util.Objects.toString(next2.j);
                com.amap.api.col.s.da.a();
            }
            com.amap.api.col.s.da.a();
        }
    }

    public static void a(boolean z2, java.lang.String str) {
        try {
            "--markHostNameFailed---hostname=".concat(java.lang.String.valueOf(str));
            com.amap.api.col.s.da.a();
            if (f || z2) {
                if ((i || !z2) && !android.text.TextUtils.isEmpty(str)) {
                    if (z2) {
                        if (A.get(str) != null) {
                            return;
                        }
                        A.put(str, java.lang.Boolean.TRUE);
                        h(k(str, "a15"), "open_common");
                        return;
                    }
                    if (z.get(str) != null) {
                        return;
                    }
                    z.put(str, java.lang.Boolean.TRUE);
                    h(k(str, "a14"), "open_common");
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static boolean a() {
        com.amap.api.col.s.bj.e b2;
        if (c != null) {
            q();
            if (!b()) {
                return false;
            }
            if (r()) {
                return true;
            }
        }
        return o && (b2 = b(c, "IPV6_CONFIG_NAME", "open_common")) != null && b2.a() < 5;
    }

    public static synchronized boolean a(java.lang.String str) {
        synchronized (com.amap.api.col.s.bj.class) {
            try {
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cg.a(th, "at", "cslct");
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

    public static synchronized boolean a(java.lang.String str, long j2) {
        synchronized (com.amap.api.col.s.bj.class) {
            boolean z2 = false;
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            if (j2 > c(str)) {
                if (android.os.SystemClock.elapsedRealtime() - ((u == null || !u.containsKey(str)) ? 0L : u.get(str).longValue()) > 30000) {
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

    public static synchronized com.amap.api.col.s.bj.e b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.amap.api.col.s.bj.e eVar;
        synchronized (com.amap.api.col.s.bj.class) {
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
            com.amap.api.col.s.bj.e b2 = com.amap.api.col.s.bj.e.b(com.amap.api.col.s.cm.b(context, str2, str, ""));
            java.lang.String a2 = com.amap.api.col.s.bu.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
            if (b2 == null) {
                b2 = new com.amap.api.col.s.bj.e(str, a2, 0);
            }
            if (!a2.equals(b2.b)) {
                b2.a(a2);
                b2.c.set(0);
            }
            p.add(b2);
            return b2;
        }
    }

    public static void b(com.amap.api.col.s.da.c cVar) {
        synchronized (B) {
            boolean z2 = false;
            for (int i2 = 0; i2 < B.size(); i2++) {
                com.amap.api.col.s.da.a aVar = B.get(i2);
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
                B.add(new com.amap.api.col.s.da.a(cVar));
            }
            com.amap.api.col.s.da.a();
        }
    }

    public static synchronized void b(java.lang.String str) {
        synchronized (com.amap.api.col.s.bj.class) {
            if (u == null) {
                return;
            }
            if (u.containsKey(str)) {
                u.remove(str);
            }
        }
    }

    public static synchronized void b(java.lang.String str, boolean z2) {
        synchronized (com.amap.api.col.s.bj.class) {
            a(str, z2, null, null, null);
        }
    }

    public static boolean b() {
        java.lang.Integer num;
        android.content.Context context = c;
        if (context == null) {
            return false;
        }
        java.lang.String p2 = com.amap.api.col.s.bm.p(context);
        return (android.text.TextUtils.isEmpty(p2) || (num = q.get(p2.toUpperCase())) == null || num.intValue() < 2) ? false : true;
    }

    public static synchronized long c(java.lang.String str) {
        synchronized (com.amap.api.col.s.bj.class) {
            try {
                if (t == null) {
                    t = new java.util.concurrent.ConcurrentHashMap<>(8);
                }
                if (t.containsKey(str)) {
                    return t.get(str).longValue();
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cg.a(th, "at", "glcut");
            }
            return 0L;
        }
    }

    public static void c() {
        try {
            com.amap.api.col.s.bj.e b2 = b(c, "IPV6_CONFIG_NAME", "open_common");
            java.lang.String a2 = com.amap.api.col.s.bu.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
            if (!a2.equals(b2.b)) {
                b2.a(a2);
                b2.c.set(0);
            }
            b2.c.incrementAndGet();
            f(c, "IPV6_CONFIG_NAME", "open_common", b2);
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void c(android.content.Context context, com.amap.api.col.s.bt btVar, java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put("amap_sdk_auth_fail", "1");
        hashMap.put("amap_sdk_auth_fail_type", str);
        hashMap.put("amap_sdk_name", btVar.b());
        hashMap.put("amap_sdk_version", btVar.d());
        java.lang.String jSONObject = new org.json.JSONObject(hashMap).toString();
        if (android.text.TextUtils.isEmpty(jSONObject)) {
            return;
        }
        try {
            com.amap.api.col.s.dj djVar = new com.amap.api.col.s.dj(context, "core", "2.0", "O001");
            djVar.a(jSONObject);
            com.amap.api.col.s.dk.a(djVar, context);
        } catch (com.amap.api.col.s.bh unused) {
        }
    }

    public static void c(com.amap.api.col.s.da.c cVar) {
        if (cVar != null && j) {
            synchronized (D) {
                D.offer(cVar);
                com.amap.api.col.s.da.a();
            }
        }
    }

    public static void d() {
        if (d) {
            return;
        }
        try {
            android.content.Context context = c;
            if (context == null) {
                return;
            }
            d = true;
            com.amap.api.col.s.bo.a().a(context);
            l(context);
            n(context);
            com.amap.api.col.s.bj.f.a = com.amap.api.col.s.cm.a(context, "open_common", "ucf", com.amap.api.col.s.bj.f.a);
            com.amap.api.col.s.bj.f.b = com.amap.api.col.s.cm.a(context, "open_common", "fsv2", com.amap.api.col.s.bj.f.b);
            com.amap.api.col.s.bj.f.c = com.amap.api.col.s.cm.a(context, "open_common", "usc", com.amap.api.col.s.bj.f.c);
            com.amap.api.col.s.bj.f.d = com.amap.api.col.s.cm.a(context, "open_common", "umv", com.amap.api.col.s.bj.f.d);
            com.amap.api.col.s.bj.f.e = com.amap.api.col.s.cm.a(context, "open_common", "ust", com.amap.api.col.s.bj.f.e);
            com.amap.api.col.s.bj.f.f = com.amap.api.col.s.cm.a(context, "open_common", "ustv", com.amap.api.col.s.bj.f.f);
        } catch (java.lang.Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x02c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(android.content.Context context, com.amap.api.col.s.bt btVar, java.lang.String str, com.amap.api.col.s.bj.b bVar, org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        org.json.JSONObject jSONObject2;
        boolean a2;
        android.content.Context context2;
        org.json.JSONObject jSONObject3;
        java.lang.String[] strArr;
        com.amap.api.col.s.bj.b.a aVar = new com.amap.api.col.s.bj.b.a();
        aVar.a = false;
        aVar.b = false;
        bVar.g = aVar;
        try {
            java.lang.String[] split = str.split(com.alipay.sdk.m.u.i.b);
            if (split != null && split.length > 0) {
                int length = split.length;
                int i2 = 0;
                while (i2 < length) {
                    java.lang.String str5 = split[i2];
                    if (jSONObject.has(str5)) {
                        strArr = split;
                        bVar.f.putOpt(str5, jSONObject.get(str5));
                    } else {
                        strArr = split;
                    }
                    i2++;
                    split = strArr;
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "at", "co");
        }
        if (com.amap.api.col.s.bu.a(jSONObject, "16H")) {
            try {
                bVar.i = a(jSONObject.getJSONObject("16H").optString("able"), false);
            } catch (java.lang.Throwable th2) {
                com.amap.api.col.s.cg.a(th2, "AuthConfigManager", "load 16H");
            }
        }
        if (com.amap.api.col.s.bu.a(jSONObject, "11K")) {
            try {
                org.json.JSONObject jSONObject4 = jSONObject.getJSONObject("11K");
                aVar.a = a(jSONObject4.getString("able"), false);
                if (jSONObject4.has(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF)) {
                    aVar.c = jSONObject4.getJSONObject(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                }
            } catch (java.lang.Throwable th3) {
                com.amap.api.col.s.cg.a(th3, "AuthConfigManager", "load 11K");
            }
        }
        if (com.amap.api.col.s.bu.a(jSONObject, "145")) {
            try {
                bVar.a = jSONObject.getJSONObject("145");
            } catch (java.lang.Throwable th4) {
                com.amap.api.col.s.cg.a(th4, "AuthConfigManager", "load 145");
            }
        }
        if (com.amap.api.col.s.bu.a(jSONObject, "14D")) {
            try {
                bVar.b = jSONObject.getJSONObject("14D");
            } catch (java.lang.Throwable th5) {
                com.amap.api.col.s.cg.a(th5, "AuthConfigManager", "load 14D");
            }
        }
        if (com.amap.api.col.s.bu.a(jSONObject, "151")) {
            try {
                org.json.JSONObject jSONObject5 = jSONObject.getJSONObject("151");
                com.amap.api.col.s.bj.b.C0115b c0115b = new com.amap.api.col.s.bj.b.C0115b();
                if (jSONObject5 != null) {
                    c0115b.a = a(jSONObject5.optString("able"), false);
                }
                bVar.h = c0115b;
            } catch (java.lang.Throwable th6) {
                com.amap.api.col.s.cg.a(th6, "AuthConfigManager", "load 151");
            }
        }
        if (com.amap.api.col.s.bu.a(jSONObject, "17S")) {
            try {
                jSONObject2 = jSONObject.getJSONObject("17S");
                if (jSONObject2 != null && (a2 = a(jSONObject2.optString("able"), false)) != o) {
                    o = a2;
                    if (context != null) {
                        android.content.SharedPreferences.Editor a3 = com.amap.api.col.s.cm.a(context, "open_common");
                        com.amap.api.col.s.cm.a(a3, "a2", a2);
                        com.amap.api.col.s.cm.a(a3);
                    }
                }
            } catch (java.lang.Throwable th7) {
                th = th7;
                str2 = "ustv";
            }
            if (jSONObject2 != null) {
                boolean a4 = a(jSONObject2.optString("static_enable"), true);
                boolean a5 = a(jSONObject2.optString("static_ip_direct_enable"), false);
                int optInt = jSONObject2.optInt("static_timeout", 5) * 1000;
                int optInt2 = jSONObject2.optInt("static_retry", 3);
                str2 = "ustv";
                try {
                    boolean a6 = a(jSONObject2.optString("bgp_enable"), true);
                    str3 = "ust";
                    try {
                        boolean a7 = a(jSONObject2.optString("bgp_ip_direct_enable"), false);
                        str4 = "umv";
                        try {
                            int optInt3 = jSONObject2.optInt("bgp_retry", 3);
                            boolean a8 = a(jSONObject2.optString("perf_data_upload_enable"), false);
                            if (a4 != f || a5 != g || optInt != e || optInt2 != x || a6 != h || a7 != i || optInt3 != y || a8 != j) {
                                f = a4;
                                g = a5;
                                e = optInt;
                                x = optInt2;
                                h = a6;
                                i = a7;
                                y = optInt3;
                                j = a8;
                                if (context != null) {
                                    android.content.SharedPreferences.Editor a9 = com.amap.api.col.s.cm.a(context, "open_common");
                                    com.amap.api.col.s.cm.a(a9, "a13", a4);
                                    com.amap.api.col.s.cm.a(a9, "a6", a6);
                                    com.amap.api.col.s.cm.a(a9, "a7", a5);
                                    com.amap.api.col.s.cm.a(a9, "a8", optInt);
                                    com.amap.api.col.s.cm.a(a9, "a9", optInt2);
                                    com.amap.api.col.s.cm.a(a9, "a10", a7);
                                    com.amap.api.col.s.cm.a(a9, "a11", optInt3);
                                    com.amap.api.col.s.cm.a(a9, "a12", a8);
                                    com.amap.api.col.s.cm.a(a9);
                                }
                            }
                            com.amap.api.col.s.da.a();
                            com.amap.api.col.s.da.a();
                            com.amap.api.col.s.da.a();
                            com.amap.api.col.s.da.a();
                            com.amap.api.col.s.da.a();
                        } catch (java.lang.Throwable th8) {
                            th = th8;
                            com.amap.api.col.s.cg.a(th, "AuthConfigManager", "load 17S");
                            if (com.amap.api.col.s.bu.a(jSONObject, "15K")) {
                            }
                            context2 = context;
                            if (com.amap.api.col.s.bu.a(jSONObject, "183")) {
                            }
                            if (com.amap.api.col.s.bu.a(jSONObject, "17I")) {
                            }
                        }
                    } catch (java.lang.Throwable th9) {
                        th = th9;
                        str4 = "umv";
                        com.amap.api.col.s.cg.a(th, "AuthConfigManager", "load 17S");
                        if (com.amap.api.col.s.bu.a(jSONObject, "15K")) {
                        }
                        context2 = context;
                        if (com.amap.api.col.s.bu.a(jSONObject, "183")) {
                        }
                        if (com.amap.api.col.s.bu.a(jSONObject, "17I")) {
                        }
                    }
                } catch (java.lang.Throwable th10) {
                    th = th10;
                    str3 = "ust";
                    str4 = "umv";
                    com.amap.api.col.s.cg.a(th, "AuthConfigManager", "load 17S");
                    if (com.amap.api.col.s.bu.a(jSONObject, "15K")) {
                    }
                    context2 = context;
                    if (com.amap.api.col.s.bu.a(jSONObject, "183")) {
                    }
                    if (com.amap.api.col.s.bu.a(jSONObject, "17I")) {
                    }
                }
                if (com.amap.api.col.s.bu.a(jSONObject, "15K")) {
                    try {
                        jSONObject3 = jSONObject.getJSONObject("15K");
                    } catch (java.lang.Throwable th11) {
                        context2 = context;
                        com.amap.api.col.s.cg.a(th11, "AuthConfigManager", "load 15K");
                    }
                    if (jSONObject3 != null) {
                        boolean a10 = a(jSONObject3.optString("ucf"), com.amap.api.col.s.bj.f.a);
                        boolean a11 = a(jSONObject3.optString("fsv2"), com.amap.api.col.s.bj.f.b);
                        boolean a12 = a(jSONObject3.optString("usc"), com.amap.api.col.s.bj.f.c);
                        java.lang.String str6 = str4;
                        int optInt4 = jSONObject3.optInt(str6, com.amap.api.col.s.bj.f.d);
                        java.lang.String str7 = str3;
                        boolean a13 = a(jSONObject3.optString(str7), com.amap.api.col.s.bj.f.e);
                        java.lang.String str8 = str2;
                        int optInt5 = jSONObject3.optInt(str8, com.amap.api.col.s.bj.f.f);
                        if (a10 != com.amap.api.col.s.bj.f.a || a11 != com.amap.api.col.s.bj.f.b || a12 != com.amap.api.col.s.bj.f.c || optInt4 != com.amap.api.col.s.bj.f.d || a13 != com.amap.api.col.s.bj.f.e || optInt5 != com.amap.api.col.s.bj.f.d) {
                            com.amap.api.col.s.bj.f.a = a10;
                            com.amap.api.col.s.bj.f.b = a11;
                            com.amap.api.col.s.bj.f.c = a12;
                            com.amap.api.col.s.bj.f.d = optInt4;
                            com.amap.api.col.s.bj.f.e = a13;
                            com.amap.api.col.s.bj.f.f = optInt5;
                            context2 = context;
                            try {
                                android.content.SharedPreferences.Editor a14 = com.amap.api.col.s.cm.a(context2, "open_common");
                                com.amap.api.col.s.cm.a(a14, "ucf", com.amap.api.col.s.bj.f.a);
                                com.amap.api.col.s.cm.a(a14, "fsv2", com.amap.api.col.s.bj.f.b);
                                com.amap.api.col.s.cm.a(a14, "usc", com.amap.api.col.s.bj.f.c);
                                com.amap.api.col.s.cm.a(a14, str6, com.amap.api.col.s.bj.f.d);
                                com.amap.api.col.s.cm.a(a14, str7, com.amap.api.col.s.bj.f.e);
                                com.amap.api.col.s.cm.a(a14, str8, com.amap.api.col.s.bj.f.f);
                                com.amap.api.col.s.cm.a(a14);
                            } catch (java.lang.Throwable unused) {
                            }
                            if (com.amap.api.col.s.bu.a(jSONObject, "183")) {
                                try {
                                    com.amap.api.col.s.cz.a(btVar, jSONObject.getJSONObject("183"));
                                } catch (java.lang.Throwable th12) {
                                    com.amap.api.col.s.cg.a(th12, "AuthConfigManager", "load 183");
                                }
                            }
                            if (com.amap.api.col.s.bu.a(jSONObject, "17I")) {
                                return;
                            }
                            try {
                                org.json.JSONObject jSONObject6 = jSONObject.getJSONObject("17I");
                                boolean a15 = a(jSONObject6.optString("na"), false);
                                boolean a16 = a(jSONObject6.optString(com.anythink.expressad.d.a.b.w), false);
                                com.amap.api.col.s.cd.d = a15;
                                com.amap.api.col.s.cd.e = a16;
                                android.content.SharedPreferences.Editor a17 = com.amap.api.col.s.cm.a(context2, "open_common");
                                com.amap.api.col.s.cm.a(a17, "a4", a15);
                                com.amap.api.col.s.cm.a(a17, "a5", a16);
                                com.amap.api.col.s.cm.a(a17);
                                return;
                            } catch (java.lang.Throwable th13) {
                                com.amap.api.col.s.cg.a(th13, "AuthConfigManager", "load 17I");
                                return;
                            }
                        }
                    }
                }
                context2 = context;
                if (com.amap.api.col.s.bu.a(jSONObject, "183")) {
                }
                if (com.amap.api.col.s.bu.a(jSONObject, "17I")) {
                }
            }
        }
        str2 = "ustv";
        str3 = "ust";
        str4 = "umv";
        if (com.amap.api.col.s.bu.a(jSONObject, "15K")) {
        }
        context2 = context;
        if (com.amap.api.col.s.bu.a(jSONObject, "183")) {
        }
        if (com.amap.api.col.s.bu.a(jSONObject, "17I")) {
        }
    }

    public static boolean d(java.lang.String str) {
        com.amap.api.col.s.bj.e b2;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return true;
            }
            if (!f) {
                return false;
            }
            if (!(z.get(str) == null)) {
                return false;
            }
            android.content.Context context = c;
            if (context == null || (b2 = b(context, k(str, "a14"), "open_common")) == null) {
                return true;
            }
            return b2.a() < x;
        } catch (java.lang.Throwable unused) {
            return true;
        }
    }

    public static com.amap.api.col.s.da.a e() {
        if (C) {
            return null;
        }
        synchronized (B) {
            if (C) {
                return null;
            }
            java.util.Collections.sort(B);
            if (B.size() <= 0) {
                return null;
            }
            com.amap.api.col.s.da.a clone = B.get(0).clone();
            C = true;
            return clone;
        }
    }

    public static void e(android.content.Context context, com.amap.api.col.s.bt btVar, java.lang.Throwable th) {
        c(context, btVar, th.getMessage());
    }

    public static boolean e(java.lang.String str) {
        com.amap.api.col.s.bj.e b2;
        if (android.text.TextUtils.isEmpty(str) || !i) {
            return false;
        }
        if (!(A.get(str) == null)) {
            return false;
        }
        android.content.Context context = c;
        if (context == null || (b2 = b(context, k(str, "a15"), "open_common")) == null) {
            return true;
        }
        return b2.a() < y;
    }

    public static com.amap.api.col.s.da.c f() {
        synchronized (D) {
            com.amap.api.col.s.da.c poll = D.poll();
            if (poll != null) {
                return poll;
            }
            return null;
        }
    }

    public static void f(android.content.Context context, java.lang.String str, java.lang.String str2, com.amap.api.col.s.bj.e eVar) {
        if (eVar == null || android.text.TextUtils.isEmpty(eVar.a)) {
            return;
        }
        java.lang.String b2 = eVar.b();
        if (android.text.TextUtils.isEmpty(b2) || context == null) {
            return;
        }
        android.content.SharedPreferences.Editor a2 = com.amap.api.col.s.cm.a(context, str2);
        a2.putString(str, b2);
        com.amap.api.col.s.cm.a(a2);
    }

    public static void g(com.amap.api.col.s.bt btVar) {
        if (btVar != null) {
            try {
                if (android.text.TextUtils.isEmpty(btVar.b())) {
                    return;
                }
                java.lang.String d2 = btVar.d();
                if (android.text.TextUtils.isEmpty(d2)) {
                    d2 = btVar.c();
                }
                if (android.text.TextUtils.isEmpty(d2)) {
                    return;
                }
                com.amap.api.col.s.cd.a(btVar.b(), d2);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void h(java.lang.String str, java.lang.String str2) {
        com.amap.api.col.s.bj.e b2 = b(c, str, str2);
        java.lang.String a2 = com.amap.api.col.s.bu.a(java.lang.System.currentTimeMillis(), "yyyyMMdd");
        if (!a2.equals(b2.b)) {
            b2.a(a2);
            b2.c.set(0);
        }
        b2.c.incrementAndGet();
        f(c, str, str2, b2);
    }

    public static boolean i(java.net.InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress() || inetAddress.isLinkLocalAddress() || inetAddress.isAnyLocalAddress();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x01ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.amap.api.col.s.bj.b j(android.content.Context context, com.amap.api.col.s.bt btVar, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        com.amap.api.col.s.bj.b bVar;
        java.lang.String str9;
        java.lang.String str10;
        java.lang.String str11;
        com.amap.api.col.s.de deVar;
        byte[] bArr;
        java.lang.String str12;
        java.lang.String str13;
        boolean isEmpty;
        java.util.List<java.lang.String> list;
        com.amap.api.col.s.bj.b bVar2 = new com.amap.api.col.s.bj.b();
        bVar2.f = new org.json.JSONObject();
        if (context != null) {
            c = context.getApplicationContext();
        }
        d();
        java.lang.String str14 = null;
        try {
            g(btVar);
            new com.amap.api.col.s.cx();
            isEmpty = android.text.TextUtils.isEmpty(str);
            if (isEmpty) {
                str11 = str;
            } else {
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    str5 = str;
                    try {
                        sb.append(str5);
                        sb.append(";15K;16H;17I;17S;183");
                        str11 = sb.toString();
                    } catch (com.amap.api.col.s.bh e2) {
                        e = e2;
                        str6 = "infocode";
                        str7 = "result";
                        str8 = "ver";
                        bVar = bVar2;
                        str9 = "at";
                        str10 = "lc";
                        try {
                            throw e;
                        } catch (com.amap.api.col.s.bh e3) {
                            e = e3;
                            str11 = str5;
                            deVar = null;
                            bArr = null;
                            bVar.c = e.a();
                            c(context, btVar, e.a());
                            com.amap.api.col.s.cj.a(btVar, "/v3/iasdkauth", e);
                            java.lang.String str15 = str11;
                            if (bArr == null) {
                            }
                        } catch (javax.crypto.IllegalBlockSizeException e4) {
                            e = e4;
                            str11 = str5;
                            deVar = null;
                            bArr = null;
                            e(context, btVar, e);
                            java.lang.String str152 = str11;
                            if (bArr == null) {
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            str11 = str5;
                            deVar = null;
                            bArr = null;
                            com.amap.api.col.s.cj.c(th, str9, str10);
                            e(context, btVar, th);
                            java.lang.String str1522 = str11;
                            if (bArr == null) {
                            }
                        }
                    } catch (java.lang.Throwable unused) {
                        str11 = str5;
                        str6 = "infocode";
                        str7 = "result";
                        str8 = "ver";
                        bVar = bVar2;
                        str9 = "at";
                        str10 = "lc";
                        try {
                            throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                        } catch (com.amap.api.col.s.bh e5) {
                            e = e5;
                            deVar = null;
                            bArr = null;
                            bVar.c = e.a();
                            c(context, btVar, e.a());
                            com.amap.api.col.s.cj.a(btVar, "/v3/iasdkauth", e);
                            java.lang.String str15222 = str11;
                            if (bArr == null) {
                            }
                        } catch (javax.crypto.IllegalBlockSizeException e6) {
                            e = e6;
                            deVar = null;
                            bArr = null;
                            e(context, btVar, e);
                            java.lang.String str152222 = str11;
                            if (bArr == null) {
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            deVar = null;
                            bArr = null;
                            com.amap.api.col.s.cj.c(th, str9, str10);
                            e(context, btVar, th);
                            java.lang.String str1522222 = str11;
                            if (bArr == null) {
                            }
                        }
                    }
                } catch (com.amap.api.col.s.bh e7) {
                    e = e7;
                    str5 = str;
                } catch (java.lang.Throwable unused2) {
                    str5 = str;
                }
            }
            try {
                o(context);
                str7 = "result";
                bVar = bVar2;
                str8 = "ver";
                str9 = "at";
                str6 = "infocode";
                str10 = "lc";
            } catch (com.amap.api.col.s.bh e8) {
                e = e8;
                str6 = "infocode";
                str7 = "result";
                str8 = "ver";
                bVar = bVar2;
                str9 = "at";
                str10 = "lc";
            } catch (java.lang.Throwable unused3) {
                str6 = "infocode";
                str7 = "result";
                str8 = "ver";
                bVar = bVar2;
                str9 = "at";
                str10 = "lc";
                throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
            }
        } catch (com.amap.api.col.s.bh e9) {
            e = e9;
            str5 = str;
            str6 = "infocode";
            str7 = "result";
            str8 = "ver";
            bVar = bVar2;
            str9 = "at";
            str10 = "lc";
        } catch (javax.crypto.IllegalBlockSizeException e10) {
            e = e10;
            str5 = str;
            str6 = "infocode";
            str7 = "result";
            str8 = "ver";
            bVar = bVar2;
            str9 = "at";
            str10 = "lc";
        } catch (java.lang.Throwable th3) {
            th = th3;
            str5 = str;
            str6 = "infocode";
            str7 = "result";
            str8 = "ver";
            bVar = bVar2;
            str9 = "at";
            str10 = "lc";
        }
        try {
            deVar = com.amap.api.col.s.cx.a(new com.amap.api.col.s.bj.c(context, btVar, str11, str2, str3, str4));
            if (isEmpty) {
                return bVar;
            }
            if (deVar != null) {
                try {
                    bArr = deVar.a;
                    try {
                        java.util.Map<java.lang.String, java.util.List<java.lang.String>> map = deVar.b;
                        if (map != null && map.containsKey("lct") && (list = map.get("lct")) != null && list.size() > 0) {
                            java.lang.String str16 = list.get(0);
                            if (!android.text.TextUtils.isEmpty(str16)) {
                                long longValue = java.lang.Long.valueOf(str16).longValue();
                                bVar.e = longValue;
                                if (btVar != null && longValue != 0) {
                                    java.lang.String b2 = btVar.b();
                                    if (!android.text.TextUtils.isEmpty(b2)) {
                                        m(b2, bVar.e);
                                    }
                                }
                            }
                        }
                    } catch (java.lang.Throwable th4) {
                        try {
                            com.amap.api.col.s.cj.c(th4, str9, "lct");
                        } catch (com.amap.api.col.s.bh e11) {
                            e = e11;
                            bVar.c = e.a();
                            c(context, btVar, e.a());
                            com.amap.api.col.s.cj.a(btVar, "/v3/iasdkauth", e);
                            java.lang.String str15222222 = str11;
                            if (bArr == null) {
                            }
                        } catch (javax.crypto.IllegalBlockSizeException e12) {
                            e = e12;
                            e(context, btVar, e);
                            java.lang.String str152222222 = str11;
                            if (bArr == null) {
                            }
                        } catch (java.lang.Throwable th5) {
                            th = th5;
                            com.amap.api.col.s.cj.c(th, str9, str10);
                            e(context, btVar, th);
                            java.lang.String str1522222222 = str11;
                            if (bArr == null) {
                            }
                        }
                    }
                } catch (com.amap.api.col.s.bh e13) {
                    e = e13;
                    bArr = null;
                    bVar.c = e.a();
                    c(context, btVar, e.a());
                    com.amap.api.col.s.cj.a(btVar, "/v3/iasdkauth", e);
                    java.lang.String str15222222222 = str11;
                    if (bArr == null) {
                    }
                } catch (javax.crypto.IllegalBlockSizeException e14) {
                    e = e14;
                    bArr = null;
                    e(context, btVar, e);
                    java.lang.String str152222222222 = str11;
                    if (bArr == null) {
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    bArr = null;
                    com.amap.api.col.s.cj.c(th, str9, str10);
                    e(context, btVar, th);
                    java.lang.String str1522222222222 = str11;
                    if (bArr == null) {
                    }
                }
            } else {
                bArr = null;
            }
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            java.lang.System.arraycopy(bArr, 0, bArr2, 0, 16);
            java.lang.System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(bArr2, com.amap.api.col.s.bu.c("EQUVT"));
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(com.amap.api.col.s.bu.c("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(2, secretKeySpec, new javax.crypto.spec.IvParameterSpec(com.amap.api.col.s.bu.c()));
            str14 = com.amap.api.col.s.bu.a(cipher.doFinal(bArr3));
            java.lang.String str15222222222222 = str11;
            if (bArr == null) {
                return bVar;
            }
            if (android.text.TextUtils.isEmpty(str14)) {
                str14 = com.amap.api.col.s.bu.a(bArr);
            }
            java.lang.String str17 = str14;
            if (android.text.TextUtils.isEmpty(str17)) {
                c(context, btVar, "result is null");
            }
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str17);
                if (jSONObject.has("status")) {
                    int i2 = jSONObject.getInt("status");
                    if (i2 == 1) {
                        a = 1;
                    } else if (i2 == 0) {
                        if (deVar != null) {
                            str12 = deVar.c;
                            str13 = deVar.d;
                        } else {
                            str12 = "authcsid";
                            str13 = "authgsid";
                        }
                        com.amap.api.col.s.bu.a(context, str12, str13, jSONObject);
                        a = 0;
                        if (jSONObject.has("info")) {
                            b = jSONObject.getString("info");
                        }
                        java.lang.String str18 = str6;
                        com.amap.api.col.s.cj.a(btVar, "/v3/iasdkauth", b, str13, str12, jSONObject.has(str18) ? jSONObject.getString(str18) : "");
                        if (a == 0) {
                            bVar.c = b;
                            return bVar;
                        }
                    }
                    java.lang.String str19 = str8;
                    try {
                        if (jSONObject.has(str19)) {
                            bVar.d = jSONObject.getInt(str19);
                        }
                    } catch (java.lang.Throwable th7) {
                        com.amap.api.col.s.cg.a(th7, str9, str10);
                    }
                    java.lang.String str20 = str7;
                    if (com.amap.api.col.s.bu.a(jSONObject, str20)) {
                        org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(str20);
                        d(context, btVar, str15222222222222, bVar, jSONObject2);
                        try {
                            org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("15K");
                            boolean a2 = a(jSONObject3.optString("isTargetAble"), false);
                            if (a(jSONObject3.optString("able"), false)) {
                                com.amap.api.col.s.bo.a().b(context, a2);
                            } else {
                                com.amap.api.col.s.bo.a();
                                com.amap.api.col.s.bo.b(context);
                            }
                        } catch (java.lang.Throwable unused4) {
                        }
                    }
                }
            } catch (java.lang.Throwable th8) {
                com.amap.api.col.s.cg.a(th8, str9, str10);
            }
            return bVar;
        } catch (com.amap.api.col.s.bh e15) {
            e = e15;
            str5 = str11;
            throw e;
        } catch (java.lang.Throwable unused5) {
            throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }

    public static java.lang.String k(java.lang.String str, java.lang.String str2) {
        return str2 + "_" + com.amap.api.col.s.bq.a(str.getBytes());
    }

    public static void l(android.content.Context context) {
        if (context == null) {
            return;
        }
        o = com.amap.api.col.s.cm.a(context, "open_common", "a2", true);
    }

    public static synchronized void m(java.lang.String str, long j2) {
        synchronized (com.amap.api.col.s.bj.class) {
            try {
                if (v != null && v.containsKey(str)) {
                    if (t == null) {
                        t = new java.util.concurrent.ConcurrentHashMap<>(8);
                    }
                    t.put(str, java.lang.Long.valueOf(j2));
                    android.content.Context context = c;
                    if (context != null) {
                        android.content.SharedPreferences.Editor a2 = com.amap.api.col.s.cm.a(context, "open_common");
                        com.amap.api.col.s.cm.a(a2, str, j2);
                        com.amap.api.col.s.cm.a(a2);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cg.a(th, "at", "ucut");
            }
        }
    }

    public static void n(android.content.Context context) {
        if (context == null) {
            return;
        }
        f = com.amap.api.col.s.cm.a(context, "open_common", "a13", true);
        h = com.amap.api.col.s.cm.a(context, "open_common", "a6", true);
        g = com.amap.api.col.s.cm.a(context, "open_common", "a7", false);
        e = com.amap.api.col.s.cm.a(context, "open_common", "a8", 5000);
        x = com.amap.api.col.s.cm.a(context, "open_common", "a9", 3);
        i = com.amap.api.col.s.cm.a(context, "open_common", "a10", false);
        y = com.amap.api.col.s.cm.a(context, "open_common", "a11", 3);
        j = com.amap.api.col.s.cm.a(context, "open_common", "a12", false);
    }

    public static void o(android.content.Context context) {
        try {
            if (w) {
                return;
            }
            com.amap.api.col.s.cd.d = com.amap.api.col.s.cm.a(context, "open_common", "a4", true);
            com.amap.api.col.s.cd.e = com.amap.api.col.s.cm.a(context, "open_common", "a5", true);
            w = true;
        } catch (java.lang.Throwable unused) {
        }
    }

    public static void q() {
        try {
            android.content.Context context = c;
            if (context != null) {
                java.lang.String p2 = com.amap.api.col.s.bm.p(context);
                if (!android.text.TextUtils.isEmpty(r) && !android.text.TextUtils.isEmpty(p2) && r.equals(p2) && java.lang.System.currentTimeMillis() - f106s < 60000) {
                    return;
                }
                if (!android.text.TextUtils.isEmpty(p2)) {
                    r = p2;
                }
            } else if (java.lang.System.currentTimeMillis() - f106s < 10000) {
                return;
            }
            f106s = java.lang.System.currentTimeMillis();
            q.clear();
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
                            if (!i((java.net.Inet6Address) address)) {
                                i2 |= 2;
                            }
                        } else if (address instanceof java.net.Inet4Address) {
                            java.net.Inet4Address inet4Address = (java.net.Inet4Address) address;
                            if (!i(inet4Address) && !inet4Address.getHostAddress().startsWith(com.amap.api.col.s.bu.c("FMTkyLjE2OC40My4"))) {
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
            com.amap.api.col.s.cg.a(th, "at", "ipstack");
        }
    }

    public static boolean r() {
        java.lang.Integer num;
        android.content.Context context = c;
        if (context == null) {
            return false;
        }
        java.lang.String p2 = com.amap.api.col.s.bm.p(context);
        return (android.text.TextUtils.isEmpty(p2) || (num = q.get(p2.toUpperCase())) == null || num.intValue() != 2) ? false : true;
    }
}
