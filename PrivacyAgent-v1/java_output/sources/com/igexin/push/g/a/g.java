package com.igexin.push.g.a;

/* loaded from: classes23.dex */
public final class g extends com.igexin.c.a.d.f {
    public static final int a = -2147483638;
    private static final java.lang.String c = "SimpleHttpTask";
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

    private g(com.igexin.push.g.a.d dVar) {
        super(0);
        this.b = dVar;
    }

    private com.igexin.push.g.a.g.a a(java.lang.String str) {
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            this.f = httpURLConnection;
            httpURLConnection.setConnectTimeout(20000);
            this.f.setReadTimeout(20000);
            this.f.setRequestMethod("GET");
            this.f.setDoInput(true);
            java.net.HttpURLConnection httpURLConnection2 = this.f;
            this.f = httpURLConnection2;
            byte[] a2 = a(httpURLConnection2);
            if (a2 != null) {
                return b(a2);
            }
        } finally {
            try {
                g();
                return new com.igexin.push.g.a.g.a(false, null);
            } finally {
            }
        }
        g();
        return new com.igexin.push.g.a.g.a(false, null);
    }

    private com.igexin.push.g.a.g.a a(java.lang.String str, byte[] bArr) {
        java.io.DataOutputStream dataOutputStream;
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
            this.f = this.f;
        } catch (java.lang.Throwable th) {
            th = th;
            dataOutputStream = null;
        }
        if (bArr == null) {
            com.igexin.push.g.a.g.a aVar = new com.igexin.push.g.a.g.a(true, null);
            com.igexin.c.a.b.g.a((java.io.Closeable) null);
            g();
            return aVar;
        }
        byte[] b = com.igexin.c.b.a.b(bArr);
        this.f.connect();
        dataOutputStream = new java.io.DataOutputStream(this.f.getOutputStream());
        try {
            dataOutputStream.write(b, 0, b.length);
            dataOutputStream.flush();
            byte[] a2 = a(this.f);
            if (a2 != null) {
                return b(a2);
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            try {
                com.igexin.c.a.c.a.a(th);
                com.igexin.c.a.b.g.a(dataOutputStream);
                g();
                return new com.igexin.push.g.a.g.a(false, null);
            } finally {
                com.igexin.c.a.b.g.a(dataOutputStream);
                g();
            }
        }
        com.igexin.c.a.b.g.a(dataOutputStream);
        g();
        return new com.igexin.push.g.a.g.a(false, null);
    }

    private void a(byte[] bArr) {
        try {
            this.b.a(bArr);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
    }

    private static byte[] a(java.net.HttpURLConnection httpURLConnection) throws java.lang.Exception {
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                try {
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
                } catch (java.lang.Exception unused) {
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    com.igexin.c.a.b.g.a(inputStream);
                    throw th;
                }
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
        } catch (java.lang.Exception unused2) {
            inputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStream = null;
        }
        com.igexin.c.a.b.g.a(inputStream);
        return null;
    }

    private com.igexin.push.g.a.g.a b(byte[] bArr) {
        try {
            return new com.igexin.push.g.a.g.a(false, bArr);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return new com.igexin.push.g.a.g.a(true, null);
        }
    }

    private java.net.HttpURLConnection b(java.lang.String str) throws java.lang.Exception {
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
        return this.f;
    }

    private java.net.HttpURLConnection c(java.lang.String str) throws java.lang.Exception {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        this.f = httpURLConnection;
        httpURLConnection.setConnectTimeout(20000);
        this.f.setReadTimeout(20000);
        this.f.setRequestMethod("GET");
        this.f.setDoInput(true);
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
        super.b_();
        android.os.Process.setThreadPriority(10);
        com.igexin.push.g.a.d dVar = this.b;
        if (dVar == null || dVar.f == null) {
            g();
            com.igexin.c.a.c.a.a(c, "run return ###");
            com.igexin.c.a.c.a.a("SimpleHttpTask|run return ###", new java.lang.Object[0]);
            return;
        }
        for (int i = 0; i < 3; i++) {
            com.igexin.push.g.a.d dVar2 = this.b;
            byte[] bArr = dVar2.g;
            java.lang.String str = dVar2.f;
            byte[] bArr2 = (bArr == null ? a(str) : a(str, bArr)).b;
            if (bArr2 != null) {
                try {
                    this.b.a(bArr2);
                    return;
                } catch (java.lang.Exception e2) {
                    com.igexin.c.a.c.a.a(e2);
                    return;
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
