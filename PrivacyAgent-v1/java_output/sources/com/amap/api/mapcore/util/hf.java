package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hf {
    private static java.lang.ref.SoftReference<javax.net.ssl.SSLContext> k;
    private static java.lang.ref.SoftReference<com.amap.api.mapcore.util.hg> t;
    private boolean a;
    private javax.net.ssl.SSLContext b;
    private java.net.Proxy c;
    private java.lang.String g;
    private com.amap.api.mapcore.util.hb.a h;
    private com.amap.api.mapcore.util.hf.d i;
    private boolean l;
    private java.lang.String m;
    private java.lang.String n;
    private volatile boolean d = false;
    private long e = -1;
    private long f = 0;
    private java.lang.String j = "";
    private boolean o = false;
    private boolean p = false;
    private java.lang.String q = "";
    private java.lang.String r = "";

    /* renamed from: s, reason: collision with root package name */
    private java.lang.String f133s = "";
    private com.amap.api.mapcore.util.hf.f u = new com.amap.api.mapcore.util.hf.f();

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

        public a(com.amap.api.mapcore.util.hf.c cVar) {
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
        public final com.amap.api.mapcore.util.hf.a clone() {
            try {
                return (com.amap.api.mapcore.util.hf.a) super.clone();
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
                java.lang.String b = com.amap.api.mapcore.util.fa.b(com.amap.api.mapcore.util.gx.a(((str4 + this.c + "#") + this.g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                com.amap.api.mapcore.util.hf.b();
                return b;
            } catch (java.lang.Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(java.lang.Object obj) {
            return this.a - ((com.amap.api.mapcore.util.hf.a) obj).a;
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
        public com.amap.api.mapcore.util.hi.b b = com.amap.api.mapcore.util.hi.b.FIRST_NONDEGRADE;
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
        public final com.amap.api.mapcore.util.hf.c clone() {
            try {
                return (com.amap.api.mapcore.util.hf.c) super.clone();
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
            java.lang.String b = com.amap.api.mapcore.util.fa.b(com.amap.api.mapcore.util.gx.a(((((str2 + this.b.a() + "#") + this.h + "#") + this.j + "#") + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            com.amap.api.mapcore.util.hf.b();
            return b;
        }

        public final java.lang.String toString() {
            return "RequestInfo{csid='" + this.a + "', degradeType=" + this.b + ", serverIp='" + this.c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    public static class d {
        private java.util.Vector<com.amap.api.mapcore.util.hf.e> a;
        private volatile com.amap.api.mapcore.util.hf.e b;

        private d() {
            this.a = new java.util.Vector<>();
            this.b = new com.amap.api.mapcore.util.hf.e((byte) 0);
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        public final com.amap.api.mapcore.util.hf.e a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                com.amap.api.mapcore.util.hf.e eVar = this.a.get(i);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            com.amap.api.mapcore.util.hf.e eVar2 = new com.amap.api.mapcore.util.hf.e((byte) 0);
            eVar2.b(str);
            this.a.add(eVar2);
            return eVar2;
        }
    }

    public static class e implements javax.net.ssl.HostnameVerifier {
        private java.lang.String a;
        private java.lang.String b;

        private e() {
        }

        public /* synthetic */ e(byte b) {
            this();
        }

        public final java.lang.String a() {
            return this.b;
        }

        public final void a(java.lang.String str) {
            java.lang.String[] split;
            if (android.text.TextUtils.isEmpty(this.a) || !str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) || (split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) == null || split.length <= 0) {
                this.a = str;
            } else {
                this.a = split[0];
            }
        }

        public final void b(java.lang.String str) {
            this.b = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            javax.net.ssl.HostnameVerifier defaultHostnameVerifier = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier();
            return !android.text.TextUtils.isEmpty(this.a) ? this.a.equals(str) : !android.text.TextUtils.isEmpty(this.b) ? defaultHostnameVerifier.verify(this.b, sSLSession) : defaultHostnameVerifier.verify(str, sSLSession);
        }
    }

    public class f {
        long a = 0;
        long b = 0;
        com.amap.api.mapcore.util.hf.c c = new com.amap.api.mapcore.util.hf.c();
        com.amap.api.mapcore.util.hf.a d;
        com.amap.api.mapcore.util.hf.c e;
        java.lang.String f;
        java.net.URL g;

        public f() {
        }

        public final void a() {
            this.c.h = android.os.SystemClock.elapsedRealtime() - this.b;
        }

        public final void a(int i) {
            "----errorcode-----".concat(java.lang.String.valueOf(i));
            com.amap.api.mapcore.util.hf.b();
            try {
                this.c.f = android.os.SystemClock.elapsedRealtime() - this.a;
                com.amap.api.mapcore.util.hf.c cVar = this.c;
                cVar.m = i;
                if (cVar.b.e()) {
                    com.amap.api.mapcore.util.ew.a(false, this.c.e);
                }
                boolean a = com.amap.api.mapcore.util.hf.this.a(this.c.e);
                if (a) {
                    if (com.amap.api.mapcore.util.hf.this.p && !android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.hf.this.n) && this.c.b.b()) {
                        com.amap.api.mapcore.util.ew.c();
                    }
                    if (this.c.b.c()) {
                        com.amap.api.mapcore.util.ew.a(this.c.b.c(), this.c.e);
                    }
                    com.amap.api.mapcore.util.ew.c(this.e);
                    com.amap.api.mapcore.util.ew.a(false, this.d);
                    com.amap.api.mapcore.util.ew.b(this.c);
                }
                com.amap.api.mapcore.util.ew.a(this.g.toString(), this.c.b.c(), true, a);
                this.c.toString();
                com.amap.api.mapcore.util.hf.b();
            } catch (java.lang.Throwable unused) {
            }
        }

        public final void a(long j) {
            this.c.l = new java.text.DecimalFormat("0.00").format(j / 1024.0f);
        }

        public final void a(com.amap.api.mapcore.util.hi hiVar, java.net.URL url) {
            this.g = url;
            this.c.d = url.getPath();
            this.c.e = url.getHost();
            if (!android.text.TextUtils.isEmpty(com.amap.api.mapcore.util.hf.this.n) && hiVar.getDegradeType().b()) {
                com.amap.api.mapcore.util.hf.c cVar = this.c;
                cVar.c = cVar.e.replace("[", "").replace("]", "");
                this.c.e = com.amap.api.mapcore.util.hf.this.n;
            }
            if (hiVar.getDegradeType().b()) {
                hiVar.setNon_degrade_final_Host(this.c.e);
            }
            if (hiVar.getDegradeType().d()) {
                this.f = hiVar.getNon_degrade_final_Host();
            }
        }

        public final void a(com.amap.api.mapcore.util.hj hjVar) {
            com.amap.api.mapcore.util.hf.c clone;
            try {
                this.c.f = android.os.SystemClock.elapsedRealtime() - this.a;
                if (hjVar != null) {
                    hjVar.f = this.c.b.c();
                }
                if (this.c.b.b()) {
                    com.amap.api.mapcore.util.hf.c cVar = this.c;
                    if (cVar.f > 10000) {
                        com.amap.api.mapcore.util.ew.a(false, cVar.e);
                    }
                }
                if (this.c.b.d()) {
                    com.amap.api.mapcore.util.ew.a(false, this.f);
                }
                boolean a = com.amap.api.mapcore.util.hf.this.a(this.c.e);
                if (a) {
                    com.amap.api.mapcore.util.ew.c(this.c);
                    com.amap.api.mapcore.util.ew.a(true, this.d);
                    com.amap.api.mapcore.util.hf.c cVar2 = this.c;
                    if (cVar2.f > com.amap.api.mapcore.util.ew.e && (clone = cVar2.clone()) != null) {
                        clone.m = 1;
                        com.amap.api.mapcore.util.ew.b(clone);
                        clone.toString();
                        com.amap.api.mapcore.util.hf.b();
                    }
                }
                com.amap.api.mapcore.util.ew.a(this.g.toString(), this.c.b.c(), false, a);
                this.c.toString();
                com.amap.api.mapcore.util.hf.b();
            } catch (java.lang.Throwable unused) {
            }
        }

        public final void b() {
            this.c.i = android.os.SystemClock.elapsedRealtime() - this.b;
        }

        public final void b(int i) {
            this.c.n = i;
        }

        public final void c() {
            this.c.j = android.os.SystemClock.elapsedRealtime() - this.b;
        }

        public final void d() {
            com.amap.api.mapcore.util.hf.c clone = this.c.clone();
            if (this.c.f > com.amap.api.mapcore.util.ew.e) {
                clone.m = 1;
            }
            com.amap.api.mapcore.util.ew.a(clone);
        }
    }

    public hf() {
        com.amap.api.mapcore.util.ew.d();
        try {
            this.g = java.util.UUID.randomUUID().toString().replaceAll(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase();
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.ga.a(th, "ht", "ic");
        }
    }

    private static int a(java.lang.Exception exc) {
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

    /* JADX WARN: Removed duplicated region for block: B:101:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0142 A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:32:0x00cd, B:35:0x00e5, B:37:0x00e8, B:39:0x00ec, B:41:0x00f2, B:44:0x00fb, B:47:0x0107, B:49:0x010a, B:53:0x0110, B:54:0x013c, B:56:0x0142, B:58:0x014c, B:59:0x015d, B:61:0x0185, B:63:0x01a6, B:64:0x01a9, B:51:0x0126, B:69:0x012a, B:71:0x012d, B:75:0x0133, B:73:0x0138), top: B:31:0x00cd }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.amap.api.mapcore.util.hf.b a(com.amap.api.mapcore.util.hi hiVar, boolean z, boolean z2) throws java.io.IOException, com.amap.api.mapcore.util.eu {
        java.lang.String str;
        boolean z3;
        java.net.URL url;
        java.net.URLConnection a2;
        javax.net.ssl.SSLContext sSLContext;
        java.lang.ref.SoftReference<javax.net.ssl.SSLContext> softReference;
        java.net.HttpURLConnection httpURLConnection;
        com.amap.api.mapcore.util.hi.b degradeType;
        java.lang.String str2;
        java.net.InetAddress[] allByName;
        java.lang.String str3;
        com.amap.api.mapcore.util.hf.f fVar = this.u;
        com.amap.api.mapcore.util.hi.b degradeType2 = hiVar.getDegradeType();
        com.amap.api.mapcore.util.hf.c cVar = fVar.c;
        cVar.a = com.amap.api.mapcore.util.hf.this.g;
        cVar.b = degradeType2;
        fVar.a = android.os.SystemClock.elapsedRealtime();
        java.util.Map<java.lang.String, java.lang.String> requestHead = hiVar.getRequestHead();
        if (requestHead == null) {
            requestHead = new java.util.HashMap<>();
        }
        com.amap.api.mapcore.util.hf.e a3 = this.i.a(this.n);
        int i = com.amap.api.mapcore.util.hb.a;
        java.lang.String str4 = this.m;
        android.net.Uri parse = android.net.Uri.parse(str4);
        java.lang.String host = parse.getHost();
        if (i == 1) {
            str = com.amap.api.mapcore.util.hb.b;
        } else {
            if (i == 2) {
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.mapcore.util.hb.c;
                str = hashMap != null ? hashMap.get(host) : "";
                z3 = false;
                if (!android.text.TextUtils.isEmpty(str)) {
                    hiVar.setHostToIP(false);
                    str4 = parse.buildUpon().encodedAuthority(str).build().toString();
                    if (z3) {
                        requestHead.put("targetHost", host);
                        this.f133s = host;
                    }
                    if (z3 && this.a) {
                        a3.a(str);
                    }
                }
                this.m = str4;
                url = new java.net.URL(this.m);
                this.u.a(hiVar, url);
                if (b(url.getHost()) && hiVar.isHostToIP()) {
                    degradeType = hiVar.getDegradeType();
                    str2 = this.u.c.e;
                    if (!a(str2) && ((degradeType.b() && com.amap.api.mapcore.util.ew.g) || (degradeType.c() && com.amap.api.mapcore.util.ew.e(str2)))) {
                        try {
                            this.u.b = android.os.SystemClock.elapsedRealtime();
                            allByName = java.net.InetAddress.getAllByName(this.u.c.e);
                        } catch (java.lang.Throwable unused) {
                        }
                        if (allByName == null || allByName.length <= 0 || allByName[0] == null) {
                            str3 = "";
                        } else {
                            boolean z4 = com.amap.api.mapcore.util.ew.a() && com.amap.api.mapcore.util.ew.b();
                            "---canUseIpv6---".concat(java.lang.String.valueOf(z4));
                            if (z4) {
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
                        com.amap.api.mapcore.util.hf.f fVar2 = this.u;
                        "---onDNSEnd---ip=".concat(java.lang.String.valueOf(str3));
                        fVar2.c.c = str3.replace("[", "").replace("]", "");
                        fVar2.c.g = android.os.SystemClock.elapsedRealtime() - fVar2.b;
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            android.net.Uri parse2 = android.net.Uri.parse(this.m);
                            java.lang.String host2 = parse2.getHost();
                            android.net.Uri build = parse2.buildUpon().encodedAuthority(str3).build();
                            this.n = host2;
                            requestHead.put(com.alipay.sdk.m.l.c.f, host2);
                            if (this.a) {
                                a3.b(host2);
                            }
                            this.m = build.toString();
                        }
                    }
                }
                if (this.a) {
                    this.m = com.amap.api.mapcore.util.fb.a(this.m);
                }
                java.util.Objects.toString(hiVar.getDegradeType());
                java.net.URL url2 = new java.net.URL(this.m);
                com.amap.api.mapcore.util.hb.a aVar = this.h;
                a2 = aVar == null ? aVar.a() : null;
                if (a2 == null) {
                    java.net.Proxy proxy = this.c;
                    a2 = proxy != null ? url2.openConnection(proxy) : url2.openConnection();
                }
                if (this.a) {
                    httpURLConnection = (java.net.HttpURLConnection) a2;
                } else {
                    try {
                        java.lang.ref.SoftReference<javax.net.ssl.SSLContext> softReference2 = k;
                        if (softReference2 == null || softReference2.get() == null) {
                            k = new java.lang.ref.SoftReference<>(javax.net.ssl.SSLContext.getInstance("TLS"));
                        }
                        softReference = k;
                    } catch (java.lang.Throwable unused2) {
                    }
                    if (softReference != null) {
                        sSLContext = softReference.get();
                        if (sSLContext == null) {
                            try {
                                sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
                            } catch (java.lang.Throwable th) {
                                com.amap.api.mapcore.util.ga.a(th, "ht", "ne");
                            }
                        }
                        sSLContext.init(null, null, null);
                        this.b = sSLContext;
                        javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) a2;
                        if (com.amap.api.mapcore.util.ew.e.a) {
                            httpsURLConnection.setSSLSocketFactory(this.b.getSocketFactory());
                        } else {
                            com.amap.api.mapcore.util.hg c2 = c();
                            if (c2 != null) {
                                httpsURLConnection.setSSLSocketFactory(c2);
                                c2.a();
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
                    if (com.amap.api.mapcore.util.ew.e.a) {
                    }
                    httpsURLConnection2.setHostnameVerifier(a3);
                    httpURLConnection = httpsURLConnection2;
                }
                if (android.os.Build.VERSION.SDK != null) {
                    httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "close");
                }
                int real_max_timeout = (int) (hiVar.getReal_max_timeout() - (this.u.c.g / 1000));
                a(requestHead, httpURLConnection, z2);
                httpURLConnection.setConnectTimeout(real_max_timeout);
                httpURLConnection.setReadTimeout(real_max_timeout);
                if (z) {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoInput(true);
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                }
                return new com.amap.api.mapcore.util.hf.b(httpURLConnection);
            }
            str = "";
        }
        z3 = true;
        if (!android.text.TextUtils.isEmpty(str)) {
        }
        this.m = str4;
        url = new java.net.URL(this.m);
        this.u.a(hiVar, url);
        if (b(url.getHost())) {
            degradeType = hiVar.getDegradeType();
            str2 = this.u.c.e;
            if (!a(str2) && ((degradeType.b() && com.amap.api.mapcore.util.ew.g) || (degradeType.c() && com.amap.api.mapcore.util.ew.e(str2)))) {
            }
        }
        if (this.a) {
        }
        java.util.Objects.toString(hiVar.getDegradeType());
        java.net.URL url22 = new java.net.URL(this.m);
        com.amap.api.mapcore.util.hb.a aVar2 = this.h;
        if (aVar2 == null) {
        }
        if (a2 == null) {
        }
        if (this.a) {
        }
        if (android.os.Build.VERSION.SDK != null) {
        }
        int real_max_timeout2 = (int) (hiVar.getReal_max_timeout() - (this.u.c.g / 1000));
        a(requestHead, httpURLConnection, z2);
        httpURLConnection.setConnectTimeout(real_max_timeout2);
        httpURLConnection.setReadTimeout(real_max_timeout2);
        if (z) {
        }
        return new com.amap.api.mapcore.util.hf.b(httpURLConnection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x022c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0221 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0216 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x020b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x017b A[Catch: all -> 0x01c8, IOException -> 0x01ce, SocketTimeoutException -> 0x01fc, ConnectTimeoutException -> 0x0201, TRY_ENTER, TryCatch #20 {SocketTimeoutException -> 0x01fc, ConnectTimeoutException -> 0x0201, IOException -> 0x01ce, all -> 0x01c8, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x0034, B:32:0x00a9, B:148:0x017b, B:149:0x01c7), top: B:2:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9 A[Catch: all -> 0x01c8, IOException -> 0x01ce, SocketTimeoutException -> 0x01fc, ConnectTimeoutException -> 0x0201, TRY_ENTER, TRY_LEAVE, TryCatch #20 {SocketTimeoutException -> 0x01fc, ConnectTimeoutException -> 0x0201, IOException -> 0x01ce, all -> 0x01c8, blocks: (B:3:0x0009, B:5:0x001d, B:7:0x0027, B:9:0x002d, B:10:0x0034, B:32:0x00a9, B:148:0x017b, B:149:0x01c7), top: B:2:0x0009 }] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.amap.api.mapcore.util.hj a(com.amap.api.mapcore.util.hf.b bVar, boolean z) throws com.amap.api.mapcore.util.eu, java.io.IOException {
        java.lang.Throwable th;
        java.io.FilterInputStream filterInputStream;
        java.io.InputStream inputStream;
        java.io.PushbackInputStream pushbackInputStream;
        ?? r6;
        boolean z2;
        java.io.FilterInputStream filterInputStream2;
        java.io.FilterInputStream filterInputStream3;
        char c2;
        java.lang.String str = "";
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        r5 = null;
        r5 = null;
        r5 = null;
        java.io.FilterInputStream filterInputStream4 = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        try {
            try {
                com.amap.api.mapcore.util.he.a();
                java.net.HttpURLConnection httpURLConnection = bVar.a;
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
                int responseCode = httpURLConnection.getResponseCode();
                if (headerFields != null) {
                    java.util.List<java.lang.String> list = headerFields.get("gsid");
                    if (list != null && list.size() > 0) {
                        str = list.get(0);
                    }
                    this.u.c.k = b(headerFields);
                    if (!android.text.TextUtils.isEmpty(this.j)) {
                        if (!this.o) {
                            z2 = a(headerFields, true);
                            c2 = 2;
                        } else if (headerFields.containsKey("sc")) {
                            z2 = a(headerFields, false);
                            c2 = 1;
                        } else {
                            com.amap.api.mapcore.util.ew.b(this.j);
                            z2 = false;
                            c2 = 0;
                        }
                        try {
                            if (z2) {
                                if (this.j.equals("loc")) {
                                    java.lang.String str2 = this.f133s;
                                    if (android.text.TextUtils.isEmpty(str2)) {
                                        str2 = httpURLConnection.getURL().getHost();
                                    }
                                    com.amap.api.mapcore.util.ew.a(this.j, c2 == 2, str2, str2, this.n);
                                } else {
                                    com.amap.api.mapcore.util.ew.b(this.j, c2 == 2);
                                }
                            } else if (c2 == 1) {
                                com.amap.api.mapcore.util.he.a(false, this.j);
                            }
                        } catch (java.lang.Throwable unused) {
                        }
                        if (responseCode == 200) {
                            com.amap.api.mapcore.util.eu euVar = new com.amap.api.mapcore.util.eu("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.g, str, this.g);
                            euVar.a(httpURLConnection.getResponseMessage());
                            euVar.a(headerFields);
                            this.u.b(responseCode);
                            this.u.a(10);
                            euVar.h();
                            throw euVar;
                        }
                        java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                        try {
                            this.u.b = android.os.SystemClock.elapsedRealtime();
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                pushbackInputStream = new java.io.PushbackInputStream(inputStream, 2);
                                try {
                                    byte[] bArr = new byte[2];
                                    pushbackInputStream.read(bArr);
                                    pushbackInputStream.unread(bArr);
                                    filterInputStream4 = (bArr[0] == 31 && bArr[1] == -117 && !z) ? new java.util.zip.GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                                    byte[] bArr2 = new byte[1024];
                                    while (true) {
                                        int read = filterInputStream4.read(bArr2);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr2, 0, read);
                                    }
                                    this.u.c();
                                    com.amap.api.mapcore.util.gd.c();
                                    com.amap.api.mapcore.util.hj hjVar = new com.amap.api.mapcore.util.hj();
                                    hjVar.a = byteArrayOutputStream2.toByteArray();
                                    hjVar.b = headerFields;
                                    hjVar.c = this.g;
                                    hjVar.d = str;
                                    hjVar.e = z2;
                                    com.amap.api.mapcore.util.he.a(httpURLConnection.getURL(), hjVar);
                                    this.u.a(hjVar.a.length);
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (java.lang.Throwable th2) {
                                        com.amap.api.mapcore.util.ga.a(th2, "ht", "par");
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.lang.Throwable th3) {
                                            com.amap.api.mapcore.util.ga.a(th3, "ht", "par");
                                        }
                                    }
                                    try {
                                        pushbackInputStream.close();
                                    } catch (java.lang.Throwable th4) {
                                        com.amap.api.mapcore.util.ga.a(th4, "ht", "par");
                                    }
                                    try {
                                        filterInputStream4.close();
                                    } catch (java.lang.Throwable th5) {
                                        com.amap.api.mapcore.util.ga.a(th5, "ht", "par");
                                    }
                                    return hjVar;
                                } catch (java.net.SocketTimeoutException e2) {
                                    e = e2;
                                    throw e;
                                } catch (org.apache.http.conn.ConnectTimeoutException e3) {
                                    e = e3;
                                    throw e;
                                } catch (java.io.IOException e4) {
                                    e = e4;
                                    filterInputStream3 = filterInputStream4;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    r6 = filterInputStream3;
                                    try {
                                        if (!(e instanceof java.io.InterruptedIOException)) {
                                            throw e;
                                        }
                                        com.amap.api.mapcore.util.eu euVar2 = new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException", str, this.g);
                                        if (android.text.TextUtils.isEmpty(e.getMessage())) {
                                            throw euVar2;
                                        }
                                        if (!e.getMessage().equals("thread interrupted")) {
                                            throw euVar2;
                                        }
                                        euVar2.j();
                                        throw euVar2;
                                    } catch (java.lang.Throwable th6) {
                                        th = th6;
                                        th = th;
                                        filterInputStream = r6;
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (java.lang.Throwable th7) {
                                                com.amap.api.mapcore.util.ga.a(th7, "ht", "par");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (java.lang.Throwable th8) {
                                                com.amap.api.mapcore.util.ga.a(th8, "ht", "par");
                                            }
                                        }
                                        if (pushbackInputStream != null) {
                                            try {
                                                pushbackInputStream.close();
                                            } catch (java.lang.Throwable th9) {
                                                com.amap.api.mapcore.util.ga.a(th9, "ht", "par");
                                            }
                                        }
                                        if (filterInputStream == null) {
                                            throw th;
                                        }
                                        try {
                                            filterInputStream.close();
                                            throw th;
                                        } catch (java.lang.Throwable th10) {
                                            com.amap.api.mapcore.util.ga.a(th10, "ht", "par");
                                            throw th;
                                        }
                                    }
                                } catch (java.lang.Throwable th11) {
                                    th = th11;
                                    filterInputStream2 = filterInputStream4;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    filterInputStream = filterInputStream2;
                                    if (byteArrayOutputStream != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (pushbackInputStream != null) {
                                    }
                                    if (filterInputStream == null) {
                                    }
                                }
                            } catch (java.net.SocketTimeoutException e5) {
                                e = e5;
                            } catch (org.apache.http.conn.ConnectTimeoutException e6) {
                                e = e6;
                            } catch (java.io.IOException e7) {
                                e = e7;
                                filterInputStream3 = null;
                                pushbackInputStream = null;
                            } catch (java.lang.Throwable th12) {
                                th = th12;
                                filterInputStream2 = null;
                                pushbackInputStream = null;
                            }
                        } catch (java.net.SocketTimeoutException e8) {
                            e = e8;
                        } catch (org.apache.http.conn.ConnectTimeoutException e9) {
                            e = e9;
                        } catch (java.io.IOException e10) {
                            e = e10;
                            filterInputStream3 = null;
                            inputStream = null;
                            pushbackInputStream = null;
                        } catch (java.lang.Throwable th13) {
                            th = th13;
                            filterInputStream2 = null;
                            inputStream = null;
                            pushbackInputStream = null;
                        }
                    }
                }
                z2 = false;
                if (responseCode == 200) {
                }
            } catch (java.lang.Throwable th14) {
                th = th14;
                r6 = "";
                th = th;
                filterInputStream = r6;
                if (byteArrayOutputStream != null) {
                }
                if (inputStream != null) {
                }
                if (pushbackInputStream != null) {
                }
                if (filterInputStream == null) {
                }
            }
        } catch (java.net.SocketTimeoutException e11) {
            throw e11;
        } catch (org.apache.http.conn.ConnectTimeoutException e12) {
            throw e12;
        } catch (java.io.IOException e13) {
            e = e13;
            r6 = 0;
            inputStream = null;
            pushbackInputStream = null;
        } catch (java.lang.Throwable th15) {
            th = th15;
            filterInputStream = null;
            inputStream = null;
            pushbackInputStream = null;
        }
    }

    private static java.lang.String a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        if (android.text.TextUtils.isEmpty(str)) {
            return str;
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.mapcore.util.hb.e;
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
        java.lang.String a2 = a(map);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(str);
        if (indexOf < 0) {
            stringBuffer.append("?");
        } else if (!str.endsWith("?") && !str.endsWith("&")) {
            stringBuffer.append("&");
        }
        if (a2 != null) {
            stringBuffer.append(a2);
        }
        return stringBuffer.toString();
    }

    private static java.lang.String a(java.net.HttpURLConnection httpURLConnection) {
        java.util.List<java.lang.String> list;
        if (httpURLConnection == null) {
            return "";
        }
        try {
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
            if (headerFields != null && (list = headerFields.get("gsid")) != null && list.size() > 0) {
                return list.get(0);
            }
        } catch (java.lang.Throwable unused) {
        }
        return "";
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map) {
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

    private void a(java.util.Map<java.lang.String, java.lang.String> map, java.net.HttpURLConnection httpURLConnection, boolean z) {
        java.lang.String str;
        com.amap.api.mapcore.util.hf.c f2;
        if (map != null) {
            try {
                for (java.lang.String str2 : map.keySet()) {
                    httpURLConnection.addRequestProperty(str2, map.get(str2));
                }
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.ga.a(th, "ht", "adh");
                return;
            }
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.mapcore.util.hb.d;
        if (hashMap != null) {
            for (java.lang.String str3 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str3, com.amap.api.mapcore.util.hb.d.get(str3));
            }
        }
        if (z && !this.m.contains("/v3/iasdkauth") && !android.text.TextUtils.isEmpty(this.j) && com.amap.api.mapcore.util.ew.a(this.j)) {
            this.o = true;
            httpURLConnection.addRequestProperty("lct", java.lang.String.valueOf(com.amap.api.mapcore.util.ew.c(this.j)));
        }
        httpURLConnection.addRequestProperty("csid", this.g);
        if (a(this.u.c.e)) {
            com.amap.api.mapcore.util.hf.f fVar = this.u;
            if (android.text.TextUtils.isEmpty(fVar.c.c)) {
                str = "";
            } else {
                java.lang.String b2 = com.amap.api.mapcore.util.fa.b(com.amap.api.mapcore.util.gx.a(fVar.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                java.lang.String str4 = fVar.c.c;
                str = b2;
            }
            if (!android.text.TextUtils.isEmpty(str)) {
                httpURLConnection.addRequestProperty("sip", str);
            }
            if (com.amap.api.mapcore.util.ew.j && (f2 = com.amap.api.mapcore.util.ew.f()) != null) {
                httpURLConnection.addRequestProperty("nls", f2.b());
                this.u.e = f2;
            }
            com.amap.api.mapcore.util.hf.a e2 = com.amap.api.mapcore.util.ew.e();
            if (e2 != null) {
                httpURLConnection.addRequestProperty("nlf", e2.b());
                this.u.d = e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(java.lang.String str) {
        if (this.l) {
            return true;
        }
        return (!android.text.TextUtils.isEmpty(this.n) && (this.n.contains("rest") || this.n.contains("apilocate"))) || b(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, boolean z) {
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
                    return com.amap.api.mapcore.util.ew.a(this.j, java.lang.Long.valueOf(str2).longValue());
                }
            }
            z2 = false;
            if (z2) {
            }
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private static java.lang.String b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
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

    public static void b() {
    }

    private static boolean b(java.lang.String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    private com.amap.api.mapcore.util.hg c() {
        try {
            java.lang.ref.SoftReference<com.amap.api.mapcore.util.hg> softReference = t;
            if (softReference == null || softReference.get() == null) {
                t = new java.lang.ref.SoftReference<>(new com.amap.api.mapcore.util.hg(com.amap.api.mapcore.util.ew.c, this.b));
            }
            com.amap.api.mapcore.util.hg hgVar = k != null ? t.get() : null;
            return hgVar == null ? new com.amap.api.mapcore.util.hg(com.amap.api.mapcore.util.ew.c, this.b) : hgVar;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "ht", "gsf");
            return null;
        }
    }

    private void d(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        this.i = new com.amap.api.mapcore.util.hf.d((byte) 0);
        this.p = hiVar.isIPV6Request();
        this.c = hiVar.getProxy();
        this.h = hiVar.getUrlConnectionImpl();
        this.l = hiVar.isBinary();
        this.j = hiVar.parseSdkNameFromRequest();
        this.a = com.amap.api.mapcore.util.fb.a().a(hiVar.isHttps());
        java.lang.String b2 = hiVar.getDegradeType().b() ? hiVar.b() : hiVar.a();
        this.m = b2;
        this.m = com.amap.api.mapcore.util.he.a(b2, this.j);
        this.n = hiVar.getIPDNSName();
        if ("loc".equals(this.j)) {
            java.lang.String a2 = hiVar.a();
            java.lang.String b3 = hiVar.b();
            if (!android.text.TextUtils.isEmpty(a2)) {
                try {
                    this.r = new java.net.URL(a2).getHost();
                } catch (java.lang.Exception unused) {
                }
            }
            if (android.text.TextUtils.isEmpty(b3)) {
                return;
            }
            try {
                if (android.text.TextUtils.isEmpty(this.n)) {
                    this.q = new java.net.URL(b3).getHost();
                } else {
                    this.q = this.n;
                }
            } catch (java.lang.Exception unused2) {
            }
        }
    }

    public final java.util.Map<java.lang.String, java.lang.String> a(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        java.lang.String headerFieldKey;
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            try {
                d(hiVar);
                this.m = a(this.m, hiVar.getParams());
                java.net.HttpURLConnection httpURLConnection2 = a(hiVar, false, false).a;
                try {
                    this.u.b = android.os.SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.u.a();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode >= 400) {
                        this.u.b(responseCode);
                        this.u.a(10);
                        com.amap.api.mapcore.util.eu euVar = new com.amap.api.mapcore.util.eu("http读取header失败");
                        euVar.a(responseCode);
                        throw euVar;
                    }
                    java.util.HashMap hashMap = new java.util.HashMap();
                    for (int i = 0; i < 50 && (headerFieldKey = httpURLConnection2.getHeaderFieldKey(i)) != null; i++) {
                        hashMap.put(headerFieldKey.toLowerCase(), httpURLConnection2.getHeaderField(headerFieldKey));
                    }
                    this.u.a((com.amap.api.mapcore.util.hj) null);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (java.lang.Throwable th) {
                        com.amap.api.mapcore.util.ga.a(th, "hth", "mgr");
                    }
                    this.u.d();
                    return hashMap;
                } catch (com.amap.api.mapcore.util.eu e2) {
                    e = e2;
                    this.u.a(e.g());
                    throw e;
                } catch (java.io.InterruptedIOException unused) {
                    this.u.b(7101);
                    this.u.a(7);
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                } catch (java.net.ConnectException e3) {
                    e = e3;
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                } catch (java.net.MalformedURLException unused2) {
                    this.u.a(8);
                    throw new com.amap.api.mapcore.util.eu("url异常 - MalformedURLException");
                } catch (java.net.SocketException e4) {
                    e = e4;
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_SOCKET);
                } catch (java.net.SocketTimeoutException e5) {
                    e = e5;
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new com.amap.api.mapcore.util.eu("socket 连接超时 - SocketTimeoutException");
                } catch (java.net.UnknownHostException unused3) {
                    this.u.a(9);
                    throw new com.amap.api.mapcore.util.eu("未知主机 - UnKnowHostException");
                } catch (javax.net.ssl.SSLException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(4);
                    throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                } catch (org.apache.http.conn.ConnectTimeoutException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                } catch (java.io.IOException unused4) {
                    this.u.a(7);
                    throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    this.u.a(9);
                    th.printStackTrace();
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (java.lang.Throwable th3) {
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (java.lang.Throwable th4) {
                        com.amap.api.mapcore.util.ga.a(th4, "hth", "mgr");
                    }
                }
                this.u.d();
                throw th3;
            }
        } catch (com.amap.api.mapcore.util.eu e8) {
            e = e8;
        } catch (java.net.ConnectException e9) {
            e = e9;
        } catch (java.net.SocketTimeoutException e10) {
            e = e10;
        } catch (org.apache.http.conn.ConnectTimeoutException e11) {
            e = e11;
        } catch (java.io.InterruptedIOException unused5) {
        } catch (java.net.MalformedURLException unused6) {
        } catch (java.net.SocketException e12) {
            e = e12;
        } catch (java.net.UnknownHostException unused7) {
        } catch (javax.net.ssl.SSLException e13) {
            e = e13;
        } catch (java.io.IOException unused8) {
        } catch (java.lang.Throwable th5) {
            th = th5;
        }
    }

    public final void a() {
        this.d = true;
    }

    public final void a(long j) {
        this.f = j;
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x063e: IF  (r12 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:568:0x0649, block:B:567:0x063e */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0649: IF  (r7 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:569:0x0654, block:B:568:0x0649 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x062d: IF  (r8 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:567:0x063e, block:B:566:0x062d */
    /* JADX WARN: Removed duplicated region for block: B:103:0x044b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0440 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x042f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x061c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0611 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0600 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x054a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x053f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x052e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x050e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0503 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x05d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x05cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x05bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0591 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0586 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0575 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0148 A[Catch: all -> 0x00cc, eu -> 0x00cf, IOException -> 0x00d2, InterruptedIOException -> 0x00d5, SocketTimeoutException -> 0x00d8, SocketException -> 0x00db, UnknownHostException -> 0x00de, MalformedURLException -> 0x00e1, ConnectTimeoutException -> 0x00e4, SSLException -> 0x00e7, ConnectException -> 0x00ea, TRY_ENTER, TRY_LEAVE, TryCatch #53 {eu -> 0x00cf, SocketTimeoutException -> 0x00d8, InterruptedIOException -> 0x00d5, ConnectException -> 0x00ea, MalformedURLException -> 0x00e1, SocketException -> 0x00db, UnknownHostException -> 0x00de, SSLException -> 0x00e7, ConnectTimeoutException -> 0x00e4, IOException -> 0x00d2, all -> 0x00cc, blocks: (B:468:0x00bc, B:27:0x0148), top: B:467:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0409 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0390 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0385 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0374 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0192 A[Catch: all -> 0x02b4, eu -> 0x02be, IOException -> 0x02c8, InterruptedIOException -> 0x02d2, SocketTimeoutException -> 0x02dc, SocketException -> 0x02e6, UnknownHostException -> 0x02f0, MalformedURLException -> 0x02fa, ConnectTimeoutException -> 0x0304, SSLException -> 0x030e, ConnectException -> 0x0318, TRY_ENTER, TRY_LEAVE, TryCatch #55 {eu -> 0x02be, SocketTimeoutException -> 0x02dc, InterruptedIOException -> 0x02d2, ConnectException -> 0x0318, MalformedURLException -> 0x02fa, SocketException -> 0x02e6, UnknownHostException -> 0x02f0, SSLException -> 0x030e, ConnectTimeoutException -> 0x0304, IOException -> 0x02c8, all -> 0x02b4, blocks: (B:18:0x0130, B:328:0x0192), top: B:17:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:442:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:465:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x03ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x03c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x048f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0484 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0473 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.amap.api.mapcore.util.hi hiVar, com.amap.api.mapcore.util.hd.a aVar) {
        java.io.InputStream inputStream;
        java.net.HttpURLConnection httpURLConnection;
        java.io.OutputStream outputStream;
        java.io.DataOutputStream dataOutputStream;
        java.lang.Throwable th;
        java.io.InputStream inputStream2;
        java.net.HttpURLConnection httpURLConnection2;
        java.lang.Throwable th2;
        java.io.InputStream inputStream3;
        java.lang.Throwable th3;
        java.io.InputStream inputStream4;
        org.apache.http.conn.ConnectTimeoutException connectTimeoutException;
        java.io.InputStream inputStream5;
        javax.net.ssl.SSLException sSLException;
        java.io.InputStream inputStream6;
        java.lang.Throwable th4;
        java.io.InputStream inputStream7;
        java.net.SocketTimeoutException socketTimeoutException;
        java.io.InputStream inputStream8;
        java.net.SocketException socketException;
        java.io.InputStream inputStream9;
        java.lang.Throwable th5;
        java.io.InputStream inputStream10;
        java.net.ConnectException connectException;
        java.io.InputStream inputStream11;
        com.amap.api.mapcore.util.eu euVar;
        java.io.InputStream inputStream12;
        com.amap.api.mapcore.util.hi hiVar2;
        boolean z;
        int responseCode;
        java.io.DataOutputStream dataOutputStream2;
        int read;
        try {
            if (aVar == null) {
                return;
            }
            try {
                d(hiVar);
                this.m = a(this.m, hiVar.getParams());
                byte[] entityBytes = hiVar.getEntityBytes();
                try {
                    try {
                        if (entityBytes != null) {
                            try {
                                if (entityBytes.length > 0) {
                                    hiVar2 = hiVar;
                                    z = true;
                                    httpURLConnection2 = a(hiVar2, z, false).a;
                                    httpURLConnection2.setRequestProperty("RANGE", "bytes=" + this.f + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                                    this.u.b = android.os.SystemClock.elapsedRealtime();
                                    httpURLConnection2.connect();
                                    this.u.a();
                                    if (z) {
                                        dataOutputStream = null;
                                    } else {
                                        try {
                                            this.u.b = android.os.SystemClock.elapsedRealtime();
                                            java.io.OutputStream outputStream2 = httpURLConnection2.getOutputStream();
                                            dataOutputStream = new java.io.DataOutputStream(outputStream2);
                                            try {
                                                dataOutputStream.write(entityBytes);
                                                dataOutputStream.close();
                                                outputStream2.close();
                                                this.u.b();
                                            } catch (com.amap.api.mapcore.util.eu e2) {
                                                euVar = e2;
                                                inputStream12 = null;
                                                this.u.a(euVar.g());
                                                aVar.onException(euVar);
                                                if (inputStream12 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (java.net.SocketTimeoutException e3) {
                                                socketTimeoutException = e3;
                                                inputStream8 = null;
                                                this.u.b(a(socketTimeoutException));
                                                this.u.a(2);
                                                aVar.onException(socketTimeoutException);
                                                if (inputStream8 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (java.io.InterruptedIOException e4) {
                                                th3 = e4;
                                                inputStream4 = null;
                                                this.u.b(7101);
                                                this.u.a(7);
                                                aVar.onException(th3);
                                                if (inputStream4 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (java.net.ConnectException e5) {
                                                connectException = e5;
                                                inputStream11 = null;
                                                this.u.b(a(connectException));
                                                this.u.a(6);
                                                aVar.onException(connectException);
                                                if (inputStream11 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (java.net.MalformedURLException e6) {
                                                th5 = e6;
                                                inputStream10 = null;
                                                this.u.a(8);
                                                aVar.onException(th5);
                                                if (inputStream10 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (java.net.SocketException e7) {
                                                socketException = e7;
                                                inputStream9 = null;
                                                this.u.b(a(socketException));
                                                this.u.a(6);
                                                aVar.onException(socketException);
                                                if (inputStream9 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (java.net.UnknownHostException e8) {
                                                th4 = e8;
                                                inputStream7 = null;
                                                this.u.a(5);
                                                aVar.onException(th4);
                                                if (inputStream7 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (javax.net.ssl.SSLException e9) {
                                                sSLException = e9;
                                                inputStream6 = null;
                                                sSLException.printStackTrace();
                                                this.u.b(a(sSLException));
                                                this.u.a(4);
                                                aVar.onException(sSLException);
                                                if (inputStream6 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (org.apache.http.conn.ConnectTimeoutException e10) {
                                                connectTimeoutException = e10;
                                                inputStream5 = null;
                                                connectTimeoutException.printStackTrace();
                                                this.u.b(a(connectTimeoutException));
                                                this.u.a(2);
                                                aVar.onException(connectTimeoutException);
                                                if (inputStream5 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (java.io.IOException e11) {
                                                th2 = e11;
                                                inputStream3 = null;
                                                this.u.a(7);
                                                aVar.onException(th2);
                                                if (inputStream3 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            } catch (java.lang.Throwable th6) {
                                                th = th6;
                                                inputStream2 = null;
                                                this.u.a(9);
                                                aVar.onException(th);
                                                if (inputStream2 != null) {
                                                }
                                                if (httpURLConnection2 != null) {
                                                }
                                                if (dataOutputStream != null) {
                                                }
                                                this.u.d();
                                                return;
                                            }
                                        } catch (com.amap.api.mapcore.util.eu e12) {
                                            euVar = e12;
                                            dataOutputStream = null;
                                            inputStream12 = null;
                                            this.u.a(euVar.g());
                                            aVar.onException(euVar);
                                            if (inputStream12 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (java.net.MalformedURLException e13) {
                                            th5 = e13;
                                            dataOutputStream = null;
                                            inputStream10 = null;
                                            this.u.a(8);
                                            aVar.onException(th5);
                                            if (inputStream10 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (java.net.SocketException e14) {
                                            socketException = e14;
                                            dataOutputStream = null;
                                            inputStream9 = null;
                                            this.u.b(a(socketException));
                                            this.u.a(6);
                                            aVar.onException(socketException);
                                            if (inputStream9 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (java.net.SocketTimeoutException e15) {
                                            socketTimeoutException = e15;
                                            dataOutputStream = null;
                                            inputStream8 = null;
                                            this.u.b(a(socketTimeoutException));
                                            this.u.a(2);
                                            aVar.onException(socketTimeoutException);
                                            if (inputStream8 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (java.io.InterruptedIOException e16) {
                                            th3 = e16;
                                            dataOutputStream = null;
                                            inputStream4 = null;
                                            this.u.b(7101);
                                            this.u.a(7);
                                            aVar.onException(th3);
                                            if (inputStream4 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (java.net.ConnectException e17) {
                                            connectException = e17;
                                            dataOutputStream = null;
                                            inputStream11 = null;
                                            this.u.b(a(connectException));
                                            this.u.a(6);
                                            aVar.onException(connectException);
                                            if (inputStream11 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (java.net.UnknownHostException e18) {
                                            th4 = e18;
                                            dataOutputStream = null;
                                            inputStream7 = null;
                                            this.u.a(5);
                                            aVar.onException(th4);
                                            if (inputStream7 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (javax.net.ssl.SSLException e19) {
                                            sSLException = e19;
                                            dataOutputStream = null;
                                            inputStream6 = null;
                                            sSLException.printStackTrace();
                                            this.u.b(a(sSLException));
                                            this.u.a(4);
                                            aVar.onException(sSLException);
                                            if (inputStream6 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (org.apache.http.conn.ConnectTimeoutException e20) {
                                            connectTimeoutException = e20;
                                            dataOutputStream = null;
                                            inputStream5 = null;
                                            connectTimeoutException.printStackTrace();
                                            this.u.b(a(connectTimeoutException));
                                            this.u.a(2);
                                            aVar.onException(connectTimeoutException);
                                            if (inputStream5 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (java.io.IOException e21) {
                                            th2 = e21;
                                            dataOutputStream = null;
                                            inputStream3 = null;
                                            this.u.a(7);
                                            aVar.onException(th2);
                                            if (inputStream3 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        } catch (java.lang.Throwable th7) {
                                            th = th7;
                                            dataOutputStream = null;
                                            inputStream2 = null;
                                            this.u.a(9);
                                            aVar.onException(th);
                                            if (inputStream2 != null) {
                                            }
                                            if (httpURLConnection2 != null) {
                                            }
                                            if (dataOutputStream != null) {
                                            }
                                            this.u.d();
                                            return;
                                        }
                                    }
                                    java.lang.String a2 = a(httpURLConnection2);
                                    responseCode = httpURLConnection2.getResponseCode();
                                    if (!(responseCode == 200) || !(responseCode != 206)) {
                                        this.u.b(responseCode);
                                        this.u.a(10);
                                        aVar.onException(new com.amap.api.mapcore.util.eu("网络异常原因：" + httpURLConnection2.getResponseMessage() + " 网络异常状态码：" + responseCode, a2, this.g));
                                        try {
                                            httpURLConnection2.disconnect();
                                        } catch (java.lang.Throwable th8) {
                                            com.amap.api.mapcore.util.ga.a(th8, "ht", "mdr");
                                        }
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (java.lang.Throwable th9) {
                                                com.amap.api.mapcore.util.ga.a(th9, "ht", "mdr");
                                            }
                                        }
                                        this.u.d();
                                        return;
                                    }
                                    this.u.b = android.os.SystemClock.elapsedRealtime();
                                    java.io.InputStream inputStream13 = httpURLConnection2.getInputStream();
                                    try {
                                        byte[] bArr = new byte[1024];
                                        int i = 0;
                                        while (!java.lang.Thread.interrupted() && !this.d && (read = inputStream13.read(bArr, 0, 1024)) > 0) {
                                            long j = this.e;
                                            if (j != -1) {
                                                dataOutputStream2 = dataOutputStream;
                                                try {
                                                    if (this.f >= j) {
                                                        break;
                                                    }
                                                } catch (com.amap.api.mapcore.util.eu e22) {
                                                    e = e22;
                                                    inputStream12 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    euVar = e;
                                                    this.u.a(euVar.g());
                                                    aVar.onException(euVar);
                                                    if (inputStream12 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (java.net.ConnectException e23) {
                                                    e = e23;
                                                    inputStream11 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    connectException = e;
                                                    this.u.b(a(connectException));
                                                    this.u.a(6);
                                                    aVar.onException(connectException);
                                                    if (inputStream11 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (java.net.MalformedURLException e24) {
                                                    e = e24;
                                                    inputStream10 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    th5 = e;
                                                    this.u.a(8);
                                                    aVar.onException(th5);
                                                    if (inputStream10 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (java.net.SocketException e25) {
                                                    e = e25;
                                                    inputStream9 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    socketException = e;
                                                    this.u.b(a(socketException));
                                                    this.u.a(6);
                                                    aVar.onException(socketException);
                                                    if (inputStream9 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (java.net.SocketTimeoutException e26) {
                                                    e = e26;
                                                    inputStream8 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    socketTimeoutException = e;
                                                    this.u.b(a(socketTimeoutException));
                                                    this.u.a(2);
                                                    aVar.onException(socketTimeoutException);
                                                    if (inputStream8 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (java.net.UnknownHostException e27) {
                                                    e = e27;
                                                    inputStream7 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    th4 = e;
                                                    this.u.a(5);
                                                    aVar.onException(th4);
                                                    if (inputStream7 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (javax.net.ssl.SSLException e28) {
                                                    e = e28;
                                                    inputStream6 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    sSLException = e;
                                                    sSLException.printStackTrace();
                                                    this.u.b(a(sSLException));
                                                    this.u.a(4);
                                                    aVar.onException(sSLException);
                                                    if (inputStream6 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (org.apache.http.conn.ConnectTimeoutException e29) {
                                                    e = e29;
                                                    inputStream5 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    connectTimeoutException = e;
                                                    connectTimeoutException.printStackTrace();
                                                    this.u.b(a(connectTimeoutException));
                                                    this.u.a(2);
                                                    aVar.onException(connectTimeoutException);
                                                    if (inputStream5 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (java.io.InterruptedIOException e30) {
                                                    e = e30;
                                                    inputStream4 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    th3 = e;
                                                    this.u.b(7101);
                                                    this.u.a(7);
                                                    aVar.onException(th3);
                                                    if (inputStream4 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (java.io.IOException e31) {
                                                    e = e31;
                                                    inputStream3 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    th2 = e;
                                                    this.u.a(7);
                                                    aVar.onException(th2);
                                                    if (inputStream3 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                } catch (java.lang.Throwable th10) {
                                                    th = th10;
                                                    inputStream2 = inputStream13;
                                                    dataOutputStream = dataOutputStream2;
                                                    th = th;
                                                    this.u.a(9);
                                                    aVar.onException(th);
                                                    if (inputStream2 != null) {
                                                    }
                                                    if (httpURLConnection2 != null) {
                                                    }
                                                    if (dataOutputStream != null) {
                                                    }
                                                    this.u.d();
                                                    return;
                                                }
                                            } else {
                                                dataOutputStream2 = dataOutputStream;
                                            }
                                            if (read == 1024) {
                                                aVar.onDownload(bArr, this.f);
                                            } else {
                                                byte[] bArr2 = new byte[read];
                                                java.lang.System.arraycopy(bArr, 0, bArr2, 0, read);
                                                aVar.onDownload(bArr2, this.f);
                                            }
                                            this.f += read;
                                            i += read;
                                            dataOutputStream = dataOutputStream2;
                                        }
                                        dataOutputStream2 = dataOutputStream;
                                        this.u.a(i);
                                        this.u.c();
                                        if (this.d) {
                                            aVar.onStop();
                                        } else {
                                            aVar.onFinish();
                                        }
                                        this.u.a((com.amap.api.mapcore.util.hj) null);
                                        if (inputStream13 != null) {
                                            try {
                                                inputStream13.close();
                                            } catch (java.io.IOException e32) {
                                                com.amap.api.mapcore.util.ga.a(e32, "ht", "mdr");
                                            } catch (java.lang.Throwable th11) {
                                                com.amap.api.mapcore.util.ga.a(th11, "ht", "mdr");
                                            }
                                        }
                                        try {
                                            httpURLConnection2.disconnect();
                                        } catch (java.lang.Throwable th12) {
                                            com.amap.api.mapcore.util.ga.a(th12, "ht", "mdr");
                                        }
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (java.lang.Throwable th13) {
                                                com.amap.api.mapcore.util.ga.a(th13, "ht", "mdr");
                                            }
                                        }
                                        this.u.d();
                                        return;
                                    } catch (com.amap.api.mapcore.util.eu e33) {
                                        e = e33;
                                        inputStream12 = inputStream13;
                                    } catch (java.io.InterruptedIOException e34) {
                                        e = e34;
                                        inputStream4 = inputStream13;
                                    } catch (java.net.ConnectException e35) {
                                        e = e35;
                                        inputStream11 = inputStream13;
                                    } catch (java.net.MalformedURLException e36) {
                                        e = e36;
                                        inputStream10 = inputStream13;
                                    } catch (java.net.SocketException e37) {
                                        e = e37;
                                        inputStream9 = inputStream13;
                                    } catch (java.net.SocketTimeoutException e38) {
                                        e = e38;
                                        inputStream8 = inputStream13;
                                    } catch (java.net.UnknownHostException e39) {
                                        e = e39;
                                        inputStream7 = inputStream13;
                                    } catch (javax.net.ssl.SSLException e40) {
                                        e = e40;
                                        inputStream6 = inputStream13;
                                    } catch (org.apache.http.conn.ConnectTimeoutException e41) {
                                        e = e41;
                                        inputStream5 = inputStream13;
                                    } catch (java.io.IOException e42) {
                                        e = e42;
                                        inputStream3 = inputStream13;
                                    } catch (java.lang.Throwable th14) {
                                        th = th14;
                                        inputStream2 = inputStream13;
                                    }
                                }
                            } catch (com.amap.api.mapcore.util.eu e43) {
                                euVar = e43;
                                dataOutputStream = null;
                                inputStream12 = null;
                                httpURLConnection2 = null;
                                this.u.a(euVar.g());
                                aVar.onException(euVar);
                                if (inputStream12 != null) {
                                    try {
                                        inputStream12.close();
                                    } catch (java.io.IOException e44) {
                                        com.amap.api.mapcore.util.ga.a(e44, "ht", "mdr");
                                    } catch (java.lang.Throwable th15) {
                                        com.amap.api.mapcore.util.ga.a(th15, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th16) {
                                        com.amap.api.mapcore.util.ga.a(th16, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th17) {
                                        com.amap.api.mapcore.util.ga.a(th17, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (java.io.InterruptedIOException e45) {
                                th3 = e45;
                                dataOutputStream = null;
                                inputStream4 = null;
                                httpURLConnection2 = null;
                                this.u.b(7101);
                                this.u.a(7);
                                aVar.onException(th3);
                                if (inputStream4 != null) {
                                    try {
                                        inputStream4.close();
                                    } catch (java.io.IOException e46) {
                                        com.amap.api.mapcore.util.ga.a(e46, "ht", "mdr");
                                    } catch (java.lang.Throwable th18) {
                                        com.amap.api.mapcore.util.ga.a(th18, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th19) {
                                        com.amap.api.mapcore.util.ga.a(th19, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th20) {
                                        com.amap.api.mapcore.util.ga.a(th20, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (java.net.ConnectException e47) {
                                connectException = e47;
                                dataOutputStream = null;
                                inputStream11 = null;
                                httpURLConnection2 = null;
                                this.u.b(a(connectException));
                                this.u.a(6);
                                aVar.onException(connectException);
                                if (inputStream11 != null) {
                                    try {
                                        inputStream11.close();
                                    } catch (java.io.IOException e48) {
                                        com.amap.api.mapcore.util.ga.a(e48, "ht", "mdr");
                                    } catch (java.lang.Throwable th21) {
                                        com.amap.api.mapcore.util.ga.a(th21, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th22) {
                                        com.amap.api.mapcore.util.ga.a(th22, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th23) {
                                        com.amap.api.mapcore.util.ga.a(th23, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (java.net.MalformedURLException e49) {
                                th5 = e49;
                                dataOutputStream = null;
                                inputStream10 = null;
                                httpURLConnection2 = null;
                                this.u.a(8);
                                aVar.onException(th5);
                                if (inputStream10 != null) {
                                    try {
                                        inputStream10.close();
                                    } catch (java.io.IOException e50) {
                                        com.amap.api.mapcore.util.ga.a(e50, "ht", "mdr");
                                    } catch (java.lang.Throwable th24) {
                                        com.amap.api.mapcore.util.ga.a(th24, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th25) {
                                        com.amap.api.mapcore.util.ga.a(th25, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th26) {
                                        com.amap.api.mapcore.util.ga.a(th26, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (java.net.SocketException e51) {
                                socketException = e51;
                                dataOutputStream = null;
                                inputStream9 = null;
                                httpURLConnection2 = null;
                                this.u.b(a(socketException));
                                this.u.a(6);
                                aVar.onException(socketException);
                                if (inputStream9 != null) {
                                    try {
                                        inputStream9.close();
                                    } catch (java.io.IOException e52) {
                                        com.amap.api.mapcore.util.ga.a(e52, "ht", "mdr");
                                    } catch (java.lang.Throwable th27) {
                                        com.amap.api.mapcore.util.ga.a(th27, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th28) {
                                        com.amap.api.mapcore.util.ga.a(th28, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th29) {
                                        com.amap.api.mapcore.util.ga.a(th29, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (java.net.SocketTimeoutException e53) {
                                socketTimeoutException = e53;
                                dataOutputStream = null;
                                inputStream8 = null;
                                httpURLConnection2 = null;
                                this.u.b(a(socketTimeoutException));
                                this.u.a(2);
                                aVar.onException(socketTimeoutException);
                                if (inputStream8 != null) {
                                    try {
                                        inputStream8.close();
                                    } catch (java.io.IOException e54) {
                                        com.amap.api.mapcore.util.ga.a(e54, "ht", "mdr");
                                    } catch (java.lang.Throwable th30) {
                                        com.amap.api.mapcore.util.ga.a(th30, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th31) {
                                        com.amap.api.mapcore.util.ga.a(th31, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th32) {
                                        com.amap.api.mapcore.util.ga.a(th32, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (java.net.UnknownHostException e55) {
                                th4 = e55;
                                dataOutputStream = null;
                                inputStream7 = null;
                                httpURLConnection2 = null;
                                this.u.a(5);
                                aVar.onException(th4);
                                if (inputStream7 != null) {
                                    try {
                                        inputStream7.close();
                                    } catch (java.io.IOException e56) {
                                        com.amap.api.mapcore.util.ga.a(e56, "ht", "mdr");
                                    } catch (java.lang.Throwable th33) {
                                        com.amap.api.mapcore.util.ga.a(th33, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th34) {
                                        com.amap.api.mapcore.util.ga.a(th34, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th35) {
                                        com.amap.api.mapcore.util.ga.a(th35, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (javax.net.ssl.SSLException e57) {
                                sSLException = e57;
                                dataOutputStream = null;
                                inputStream6 = null;
                                httpURLConnection2 = null;
                                sSLException.printStackTrace();
                                this.u.b(a(sSLException));
                                this.u.a(4);
                                aVar.onException(sSLException);
                                if (inputStream6 != null) {
                                    try {
                                        inputStream6.close();
                                    } catch (java.io.IOException e58) {
                                        com.amap.api.mapcore.util.ga.a(e58, "ht", "mdr");
                                    } catch (java.lang.Throwable th36) {
                                        com.amap.api.mapcore.util.ga.a(th36, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th37) {
                                        com.amap.api.mapcore.util.ga.a(th37, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th38) {
                                        com.amap.api.mapcore.util.ga.a(th38, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (org.apache.http.conn.ConnectTimeoutException e59) {
                                connectTimeoutException = e59;
                                dataOutputStream = null;
                                inputStream5 = null;
                                httpURLConnection2 = null;
                                connectTimeoutException.printStackTrace();
                                this.u.b(a(connectTimeoutException));
                                this.u.a(2);
                                aVar.onException(connectTimeoutException);
                                if (inputStream5 != null) {
                                    try {
                                        inputStream5.close();
                                    } catch (java.io.IOException e60) {
                                        com.amap.api.mapcore.util.ga.a(e60, "ht", "mdr");
                                    } catch (java.lang.Throwable th39) {
                                        com.amap.api.mapcore.util.ga.a(th39, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th40) {
                                        com.amap.api.mapcore.util.ga.a(th40, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th41) {
                                        com.amap.api.mapcore.util.ga.a(th41, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (java.io.IOException e61) {
                                th2 = e61;
                                dataOutputStream = null;
                                inputStream3 = null;
                                httpURLConnection2 = null;
                                this.u.a(7);
                                aVar.onException(th2);
                                if (inputStream3 != null) {
                                    try {
                                        inputStream3.close();
                                    } catch (java.io.IOException e62) {
                                        com.amap.api.mapcore.util.ga.a(e62, "ht", "mdr");
                                    } catch (java.lang.Throwable th42) {
                                        com.amap.api.mapcore.util.ga.a(th42, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th43) {
                                        com.amap.api.mapcore.util.ga.a(th43, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th44) {
                                        com.amap.api.mapcore.util.ga.a(th44, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            } catch (java.lang.Throwable th45) {
                                th = th45;
                                dataOutputStream = null;
                                inputStream2 = null;
                                httpURLConnection2 = null;
                                this.u.a(9);
                                aVar.onException(th);
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (java.io.IOException e63) {
                                        com.amap.api.mapcore.util.ga.a(e63, "ht", "mdr");
                                    } catch (java.lang.Throwable th46) {
                                        com.amap.api.mapcore.util.ga.a(th46, "ht", "mdr");
                                    }
                                }
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (java.lang.Throwable th47) {
                                        com.amap.api.mapcore.util.ga.a(th47, "ht", "mdr");
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (java.lang.Throwable th48) {
                                        com.amap.api.mapcore.util.ga.a(th48, "ht", "mdr");
                                    }
                                }
                                this.u.d();
                                return;
                            }
                        }
                        java.lang.String a22 = a(httpURLConnection2);
                        responseCode = httpURLConnection2.getResponseCode();
                        if (!((responseCode == 200) & (responseCode != 206))) {
                        }
                    } catch (com.amap.api.mapcore.util.eu e64) {
                        euVar = e64;
                        inputStream12 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (java.net.SocketTimeoutException e65) {
                        socketTimeoutException = e65;
                        inputStream8 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (java.io.InterruptedIOException e66) {
                        th3 = e66;
                        inputStream4 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (java.net.ConnectException e67) {
                        connectException = e67;
                        inputStream11 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (java.net.MalformedURLException e68) {
                        th5 = e68;
                        inputStream10 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (java.net.SocketException e69) {
                        socketException = e69;
                        inputStream9 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (java.net.UnknownHostException e70) {
                        th4 = e70;
                        inputStream7 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (javax.net.ssl.SSLException e71) {
                        sSLException = e71;
                        inputStream6 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (org.apache.http.conn.ConnectTimeoutException e72) {
                        connectTimeoutException = e72;
                        inputStream5 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (java.io.IOException e73) {
                        th2 = e73;
                        inputStream3 = null;
                        dataOutputStream = dataOutputStream;
                    } catch (java.lang.Throwable th49) {
                        th = th49;
                        inputStream2 = null;
                        dataOutputStream = dataOutputStream;
                    }
                    httpURLConnection2.setRequestProperty("RANGE", "bytes=" + this.f + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    this.u.b = android.os.SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.u.a();
                    if (z) {
                    }
                } catch (com.amap.api.mapcore.util.eu e74) {
                    dataOutputStream = null;
                    euVar = e74;
                    inputStream12 = null;
                } catch (java.io.InterruptedIOException e75) {
                    dataOutputStream = null;
                    th3 = e75;
                    inputStream4 = null;
                } catch (java.net.ConnectException e76) {
                    dataOutputStream = null;
                    connectException = e76;
                    inputStream11 = null;
                } catch (java.net.MalformedURLException e77) {
                    dataOutputStream = null;
                    th5 = e77;
                    inputStream10 = null;
                } catch (java.net.SocketException e78) {
                    dataOutputStream = null;
                    socketException = e78;
                    inputStream9 = null;
                } catch (java.net.SocketTimeoutException e79) {
                    dataOutputStream = null;
                    socketTimeoutException = e79;
                    inputStream8 = null;
                } catch (java.net.UnknownHostException e80) {
                    dataOutputStream = null;
                    th4 = e80;
                    inputStream7 = null;
                } catch (javax.net.ssl.SSLException e81) {
                    dataOutputStream = null;
                    sSLException = e81;
                    inputStream6 = null;
                } catch (org.apache.http.conn.ConnectTimeoutException e82) {
                    dataOutputStream = null;
                    connectTimeoutException = e82;
                    inputStream5 = null;
                } catch (java.io.IOException e83) {
                    dataOutputStream = null;
                    th2 = e83;
                    inputStream3 = null;
                } catch (java.lang.Throwable th50) {
                    dataOutputStream = null;
                    th = th50;
                    inputStream2 = null;
                }
                hiVar2 = hiVar;
                z = false;
                httpURLConnection2 = a(hiVar2, z, false).a;
            } catch (com.amap.api.mapcore.util.eu e84) {
                dataOutputStream = null;
                euVar = e84;
                inputStream12 = null;
                httpURLConnection2 = null;
            } catch (java.net.ConnectException e85) {
                dataOutputStream = null;
                connectException = e85;
                inputStream11 = null;
                httpURLConnection2 = null;
            } catch (java.net.MalformedURLException e86) {
                dataOutputStream = null;
                th5 = e86;
                inputStream10 = null;
                httpURLConnection2 = null;
            } catch (java.net.SocketException e87) {
                dataOutputStream = null;
                socketException = e87;
                inputStream9 = null;
                httpURLConnection2 = null;
            } catch (java.net.SocketTimeoutException e88) {
                dataOutputStream = null;
                socketTimeoutException = e88;
                inputStream8 = null;
                httpURLConnection2 = null;
            } catch (java.net.UnknownHostException e89) {
                dataOutputStream = null;
                th4 = e89;
                inputStream7 = null;
                httpURLConnection2 = null;
            } catch (javax.net.ssl.SSLException e90) {
                dataOutputStream = null;
                sSLException = e90;
                inputStream6 = null;
                httpURLConnection2 = null;
            } catch (org.apache.http.conn.ConnectTimeoutException e91) {
                dataOutputStream = null;
                connectTimeoutException = e91;
                inputStream5 = null;
                httpURLConnection2 = null;
            } catch (java.io.InterruptedIOException e92) {
                dataOutputStream = null;
                th3 = e92;
                inputStream4 = null;
                httpURLConnection2 = null;
            } catch (java.io.IOException e93) {
                dataOutputStream = null;
                th2 = e93;
                inputStream3 = null;
                httpURLConnection2 = null;
            } catch (java.lang.Throwable th51) {
                dataOutputStream = null;
                th = th51;
                inputStream2 = null;
                httpURLConnection2 = null;
            }
        } catch (java.lang.Throwable th52) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException e94) {
                    com.amap.api.mapcore.util.ga.a(e94, "ht", "mdr");
                } catch (java.lang.Throwable th53) {
                    com.amap.api.mapcore.util.ga.a(th53, "ht", "mdr");
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (java.lang.Throwable th54) {
                    com.amap.api.mapcore.util.ga.a(th54, "ht", "mdr");
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (java.lang.Throwable th55) {
                    com.amap.api.mapcore.util.ga.a(th55, "ht", "mdr");
                }
            }
            this.u.d();
            throw th52;
        }
    }

    public final com.amap.api.mapcore.util.hj b(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        d(hiVar);
                                        java.lang.String a2 = a(this.m, hiVar.getParams());
                                        this.m = a2;
                                        com.amap.api.mapcore.util.hj b2 = com.amap.api.mapcore.util.he.b(a2, this.j);
                                        if (b2 != null) {
                                            this.u.d();
                                            return b2;
                                        }
                                        com.amap.api.mapcore.util.hf.b a3 = a(hiVar, false, true);
                                        httpURLConnection = a3.a;
                                        this.u.b = android.os.SystemClock.elapsedRealtime();
                                        httpURLConnection.connect();
                                        this.u.a();
                                        com.amap.api.mapcore.util.hj a4 = a(a3, hiVar.isIgnoreGZip());
                                        this.u.a(a4);
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (java.lang.Throwable th) {
                                            com.amap.api.mapcore.util.ga.a(th, "ht", "mgr");
                                        }
                                        this.u.d();
                                        return a4;
                                    } catch (java.io.IOException unused) {
                                        this.u.a(7);
                                        throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                                    }
                                } catch (com.amap.api.mapcore.util.eu e2) {
                                    if (!e2.i() && e2.g() != 10) {
                                        this.u.a(e2.f());
                                    }
                                    throw e2;
                                }
                            } catch (java.lang.Throwable th2) {
                                th2.printStackTrace();
                                this.u.a(9);
                                throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                            }
                        } catch (java.net.ConnectException e3) {
                            this.u.b(a(e3));
                            this.u.a(6);
                            throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                        } catch (java.net.SocketTimeoutException e4) {
                            this.u.b(a(e4));
                            this.u.a(2);
                            throw new com.amap.api.mapcore.util.eu("socket 连接超时 - SocketTimeoutException");
                        }
                    } catch (java.net.UnknownHostException unused2) {
                        this.u.a(9);
                        throw new com.amap.api.mapcore.util.eu("未知主机 - UnKnowHostException");
                    } catch (javax.net.ssl.SSLException e5) {
                        e5.printStackTrace();
                        this.u.b(a(e5));
                        this.u.a(4);
                        throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                    }
                } catch (java.net.MalformedURLException unused3) {
                    this.u.a(8);
                    throw new com.amap.api.mapcore.util.eu("url异常 - MalformedURLException");
                } catch (org.apache.http.conn.ConnectTimeoutException e6) {
                    e6.printStackTrace();
                    this.u.b(a(e6));
                    this.u.a(2);
                    throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                }
            } catch (java.io.InterruptedIOException unused4) {
                this.u.b(7101);
                this.u.a(7);
                throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
            } catch (java.net.SocketException e7) {
                this.u.b(a(e7));
                this.u.a(6);
                throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_SOCKET);
            }
        } catch (java.lang.Throwable th3) {
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (java.lang.Throwable th4) {
                    com.amap.api.mapcore.util.ga.a(th4, "ht", "mgr");
                }
            }
            this.u.d();
            throw th3;
        }
    }

    public final void b(long j) {
        this.e = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v17 */
    public final com.amap.api.mapcore.util.hj c(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        java.io.OutputStream outputStream;
        ?? r7 = 0;
        r7 = 0;
        try {
            try {
                d(hiVar);
                com.amap.api.mapcore.util.hj b2 = com.amap.api.mapcore.util.he.b(this.m, this.j);
                if (b2 != null) {
                    this.u.d();
                    return b2;
                }
                com.amap.api.mapcore.util.hf.b a2 = a(hiVar, true, true);
                java.net.HttpURLConnection httpURLConnection = a2.a;
                try {
                    this.u.b = android.os.SystemClock.elapsedRealtime();
                    httpURLConnection.connect();
                    this.u.a();
                    byte[] entityBytes = hiVar.getEntityBytes();
                    if (entityBytes == null || entityBytes.length == 0) {
                        java.util.Map<java.lang.String, java.lang.String> params = hiVar.getParams();
                        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.amap.api.mapcore.util.hb.e;
                        if (hashMap != null) {
                            if (params != null) {
                                params.putAll(hashMap);
                            } else {
                                params = hashMap;
                            }
                        }
                        java.lang.String a3 = a(params);
                        if (!android.text.TextUtils.isEmpty(a3)) {
                            entityBytes = com.amap.api.mapcore.util.fi.a(a3);
                        }
                    }
                    if (entityBytes != null && entityBytes.length > 0) {
                        try {
                            this.u.b = android.os.SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection.getOutputStream();
                            try {
                                java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(outputStream);
                                try {
                                    dataOutputStream.write(entityBytes);
                                    dataOutputStream.close();
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.u.b();
                                } catch (java.lang.Throwable th) {
                                    th = th;
                                    r7 = dataOutputStream;
                                    if (r7 != 0) {
                                        r7.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.u.b();
                                    throw th;
                                }
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            outputStream = null;
                        }
                    }
                    com.amap.api.mapcore.util.hj a4 = a(a2, hiVar.isIgnoreGZip());
                    this.u.a(a4);
                    try {
                        httpURLConnection.disconnect();
                    } catch (java.lang.Throwable th4) {
                        com.amap.api.mapcore.util.ga.a(th4, "ht", "mPt");
                    }
                    this.u.d();
                    return a4;
                } catch (com.amap.api.mapcore.util.eu e2) {
                    e = e2;
                    if (!e.i() && e.g() != 10) {
                        this.u.a(e.g());
                    }
                    com.amap.api.mapcore.util.ga.a(e, "ht", "mPt");
                    throw e;
                } catch (java.io.InterruptedIOException unused) {
                    this.u.b(7101);
                    this.u.a(7);
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                } catch (java.net.ConnectException e3) {
                    e = e3;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                } catch (java.net.MalformedURLException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.u.a(8);
                    throw new com.amap.api.mapcore.util.eu("url异常 - MalformedURLException");
                } catch (java.net.SocketException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_SOCKET);
                } catch (java.net.SocketTimeoutException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new com.amap.api.mapcore.util.eu("socket 连接超时 - SocketTimeoutException");
                } catch (java.net.UnknownHostException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.u.a(5);
                    throw new com.amap.api.mapcore.util.eu("未知主机 - UnKnowHostException");
                } catch (javax.net.ssl.SSLException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(4);
                    throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                } catch (org.apache.http.conn.ConnectTimeoutException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                } catch (java.io.IOException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.u.a(7);
                    throw new com.amap.api.mapcore.util.eu("IO 操作异常 - IOException");
                } catch (java.lang.Throwable th5) {
                    th = th5;
                    com.amap.api.mapcore.util.ga.a(th, "ht", "mPt");
                    this.u.a(9);
                    throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (java.lang.Throwable th6) {
                if (0 != 0) {
                    try {
                        r7.disconnect();
                    } catch (java.lang.Throwable th7) {
                        com.amap.api.mapcore.util.ga.a(th7, "ht", "mPt");
                    }
                }
                this.u.d();
                throw th6;
            }
        } catch (com.amap.api.mapcore.util.eu e11) {
            e = e11;
        } catch (java.io.InterruptedIOException unused2) {
        } catch (java.net.ConnectException e12) {
            e = e12;
        } catch (java.net.MalformedURLException e13) {
            e = e13;
        } catch (java.net.SocketException e14) {
            e = e14;
        } catch (java.net.SocketTimeoutException e15) {
            e = e15;
        } catch (java.net.UnknownHostException e16) {
            e = e16;
        } catch (javax.net.ssl.SSLException e17) {
            e = e17;
        } catch (org.apache.http.conn.ConnectTimeoutException e18) {
            e = e18;
        } catch (java.io.IOException e19) {
            e = e19;
        } catch (java.lang.Throwable th8) {
            th = th8;
        }
    }
}
