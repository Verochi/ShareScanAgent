package com.anythink.expressad.a;

/* loaded from: classes12.dex */
public class f {
    private static final java.lang.String a = "f";
    private static final int b = 60000;
    private com.anythink.expressad.d.a c;
    private java.lang.String d;
    private boolean e = true;
    private final int f = 3145728;
    private com.anythink.expressad.a.f.a g;

    public static class a {
        public java.lang.String a;
        public java.lang.String b;
        public java.lang.String c;
        public java.lang.String d;
        public int e;
        public int f;
        public java.lang.String g;
        public java.lang.String h;

        public final java.lang.String a() {
            return "statusCode=" + this.f + ", location=" + this.a + ", contentType=" + this.b + ", contentLength=" + this.e + ", contentEncoding=" + this.c + ", referer=" + this.d;
        }

        public final java.lang.String toString() {
            return "http header:...\nstatusCode=" + this.f + ", location=" + this.a + ", contentType=" + this.b + ", contentLength=" + this.e + ", contentEncoding=" + this.c + ", referer=" + this.d;
        }
    }

    public f() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
        this.c = b2;
        if (b2 == null) {
            com.anythink.expressad.d.b.a();
            this.c = com.anythink.expressad.d.b.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045 A[Catch: Exception -> 0x0049, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0049, blocks: (B:32:0x0022, B:12:0x0045), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033 A[Catch: all -> 0x002c, TryCatch #5 {all -> 0x002c, blocks: (B:39:0x0008, B:4:0x000e, B:7:0x002f, B:9:0x0033, B:10:0x0040), top: B:38:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String a(java.io.InputStream inputStream, boolean z) {
        java.lang.Throwable th;
        java.lang.Exception e;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.io.BufferedReader bufferedReader = null;
        try {
            if (z) {
                try {
                    try {
                        inputStream = new java.util.zip.GZIPInputStream(inputStream);
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        if (this.g == null) {
                            com.anythink.expressad.a.f.a aVar = new com.anythink.expressad.a.f.a();
                            this.g = aVar;
                            aVar.h = e.getMessage();
                        }
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb.toString();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (java.lang.Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
            while (true) {
                try {
                    java.lang.String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                } catch (java.lang.Exception e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                    if (this.g == null) {
                    }
                    e.printStackTrace();
                    if (bufferedReader != null) {
                    }
                    return sb.toString();
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            }
            bufferedReader2.close();
        } catch (java.lang.Exception e5) {
            e5.printStackTrace();
        }
        return sb.toString();
    }

    private void a(boolean z) {
        this.e = z;
    }

    public final com.anythink.expressad.a.f.a a(java.lang.String str, boolean z, boolean z2, com.anythink.expressad.foundation.d.c cVar) {
        int i;
        byte[] bytes;
        java.net.HttpURLConnection httpURLConnection = null;
        if (!android.webkit.URLUtil.isNetworkUrl(str)) {
            return null;
        }
        java.lang.String replace = str.replace(" ", "%20");
        android.webkit.URLUtil.isHttpsUrl(replace);
        this.g = new com.anythink.expressad.a.f.a();
        try {
            java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) new java.net.URL(replace).openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                if ((!z && !z2) || cVar == null) {
                    httpURLConnection2.setRequestProperty("User-Agent", com.anythink.core.common.o.e.i());
                }
                if (z && cVar != null && cVar.E() == 1) {
                    httpURLConnection2.setRequestProperty("User-Agent", com.anythink.core.common.o.e.i());
                }
                if (z2 && cVar != null && cVar.D() == 1) {
                    httpURLConnection2.setRequestProperty("User-Agent", com.anythink.core.common.o.e.i());
                }
                httpURLConnection2.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
                if (this.c.v() && !android.text.TextUtils.isEmpty(this.d)) {
                    httpURLConnection2.setRequestProperty(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_REFERER, this.d);
                }
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.connect();
                this.g.a = httpURLConnection2.getHeaderField("Location");
                this.g.d = httpURLConnection2.getHeaderField(com.google.common.net.HttpHeaders.REFERER);
                this.g.f = httpURLConnection2.getResponseCode();
                this.g.b = httpURLConnection2.getContentType();
                this.g.e = httpURLConnection2.getContentLength();
                this.g.c = httpURLConnection2.getContentEncoding();
                boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(this.g.c);
                com.anythink.expressad.a.f.a aVar = this.g;
                if (aVar.f == 200 && this.e && (i = aVar.e) > 0 && i < 3145728 && !android.text.TextUtils.isEmpty(replace) && !replace.endsWith(com.anythink.china.common.a.a.g)) {
                    try {
                        java.lang.String a2 = a(httpURLConnection2.getInputStream(), equalsIgnoreCase);
                        if (!android.text.TextUtils.isEmpty(a2) && (bytes = a2.getBytes()) != null && bytes.length > 0 && bytes.length < 3145728) {
                            this.g.g = a2.trim();
                        }
                    } catch (java.lang.Throwable unused) {
                    }
                }
                this.d = replace;
                httpURLConnection2.disconnect();
                return this.g;
            } catch (java.lang.Throwable th) {
                th = th;
                httpURLConnection = httpURLConnection2;
                try {
                    this.g.h = th.getMessage();
                    return this.g;
                } finally {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
