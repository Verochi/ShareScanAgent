package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class da {
    public static java.lang.ref.SoftReference<javax.net.ssl.SSLContext> t;
    public static java.lang.ref.SoftReference<com.amap.api.col.s.db> u;
    public boolean a;
    public javax.net.ssl.SSLContext b;
    public java.net.Proxy c;
    public java.lang.String g;
    public com.amap.api.col.s.cx.a h;
    public com.amap.api.col.s.da.d i;
    public boolean k;
    public java.lang.String l;
    public java.lang.String m;
    public volatile boolean d = false;
    public long e = -1;
    public long f = 0;
    public java.lang.String j = "";
    public boolean n = false;
    public boolean o = false;
    public java.lang.String p = "";
    public java.lang.String q = "";
    public java.lang.String r = "";

    /* renamed from: s, reason: collision with root package name */
    public com.amap.api.col.s.da.f f113s = new com.amap.api.col.s.da.f();

    public static class a implements java.lang.Cloneable, java.lang.Comparable {
        public int a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public java.lang.String e;
        public int f;
        public int g;
        public int h;
        public long i;
        public volatile java.util.concurrent.atomic.AtomicInteger j = new java.util.concurrent.atomic.AtomicInteger(1);

        public a(com.amap.api.col.s.da.c cVar) {
            this.b = cVar.c;
            this.c = cVar.e;
            this.e = cVar.d;
            this.f = cVar.m;
            this.g = cVar.n;
            this.h = cVar.b.a();
            this.d = cVar.a;
            this.i = cVar.f;
            if (this.f == 10) {
                this.a = 0;
            }
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.amap.api.col.s.da.a clone() {
            try {
                return (com.amap.api.col.s.da.a) super.clone();
            } catch (java.lang.CloneNotSupportedException unused) {
                return null;
            }
        }

        public final java.lang.String b() {
            java.lang.String str;
            java.lang.String str2;
            java.lang.String str3;
            java.lang.String str4;
            try {
                java.lang.String str5 = this.f + "#";
                if (android.text.TextUtils.isEmpty(this.e)) {
                    str = str5 + "-#";
                } else {
                    str = str5 + this.e + "#";
                }
                java.lang.String str6 = (str + this.h + "#") + this.j + "#";
                if (android.text.TextUtils.isEmpty(this.b)) {
                    str2 = str6 + "-#";
                } else {
                    str2 = str6 + this.b + "#";
                }
                if (this.f == 1) {
                    str3 = str2 + this.d + "#";
                } else {
                    str3 = str2 + "-#";
                }
                if (this.f == 1) {
                    str4 = str3 + this.i + "#";
                } else {
                    str4 = str3 + "-#";
                }
                java.lang.String b = com.amap.api.col.s.bn.b(com.amap.api.col.s.ct.a(((str4 + this.c + "#") + this.g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                com.amap.api.col.s.da.a();
                return b;
            } catch (java.lang.Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(java.lang.Object obj) {
            return this.a - ((com.amap.api.col.s.da.a) obj).a;
        }
    }

    public static class b {
        public java.net.HttpURLConnection a;
        public int b = this.b;
        public int b = this.b;

        public b(java.net.HttpURLConnection httpURLConnection) {
            this.a = httpURLConnection;
        }
    }

    public static class c implements java.lang.Cloneable {
        public java.lang.String a = "";
        public com.amap.api.col.s.dd.b b = com.amap.api.col.s.dd.b.FIRST_NONDEGRADE;
        public java.lang.String c = "";
        public java.lang.String d = "";
        public java.lang.String e = "";
        public long f = 0;
        public long g = 0;
        public long h = 0;
        public long i = 0;
        public long j = 0;
        public java.lang.String k = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        public java.lang.String l = com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        public int m = 0;
        public int n = 0;

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.amap.api.col.s.da.c clone() {
            try {
                return (com.amap.api.col.s.da.c) super.clone();
            } catch (java.lang.CloneNotSupportedException unused) {
                return null;
            }
        }

        public final java.lang.String b() {
            java.lang.String str;
            java.lang.String str2;
            if (android.text.TextUtils.isEmpty(this.c)) {
                str = "-#";
            } else {
                str = this.c + "#";
            }
            if (android.text.TextUtils.isEmpty(this.d)) {
                str2 = str + "-#";
            } else {
                str2 = str + this.d + "#";
            }
            java.lang.String b = com.amap.api.col.s.bn.b(com.amap.api.col.s.ct.a(((((str2 + this.b.a() + "#") + this.h + "#") + this.j + "#") + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            com.amap.api.col.s.da.a();
            return b;
        }

        public final java.lang.String toString() {
            return "RequestInfo{csid='" + this.a + "', degradeType=" + this.b + ", serverIp='" + this.c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    public static class d {
        public java.util.Vector<com.amap.api.col.s.da.e> a;
        public volatile com.amap.api.col.s.da.e b;

        public d() {
            this.a = new java.util.Vector<>();
            this.b = new com.amap.api.col.s.da.e((byte) 0);
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        public final com.amap.api.col.s.da.e a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                com.amap.api.col.s.da.e eVar = this.a.get(i);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            com.amap.api.col.s.da.e eVar2 = new com.amap.api.col.s.da.e((byte) 0);
            eVar2.c(str);
            this.a.add(eVar2);
            return eVar2;
        }
    }

    public static class e implements javax.net.ssl.HostnameVerifier {
        public java.lang.String a;
        public java.lang.String b;

        public e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }

        public final java.lang.String a() {
            return this.b;
        }

        public final void b(java.lang.String str) {
            java.lang.String[] split;
            if (android.text.TextUtils.isEmpty(this.a) || !str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) || (split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) == null || split.length <= 0) {
                this.a = str;
            } else {
                this.a = split[0];
            }
        }

        public final void c(java.lang.String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            javax.net.ssl.HostnameVerifier defaultHostnameVerifier = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier();
            return !android.text.TextUtils.isEmpty(this.a) ? this.a.equals(str) : !android.text.TextUtils.isEmpty(this.b) ? defaultHostnameVerifier.verify(this.b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    public class f {
        public long a = 0;
        public long b = 0;
        public com.amap.api.col.s.da.c c = new com.amap.api.col.s.da.c();
        public com.amap.api.col.s.da.a d;
        public com.amap.api.col.s.da.c e;
        public java.lang.String f;
        public java.net.URL g;

        public f() {
        }

        public final void a() {
            this.c.h = android.os.SystemClock.elapsedRealtime() - this.b;
        }

        public final void b(int i) {
            "----errorcode-----".concat(java.lang.String.valueOf(i));
            com.amap.api.col.s.da.a();
            try {
                this.c.f = android.os.SystemClock.elapsedRealtime() - this.a;
                com.amap.api.col.s.da.c cVar = this.c;
                cVar.m = i;
                if (cVar.b.e()) {
                    com.amap.api.col.s.bj.a(false, this.c.e);
                }
                boolean j = com.amap.api.col.s.da.this.j(this.c.e);
                if (j) {
                    if (com.amap.api.col.s.da.this.o && !android.text.TextUtils.isEmpty(com.amap.api.col.s.da.this.m) && this.c.b.b()) {
                        com.amap.api.col.s.bj.c();
                    }
                    if (this.c.b.c()) {
                        com.amap.api.col.s.bj.a(this.c.b.c(), this.c.e);
                    }
                    com.amap.api.col.s.bj.c(this.e);
                    com.amap.api.col.s.bj.a(false, this.d);
                    com.amap.api.col.s.bj.b(this.c);
                }
                com.amap.api.col.s.bj.a(this.g.toString(), this.c.b.c(), true, j);
                this.c.toString();
                com.amap.api.col.s.da.a();
            } catch (java.lang.Throwable unused) {
            }
        }

        public final void c(long j) {
            this.c.l = new java.text.DecimalFormat("0.00").format(j / 1024.0f);
        }

        public final void d(com.amap.api.col.s.dd ddVar, java.net.URL url) {
            this.g = url;
            this.c.d = url.getPath();
            this.c.e = url.getHost();
            if (!android.text.TextUtils.isEmpty(com.amap.api.col.s.da.this.m) && ddVar.t().b()) {
                com.amap.api.col.s.da.c cVar = this.c;
                cVar.c = cVar.e.replace("[", "").replace("]", "");
                this.c.e = com.amap.api.col.s.da.this.m;
            }
            if (ddVar.t().b()) {
                ddVar.d(this.c.e);
            }
            if (ddVar.t().d()) {
                this.f = ddVar.w();
            }
        }

        public final void e(com.amap.api.col.s.de deVar) {
            com.amap.api.col.s.da.c clone;
            try {
                this.c.f = android.os.SystemClock.elapsedRealtime() - this.a;
                if (deVar != null) {
                    deVar.f = this.c.b.c();
                }
                if (this.c.b.b()) {
                    com.amap.api.col.s.da.c cVar = this.c;
                    if (cVar.f > 10000) {
                        com.amap.api.col.s.bj.a(false, cVar.e);
                    }
                }
                if (this.c.b.d()) {
                    com.amap.api.col.s.bj.a(false, this.f);
                }
                boolean j = com.amap.api.col.s.da.this.j(this.c.e);
                if (j) {
                    com.amap.api.col.s.bj.c(this.c);
                    com.amap.api.col.s.bj.a(true, this.d);
                    com.amap.api.col.s.da.c cVar2 = this.c;
                    if (cVar2.f > com.amap.api.col.s.bj.e && (clone = cVar2.clone()) != null) {
                        clone.m = 1;
                        com.amap.api.col.s.bj.b(clone);
                        clone.toString();
                        com.amap.api.col.s.da.a();
                    }
                }
                com.amap.api.col.s.bj.a(this.g.toString(), this.c.b.c(), false, j);
                this.c.toString();
                com.amap.api.col.s.da.a();
            } catch (java.lang.Throwable unused) {
            }
        }

        public final void f() {
            this.c.i = android.os.SystemClock.elapsedRealtime() - this.b;
        }

        public final void g(int i) {
            this.c.n = i;
        }

        public final void h() {
            this.c.j = android.os.SystemClock.elapsedRealtime() - this.b;
        }

        public final void i() {
            com.amap.api.col.s.da.c clone = this.c.clone();
            if (this.c.f > com.amap.api.col.s.bj.e) {
                clone.m = 1;
            }
            com.amap.api.col.s.bj.a(clone);
        }
    }

    public da() {
        com.amap.api.col.s.bj.d();
        try {
            this.g = java.util.UUID.randomUUID().toString().replaceAll(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase();
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cg.a(th, "ht", "ic");
        }
    }

    public static int a(java.lang.Exception exc) {
        if (exc instanceof javax.net.ssl.SSLHandshakeException) {
            return 4101;
        }
        if (exc instanceof javax.net.ssl.SSLKeyException) {
            return 4102;
        }
        if (exc instanceof javax.net.ssl.SSLProtocolException) {
            return 4103;
        }
        if (exc instanceof javax.net.ssl.SSLPeerUnverifiedException) {
            return com.umeng.analytics.pro.q.a.h;
        }
        if (exc instanceof java.net.ConnectException) {
            return 6101;
        }
        if (exc instanceof java.net.SocketException) {
            return 6102;
        }
        return exc instanceof org.apache.http.conn.ConnectTimeoutException ? com.amap.api.services.core.AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND : exc instanceof java.net.SocketTimeoutException ? 2102 : 0;
    }

    public static void a() {
    }

    public static java.lang.String f(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.col.s.cx.e;
        if (hashMap != null) {
            if (map != null) {
                map.putAll(hashMap);
            } else {
                map = hashMap;
            }
        }
        if (map == null || map.size() <= 0) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf >= 0) {
            java.util.HashMap hashMap2 = new java.util.HashMap();
            java.lang.String substring = str.substring(indexOf);
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                java.lang.String key = entry.getKey();
                java.lang.String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                if (!substring.matches(".*[\\?\\&]" + java.net.URLEncoder.encode(key) + "=.*")) {
                    hashMap2.put(key, value);
                }
            }
            map = hashMap2;
        }
        if (map.size() == 0) {
            return str;
        }
        java.lang.String g = g(map);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        if (indexOf < 0) {
            stringBuffer.append("?");
        } else if (!str.endsWith("?") && !str.endsWith("&")) {
            stringBuffer.append("&");
        }
        if (g != null) {
            stringBuffer.append(g);
        }
        return stringBuffer.toString();
    }

    public static java.lang.String g(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(java.net.URLEncoder.encode(key));
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(java.net.URLEncoder.encode(value));
        }
        return sb.toString();
    }

    public static java.lang.String n(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        try {
            java.util.List<java.lang.String> list = map.get("sc");
            if (list == null || list.size() <= 0) {
                return "";
            }
            java.lang.String str = list.get(0);
            if (android.text.TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.contains("#")) {
                java.lang.String[] split = str.split("#");
                if (split.length <= 1) {
                    return "";
                }
                str = split[0];
            }
            return str;
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    public static boolean p(java.lang.String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0140 A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:32:0x00cb, B:35:0x00e3, B:37:0x00e6, B:39:0x00ea, B:41:0x00f0, B:44:0x00f9, B:47:0x0105, B:49:0x0108, B:53:0x010e, B:54:0x013a, B:56:0x0140, B:58:0x014a, B:59:0x015b, B:61:0x0183, B:63:0x01a4, B:64:0x01a7, B:51:0x0124, B:69:0x0128, B:71:0x012b, B:75:0x0131, B:73:0x0136), top: B:31:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0247  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.amap.api.col.s.da.b b(com.amap.api.col.s.dd ddVar, boolean z) throws java.io.IOException, com.amap.api.col.s.bh {
        java.lang.String str;
        boolean z2;
        java.net.URL url;
        java.net.URLConnection a2;
        javax.net.ssl.SSLContext sSLContext;
        java.lang.ref.SoftReference<javax.net.ssl.SSLContext> softReference;
        java.net.HttpURLConnection httpURLConnection;
        com.amap.api.col.s.dd.b t2;
        java.lang.String str2;
        java.net.InetAddress[] allByName;
        java.lang.String str3;
        com.amap.api.col.s.da.f fVar = this.f113s;
        com.amap.api.col.s.dd.b t3 = ddVar.t();
        com.amap.api.col.s.da.c cVar = fVar.c;
        cVar.a = com.amap.api.col.s.da.this.g;
        cVar.b = t3;
        fVar.a = android.os.SystemClock.elapsedRealtime();
        java.util.Map<java.lang.String, java.lang.String> f2 = ddVar.f();
        if (f2 == null) {
            f2 = new java.util.HashMap<>();
        }
        com.amap.api.col.s.da.e a3 = this.i.a(this.m);
        int i = com.amap.api.col.s.cx.a;
        java.lang.String str4 = this.l;
        android.net.Uri parse = android.net.Uri.parse(str4);
        java.lang.String host = parse.getHost();
        if (i == 1) {
            str = com.amap.api.col.s.cx.b;
        } else {
            if (i == 2) {
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.col.s.cx.c;
                str = hashMap != null ? hashMap.get(host) : "";
                z2 = false;
                if (!android.text.TextUtils.isEmpty(str)) {
                    ddVar.v();
                    str4 = parse.buildUpon().encodedAuthority(str).build().toString();
                    if (z2) {
                        f2.put("targetHost", host);
                        this.r = host;
                    }
                    if (z2 && this.a) {
                        a3.b(str);
                    }
                }
                this.l = str4;
                url = new java.net.URL(this.l);
                this.f113s.d(ddVar, url);
                if (p(url.getHost()) && ddVar.b_()) {
                    t2 = ddVar.t();
                    str2 = this.f113s.c.e;
                    if (!j(str2) && ((t2.b() && com.amap.api.col.s.bj.g) || (t2.c() && com.amap.api.col.s.bj.e(str2)))) {
                        try {
                            this.f113s.b = android.os.SystemClock.elapsedRealtime();
                            allByName = java.net.InetAddress.getAllByName(this.f113s.c.e);
                        } catch (java.lang.Throwable unused) {
                        }
                        if (allByName == null || allByName.length <= 0 || allByName[0] == null) {
                            str3 = "";
                        } else {
                            boolean z3 = com.amap.api.col.s.bj.a() && com.amap.api.col.s.bj.b();
                            "---canUseIpv6---".concat(java.lang.String.valueOf(z3));
                            if (z3) {
                                for (int i2 = 0; i2 < allByName.length; i2++) {
                                    if (allByName[i2] instanceof java.net.Inet6Address) {
                                        str3 = "[" + allByName[i2].getHostAddress() + "]";
                                        break;
                                    }
                                }
                                str3 = "";
                                if (android.text.TextUtils.isEmpty(str3)) {
                                    java.net.InetAddress inetAddress = allByName[0];
                                    str3 = inetAddress.getHostAddress();
                                    if (inetAddress instanceof java.net.Inet6Address) {
                                        str3 = "[" + str3 + "]";
                                    }
                                }
                            } else {
                                for (java.net.InetAddress inetAddress2 : allByName) {
                                    if (inetAddress2 instanceof java.net.Inet4Address) {
                                        str3 = inetAddress2.getHostAddress();
                                        break;
                                    }
                                }
                                str3 = "";
                                if (android.text.TextUtils.isEmpty(str3)) {
                                }
                            }
                        }
                        com.amap.api.col.s.da.f fVar2 = this.f113s;
                        "---onDNSEnd---ip=".concat(java.lang.String.valueOf(str3));
                        fVar2.c.c = str3.replace("[", "").replace("]", "");
                        fVar2.c.g = android.os.SystemClock.elapsedRealtime() - fVar2.b;
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            android.net.Uri parse2 = android.net.Uri.parse(this.l);
                            java.lang.String host2 = parse2.getHost();
                            android.net.Uri build = parse2.buildUpon().encodedAuthority(str3).build();
                            this.m = host2;
                            f2.put(com.alipay.sdk.m.l.c.f, host2);
                            if (this.a) {
                                a3.c(host2);
                            }
                            this.l = build.toString();
                        }
                    }
                }
                if (this.a) {
                    this.l = com.amap.api.col.s.bo.a(this.l);
                }
                java.util.Objects.toString(ddVar.t());
                java.net.URL url2 = new java.net.URL(this.l);
                com.amap.api.col.s.cx.a aVar = this.h;
                a2 = aVar == null ? aVar.a() : null;
                if (a2 == null) {
                    java.net.Proxy proxy = this.c;
                    a2 = proxy != null ? url2.openConnection(proxy) : url2.openConnection();
                }
                if (this.a) {
                    httpURLConnection = (java.net.HttpURLConnection) a2;
                } else {
                    try {
                        java.lang.ref.SoftReference<javax.net.ssl.SSLContext> softReference2 = t;
                        if (softReference2 == null || softReference2.get() == null) {
                            t = new java.lang.ref.SoftReference<>(javax.net.ssl.SSLContext.getInstance("TLS"));
                        }
                        softReference = t;
                    } catch (java.lang.Throwable unused2) {
                    }
                    if (softReference != null) {
                        sSLContext = softReference.get();
                        if (sSLContext == null) {
                            try {
                                sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
                            } catch (java.lang.Throwable th) {
                                com.amap.api.col.s.cg.a(th, "ht", "ne");
                            }
                        }
                        sSLContext.init(null, null, null);
                        this.b = sSLContext;
                        javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) a2;
                        if (com.amap.api.col.s.bj.f.a) {
                            httpsURLConnection.setSSLSocketFactory(this.b.getSocketFactory());
                        } else {
                            com.amap.api.col.s.db l = l();
                            if (l != null) {
                                httpsURLConnection.setSSLSocketFactory(l);
                                l.a();
                            } else {
                                httpsURLConnection.setSSLSocketFactory(this.b.getSocketFactory());
                            }
                        }
                        httpsURLConnection.setHostnameVerifier(a3);
                        httpURLConnection = httpsURLConnection;
                    }
                    sSLContext = null;
                    if (sSLContext == null) {
                    }
                    sSLContext.init(null, null, null);
                    this.b = sSLContext;
                    javax.net.ssl.HttpsURLConnection httpsURLConnection2 = (javax.net.ssl.HttpsURLConnection) a2;
                    if (com.amap.api.col.s.bj.f.a) {
                    }
                    httpsURLConnection2.setHostnameVerifier(a3);
                    httpURLConnection = httpsURLConnection2;
                }
                if (android.os.Build.VERSION.SDK != null) {
                    httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "close");
                }
                int u2 = (int) (ddVar.u() - (this.f113s.c.g / 1000));
                h(f2, httpURLConnection);
                httpURLConnection.setConnectTimeout(u2);
                httpURLConnection.setReadTimeout(u2);
                if (z) {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoInput(true);
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                }
                return new com.amap.api.col.s.da.b(httpURLConnection);
            }
            str = "";
        }
        z2 = true;
        if (!android.text.TextUtils.isEmpty(str)) {
        }
        this.l = str4;
        url = new java.net.URL(this.l);
        this.f113s.d(ddVar, url);
        if (p(url.getHost())) {
            t2 = ddVar.t();
            str2 = this.f113s.c.e;
            if (!j(str2) && ((t2.b() && com.amap.api.col.s.bj.g) || (t2.c() && com.amap.api.col.s.bj.e(str2)))) {
            }
        }
        if (this.a) {
        }
        java.util.Objects.toString(ddVar.t());
        java.net.URL url22 = new java.net.URL(this.l);
        com.amap.api.col.s.cx.a aVar2 = this.h;
        if (aVar2 == null) {
        }
        if (a2 == null) {
        }
        if (this.a) {
        }
        if (android.os.Build.VERSION.SDK != null) {
        }
        int u22 = (int) (ddVar.u() - (this.f113s.c.g / 1000));
        h(f2, httpURLConnection);
        httpURLConnection.setConnectTimeout(u22);
        httpURLConnection.setReadTimeout(u22);
        if (z) {
        }
        return new com.amap.api.col.s.da.b(httpURLConnection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x016e A[Catch: all -> 0x01bb, IOException -> 0x01c0, SocketTimeoutException -> 0x01ee, ConnectTimeoutException -> 0x01f3, TRY_ENTER, TryCatch #18 {SocketTimeoutException -> 0x01ee, ConnectTimeoutException -> 0x01f3, IOException -> 0x01c0, all -> 0x01bb, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:32:0x00a5, B:146:0x016e, B:147:0x01ba), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5 A[Catch: all -> 0x01bb, IOException -> 0x01c0, SocketTimeoutException -> 0x01ee, ConnectTimeoutException -> 0x01f3, TRY_ENTER, TRY_LEAVE, TryCatch #18 {SocketTimeoutException -> 0x01ee, ConnectTimeoutException -> 0x01f3, IOException -> 0x01c0, all -> 0x01bb, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0023, B:9:0x0029, B:10:0x0030, B:32:0x00a5, B:146:0x016e, B:147:0x01ba), top: B:2:0x0007 }] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.amap.api.col.s.de c(com.amap.api.col.s.da.b bVar) throws com.amap.api.col.s.bh, java.io.IOException {
        ?? r4;
        java.io.InputStream inputStream;
        java.io.PushbackInputStream pushbackInputStream;
        boolean z;
        java.io.FilterInputStream filterInputStream;
        char c2;
        java.lang.String str = "";
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        r3 = null;
        r3 = null;
        r3 = null;
        java.io.FilterInputStream filterInputStream2 = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        try {
            try {
                com.amap.api.col.s.cz.a();
                java.net.HttpURLConnection httpURLConnection = bVar.a;
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
                int responseCode = httpURLConnection.getResponseCode();
                if (headerFields != null) {
                    java.util.List<java.lang.String> list = headerFields.get("gsid");
                    if (list != null && list.size() > 0) {
                        str = list.get(0);
                    }
                    this.f113s.c.k = n(headerFields);
                    if (!android.text.TextUtils.isEmpty(this.j)) {
                        if (!this.n) {
                            z = k(headerFields, true);
                            c2 = 2;
                        } else if (headerFields.containsKey("sc")) {
                            z = k(headerFields, false);
                            c2 = 1;
                        } else {
                            com.amap.api.col.s.bj.b(this.j);
                            z = false;
                            c2 = 0;
                        }
                        try {
                            if (z) {
                                if (this.j.equals("loc")) {
                                    java.lang.String str2 = this.r;
                                    if (android.text.TextUtils.isEmpty(str2)) {
                                        str2 = httpURLConnection.getURL().getHost();
                                    }
                                    com.amap.api.col.s.bj.a(this.j, c2 == 2, str2, str2, this.m);
                                } else {
                                    com.amap.api.col.s.bj.b(this.j, c2 == 2);
                                }
                            } else if (c2 == 1) {
                                com.amap.api.col.s.cz.a(false, this.j);
                            }
                        } catch (java.lang.Throwable unused) {
                        }
                        if (responseCode == 200) {
                            com.amap.api.col.s.bh bhVar = new com.amap.api.col.s.bh("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.g, str, this.g);
                            bhVar.a(httpURLConnection.getResponseMessage());
                            bhVar.a(headerFields);
                            this.f113s.g(responseCode);
                            this.f113s.b(10);
                            bhVar.h();
                            throw bhVar;
                        }
                        java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                        try {
                            this.f113s.b = android.os.SystemClock.elapsedRealtime();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                pushbackInputStream = new java.io.PushbackInputStream(inputStream, 2);
                                try {
                                    byte[] bArr = new byte[2];
                                    pushbackInputStream.read(bArr);
                                    pushbackInputStream.unread(bArr);
                                    filterInputStream2 = (bArr[0] == 31 && bArr[1] == -117) ? new java.util.zip.GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                                    byte[] bArr2 = new byte[1024];
                                    while (true) {
                                        int read = filterInputStream2.read(bArr2);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr2, 0, read);
                                    }
                                    this.f113s.h();
                                    com.amap.api.col.s.cj.b();
                                    com.amap.api.col.s.de deVar = new com.amap.api.col.s.de();
                                    deVar.a = byteArrayOutputStream2.toByteArray();
                                    deVar.b = headerFields;
                                    deVar.c = this.g;
                                    deVar.d = str;
                                    deVar.e = z;
                                    com.amap.api.col.s.cz.a(httpURLConnection.getURL(), deVar);
                                    this.f113s.c(deVar.a.length);
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (java.lang.Throwable th) {
                                        com.amap.api.col.s.cg.a(th, "ht", "par");
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.lang.Throwable th2) {
                                            com.amap.api.col.s.cg.a(th2, "ht", "par");
                                        }
                                    }
                                    try {
                                        pushbackInputStream.close();
                                    } catch (java.lang.Throwable th3) {
                                        com.amap.api.col.s.cg.a(th3, "ht", "par");
                                    }
                                    try {
                                        filterInputStream2.close();
                                    } catch (java.lang.Throwable th4) {
                                        com.amap.api.col.s.cg.a(th4, "ht", "par");
                                    }
                                    return deVar;
                                } catch (java.net.SocketTimeoutException e2) {
                                    e = e2;
                                    throw e;
                                } catch (org.apache.http.conn.ConnectTimeoutException e3) {
                                    e = e3;
                                    throw e;
                                } catch (java.io.IOException e4) {
                                    e = e4;
                                    filterInputStream = filterInputStream2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    r4 = filterInputStream;
                                    try {
                                        if (!(e instanceof java.io.InterruptedIOException)) {
                                            throw e;
                                        }
                                        com.amap.api.col.s.bh bhVar2 = new com.amap.api.col.s.bh("IO 操作异常 - IOException", str, this.g);
                                        if (android.text.TextUtils.isEmpty(e.getMessage())) {
                                            throw bhVar2;
                                        }
                                        if (!e.getMessage().equals("thread interrupted")) {
                                            throw bhVar2;
                                        }
                                        bhVar2.j();
                                        throw bhVar2;
                                    } catch (java.lang.Throwable th5) {
                                        th = th5;
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (java.lang.Throwable th6) {
                                                com.amap.api.col.s.cg.a(th6, "ht", "par");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (java.lang.Throwable th7) {
                                                com.amap.api.col.s.cg.a(th7, "ht", "par");
                                            }
                                        }
                                        if (pushbackInputStream != null) {
                                            try {
                                                pushbackInputStream.close();
                                            } catch (java.lang.Throwable th8) {
                                                com.amap.api.col.s.cg.a(th8, "ht", "par");
                                            }
                                        }
                                        if (r4 != 0) {
                                            throw th;
                                        }
                                        try {
                                            r4.close();
                                            throw th;
                                        } catch (java.lang.Throwable th9) {
                                            com.amap.api.col.s.cg.a(th9, "ht", "par");
                                            throw th;
                                        }
                                    }
                                } catch (java.lang.Throwable th10) {
                                    th = th10;
                                    r4 = filterInputStream2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (pushbackInputStream != null) {
                                    }
                                    if (r4 != 0) {
                                    }
                                }
                            } catch (java.net.SocketTimeoutException e5) {
                                e = e5;
                            } catch (org.apache.http.conn.ConnectTimeoutException e6) {
                                e = e6;
                            } catch (java.io.IOException e7) {
                                e = e7;
                                filterInputStream = null;
                                pushbackInputStream = null;
                            } catch (java.lang.Throwable th11) {
                                th = th11;
                                r4 = 0;
                                pushbackInputStream = null;
                            }
                        } catch (java.net.SocketTimeoutException e8) {
                            e = e8;
                        } catch (org.apache.http.conn.ConnectTimeoutException e9) {
                            e = e9;
                        } catch (java.io.IOException e10) {
                            e = e10;
                            filterInputStream = null;
                            inputStream = null;
                            pushbackInputStream = null;
                        } catch (java.lang.Throwable th12) {
                            th = th12;
                            r4 = 0;
                            inputStream = null;
                            pushbackInputStream = null;
                        }
                    }
                }
                z = false;
                if (responseCode == 200) {
                }
            } catch (java.lang.Throwable th13) {
                th = th13;
                r4 = "";
            }
        } catch (java.net.SocketTimeoutException e11) {
            throw e11;
        } catch (org.apache.http.conn.ConnectTimeoutException e12) {
            throw e12;
        } catch (java.io.IOException e13) {
            e = e13;
            r4 = 0;
            inputStream = null;
            pushbackInputStream = null;
        } catch (java.lang.Throwable th14) {
            th = th14;
            r4 = 0;
            inputStream = null;
            pushbackInputStream = null;
        }
    }

    public final com.amap.api.col.s.de d(com.amap.api.col.s.dd ddVar) throws com.amap.api.col.s.bh {
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        q(ddVar);
                                        java.lang.String f2 = f(this.l, ddVar.e());
                                        this.l = f2;
                                        com.amap.api.col.s.de b2 = com.amap.api.col.s.cz.b(f2, this.j);
                                        if (b2 != null) {
                                            this.f113s.i();
                                            return b2;
                                        }
                                        com.amap.api.col.s.da.b b3 = b(ddVar, false);
                                        httpURLConnection = b3.a;
                                        this.f113s.b = android.os.SystemClock.elapsedRealtime();
                                        httpURLConnection.connect();
                                        this.f113s.a();
                                        com.amap.api.col.s.de c2 = c(b3);
                                        this.f113s.e(c2);
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (java.lang.Throwable th) {
                                            com.amap.api.col.s.cg.a(th, "ht", "mgr");
                                        }
                                        this.f113s.i();
                                        return c2;
                                    } catch (java.net.MalformedURLException unused) {
                                        this.f113s.b(8);
                                        throw new com.amap.api.col.s.bh("url异常 - MalformedURLException");
                                    }
                                } catch (java.io.IOException unused2) {
                                    this.f113s.b(7);
                                    throw new com.amap.api.col.s.bh("IO 操作异常 - IOException");
                                }
                            } catch (java.lang.Throwable th2) {
                                th2.printStackTrace();
                                this.f113s.b(9);
                                throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                            }
                        } catch (java.net.SocketTimeoutException e2) {
                            this.f113s.g(a(e2));
                            this.f113s.b(2);
                            throw new com.amap.api.col.s.bh("socket 连接超时 - SocketTimeoutException");
                        } catch (org.apache.http.conn.ConnectTimeoutException e3) {
                            e3.printStackTrace();
                            this.f113s.g(a(e3));
                            this.f113s.b(2);
                            throw new com.amap.api.col.s.bh("IO 操作异常 - IOException");
                        }
                    } catch (java.net.ConnectException e4) {
                        this.f113s.g(a(e4));
                        this.f113s.b(6);
                        throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                    } catch (java.net.UnknownHostException unused3) {
                        this.f113s.b(9);
                        throw new com.amap.api.col.s.bh("未知主机 - UnKnowHostException");
                    }
                } catch (com.amap.api.col.s.bh e5) {
                    if (!e5.i() && e5.g() != 10) {
                        this.f113s.b(e5.f());
                    }
                    throw e5;
                } catch (javax.net.ssl.SSLException e6) {
                    e6.printStackTrace();
                    this.f113s.g(a(e6));
                    this.f113s.b(4);
                    throw new com.amap.api.col.s.bh("IO 操作异常 - IOException");
                }
            } catch (java.io.InterruptedIOException unused4) {
                this.f113s.g(7101);
                this.f113s.b(7);
                throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
            } catch (java.net.SocketException e7) {
                this.f113s.g(a(e7));
                this.f113s.b(6);
                throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_SOCKET);
            }
        } catch (java.lang.Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (java.lang.Throwable th4) {
                    com.amap.api.col.s.cg.a(th4, "ht", "mgr");
                }
            }
            this.f113s.i();
            throw th3;
        }
    }

    public final void h(java.util.Map<java.lang.String, java.lang.String> map, java.net.HttpURLConnection httpURLConnection) {
        java.lang.String str;
        com.amap.api.col.s.da.c f2;
        if (map != null) {
            try {
                for (java.lang.String str2 : map.keySet()) {
                    httpURLConnection.addRequestProperty(str2, map.get(str2));
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cg.a(th, "ht", "adh");
                return;
            }
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.col.s.cx.d;
        if (hashMap != null) {
            for (java.lang.String str3 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str3, com.amap.api.col.s.cx.d.get(str3));
            }
        }
        if (!this.l.contains("/v3/iasdkauth") && !android.text.TextUtils.isEmpty(this.j) && com.amap.api.col.s.bj.a(this.j)) {
            this.n = true;
            httpURLConnection.addRequestProperty("lct", java.lang.String.valueOf(com.amap.api.col.s.bj.c(this.j)));
        }
        httpURLConnection.addRequestProperty("csid", this.g);
        if (j(this.f113s.c.e)) {
            com.amap.api.col.s.da.f fVar = this.f113s;
            if (android.text.TextUtils.isEmpty(fVar.c.c)) {
                str = "";
            } else {
                java.lang.String b2 = com.amap.api.col.s.bn.b(com.amap.api.col.s.ct.a(fVar.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                java.lang.String str4 = fVar.c.c;
                str = b2;
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                httpURLConnection.addRequestProperty("sip", str);
            }
            if (com.amap.api.col.s.bj.j && (f2 = com.amap.api.col.s.bj.f()) != null) {
                httpURLConnection.addRequestProperty("nls", f2.b());
                this.f113s.e = f2;
            }
            com.amap.api.col.s.da.a e2 = com.amap.api.col.s.bj.e();
            if (e2 != null) {
                httpURLConnection.addRequestProperty("nlf", e2.b());
                this.f113s.d = e2;
            }
        }
    }

    public final boolean j(java.lang.String str) {
        if (this.k) {
            return true;
        }
        return (!android.text.TextUtils.isEmpty(this.m) && (this.m.contains("rest") || this.m.contains("apilocate"))) || p(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, boolean z) {
        boolean z2;
        java.util.List<java.lang.String> list;
        try {
            java.util.List<java.lang.String> list2 = map.get("sc");
            if (list2 != null && list2.size() > 0) {
                java.lang.String str = list2.get(0);
                if (!android.text.TextUtils.isEmpty(str)) {
                    if (str.contains("#")) {
                        java.lang.String[] split = str.split("#");
                        if (split.length > 1 && "1".equals(split[1])) {
                        }
                    }
                    z2 = true;
                    if (z2) {
                        return false;
                    }
                    if (!z) {
                        return true;
                    }
                    if (!map.containsKey("lct") || (list = map.get("lct")) == null || list.size() <= 0) {
                        return false;
                    }
                    java.lang.String str2 = list.get(0);
                    if (android.text.TextUtils.isEmpty(str2)) {
                        return false;
                    }
                    return com.amap.api.col.s.bj.a(this.j, java.lang.Long.valueOf(str2).longValue());
                }
            }
            z2 = false;
            if (z2) {
            }
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public final com.amap.api.col.s.db l() {
        try {
            java.lang.ref.SoftReference<com.amap.api.col.s.db> softReference = u;
            if (softReference == null || softReference.get() == null) {
                u = new java.lang.ref.SoftReference<>(new com.amap.api.col.s.db(com.amap.api.col.s.bj.c, this.b));
            }
            com.amap.api.col.s.db dbVar = t != null ? u.get() : null;
            return dbVar == null ? new com.amap.api.col.s.db(com.amap.api.col.s.bj.c, this.b) : dbVar;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "ht", "gsf");
            return null;
        }
    }

    public final com.amap.api.col.s.de m(com.amap.api.col.s.dd ddVar) throws com.amap.api.col.s.bh {
        java.io.DataOutputStream dataOutputStream;
        java.lang.Throwable th;
        java.io.OutputStream outputStream;
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            try {
                q(ddVar);
                com.amap.api.col.s.de b2 = com.amap.api.col.s.cz.b(this.l, this.j);
                if (b2 != null) {
                    this.f113s.i();
                    return b2;
                }
                com.amap.api.col.s.da.b b3 = b(ddVar, true);
                java.net.HttpURLConnection httpURLConnection2 = b3.a;
                try {
                    this.f113s.b = android.os.SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.f113s.a();
                    byte[] g = ddVar.g();
                    if (g == null || g.length == 0) {
                        java.util.Map<java.lang.String, java.lang.String> e2 = ddVar.e();
                        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.col.s.cx.e;
                        if (hashMap != null) {
                            if (e2 != null) {
                                e2.putAll(hashMap);
                            } else {
                                e2 = hashMap;
                            }
                        }
                        java.lang.String g2 = g(e2);
                        if (!android.text.TextUtils.isEmpty(g2)) {
                            g = com.amap.api.col.s.bu.a(g2);
                        }
                    }
                    if (g != null && g.length > 0) {
                        try {
                            this.f113s.b = android.os.SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection2.getOutputStream();
                            try {
                                dataOutputStream = new java.io.DataOutputStream(outputStream);
                                try {
                                    dataOutputStream.write(g);
                                    dataOutputStream.close();
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.f113s.f();
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.f113s.f();
                                    throw th;
                                }
                            } catch (java.lang.Throwable th3) {
                                dataOutputStream = null;
                                th = th3;
                            }
                        } catch (java.lang.Throwable th4) {
                            dataOutputStream = null;
                            th = th4;
                            outputStream = null;
                        }
                    }
                    com.amap.api.col.s.de c2 = c(b3);
                    this.f113s.e(c2);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (java.lang.Throwable th5) {
                        com.amap.api.col.s.cg.a(th5, "ht", "mPt");
                    }
                    this.f113s.i();
                    return c2;
                } catch (com.amap.api.col.s.bh e3) {
                    e = e3;
                    if (!e.i() && e.g() != 10) {
                        this.f113s.b(e.g());
                    }
                    com.amap.api.col.s.cg.a(e, "ht", "mPt");
                    throw e;
                } catch (java.io.InterruptedIOException unused) {
                    this.f113s.g(7101);
                    this.f113s.b(7);
                    throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                } catch (java.net.ConnectException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.f113s.g(a(e));
                    this.f113s.b(6);
                    throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                } catch (java.net.MalformedURLException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.f113s.b(8);
                    throw new com.amap.api.col.s.bh("url异常 - MalformedURLException");
                } catch (java.net.SocketException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.f113s.g(a(e));
                    this.f113s.b(6);
                    throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_SOCKET);
                } catch (java.net.SocketTimeoutException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.f113s.g(a(e));
                    this.f113s.b(2);
                    throw new com.amap.api.col.s.bh("socket 连接超时 - SocketTimeoutException");
                } catch (java.net.UnknownHostException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.f113s.b(5);
                    throw new com.amap.api.col.s.bh("未知主机 - UnKnowHostException");
                } catch (javax.net.ssl.SSLException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.f113s.g(a(e));
                    this.f113s.b(4);
                    throw new com.amap.api.col.s.bh("IO 操作异常 - IOException");
                } catch (org.apache.http.conn.ConnectTimeoutException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.f113s.g(a(e));
                    this.f113s.b(2);
                    throw new com.amap.api.col.s.bh("IO 操作异常 - IOException");
                } catch (java.io.IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    this.f113s.b(7);
                    throw new com.amap.api.col.s.bh("IO 操作异常 - IOException");
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    com.amap.api.col.s.cg.a(th, "ht", "mPt");
                    this.f113s.b(9);
                    throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (java.lang.Throwable th7) {
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (java.lang.Throwable th8) {
                        com.amap.api.col.s.cg.a(th8, "ht", "mPt");
                    }
                }
                this.f113s.i();
                throw th7;
            }
        } catch (com.amap.api.col.s.bh e12) {
            e = e12;
        } catch (java.io.InterruptedIOException unused2) {
        } catch (java.net.ConnectException e13) {
            e = e13;
        } catch (java.net.MalformedURLException e14) {
            e = e14;
        } catch (java.net.SocketException e15) {
            e = e15;
        } catch (java.net.SocketTimeoutException e16) {
            e = e16;
        } catch (java.net.UnknownHostException e17) {
            e = e17;
        } catch (javax.net.ssl.SSLException e18) {
            e = e18;
        } catch (org.apache.http.conn.ConnectTimeoutException e19) {
            e = e19;
        } catch (java.io.IOException e20) {
            e = e20;
        } catch (java.lang.Throwable th9) {
            th = th9;
        }
    }

    public final void q(com.amap.api.col.s.dd ddVar) throws com.amap.api.col.s.bh {
        this.i = new com.amap.api.col.s.da.d((byte) 0);
        this.o = ddVar.x();
        this.c = ddVar.n();
        this.h = ddVar.s();
        this.k = ddVar.p();
        this.j = ddVar.y();
        this.a = com.amap.api.col.s.bo.a().b(ddVar.r());
        java.lang.String l = ddVar.t().b() ? ddVar.l() : ddVar.k();
        this.l = l;
        this.l = com.amap.api.col.s.cz.a(l, this.j);
        this.m = ddVar.i();
        if ("loc".equals(this.j)) {
            java.lang.String k = ddVar.k();
            java.lang.String l2 = ddVar.l();
            if (!android.text.TextUtils.isEmpty(k)) {
                try {
                    this.q = new java.net.URL(k).getHost();
                } catch (java.lang.Exception unused) {
                }
            }
            if (android.text.TextUtils.isEmpty(l2)) {
                return;
            }
            try {
                if (android.text.TextUtils.isEmpty(this.m)) {
                    this.p = new java.net.URL(l2).getHost();
                } else {
                    this.p = this.m;
                }
            } catch (java.lang.Exception unused2) {
            }
        }
    }
}
