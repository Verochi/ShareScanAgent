package com.alipay.sdk.m.o;

/* loaded from: classes.dex */
public final class a {
    public static final java.lang.String a = "msp";
    public static final java.lang.String b = "application/octet-stream;binary/octet-stream";
    public static final java.net.CookieManager c = new java.net.CookieManager();

    /* renamed from: com.alipay.sdk.m.o.a$a, reason: collision with other inner class name */
    public static final class C0039a {
        public final java.lang.String a;
        public final byte[] b;
        public final java.util.Map<java.lang.String, java.lang.String> c;

        public C0039a(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, byte[] bArr) {
            this.a = str;
            this.b = bArr;
            this.c = map;
        }

        public java.lang.String toString() {
            return java.lang.String.format("<UrlConnectionConfigure url=%s headers=%s>", this.a, this.c);
        }
    }

    public static final class b {
        public final java.util.Map<java.lang.String, java.util.List<java.lang.String>> a;
        public final java.lang.String b;
        public final byte[] c;

        public b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map, java.lang.String str, byte[] bArr) {
            this.a = map;
            this.b = str;
            this.c = bArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.alipay.sdk.m.o.a.b a(android.content.Context context, com.alipay.sdk.m.o.a.C0039a c0039a) {
        java.lang.Throwable th;
        java.net.HttpURLConnection httpURLConnection;
        java.lang.Throwable th2;
        java.io.BufferedInputStream bufferedInputStream;
        java.io.BufferedOutputStream bufferedOutputStream;
        if (context == null) {
            return null;
        }
        try {
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "conn config: " + c0039a);
            java.net.URL url = new java.net.URL(c0039a.a);
            java.net.Proxy b2 = b(context);
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.z, "conn proxy: " + b2);
            httpURLConnection = b2 != null ? (java.net.HttpURLConnection) url.openConnection(b2) : (java.net.HttpURLConnection) url.openConnection();
            try {
                java.lang.System.setProperty("http.keepAlive", com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                if (httpURLConnection instanceof javax.net.ssl.HttpsURLConnection) {
                }
                java.net.CookieManager cookieManager = c;
                if (cookieManager.getCookieStore().getCookies().size() > 0) {
                    httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.COOKIE, android.text.TextUtils.join(com.alipay.sdk.m.u.i.b, cookieManager.getCookieStore().getCookies()));
                }
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", a);
                byte[] bArr = c0039a.b;
                if (bArr == null || bArr.length <= 0) {
                    httpURLConnection.setRequestMethod("GET");
                } else {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", b);
                    httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_CHARSET, "UTF-8");
                    httpURLConnection.setRequestProperty(com.google.common.net.HttpHeaders.CONNECTION, com.anythink.expressad.foundation.g.f.g.b.c);
                    httpURLConnection.setRequestProperty(com.anythink.expressad.foundation.g.f.g.b.c, "timeout=180, max=100");
                }
                java.util.Map<java.lang.String, java.lang.String> map = c0039a.c;
                if (map != null) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                        if (entry.getKey() != null) {
                            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                }
                httpURLConnection.setDoInput(true);
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                    httpURLConnection.setDoOutput(true);
                }
                if ("POST".equals(httpURLConnection.getRequestMethod())) {
                    bufferedOutputStream = new java.io.BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream.write(c0039a.b);
                        bufferedOutputStream.flush();
                    } catch (java.lang.Throwable th3) {
                        th2 = th3;
                        bufferedInputStream = null;
                        try {
                            com.alipay.sdk.m.u.e.a(th2);
                            if (httpURLConnection != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (bufferedOutputStream != null) {
                            }
                            return null;
                        } finally {
                        }
                    }
                } else {
                    bufferedOutputStream = null;
                }
                bufferedInputStream = new java.io.BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    byte[] a2 = a(bufferedInputStream);
                    java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
                    java.lang.String join = (headerFields == null || headerFields.get(null) == null) ? null : android.text.TextUtils.join(",", headerFields.get(null));
                    java.util.List<java.lang.String> list = headerFields.get(com.google.common.net.HttpHeaders.SET_COOKIE);
                    if (list != null) {
                        java.util.Iterator<java.lang.String> it = list.iterator();
                        while (it.hasNext()) {
                            java.util.List<java.net.HttpCookie> parse = java.net.HttpCookie.parse(it.next());
                            if (parse != null && !parse.isEmpty()) {
                                c.getCookieStore().add(url.toURI(), parse.get(0));
                            }
                        }
                    }
                    com.alipay.sdk.m.o.a.b bVar = new com.alipay.sdk.m.o.a.b(headerFields, join, a2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (java.lang.Throwable unused) {
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Throwable unused2) {
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (java.lang.Throwable unused3) {
                        }
                    }
                    return bVar;
                } catch (java.lang.Throwable th4) {
                    th2 = th4;
                    com.alipay.sdk.m.u.e.a(th2);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (java.lang.Throwable unused4) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (java.lang.Throwable unused5) {
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (java.lang.Throwable unused6) {
                        }
                    }
                    return null;
                }
            } catch (java.lang.Throwable th5) {
                th = th5;
                th2 = th;
                bufferedInputStream = null;
                bufferedOutputStream = null;
                com.alipay.sdk.m.u.e.a(th2);
                if (httpURLConnection != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                return null;
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
            httpURLConnection = null;
        }
    }

    public static java.lang.String a(android.content.Context context) {
        try {
            android.net.NetworkInfo a2 = com.alipay.sdk.m.w.b.a(null, context);
            if (a2 != null && a2.isAvailable()) {
                return a2.getType() == 1 ? com.efs.sdk.base.core.util.NetworkUtil.NETWORK_TYPE_WIFI : a2.getExtraInfo().toLowerCase();
            }
        } catch (java.lang.Exception unused) {
        }
        return "none";
    }

    public static byte[] a(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read == -1) {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static java.net.Proxy b(android.content.Context context) {
        java.lang.String a2 = a(context);
        if (a2 != null && !a2.contains("wap")) {
            return null;
        }
        try {
            java.lang.String property = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTPS_PROXY_HOST);
            java.lang.String property2 = java.lang.System.getProperty(org.apache.tools.ant.util.ProxySetup.HTTPS_PROXY_PORT);
            if (android.text.TextUtils.isEmpty(property)) {
                return null;
            }
            return new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(property, java.lang.Integer.parseInt(property2)));
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
