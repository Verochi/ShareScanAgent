package com.loc;

/* loaded from: classes23.dex */
public final class bs {
    private static java.lang.ref.SoftReference<javax.net.ssl.SSLContext> k;
    private static java.lang.ref.SoftReference<com.loc.bt> t;
    private boolean a;
    private javax.net.ssl.SSLContext b;
    private java.net.Proxy c;
    private java.lang.String g;
    private com.loc.bp.a h;
    private com.loc.bs.d i;
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
    private java.lang.String f400s = "";
    private com.loc.bs.f u = new com.loc.bs.f();

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

        public a(com.loc.bs.c cVar) {
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
        public final com.loc.bs.a clone() {
            try {
                return (com.loc.bs.a) super.clone();
            } catch (java.lang.CloneNotSupportedException unused) {
                return null;
            }
        }

        public final java.lang.String b() {
            java.lang.StringBuilder sb;
            java.lang.StringBuilder sb2;
            java.lang.StringBuilder sb3;
            java.lang.StringBuilder sb4;
            try {
                java.lang.String str = this.f + "#";
                if (android.text.TextUtils.isEmpty(this.e)) {
                    sb = new java.lang.StringBuilder();
                    sb.append(str);
                    sb.append("-#");
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append(str);
                    sb.append(this.e);
                    sb.append("#");
                }
                java.lang.String str2 = (sb.toString() + this.h + "#") + this.j + "#";
                if (android.text.TextUtils.isEmpty(this.b)) {
                    sb2 = new java.lang.StringBuilder();
                    sb2.append(str2);
                    sb2.append("-#");
                } else {
                    sb2 = new java.lang.StringBuilder();
                    sb2.append(str2);
                    sb2.append(this.b);
                    sb2.append("#");
                }
                java.lang.String sb5 = sb2.toString();
                if (this.f == 1) {
                    sb3 = new java.lang.StringBuilder();
                    sb3.append(sb5);
                    sb3.append(this.d);
                    sb3.append("#");
                } else {
                    sb3 = new java.lang.StringBuilder();
                    sb3.append(sb5);
                    sb3.append("-#");
                }
                java.lang.String sb6 = sb3.toString();
                if (this.f == 1) {
                    sb4 = new java.lang.StringBuilder();
                    sb4.append(sb6);
                    sb4.append(this.i);
                    sb4.append("#");
                } else {
                    sb4 = new java.lang.StringBuilder();
                    sb4.append(sb6);
                    sb4.append("-#");
                }
                java.lang.String b = com.loc.q.b(com.loc.bl.a(((sb4.toString() + this.c + "#") + this.g).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                com.loc.bs.a();
                return b;
            } catch (java.lang.Exception unused) {
                return null;
            }
        }

        @Override // java.lang.Comparable
        public final int compareTo(java.lang.Object obj) {
            return this.a - ((com.loc.bs.a) obj).a;
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
        public com.loc.bu.b b = com.loc.bu.b.FIRST_NONDEGRADE;
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
        public final com.loc.bs.c clone() {
            try {
                return (com.loc.bs.c) super.clone();
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
            java.lang.String b = com.loc.q.b(com.loc.bl.a(((((str2 + this.b.a() + "#") + this.h + "#") + this.j + "#") + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            com.loc.bs.a();
            return b;
        }

        public final java.lang.String toString() {
            return "RequestInfo{csid='" + this.a + "', degradeType=" + this.b + ", serverIp='" + this.c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    public static class d {
        private java.util.Vector<com.loc.bs.e> a;
        private volatile com.loc.bs.e b;

        private d() {
            this.a = new java.util.Vector<>();
            this.b = new com.loc.bs.e((byte) 0);
        }

        public /* synthetic */ d(byte b) {
            this();
        }

        public final com.loc.bs.e a(java.lang.String str) {
            if (android.text.TextUtils.isEmpty(str)) {
                return this.b;
            }
            for (int i = 0; i < this.a.size(); i++) {
                com.loc.bs.e eVar = this.a.get(i);
                if (eVar != null && eVar.a().equals(str)) {
                    return eVar;
                }
            }
            com.loc.bs.e eVar2 = new com.loc.bs.e((byte) 0);
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
        com.loc.bs.c c = new com.loc.bs.c();
        com.loc.bs.a d;
        com.loc.bs.c e;
        java.lang.String f;
        java.net.URL g;

        public f() {
        }

        public final void a() {
            this.c.h = android.os.SystemClock.elapsedRealtime() - this.b;
        }

        public final void a(int i) {
            "----errorcode-----".concat(java.lang.String.valueOf(i));
            com.loc.bs.a();
            try {
                this.c.f = android.os.SystemClock.elapsedRealtime() - this.a;
                com.loc.bs.c cVar = this.c;
                cVar.m = i;
                if (cVar.b.e()) {
                    com.loc.n.a(false, this.c.e);
                }
                boolean b = com.loc.bs.this.b(this.c.e);
                if (b) {
                    if (com.loc.bs.this.p && !android.text.TextUtils.isEmpty(com.loc.bs.this.n) && this.c.b.b()) {
                        com.loc.n.d();
                    }
                    if (this.c.b.c()) {
                        com.loc.n.a(this.c.b.c(), this.c.e);
                    }
                    com.loc.n.c(this.e);
                    com.loc.n.a(false, this.d);
                    com.loc.n.b(this.c);
                }
                com.loc.n.a(this.g.toString(), this.c.b.c(), true, b);
                this.c.toString();
                com.loc.bs.a();
            } catch (java.lang.Throwable unused) {
            }
        }

        public final void a(long j) {
            this.c.l = new java.text.DecimalFormat("0.00").format(j / 1024.0f);
        }

        public final void a(com.loc.bu buVar, java.net.URL url) {
            this.g = url;
            this.c.d = url.getPath();
            this.c.e = url.getHost();
            if (!android.text.TextUtils.isEmpty(com.loc.bs.this.n) && buVar.u().b()) {
                com.loc.bs.c cVar = this.c;
                cVar.c = cVar.e.replace("[", "").replace("]", "");
                this.c.e = com.loc.bs.this.n;
            }
            if (buVar.u().b()) {
                buVar.a(this.c.e);
            }
            if (buVar.u().d()) {
                this.f = buVar.x();
            }
        }

        public final void a(com.loc.bv bvVar) {
            com.loc.bs.c clone;
            try {
                this.c.f = android.os.SystemClock.elapsedRealtime() - this.a;
                if (bvVar != null) {
                    bvVar.f = this.c.b.c();
                }
                if (this.c.b.b()) {
                    com.loc.bs.c cVar = this.c;
                    if (cVar.f > 10000) {
                        com.loc.n.a(false, cVar.e);
                    }
                }
                if (this.c.b.d()) {
                    com.loc.n.a(false, this.f);
                }
                boolean b = com.loc.bs.this.b(this.c.e);
                if (b) {
                    com.loc.n.c(this.c);
                    com.loc.n.a(true, this.d);
                    com.loc.bs.c cVar2 = this.c;
                    if (cVar2.f > com.loc.n.e && (clone = cVar2.clone()) != null) {
                        clone.m = 1;
                        com.loc.n.b(clone);
                        clone.toString();
                        com.loc.bs.a();
                    }
                }
                com.loc.n.a(this.g.toString(), this.c.b.c(), false, b);
                this.c.toString();
                com.loc.bs.a();
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
            com.loc.bs.c clone = this.c.clone();
            if (this.c.f > com.loc.n.e) {
                clone.m = 1;
            }
            com.loc.n.a(clone);
        }
    }

    public bs() {
        com.loc.n.e();
        try {
            this.g = java.util.UUID.randomUUID().toString().replaceAll(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER, "").toLowerCase();
        } catch (java.lang.Throwable th) {
            com.loc.at.a(th, "ht", "ic");
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
    private com.loc.bv a(com.loc.bs.b bVar) throws com.loc.l, java.io.IOException {
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
                com.loc.br.a();
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
                            z = a(headerFields, true);
                            c2 = 2;
                        } else if (headerFields.containsKey("sc")) {
                            z = a(headerFields, false);
                            c2 = 1;
                        } else {
                            com.loc.n.e(this.j);
                            z = false;
                            c2 = 0;
                        }
                        try {
                            if (z) {
                                if (this.j.equals("loc")) {
                                    java.lang.String str2 = this.f400s;
                                    if (android.text.TextUtils.isEmpty(str2)) {
                                        str2 = httpURLConnection.getURL().getHost();
                                    }
                                    com.loc.n.a(this.j, c2 == 2, str2, str2, this.n);
                                } else {
                                    com.loc.n.b(this.j, c2 == 2);
                                }
                            } else if (c2 == 1) {
                                com.loc.br.a(false, this.j);
                            }
                        } catch (java.lang.Throwable unused) {
                        }
                        if (responseCode == 200) {
                            com.loc.l lVar = new com.loc.l("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode + "  " + str + " " + this.g, str, this.g);
                            lVar.a(httpURLConnection.getResponseMessage());
                            lVar.a(headerFields);
                            this.u.b(responseCode);
                            this.u.a(10);
                            lVar.h();
                            throw lVar;
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
                                    filterInputStream2 = (bArr[0] == 31 && bArr[1] == -117) ? new java.util.zip.GZIPInputStream(pushbackInputStream) : pushbackInputStream;
                                    byte[] bArr2 = new byte[1024];
                                    while (true) {
                                        int read = filterInputStream2.read(bArr2);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream2.write(bArr2, 0, read);
                                    }
                                    this.u.c();
                                    com.loc.aw.c();
                                    com.loc.bv bvVar = new com.loc.bv();
                                    bvVar.a = byteArrayOutputStream2.toByteArray();
                                    bvVar.b = headerFields;
                                    bvVar.c = this.g;
                                    bvVar.d = str;
                                    bvVar.e = z;
                                    com.loc.br.a(httpURLConnection.getURL(), bvVar);
                                    this.u.a(bvVar.a.length);
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (java.lang.Throwable th) {
                                        com.loc.at.a(th, "ht", "par");
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (java.lang.Throwable th2) {
                                            com.loc.at.a(th2, "ht", "par");
                                        }
                                    }
                                    try {
                                        pushbackInputStream.close();
                                    } catch (java.lang.Throwable th3) {
                                        com.loc.at.a(th3, "ht", "par");
                                    }
                                    try {
                                        filterInputStream2.close();
                                    } catch (java.lang.Throwable th4) {
                                        com.loc.at.a(th4, "ht", "par");
                                    }
                                    return bvVar;
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
                                        com.loc.l lVar2 = new com.loc.l("IO 操作异常 - IOException", str, this.g);
                                        if (android.text.TextUtils.isEmpty(e.getMessage())) {
                                            throw lVar2;
                                        }
                                        if (!e.getMessage().equals("thread interrupted")) {
                                            throw lVar2;
                                        }
                                        lVar2.j();
                                        throw lVar2;
                                    } catch (java.lang.Throwable th5) {
                                        th = th5;
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (java.lang.Throwable th6) {
                                                com.loc.at.a(th6, "ht", "par");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (java.lang.Throwable th7) {
                                                com.loc.at.a(th7, "ht", "par");
                                            }
                                        }
                                        if (pushbackInputStream != null) {
                                            try {
                                                pushbackInputStream.close();
                                            } catch (java.lang.Throwable th8) {
                                                com.loc.at.a(th8, "ht", "par");
                                            }
                                        }
                                        if (r4 != 0) {
                                            throw th;
                                        }
                                        try {
                                            r4.close();
                                            throw th;
                                        } catch (java.lang.Throwable th9) {
                                            com.loc.at.a(th9, "ht", "par");
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

    private static java.lang.String a(java.lang.String str) {
        java.net.URL url;
        int i;
        com.amap.apis.utils.core.api.NetProxy netProxy = com.amap.apis.utils.core.api.AMapUtilCoreApi.getNetProxy();
        if (netProxy == null) {
            return str;
        }
        java.net.URL url2 = null;
        try {
            url = new java.net.URL(str);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            url = null;
        }
        if (url == null) {
            return str;
        }
        java.lang.String onHostProxy = netProxy.onHostProxy(url.getHost(), url.getPath());
        if (android.text.TextUtils.isEmpty(onHostProxy)) {
            return str;
        }
        java.lang.String[] split = onHostProxy.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        int i2 = 0;
        if (split.length == 2) {
            try {
                i = java.lang.Integer.parseInt(split[1]);
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
                i = 0;
            }
            i2 = i;
            onHostProxy = split[0];
        }
        try {
            java.lang.String protocol = url.getProtocol();
            if (i2 == 0) {
                i2 = url.getPort();
            }
            url2 = new java.net.URL(protocol, onHostProxy, i2, url.getFile().toString());
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
        }
        return url2 == null ? str : url2.toString();
    }

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = android.os.Build.MANUFACTURER;
        android.content.Context context = com.loc.n.c;
        return java.lang.String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", str, str2, str3, context != null ? com.loc.y.a(context) : "");
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

    public static void a() {
    }

    private void a(java.util.Map<java.lang.String, java.lang.String> map, java.net.HttpURLConnection httpURLConnection) {
        com.loc.bs.c g;
        if (map != null) {
            try {
                for (java.lang.String str : map.keySet()) {
                    httpURLConnection.addRequestProperty(str, map.get(str));
                }
            } catch (java.lang.Throwable th) {
                com.loc.at.a(th, "ht", "adh");
                return;
            }
        }
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.loc.bp.d;
        if (hashMap != null) {
            for (java.lang.String str2 : hashMap.keySet()) {
                httpURLConnection.addRequestProperty(str2, com.loc.bp.d.get(str2));
            }
        }
        java.lang.String str3 = "";
        if (!this.m.contains("/v3/iasdkauth") && !android.text.TextUtils.isEmpty(this.j) && com.loc.n.d(this.j)) {
            this.o = true;
            com.loc.n.g f2 = com.loc.n.f(this.j);
            httpURLConnection.addRequestProperty("lct", java.lang.String.valueOf(f2.a));
            httpURLConnection.addRequestProperty("lct-info", f2.b);
            httpURLConnection.addRequestProperty(com.anythink.expressad.foundation.d.c.bh, com.loc.n.c(com.loc.n.a(this.j)));
            httpURLConnection.addRequestProperty("lct-args", a(com.loc.n.b(this.j) != null ? com.loc.n.b(this.j).b() : "", this.j));
        }
        httpURLConnection.addRequestProperty("csid", this.g);
        if (b(this.u.c.e)) {
            com.loc.bs.f fVar = this.u;
            if (!android.text.TextUtils.isEmpty(fVar.c.c)) {
                str3 = com.loc.q.b(com.loc.bl.a(fVar.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
                java.lang.String str4 = fVar.c.c;
            }
            if (!android.text.TextUtils.isEmpty(str3)) {
                httpURLConnection.addRequestProperty("sip", str3);
            }
            if (com.loc.n.j && (g = com.loc.n.g()) != null) {
                httpURLConnection.addRequestProperty("nls", g.b());
                this.u.e = g;
            }
            com.loc.bs.a f3 = com.loc.n.f();
            if (f3 != null) {
                httpURLConnection.addRequestProperty("nlf", f3.b());
                this.u.d = f3;
            }
        }
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
                    return com.loc.n.a(this.j, com.loc.n.a(list));
                }
            }
            z2 = false;
            if (z2) {
            }
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    private com.loc.bt b() {
        try {
            java.lang.ref.SoftReference<com.loc.bt> softReference = t;
            if (softReference == null || softReference.get() == null) {
                t = new java.lang.ref.SoftReference<>(new com.loc.bt(com.loc.n.c, this.b));
            }
            com.loc.bt btVar = k != null ? t.get() : null;
            return btVar == null ? new com.loc.bt(com.loc.n.c, this.b) : btVar;
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "ht", "gsf");
            return null;
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

    private void b(com.loc.bu buVar) throws com.loc.l {
        this.i = new com.loc.bs.d((byte) 0);
        this.p = buVar.y();
        this.c = buVar.o();
        this.h = buVar.t();
        this.l = buVar.q();
        this.j = buVar.z();
        this.a = com.loc.r.a().a(buVar.s());
        java.lang.String m = buVar.u().b() ? buVar.m() : buVar.l();
        this.m = m;
        java.lang.String a2 = a(m);
        this.m = a2;
        java.lang.String a3 = com.loc.br.a(a2, this.j);
        this.m = a3;
        "restrictionURLTest: ".concat(java.lang.String.valueOf(a3));
        if (com.loc.bw.a().a(a3)) {
            "restriction hit: ".concat(java.lang.String.valueOf(a3));
            throw new com.loc.l("限制访问的接口");
        }
        this.n = buVar.g();
        if ("loc".equals(this.j)) {
            java.lang.String l = buVar.l();
            java.lang.String m2 = buVar.m();
            if (!android.text.TextUtils.isEmpty(l)) {
                try {
                    this.r = new java.net.URL(l).getHost();
                } catch (java.lang.Exception unused) {
                }
            }
            if (android.text.TextUtils.isEmpty(m2)) {
                return;
            }
            try {
                if (android.text.TextUtils.isEmpty(this.n)) {
                    this.q = new java.net.URL(m2).getHost();
                } else {
                    this.q = this.n;
                }
            } catch (java.lang.Exception unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(java.lang.String str) {
        if (this.l) {
            return true;
        }
        return (!android.text.TextUtils.isEmpty(this.n) && (this.n.contains("rest") || this.n.contains("apilocate"))) || c(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0209 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e A[Catch: all -> 0x01ac, TryCatch #2 {all -> 0x01ac, blocks: (B:32:0x00c9, B:35:0x00e1, B:37:0x00e4, B:39:0x00e8, B:41:0x00ee, B:44:0x00f7, B:47:0x0103, B:49:0x0106, B:53:0x010c, B:54:0x0138, B:56:0x013e, B:58:0x0148, B:59:0x0159, B:61:0x0181, B:63:0x01a2, B:64:0x01a5, B:51:0x0122, B:69:0x0126, B:71:0x0129, B:75:0x012f, B:73:0x0134), top: B:31:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x023b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.loc.bs.b c(com.loc.bu buVar) throws java.io.IOException, com.loc.l {
        java.lang.String str;
        boolean z;
        java.net.URL url;
        java.net.URLConnection a2;
        javax.net.ssl.SSLContext sSLContext;
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        com.loc.bt b2;
        java.lang.ref.SoftReference<javax.net.ssl.SSLContext> softReference;
        java.net.HttpURLConnection httpURLConnection;
        com.loc.bu.b u;
        java.lang.String str2;
        java.net.InetAddress[] allByName;
        java.lang.String str3;
        com.loc.bs.f fVar = this.u;
        com.loc.bu.b u2 = buVar.u();
        com.loc.bs.c cVar = fVar.c;
        cVar.a = com.loc.bs.this.g;
        cVar.b = u2;
        fVar.a = android.os.SystemClock.elapsedRealtime();
        java.util.Map<java.lang.String, java.lang.String> a3 = buVar.a();
        if (a3 == null) {
            a3 = new java.util.HashMap<>();
        }
        com.loc.bs.e a4 = this.i.a(this.n);
        int i = com.loc.bp.a;
        java.lang.String str4 = this.m;
        android.net.Uri parse = android.net.Uri.parse(str4);
        java.lang.String host = parse.getHost();
        if (i == 1) {
            str = com.loc.bp.b;
        } else {
            if (i == 2) {
                java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.loc.bp.c;
                str = hashMap != null ? hashMap.get(host) : "";
                z = false;
                if (!android.text.TextUtils.isEmpty(str)) {
                    buVar.w();
                    str4 = parse.buildUpon().encodedAuthority(str).build().toString();
                    if (z) {
                        a3.put("targetHost", host);
                        this.f400s = host;
                    }
                    if (z && this.a) {
                        a4.a(str);
                    }
                }
                this.m = str4;
                url = new java.net.URL(this.m);
                this.u.a(buVar, url);
                if (c(url.getHost()) && buVar.h()) {
                    u = buVar.u();
                    str2 = this.u.c.e;
                    if (!b(str2) && ((u.b() && com.loc.n.g) || (u.c() && com.loc.n.h(str2)))) {
                        try {
                            this.u.b = android.os.SystemClock.elapsedRealtime();
                            allByName = java.net.InetAddress.getAllByName(this.u.c.e);
                        } catch (java.lang.Throwable unused) {
                        }
                        if (allByName == null || allByName.length <= 0 || allByName[0] == null) {
                            str3 = "";
                        } else {
                            boolean z2 = com.loc.n.a() && com.loc.n.c();
                            "---canUseIpv6---".concat(java.lang.String.valueOf(z2));
                            if (z2) {
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
                        com.loc.bs.f fVar2 = this.u;
                        "---onDNSEnd---ip=".concat(java.lang.String.valueOf(str3));
                        fVar2.c.c = str3.replace("[", "").replace("]", "");
                        fVar2.c.g = android.os.SystemClock.elapsedRealtime() - fVar2.b;
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            android.net.Uri parse2 = android.net.Uri.parse(this.m);
                            java.lang.String host2 = parse2.getHost();
                            android.net.Uri build = parse2.buildUpon().encodedAuthority(str3).build();
                            this.n = host2;
                            a3.put(com.alipay.sdk.m.l.c.f, host2);
                            if (this.a) {
                                a4.b(host2);
                            }
                            this.m = build.toString();
                        }
                    }
                }
                if (this.a) {
                    this.m = com.loc.r.a(this.m);
                }
                java.util.Objects.toString(buVar.u());
                java.net.URL url2 = new java.net.URL(this.m);
                com.loc.bp.a aVar = this.h;
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
                                com.loc.at.a(th, "ht", "ne");
                            }
                        }
                        sSLContext.init(null, null, null);
                        this.b = sSLContext;
                        httpsURLConnection = (javax.net.ssl.HttpsURLConnection) a2;
                        if (com.loc.n.f.a || (b2 = b()) == null) {
                            httpsURLConnection.setSSLSocketFactory(this.b.getSocketFactory());
                        } else {
                            httpsURLConnection.setSSLSocketFactory(b2);
                            b2.a();
                        }
                        httpsURLConnection.setHostnameVerifier(a4);
                        httpURLConnection = httpsURLConnection;
                    }
                    sSLContext = null;
                    if (sSLContext == null) {
                    }
                    sSLContext.init(null, null, null);
                    this.b = sSLContext;
                    httpsURLConnection = (javax.net.ssl.HttpsURLConnection) a2;
                    if (com.loc.n.f.a) {
                    }
                    httpsURLConnection.setSSLSocketFactory(this.b.getSocketFactory());
                    httpsURLConnection.setHostnameVerifier(a4);
                    httpURLConnection = httpsURLConnection;
                }
                if (android.os.Build.VERSION.SDK != null) {
                    httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "close");
                }
                int v = (int) (buVar.v() - (this.u.c.g / 1000));
                a(a3, httpURLConnection);
                httpURLConnection.setConnectTimeout(v);
                httpURLConnection.setReadTimeout(v);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                return new com.loc.bs.b(httpURLConnection);
            }
            str = "";
        }
        z = true;
        if (!android.text.TextUtils.isEmpty(str)) {
        }
        this.m = str4;
        url = new java.net.URL(this.m);
        this.u.a(buVar, url);
        if (c(url.getHost())) {
            u = buVar.u();
            str2 = this.u.c.e;
            if (!b(str2) && ((u.b() && com.loc.n.g) || (u.c() && com.loc.n.h(str2)))) {
            }
        }
        if (this.a) {
        }
        java.util.Objects.toString(buVar.u());
        java.net.URL url22 = new java.net.URL(this.m);
        com.loc.bp.a aVar2 = this.h;
        if (aVar2 == null) {
        }
        if (a2 == null) {
        }
        if (this.a) {
        }
        if (android.os.Build.VERSION.SDK != null) {
        }
        int v2 = (int) (buVar.v() - (this.u.c.g / 1000));
        a(a3, httpURLConnection);
        httpURLConnection.setConnectTimeout(v2);
        httpURLConnection.setReadTimeout(v2);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        return new com.loc.bs.b(httpURLConnection);
    }

    private static boolean c(java.lang.String str) {
        return str.contains("rest") || str.contains("apilocate");
    }

    public final com.loc.bv a(com.loc.bu buVar) throws com.loc.l {
        java.io.DataOutputStream dataOutputStream;
        java.lang.Throwable th;
        java.io.OutputStream outputStream;
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            try {
                b(buVar);
                com.loc.bv b2 = com.loc.br.b(this.m, this.j);
                if (b2 != null) {
                    this.u.d();
                    return b2;
                }
                com.loc.bs.b c2 = c(buVar);
                java.net.HttpURLConnection httpURLConnection2 = c2.a;
                try {
                    this.u.b = android.os.SystemClock.elapsedRealtime();
                    httpURLConnection2.connect();
                    this.u.a();
                    byte[] d2 = buVar.d();
                    if (d2 == null || d2.length == 0) {
                        java.util.Map<java.lang.String, java.lang.String> e2 = buVar.e();
                        java.util.HashMap<java.lang.String, java.lang.String> hashMap = com.loc.bp.e;
                        if (hashMap != null) {
                            if (e2 != null) {
                                e2.putAll(hashMap);
                            } else {
                                e2 = hashMap;
                            }
                        }
                        java.lang.String a2 = a(e2);
                        if (!android.text.TextUtils.isEmpty(a2)) {
                            d2 = com.loc.y.a(a2);
                        }
                    }
                    if (d2 != null && d2.length > 0) {
                        try {
                            this.u.b = android.os.SystemClock.elapsedRealtime();
                            outputStream = httpURLConnection2.getOutputStream();
                            try {
                                dataOutputStream = new java.io.DataOutputStream(outputStream);
                                try {
                                    dataOutputStream.write(d2);
                                    dataOutputStream.close();
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.u.b();
                                } catch (java.lang.Throwable th2) {
                                    th = th2;
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    this.u.b();
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
                    com.loc.bv a3 = a(c2);
                    this.u.a(a3);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (java.lang.Throwable th5) {
                        com.loc.at.a(th5, "ht", "mPt");
                    }
                    this.u.d();
                    return a3;
                } catch (com.loc.l e3) {
                    e = e3;
                    if (!e.i() && e.g() != 10) {
                        this.u.a(e.g());
                    }
                    com.loc.at.a(e, "ht", "mPt");
                    throw e;
                } catch (java.io.InterruptedIOException unused) {
                    this.u.b(7101);
                    this.u.a(7);
                    throw new com.loc.l(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                } catch (java.net.ConnectException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new com.loc.l(com.amap.api.maps.AMapException.ERROR_CONNECTION);
                } catch (java.net.MalformedURLException e5) {
                    e = e5;
                    e.printStackTrace();
                    this.u.a(8);
                    throw new com.loc.l("url异常 - MalformedURLException");
                } catch (java.net.SocketException e6) {
                    e = e6;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(6);
                    throw new com.loc.l(com.amap.api.maps.AMapException.ERROR_SOCKET);
                } catch (java.net.SocketTimeoutException e7) {
                    e = e7;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new com.loc.l("socket 连接超时 - SocketTimeoutException");
                } catch (java.net.UnknownHostException e8) {
                    e = e8;
                    e.printStackTrace();
                    this.u.a(5);
                    throw new com.loc.l("未知主机 - UnKnowHostException");
                } catch (javax.net.ssl.SSLException e9) {
                    e = e9;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(4);
                    throw new com.loc.l("IO 操作异常 - IOException");
                } catch (org.apache.http.conn.ConnectTimeoutException e10) {
                    e = e10;
                    e.printStackTrace();
                    this.u.b(a(e));
                    this.u.a(2);
                    throw new com.loc.l("IO 操作异常 - IOException");
                } catch (java.io.IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    this.u.a(7);
                    throw new com.loc.l("IO 操作异常 - IOException");
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    com.loc.at.a(th, "ht", "mPt");
                    this.u.a(9);
                    throw new com.loc.l(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
                }
            } catch (java.lang.Throwable th7) {
                if (0 != 0) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (java.lang.Throwable th8) {
                        com.loc.at.a(th8, "ht", "mPt");
                    }
                }
                this.u.d();
                throw th7;
            }
        } catch (com.loc.l e12) {
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
}
