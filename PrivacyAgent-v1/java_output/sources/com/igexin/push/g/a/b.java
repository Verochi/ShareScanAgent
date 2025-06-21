package com.igexin.push.g.a;

/* loaded from: classes23.dex */
public class b extends com.igexin.c.a.d.f {
    public static final java.lang.String a = "com.igexin.push.g.a.b";
    public static final int b = -2147483639;
    private static final int d = 20000;
    public com.igexin.push.g.a.d c;
    private java.net.HttpURLConnection e;

    public b(com.igexin.push.g.a.d dVar) {
        super(0);
        this.c = dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(java.lang.String str) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            this.e = httpURLConnection;
            httpURLConnection.setConnectTimeout(20000);
            this.e.setReadTimeout(20000);
            this.e.setRequestMethod("GET");
            this.e.setDoInput(true);
            inputStream = this.e.getInputStream();
            try {
                byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                try {
                    try {
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.igexin.c.a.c.a.a(e);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception e2) {
                                com.igexin.c.a.c.a.a(e2);
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (java.lang.Exception e3) {
                                e = e3;
                                com.igexin.c.a.c.a.a(e);
                                g();
                                return null;
                            }
                        }
                        g();
                        return null;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (java.lang.Exception e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (java.lang.Exception e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    g();
                    throw th;
                }
            } catch (java.lang.Exception e6) {
                e = e6;
                byteArrayOutputStream = null;
            } catch (java.lang.Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                g();
                throw th;
            }
        } catch (java.lang.Exception e7) {
            e = e7;
            inputStream = null;
            byteArrayOutputStream = null;
        } catch (java.lang.Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStream = null;
        }
        if (this.e.getResponseCode() != 200) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.lang.Exception e8) {
                    com.igexin.c.a.c.a.a(e8);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (java.lang.Exception e9) {
                e = e9;
                com.igexin.c.a.c.a.a(e);
                g();
                return null;
            }
            g();
            return null;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            inputStream.close();
        } catch (java.lang.Exception e10) {
            com.igexin.c.a.c.a.a(e10);
        }
        try {
            byteArrayOutputStream.close();
        } catch (java.lang.Exception e11) {
            com.igexin.c.a.c.a.a(e11);
        }
        g();
        return byteArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.DataOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] a(java.lang.String str, byte[] bArr) {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th;
        java.io.ByteArrayOutputStream byteArrayOutputStream2;
        java.lang.Exception e;
        try {
            try {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                this.e = httpURLConnection;
                httpURLConnection.setDoInput(true);
                this.e.setDoOutput(true);
                this.e.setRequestMethod("POST");
                this.e.setUseCaches(false);
                this.e.setInstanceFollowRedirects(true);
                this.e.setRequestProperty("Content-Type", com.alibaba.sdk.android.oss.common.OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                this.e.setConnectTimeout(20000);
                this.e.setReadTimeout(20000);
                this.e.connect();
                str = new java.io.DataOutputStream(this.e.getOutputStream());
                try {
                    str.write(bArr, 0, bArr.length);
                    str.flush();
                } catch (java.lang.Exception e2) {
                    e = e2;
                    bArr = 0;
                    str = str;
                    byteArrayOutputStream2 = bArr;
                    com.igexin.c.a.c.a.a(e);
                    if (str != 0) {
                    }
                    if (bArr != 0) {
                    }
                    if (byteArrayOutputStream2 != null) {
                    }
                    g();
                    return null;
                } catch (java.lang.Throwable th2) {
                    byteArrayOutputStream = null;
                    th = th2;
                    bArr = 0;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Exception e3) {
            e = e3;
            str = 0;
            bArr = 0;
        } catch (java.lang.Throwable th4) {
            bArr = 0;
            byteArrayOutputStream = null;
            th = th4;
            str = 0;
        }
        if (this.e.getResponseCode() != 200) {
            try {
                str.close();
            } catch (java.lang.Exception e4) {
                e = e4;
                com.igexin.c.a.c.a.a(e);
                g();
                return null;
            }
            g();
            return null;
        }
        bArr = this.e.getInputStream();
        try {
            byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = bArr.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr2, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                try {
                    str.close();
                } catch (java.lang.Exception e5) {
                    com.igexin.c.a.c.a.a(e5);
                }
                try {
                    bArr.close();
                } catch (java.lang.Exception e6) {
                    com.igexin.c.a.c.a.a(e6);
                }
                try {
                    byteArrayOutputStream2.close();
                } catch (java.lang.Exception e7) {
                    com.igexin.c.a.c.a.a(e7);
                }
                g();
                return byteArray;
            } catch (java.lang.Exception e8) {
                e = e8;
                com.igexin.c.a.c.a.a(e);
                if (str != 0) {
                    try {
                        str.close();
                    } catch (java.lang.Exception e9) {
                        com.igexin.c.a.c.a.a(e9);
                    }
                }
                if (bArr != 0) {
                    try {
                        bArr.close();
                    } catch (java.lang.Exception e10) {
                        com.igexin.c.a.c.a.a(e10);
                    }
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (java.lang.Exception e11) {
                        e = e11;
                        com.igexin.c.a.c.a.a(e);
                        g();
                        return null;
                    }
                }
                g();
                return null;
            }
        } catch (java.lang.Exception e12) {
            e = e12;
            byteArrayOutputStream2 = null;
        } catch (java.lang.Throwable th5) {
            byteArrayOutputStream = null;
            th = th5;
            if (str != 0) {
                try {
                    str.close();
                } catch (java.lang.Exception e13) {
                    com.igexin.c.a.c.a.a(e13);
                }
            }
            if (bArr != 0) {
                try {
                    bArr.close();
                } catch (java.lang.Exception e14) {
                    com.igexin.c.a.c.a.a(e14);
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (java.lang.Exception e15) {
                    com.igexin.c.a.c.a.a(e15);
                }
            }
            g();
            throw th;
        }
    }

    private void g() {
        java.net.HttpURLConnection httpURLConnection = this.e;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.e = null;
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        g();
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws java.lang.Exception {
        java.lang.String str;
        byte[] bArr;
        super.b_();
        android.os.Process.setThreadPriority(10);
        com.igexin.push.g.a.d dVar = this.c;
        if (dVar == null || (str = dVar.f) == null || ((bArr = dVar.g) != null && bArr.length > com.igexin.push.config.d.A * 1024)) {
            l();
            java.lang.String str2 = a;
            com.igexin.c.a.c.a.a(str2, "run return ###");
            com.igexin.c.a.c.a.a(str2 + "|run return ###", new java.lang.Object[0]);
            return;
        }
        try {
            byte[] a2 = bArr == null ? a(str) : a(str, bArr);
            if (a2 == null) {
                java.lang.Exception exc = new java.lang.Exception("Http response ＝＝ null");
                this.c.a(exc);
                throw exc;
            }
            try {
                this.c.a(a2);
                com.igexin.c.a.b.e.a().a(this.c);
                com.igexin.c.a.b.e.a().b();
            } catch (java.lang.Exception e) {
                this.c.a(e);
                throw e;
            }
        } catch (java.lang.Exception e2) {
            this.c.a(e2);
            throw e2;
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2147483639;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        this.o = true;
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
        g();
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }
}
