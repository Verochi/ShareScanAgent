package com.igexin.push.g.a;

/* loaded from: classes23.dex */
public class e extends com.igexin.c.a.d.f {
    public static final int a = -2147483638;
    private static final java.lang.String c = "HttpTask";
    private static final int d = 20000;
    private static final int e = 3;
    public com.igexin.push.g.a.d b;
    private java.net.HttpURLConnection f;

    public class a {
        boolean a;
        byte[] b;

        public a(boolean z, byte[] bArr) {
            this.a = z;
            this.b = bArr;
        }
    }

    public e(com.igexin.push.g.a.d dVar) {
        super(0);
        this.b = dVar;
    }

    private com.igexin.push.g.a.e.a a(java.lang.String str) {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            this.f = httpURLConnection;
            httpURLConnection.setConnectTimeout(20000);
            this.f.setReadTimeout(20000);
            this.f.setRequestMethod("GET");
            this.f.setDoInput(true);
            a(this.f, (byte[]) null);
            java.net.HttpURLConnection httpURLConnection2 = this.f;
            this.f = httpURLConnection2;
            byte[] a2 = a(httpURLConnection2);
            if (a2 != null) {
                return b(this.f, a2);
            }
        } finally {
            try {
                g();
                return new com.igexin.push.g.a.e.a(false, null);
            } finally {
            }
        }
        g();
        return new com.igexin.push.g.a.e.a(false, null);
    }

    private com.igexin.push.g.a.e.a a(java.lang.String str, byte[] bArr) {
        java.io.DataOutputStream dataOutputStream;
        byte[] a2;
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            this.f = httpURLConnection;
            httpURLConnection.setDoInput(true);
            this.f.setDoOutput(true);
            this.f.setRequestMethod("POST");
            this.f.setUseCaches(false);
            this.f.setInstanceFollowRedirects(true);
            this.f.setRequestProperty("Content-Type", com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
            this.f.setConnectTimeout(20000);
            this.f.setReadTimeout(20000);
            a(this.f, bArr);
            java.net.HttpURLConnection httpURLConnection2 = this.f;
            this.f = httpURLConnection2;
            a2 = a(bArr, httpURLConnection2);
        } catch (java.lang.Throwable th) {
            th = th;
            dataOutputStream = null;
        }
        if (a2 == null) {
            com.igexin.push.g.a.e.a aVar = new com.igexin.push.g.a.e.a(true, null);
            com.igexin.c.a.b.g.a((java.io.Closeable) null);
            g();
            return aVar;
        }
        this.f.connect();
        dataOutputStream = new java.io.DataOutputStream(this.f.getOutputStream());
        try {
            dataOutputStream.write(a2, 0, a2.length);
            dataOutputStream.flush();
            byte[] a3 = a(this.f);
            if (a3 != null) {
                return b(this.f, a3);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            try {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.b.g.a(dataOutputStream);
                g();
                return new com.igexin.push.g.a.e.a(false, null);
            } finally {
                com.igexin.c.a.b.g.a(dataOutputStream);
                g();
            }
        }
        com.igexin.c.a.b.g.a(dataOutputStream);
        g();
        return new com.igexin.push.g.a.e.a(false, null);
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, byte[] bArr) throws java.lang.Exception {
        if (httpURLConnection == null) {
            return;
        }
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            bArr = bArr2;
        }
        httpURLConnection.addRequestProperty("GT_C_T", "1");
        httpURLConnection.addRequestProperty("GT_C_K", new java.lang.String(com.igexin.push.h.g.c()));
        httpURLConnection.addRequestProperty("GT_C_V", com.igexin.push.h.g.f());
        java.lang.String valueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        java.lang.String a2 = com.igexin.push.h.g.a(valueOf, bArr);
        httpURLConnection.addRequestProperty("GT_T", valueOf);
        httpURLConnection.addRequestProperty("GT_C_S", a2);
    }

    private void a(byte[] bArr) {
        try {
            this.b.a(bArr);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static byte[] a(java.net.HttpURLConnection httpURLConnection) throws java.lang.Exception {
        java.io.InputStream inputStream;
        java.io.InputStream inputStream2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                if (httpURLConnection.getResponseCode() == 200) {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            com.igexin.c.a.b.g.a(inputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                }
            } catch (java.lang.Exception unused) {
            } catch (java.lang.Throwable th) {
                th = th;
                inputStream2 = inputStream;
                com.igexin.c.a.b.g.a(inputStream2);
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            inputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        com.igexin.c.a.b.g.a(inputStream);
        return null;
    }

    private static byte[] a(byte[] bArr, java.net.HttpURLConnection httpURLConnection) {
        java.lang.String requestProperty;
        try {
            if (!httpURLConnection.getRequestProperties().containsKey("GT_C_S") || (requestProperty = httpURLConnection.getRequestProperty("GT_C_S")) == null) {
                return null;
            }
            return com.igexin.push.h.g.a(bArr, com.igexin.push.h.g.c(requestProperty.getBytes()));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return null;
        }
    }

    private com.igexin.push.g.a.e.a b(java.net.HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            if (!(this.b.l && com.igexin.push.h.a.a())) {
                return new com.igexin.push.g.a.e.a(false, bArr);
            }
            java.lang.String headerField = httpURLConnection.getHeaderField("GT_ERR");
            if (headerField != null && headerField.equals("0")) {
                java.lang.String headerField2 = httpURLConnection.getHeaderField("GT_T");
                if (headerField2 == null) {
                    com.igexin.c.a.c.a.a(c, "GT_T = null");
                    com.igexin.c.a.c.a.a("HttpTask|GT_T = null", new java.lang.Object[0]);
                    return new com.igexin.push.g.a.e.a(true, null);
                }
                java.lang.String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
                if (headerField3 == null) {
                    com.igexin.c.a.c.a.a(c, "GT_C_S = null");
                    com.igexin.c.a.c.a.a("HttpTask|GT_C_S = null", new java.lang.Object[0]);
                    return new com.igexin.push.g.a.e.a(true, null);
                }
                byte[] b = com.igexin.push.h.g.b(bArr, com.igexin.push.h.g.c(headerField2.getBytes()));
                java.lang.String a2 = com.igexin.push.h.g.a(headerField2, b);
                if (a2 != null && a2.equals(headerField3)) {
                    return new com.igexin.push.g.a.e.a(false, b);
                }
                com.igexin.c.a.c.a.a(c, "signature = null or error");
                com.igexin.c.a.c.a.a("HttpTask|signature = null or error", new java.lang.Object[0]);
                return new com.igexin.push.g.a.e.a(true, null);
            }
            com.igexin.c.a.c.a.a(c, "GT_ERR = ".concat(java.lang.String.valueOf(headerField)));
            com.igexin.c.a.c.a.a("HttpTask|GT_ERR = ".concat(java.lang.String.valueOf(headerField)), new java.lang.Object[0]);
            return new com.igexin.push.g.a.e.a(true, null);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new com.igexin.push.g.a.e.a(true, null);
        }
    }

    private java.net.HttpURLConnection b(java.lang.String str) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        this.f = httpURLConnection;
        httpURLConnection.setConnectTimeout(20000);
        this.f.setReadTimeout(20000);
        this.f.setRequestMethod("GET");
        this.f.setDoInput(true);
        a(this.f, (byte[]) null);
        return this.f;
    }

    private java.net.HttpURLConnection b(java.lang.String str, byte[] bArr) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        this.f = httpURLConnection;
        httpURLConnection.setDoInput(true);
        this.f.setDoOutput(true);
        this.f.setRequestMethod("POST");
        this.f.setUseCaches(false);
        this.f.setInstanceFollowRedirects(true);
        this.f.setRequestProperty("Content-Type", com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        this.f.setConnectTimeout(20000);
        this.f.setReadTimeout(20000);
        a(this.f, bArr);
        return this.f;
    }

    private void g() {
        java.net.HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.f = null;
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
    }

    private boolean h() {
        return this.b.l && com.igexin.push.h.a.a();
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        byte[] bArr;
        super.b_();
        android.os.Process.setThreadPriority(10);
        com.igexin.push.g.a.d dVar = this.b;
        if (dVar == null || dVar.f == null || ((bArr = dVar.g) != null && bArr.length > com.igexin.push.config.d.A * 1024)) {
            g();
            com.igexin.c.a.c.a.a(c, "run return ###");
            com.igexin.c.a.c.a.a("HttpTask|run return ###", new java.lang.Object[0]);
            return;
        }
        if (bArr != null && bArr.length > 0) {
            dVar.g = com.igexin.c.a.b.g.a(bArr);
        }
        for (int i = 0; i < 3; i++) {
            com.igexin.push.g.a.d dVar2 = this.b;
            byte[] bArr2 = dVar2.g;
            java.lang.String str = dVar2.f;
            com.igexin.push.g.a.e.a a2 = bArr2 == null ? a(str) : a(str, bArr2);
            if (a2.a) {
                com.igexin.c.a.c.a.a(c, "http server resp decode header error");
            } else {
                byte[] bArr3 = a2.b;
                if (bArr3 != null) {
                    try {
                        this.b.a(bArr3);
                        return;
                    } catch (java.lang.Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        return;
                    }
                }
            }
            if (i == 2) {
                this.b.a(new java.lang.Exception("try up to limit"));
                com.igexin.c.a.c.a.a(c, "http request exception, try times = " + (i + 1));
            }
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2147483638;
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
        g();
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
