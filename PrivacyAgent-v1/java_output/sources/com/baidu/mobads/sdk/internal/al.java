package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class al extends java.util.Observable implements com.baidu.mobads.sdk.internal.x, java.lang.Runnable {
    protected static final int i = 10240;
    protected static final int j = 10240;
    public static final java.lang.String k = ".tmp";
    private static final java.lang.String m = "FileDownloader";
    protected android.content.Context a;
    protected java.net.URL b;
    protected java.lang.String c;
    protected java.lang.String d;
    protected int e;
    protected com.baidu.mobads.sdk.internal.x.a f;
    protected int g;
    protected int h;
    protected byte[] l;
    private boolean n;

    public al(android.content.Context context, java.net.URL url, java.lang.String str, java.lang.String str2, boolean z) {
        this.a = context;
        this.b = url;
        this.c = str;
        this.n = z;
        if (str2 == null || str2.trim().length() <= 0) {
            java.lang.String file = url.getFile();
            this.d = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.d = str2;
        }
        this.e = -1;
        this.f = com.baidu.mobads.sdk.internal.x.a.DOWNLOADING;
        this.g = 0;
        this.h = 0;
    }

    private java.net.HttpURLConnection a(java.net.HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                java.net.URL url = new java.net.URL(httpURLConnection.getHeaderField("Location"));
                this.b = url;
                java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (java.lang.Exception unused) {
                    return httpURLConnection2;
                }
            } catch (java.lang.Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    private void s() {
        a(com.baidu.mobads.sdk.internal.x.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a() {
        a(com.baidu.mobads.sdk.internal.x.a.DOWNLOADING);
        p();
    }

    public void a(int i2, float f) {
        this.g += i2;
        q();
    }

    public void a(com.baidu.mobads.sdk.internal.x.a aVar) {
        this.f = aVar;
        q();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @java.lang.Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @java.lang.Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @java.lang.Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public java.lang.String e() {
        return this.b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @java.lang.Deprecated
    public java.lang.String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public java.lang.String g() {
        return this.c + this.d;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @java.lang.Deprecated
    public java.lang.String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @java.lang.Deprecated
    public java.lang.String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public int j() {
        return this.e;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public float k() {
        return java.lang.Math.abs((this.g / this.e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public com.baidu.mobads.sdk.internal.x.a l() {
        return this.f;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.l;
    }

    public void p() {
        com.baidu.mobads.sdk.internal.bd.a().a(this);
    }

    public void q() {
        setChanged();
        notifyObservers();
    }

    public void r() {
        com.baidu.mobads.sdk.internal.br.a(this.c + this.d + k, this.c + this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        java.io.BufferedInputStream bufferedInputStream;
        java.net.HttpURLConnection httpURLConnection;
        java.lang.Throwable th;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Exception e;
        com.baidu.mobads.sdk.internal.x.a aVar;
        int read;
        try {
            if (this.b != null && !com.baidu.mobads.sdk.internal.cq.a().f(this.b.toString())) {
                com.baidu.mobads.sdk.internal.cq.a().a((java.net.HttpURLConnection) null);
                return;
            }
            java.net.HttpURLConnection a = com.baidu.mobads.sdk.internal.cq.a().a(this.b);
            try {
                a.setConnectTimeout(10000);
                a.setInstanceFollowRedirects(true);
                a.connect();
                int responseCode = a.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    a.setInstanceFollowRedirects(false);
                    a = a(a);
                    responseCode = a.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    s();
                }
                int contentLength = a.getContentLength();
                if (contentLength > 0) {
                    this.e = contentLength;
                }
                java.io.File file = new java.io.File(this.c);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bufferedInputStream = new java.io.BufferedInputStream(a.getInputStream());
                try {
                    java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(g() + k));
                    try {
                        byte[] bArr = new byte[10240];
                        r4 = this.n ? new java.io.ByteArrayOutputStream() : null;
                        int i2 = 0;
                        while (true) {
                            com.baidu.mobads.sdk.internal.x.a aVar2 = this.f;
                            aVar = com.baidu.mobads.sdk.internal.x.a.DOWNLOADING;
                            if (aVar2 != aVar || (read = bufferedInputStream.read(bArr, 0, 10240)) == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                            if (r4 != null) {
                                r4.write(bArr, 0, read);
                            }
                            i2 += read;
                            a(read, i2 / this.e);
                        }
                        bufferedOutputStream.flush();
                        if (r4 != null) {
                            r4.flush();
                        }
                        if (this.f == aVar) {
                            r();
                            a(com.baidu.mobads.sdk.internal.x.a.COMPLETED);
                        }
                        try {
                            bufferedOutputStream.close();
                        } catch (java.lang.Exception e2) {
                            com.baidu.mobads.sdk.internal.bt.a().c(m, e2.getMessage());
                        }
                        if (r4 != null) {
                            try {
                                r4.close();
                            } catch (java.lang.Exception e3) {
                                com.baidu.mobads.sdk.internal.bt.a().c(m, e3.getMessage());
                            }
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (java.lang.Exception e4) {
                            com.baidu.mobads.sdk.internal.bt.a().c(m, e4.getMessage());
                        }
                        com.baidu.mobads.sdk.internal.cq.a().a(a);
                    } catch (java.lang.Exception e5) {
                        e = e5;
                        java.net.HttpURLConnection httpURLConnection2 = a;
                        byteArrayOutputStream = r4;
                        r4 = bufferedOutputStream;
                        httpURLConnection = httpURLConnection2;
                        try {
                            com.baidu.mobads.sdk.internal.bt.a().c(m, e.getMessage());
                            s();
                            if (r4 != null) {
                                try {
                                    r4.close();
                                } catch (java.lang.Exception e6) {
                                    com.baidu.mobads.sdk.internal.bt.a().c(m, e6.getMessage());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Exception e7) {
                                    com.baidu.mobads.sdk.internal.bt.a().c(m, e7.getMessage());
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.lang.Exception e8) {
                                    com.baidu.mobads.sdk.internal.bt.a().c(m, e8.getMessage());
                                }
                            }
                            com.baidu.mobads.sdk.internal.cq.a().a(httpURLConnection);
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            if (r4 != null) {
                                try {
                                    r4.close();
                                } catch (java.lang.Exception e9) {
                                    com.baidu.mobads.sdk.internal.bt.a().c(m, e9.getMessage());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (java.lang.Exception e10) {
                                    com.baidu.mobads.sdk.internal.bt.a().c(m, e10.getMessage());
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.lang.Exception e11) {
                                    com.baidu.mobads.sdk.internal.bt.a().c(m, e11.getMessage());
                                }
                            }
                            com.baidu.mobads.sdk.internal.cq.a().a(httpURLConnection);
                            throw th;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        java.net.HttpURLConnection httpURLConnection3 = a;
                        byteArrayOutputStream = r4;
                        r4 = bufferedOutputStream;
                        httpURLConnection = httpURLConnection3;
                        if (r4 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        com.baidu.mobads.sdk.internal.cq.a().a(httpURLConnection);
                        throw th;
                    }
                } catch (java.lang.Exception e12) {
                    e = e12;
                    httpURLConnection = a;
                    byteArrayOutputStream = null;
                } catch (java.lang.Throwable th4) {
                    th = th4;
                    httpURLConnection = a;
                    byteArrayOutputStream = null;
                }
            } catch (java.lang.Exception e13) {
                httpURLConnection = a;
                e = e13;
                byteArrayOutputStream = null;
                bufferedInputStream = null;
            } catch (java.lang.Throwable th5) {
                httpURLConnection = a;
                th = th5;
                byteArrayOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (java.lang.Exception e14) {
            bufferedInputStream = null;
            httpURLConnection = null;
            e = e14;
            byteArrayOutputStream = null;
        } catch (java.lang.Throwable th6) {
            bufferedInputStream = null;
            httpURLConnection = null;
            th = th6;
            byteArrayOutputStream = null;
        }
    }
}
