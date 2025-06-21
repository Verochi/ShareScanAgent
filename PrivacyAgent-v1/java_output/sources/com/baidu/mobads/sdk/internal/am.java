package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class am {
    public static final java.lang.String a = "OAdURLConnection";
    public static final java.lang.String b = "POST";
    public static final java.lang.String c = "GET";
    public static final java.lang.String d = "application/json";
    public static final java.lang.String e = "text/plain";
    private java.net.HttpURLConnection f;
    private com.baidu.mobads.sdk.internal.bt g;
    private com.baidu.mobads.sdk.internal.am.b h;
    private com.baidu.mobads.sdk.internal.am.c i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String m;
    private int n;
    private int o;
    private boolean p;
    private android.net.Uri.Builder q;

    public class a extends com.baidu.mobads.sdk.internal.j {
        public a() {
        }

        @Override // com.baidu.mobads.sdk.internal.j
        public java.lang.Object i() {
            com.baidu.mobads.sdk.internal.am.this.e();
            com.baidu.mobads.sdk.internal.am.this.f();
            return null;
        }
    }

    public interface b {
        void a(java.lang.String str, int i);

        void a(java.lang.String str, java.lang.String str2);
    }

    public interface c {
        void a(java.io.InputStream inputStream, java.lang.String str);

        void a(java.lang.String str, int i);
    }

    public am(java.lang.String str) {
        this(str, "GET");
    }

    public am(java.lang.String str, java.lang.String str2) {
        this.g = com.baidu.mobads.sdk.internal.bt.a();
        this.h = null;
        this.i = null;
        this.m = e;
        this.n = 10000;
        this.o = 10000;
        this.p = false;
        this.q = null;
        this.j = str;
        this.k = str2;
    }

    private java.net.HttpURLConnection a(java.net.HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) new java.net.URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
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

    private void a(java.lang.String str, java.net.HttpURLConnection httpURLConnection) {
        java.io.OutputStream outputStream;
        java.io.BufferedWriter bufferedWriter = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(outputStream, "UTF-8"));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (android.text.TextUtils.isEmpty(this.j) || !com.baidu.mobads.sdk.internal.cq.a().f(this.j)) {
            return;
        }
        try {
            java.net.HttpURLConnection a2 = com.baidu.mobads.sdk.internal.cq.a().a(new java.net.URL(this.j));
            this.f = a2;
            a2.setConnectTimeout(this.n);
            if (java.lang.Integer.parseInt(com.baidu.mobads.sdk.internal.bm.a((android.content.Context) null).b()) < 8) {
                java.lang.System.setProperty("http.keepAlive", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            }
            this.f.setRequestMethod(this.k);
            this.f.setUseCaches(this.p);
            if (!android.text.TextUtils.isEmpty(this.l)) {
                this.f.setRequestProperty("User-Agent", this.l);
            }
            this.f.setRequestProperty("Content-type", this.m);
            this.f.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, "keep-alive");
            this.f.setRequestProperty("Cache-Control", "no-cache");
            if (this.k.equals("POST")) {
                this.f.setDoInput(true);
                this.f.setDoOutput(true);
                android.net.Uri.Builder builder = this.q;
                if (builder != null) {
                    a(builder.build().getEncodedQuery(), this.f);
                }
            }
        } catch (java.lang.Exception e2) {
            com.baidu.mobads.sdk.internal.am.b bVar = this.h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
            com.baidu.mobads.sdk.internal.am.c cVar = this.i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        java.net.HttpURLConnection httpURLConnection;
        try {
            try {
                this.f.connect();
                this.g.a(a, this.f.getRequestMethod() + " connect code :" + this.f.getResponseCode());
                int responseCode = this.f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f.setInstanceFollowRedirects(false);
                    java.net.HttpURLConnection a2 = a(this.f);
                    this.f = a2;
                    responseCode = a2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    com.baidu.mobads.sdk.internal.am.b bVar = this.h;
                    if (bVar != null) {
                        bVar.a(this.f.getResponseMessage(), responseCode);
                    }
                    com.baidu.mobads.sdk.internal.am.c cVar = this.i;
                    if (cVar != null) {
                        cVar.a(this.f.getResponseMessage(), responseCode);
                    }
                } else {
                    java.lang.String g = com.baidu.mobads.sdk.internal.cq.a().g(this.j);
                    com.baidu.mobads.sdk.internal.am.b bVar2 = this.h;
                    if (bVar2 != null) {
                        bVar2.a(c(), g);
                    }
                    com.baidu.mobads.sdk.internal.am.c cVar2 = this.i;
                    if (cVar2 != null) {
                        cVar2.a(this.f.getInputStream(), g);
                    }
                }
                httpURLConnection = this.f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (java.lang.Exception e2) {
                com.baidu.mobads.sdk.internal.am.b bVar3 = this.h;
                if (bVar3 != null) {
                    bVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                com.baidu.mobads.sdk.internal.am.c cVar3 = this.i;
                if (cVar3 != null) {
                    cVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (java.lang.Throwable th) {
            java.net.HttpURLConnection httpURLConnection2 = this.f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public java.lang.String a() {
        e();
        java.net.HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    java.net.HttpURLConnection httpURLConnection2 = this.f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                java.lang.String c2 = c();
                java.net.HttpURLConnection httpURLConnection3 = this.f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c2;
            } catch (java.lang.Throwable unused) {
                java.net.HttpURLConnection httpURLConnection4 = this.f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void a(int i) {
        this.n = i;
    }

    public void a(android.net.Uri.Builder builder) {
        this.q = builder;
    }

    public void a(com.baidu.mobads.sdk.internal.am.b bVar) {
        this.h = bVar;
    }

    public void a(com.baidu.mobads.sdk.internal.am.c cVar) {
        this.i = cVar;
    }

    public void a(java.lang.String str) {
        this.m = str;
    }

    public void a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (this.f != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                this.f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    public void b() {
        try {
            com.baidu.mobads.sdk.internal.bd.a().a((com.baidu.mobads.sdk.internal.j) new com.baidu.mobads.sdk.internal.am.a());
        } catch (java.lang.Exception unused) {
        }
    }

    public void b(int i) {
        this.o = i;
    }

    public java.lang.String c() {
        java.io.InputStream inputStream = null;
        try {
            inputStream = this.f.getInputStream();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    java.lang.String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    inputStream.close();
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (java.lang.Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public void d() {
        java.net.HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            try {
                java.io.InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (java.lang.Exception e2) {
                com.baidu.mobads.sdk.internal.ay.h(a).f(e2.toString());
            }
        }
    }
}
