package com.anythink.expressad.exoplayer.j;

/* loaded from: classes12.dex */
public final class p implements com.anythink.expressad.exoplayer.j.s {
    public static final int a = 8000;
    public static final int b = 8000;
    private static final java.lang.String d = "DefaultHttpDataSource";
    private static final int e = 20;
    private static final long f = 2048;
    private static final java.util.regex.Pattern g = java.util.regex.Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final java.util.concurrent.atomic.AtomicReference<byte[]> h = new java.util.concurrent.atomic.AtomicReference<>();
    private final boolean i;
    private final int j;
    private final int k;
    private final java.lang.String l;
    private final com.anythink.expressad.exoplayer.k.u<java.lang.String> m;
    private final com.anythink.expressad.exoplayer.j.s.f n;
    private final com.anythink.expressad.exoplayer.j.s.f o;
    private final com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> p;
    private com.anythink.expressad.exoplayer.j.k q;
    private java.net.HttpURLConnection r;

    /* renamed from: s, reason: collision with root package name */
    private java.io.InputStream f227s;
    private boolean t;
    private long u;
    private long v;
    private long w;
    private long x;

    private p(java.lang.String str, com.anythink.expressad.exoplayer.k.u<java.lang.String> uVar) {
        this(str, uVar, null);
    }

    private p(java.lang.String str, com.anythink.expressad.exoplayer.k.u<java.lang.String> uVar, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar) {
        this(str, uVar, aaVar, (byte) 0);
    }

    private p(java.lang.String str, com.anythink.expressad.exoplayer.k.u<java.lang.String> uVar, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar, byte b2) {
        this(str, uVar, aaVar, 8000, 8000, false, null);
    }

    public p(java.lang.String str, com.anythink.expressad.exoplayer.k.u<java.lang.String> uVar, com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar, int i, int i2, boolean z, com.anythink.expressad.exoplayer.j.s.f fVar) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException();
        }
        this.l = str;
        this.m = uVar;
        this.p = aaVar;
        this.o = new com.anythink.expressad.exoplayer.j.s.f();
        this.j = i;
        this.k = i2;
        this.i = z;
        this.n = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long a(java.net.HttpURLConnection httpURLConnection) {
        long parseLong;
        java.lang.String headerField;
        java.lang.String headerField2 = httpURLConnection.getHeaderField("Content-Length");
        if (!android.text.TextUtils.isEmpty(headerField2)) {
            try {
                parseLong = java.lang.Long.parseLong(headerField2);
            } catch (java.lang.NumberFormatException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Unexpected Content-Length [");
                sb.append(headerField2);
                sb.append("]");
            }
            headerField = httpURLConnection.getHeaderField("Content-Range");
            if (!android.text.TextUtils.isEmpty(headerField)) {
                return parseLong;
            }
            java.util.regex.Matcher matcher = g.matcher(headerField);
            if (!matcher.find()) {
                return parseLong;
            }
            try {
                long parseLong2 = (java.lang.Long.parseLong(matcher.group(2)) - java.lang.Long.parseLong(matcher.group(1))) + 1;
                if (parseLong < 0) {
                    return parseLong2;
                }
                if (parseLong == parseLong2) {
                    return parseLong;
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder("Inconsistent headers [");
                sb2.append(headerField2);
                sb2.append("] [");
                sb2.append(headerField);
                sb2.append("]");
                return java.lang.Math.max(parseLong, parseLong2);
            } catch (java.lang.NumberFormatException unused2) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder("Unexpected Content-Range [");
                sb3.append(headerField);
                sb3.append("]");
                return parseLong;
            }
        }
        parseLong = -1;
        headerField = httpURLConnection.getHeaderField("Content-Range");
        if (!android.text.TextUtils.isEmpty(headerField)) {
        }
    }

    private java.net.HttpURLConnection a(java.net.URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.j);
        httpURLConnection.setReadTimeout(this.k);
        com.anythink.expressad.exoplayer.j.s.f fVar = this.n;
        if (fVar != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : fVar.b().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry2 : this.o.b().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j != 0 || j2 != -1) {
            java.lang.String str = "bytes=" + j + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.l);
        if (!z) {
            httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                java.io.OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private static java.net.URL a(java.net.URL url, java.lang.String str) {
        if (str == null) {
            throw new java.net.ProtocolException("Null location redirect");
        }
        java.net.URL url2 = new java.net.URL(url, str);
        java.lang.String protocol = url2.getProtocol();
        if ("https".equals(protocol) || com.alipay.sdk.m.l.a.q.equals(protocol)) {
            return url2;
        }
        throw new java.net.ProtocolException("Unsupported protocol redirect: ".concat(java.lang.String.valueOf(protocol)));
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, long j) {
        int i = com.anythink.expressad.exoplayer.k.af.a;
        if (i == 19 || i == 20) {
            try {
                java.io.InputStream inputStream = httpURLConnection.getInputStream();
                if (j == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j <= 2048) {
                    return;
                }
                java.lang.String name = inputStream.getClass().getName();
                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    java.lang.reflect.Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new java.lang.Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new java.lang.Object[0]);
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private int b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        long j = this.v;
        if (j != -1) {
            long j2 = j - this.x;
            if (j2 == 0) {
                return -1;
            }
            i2 = (int) java.lang.Math.min(i2, j2);
        }
        int read = this.f227s.read(bArr, i, i2);
        if (read == -1) {
            if (this.v == -1) {
                return -1;
            }
            throw new java.io.EOFException();
        }
        this.x += read;
        com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar = this.p;
        if (aaVar != null) {
            aaVar.a(read);
        }
        return read;
    }

    private java.net.HttpURLConnection b(com.anythink.expressad.exoplayer.j.k kVar) {
        java.net.HttpURLConnection a2;
        java.net.URL url = new java.net.URL(kVar.c.toString());
        byte[] bArr = kVar.d;
        long j = kVar.f;
        long j2 = kVar.g;
        boolean a3 = kVar.a(1);
        if (!this.i) {
            return a(url, bArr, j, j2, a3, true);
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i > 20) {
                throw new java.net.NoRouteToHostException("Too many redirects: ".concat(java.lang.String.valueOf(i2)));
            }
            a2 = a(url, bArr, j, j2, a3, false);
            int responseCode = a2.getResponseCode();
            if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                java.lang.String headerField = a2.getHeaderField("Location");
                a2.disconnect();
                if (headerField == null) {
                    throw new java.net.ProtocolException("Null location redirect");
                }
                java.net.URL url2 = new java.net.URL(url, headerField);
                java.lang.String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !com.alipay.sdk.m.l.a.q.equals(protocol)) {
                    throw new java.net.ProtocolException("Unsupported protocol redirect: ".concat(java.lang.String.valueOf(protocol)));
                }
                bArr = null;
                url = url2;
                i = i2;
            }
        }
        return a2;
    }

    private java.net.HttpURLConnection e() {
        return this.r;
    }

    private long f() {
        return this.w;
    }

    private long g() {
        return this.x;
    }

    private long h() {
        long j = this.v;
        return j == -1 ? j : j - this.x;
    }

    private void i() {
        if (this.w == this.u) {
            return;
        }
        byte[] andSet = h.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j = this.w;
            long j2 = this.u;
            if (j == j2) {
                h.set(andSet);
                return;
            }
            int read = this.f227s.read(andSet, 0, (int) java.lang.Math.min(j2 - j, andSet.length));
            if (java.lang.Thread.currentThread().isInterrupted()) {
                throw new java.io.InterruptedIOException();
            }
            if (read == -1) {
                throw new java.io.EOFException();
            }
            this.w += read;
            com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar = this.p;
            if (aaVar != null) {
                aaVar.a(read);
            }
        }
    }

    private void j() {
        java.net.HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (java.lang.Exception unused) {
            }
            this.r = null;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) {
        try {
            if (this.w != this.u) {
                byte[] andSet = h.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j = this.w;
                    long j2 = this.u;
                    if (j == j2) {
                        h.set(andSet);
                        break;
                    }
                    int read = this.f227s.read(andSet, 0, (int) java.lang.Math.min(j2 - j, andSet.length));
                    if (java.lang.Thread.currentThread().isInterrupted()) {
                        throw new java.io.InterruptedIOException();
                    }
                    if (read == -1) {
                        throw new java.io.EOFException();
                    }
                    this.w += read;
                    com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar = this.p;
                    if (aaVar != null) {
                        aaVar.a(read);
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.v;
            if (j3 != -1) {
                long j4 = j3 - this.x;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) java.lang.Math.min(i2, j4);
            }
            int read2 = this.f227s.read(bArr, i, i2);
            if (read2 == -1) {
                if (this.v == -1) {
                    return -1;
                }
                throw new java.io.EOFException();
            }
            this.x += read2;
            com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar2 = this.p;
            if (aaVar2 != null) {
                aaVar2.a(read2);
            }
            return read2;
        } catch (java.io.IOException e2) {
            throw new com.anythink.expressad.exoplayer.j.s.c(e2, this.q, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0074, code lost:
    
        r0 = r1;
     */
    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) {
        java.net.HttpURLConnection httpURLConnection;
        this.q = kVar;
        long j = 0;
        this.x = 0L;
        this.w = 0L;
        try {
            java.net.URL url = new java.net.URL(kVar.c.toString());
            byte[] bArr = kVar.d;
            long j2 = kVar.f;
            long j3 = kVar.g;
            boolean a2 = kVar.a(1);
            if (this.i) {
                int i = 0;
                java.net.URL url2 = url;
                byte[] bArr2 = bArr;
                while (true) {
                    int i2 = i + 1;
                    if (i > 20) {
                        throw new java.net.NoRouteToHostException("Too many redirects: ".concat(java.lang.String.valueOf(i2)));
                    }
                    java.net.URL url3 = url2;
                    long j4 = j3;
                    long j5 = j2;
                    java.net.HttpURLConnection a3 = a(url2, bArr2, j2, j3, a2, false);
                    int responseCode = a3.getResponseCode();
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr2 != null || (responseCode != 307 && responseCode != 308))) {
                        break;
                    }
                    java.lang.String headerField = a3.getHeaderField("Location");
                    a3.disconnect();
                    if (headerField == null) {
                        throw new java.net.ProtocolException("Null location redirect");
                    }
                    url2 = new java.net.URL(url3, headerField);
                    java.lang.String protocol = url2.getProtocol();
                    if (!"https".equals(protocol) && !com.alipay.sdk.m.l.a.q.equals(protocol)) {
                        throw new java.net.ProtocolException("Unsupported protocol redirect: ".concat(java.lang.String.valueOf(protocol)));
                    }
                    bArr2 = null;
                    i = i2;
                    j3 = j4;
                    j2 = j5;
                }
            } else {
                httpURLConnection = a(url, bArr, j2, j3, a2, true);
            }
            this.r = httpURLConnection;
            try {
                int responseCode2 = httpURLConnection.getResponseCode();
                if (responseCode2 < 200 || responseCode2 > 299) {
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = this.r.getHeaderFields();
                    j();
                    com.anythink.expressad.exoplayer.j.s.e eVar = new com.anythink.expressad.exoplayer.j.s.e(responseCode2, headerFields, kVar);
                    if (responseCode2 != 416) {
                        throw eVar;
                    }
                    eVar.initCause(new com.anythink.expressad.exoplayer.j.i());
                    throw eVar;
                }
                java.lang.String contentType = this.r.getContentType();
                com.anythink.expressad.exoplayer.k.u<java.lang.String> uVar = this.m;
                if (uVar != null && !uVar.a(contentType)) {
                    j();
                    throw new com.anythink.expressad.exoplayer.j.s.d(contentType, kVar);
                }
                if (responseCode2 == 200) {
                    long j6 = kVar.f;
                    if (j6 != 0) {
                        j = j6;
                    }
                }
                this.u = j;
                if (kVar.a(1)) {
                    this.v = kVar.g;
                } else {
                    long j7 = kVar.g;
                    if (j7 != -1) {
                        this.v = j7;
                    } else {
                        long a4 = a(this.r);
                        this.v = a4 != -1 ? a4 - this.u : -1L;
                    }
                }
                try {
                    this.f227s = this.r.getInputStream();
                    this.t = true;
                    com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar = this.p;
                    if (aaVar != null) {
                        aaVar.b();
                    }
                    return this.v;
                } catch (java.io.IOException e2) {
                    j();
                    throw new com.anythink.expressad.exoplayer.j.s.c(e2, kVar, 1);
                }
            } catch (java.io.IOException e3) {
                j();
                throw new com.anythink.expressad.exoplayer.j.s.c("Unable to connect to " + kVar.c.toString(), e3, kVar);
            }
        } catch (java.io.IOException e4) {
            throw new com.anythink.expressad.exoplayer.j.s.c("Unable to connect to " + kVar.c.toString(), e4, kVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final android.net.Uri a() {
        java.net.HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection == null) {
            return null;
        }
        return android.net.Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void a(java.lang.String str) {
        com.anythink.expressad.exoplayer.k.a.a(str);
        this.o.a(str);
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void a(java.lang.String str, java.lang.String str2) {
        com.anythink.expressad.exoplayer.k.a.a(str);
        com.anythink.expressad.exoplayer.k.a.a(str2);
        this.o.a(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0032, code lost:
    
        if (r3 > 2048) goto L21;
     */
    @Override // com.anythink.expressad.exoplayer.j.s, com.anythink.expressad.exoplayer.j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        try {
            if (this.f227s != null) {
                java.net.HttpURLConnection httpURLConnection = this.r;
                long j = this.v;
                if (j != -1) {
                    j -= this.x;
                }
                int i = com.anythink.expressad.exoplayer.k.af.a;
                if (i == 19 || i == 20) {
                    try {
                        java.io.InputStream inputStream = httpURLConnection.getInputStream();
                        if (j == -1) {
                            if (inputStream.read() == -1) {
                            }
                        }
                        java.lang.String name = inputStream.getClass().getName();
                        if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                            java.lang.reflect.Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new java.lang.Class[0]);
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(inputStream, new java.lang.Object[0]);
                        }
                    } catch (java.lang.Exception unused) {
                    }
                }
                try {
                    this.f227s.close();
                } catch (java.io.IOException e2) {
                    throw new com.anythink.expressad.exoplayer.j.s.c(e2, this.q, 3);
                }
            }
        } finally {
            this.f227s = null;
            j();
            if (this.t) {
                this.t = false;
                com.anythink.expressad.exoplayer.j.aa<? super com.anythink.expressad.exoplayer.j.p> aaVar = this.p;
                if (aaVar != null) {
                    aaVar.c();
                }
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> c() {
        java.net.HttpURLConnection httpURLConnection = this.r;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @Override // com.anythink.expressad.exoplayer.j.s
    public final void d() {
        this.o.a();
    }
}
