package com.anythink.expressad.foundation.g.f.e;

/* loaded from: classes12.dex */
public final class b implements com.anythink.expressad.foundation.g.f.e.a {
    private static final int a = 100;
    private com.anythink.expressad.foundation.g.f.c.a b;
    private javax.net.ssl.SSLSocketFactory c;

    public static class a extends java.io.FilterInputStream {
        private final java.net.HttpURLConnection a;

        public a(java.net.HttpURLConnection httpURLConnection) {
            super(com.anythink.expressad.foundation.g.f.e.b.b(httpURLConnection));
            this.a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            super.close();
            this.a.disconnect();
        }
    }

    public b(javax.net.ssl.SSLSocketFactory sSLSocketFactory, com.anythink.expressad.foundation.g.f.c.a aVar) {
        this.c = sSLSocketFactory;
        this.b = aVar;
    }

    private java.net.HttpURLConnection a(java.net.URL url) {
        java.net.HttpURLConnection httpURLConnection;
        com.anythink.expressad.foundation.g.f.c.a aVar = this.b;
        if (aVar == null || android.text.TextUtils.isEmpty(aVar.b) || android.text.TextUtils.isEmpty(this.b.c)) {
            httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        } else {
            java.net.Proxy.Type type = java.net.Proxy.Type.HTTP;
            com.anythink.expressad.foundation.g.f.c.a aVar2 = this.b;
            httpURLConnection = (java.net.HttpURLConnection) url.openConnection(new java.net.Proxy(type, new java.net.InetSocketAddress(aVar2.b, java.lang.Integer.valueOf(aVar2.c).intValue())));
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private java.net.HttpURLConnection a(java.net.URL url, com.anythink.expressad.foundation.g.f.i<?> iVar) {
        java.net.HttpURLConnection httpURLConnection;
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        com.anythink.expressad.foundation.g.f.c.a aVar = this.b;
        if (aVar == null || android.text.TextUtils.isEmpty(aVar.b) || android.text.TextUtils.isEmpty(this.b.c)) {
            httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        } else {
            java.net.Proxy.Type type = java.net.Proxy.Type.HTTP;
            com.anythink.expressad.foundation.g.f.c.a aVar2 = this.b;
            httpURLConnection = (java.net.HttpURLConnection) url.openConnection(new java.net.Proxy(type, new java.net.InetSocketAddress(aVar2.b, java.lang.Integer.valueOf(aVar2.c).intValue())));
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        int k = iVar.k();
        httpURLConnection.setConnectTimeout(k);
        httpURLConnection.setReadTimeout(k);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.c) != null) {
            ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnection;
    }

    private static java.util.List<com.anythink.expressad.foundation.g.f.c.c> a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> map) {
        java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                java.util.Iterator<java.lang.String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.anythink.expressad.foundation.g.f.c.c(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, com.anythink.expressad.foundation.g.f.i<?> iVar) {
        switch (iVar.a()) {
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, iVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod("PUT");
                b(httpURLConnection, iVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod("DELETE");
                return;
            case 4:
                httpURLConnection.setRequestMethod("HEAD");
                return;
            case 5:
                httpURLConnection.setRequestMethod("OPTIONS");
                return;
            case 6:
                httpURLConnection.setRequestMethod("TRACE");
                return;
            case 7:
                b(httpURLConnection, iVar);
                httpURLConnection.setRequestMethod("PATCH");
                return;
            default:
                throw new java.lang.IllegalStateException("Unknown method type.");
        }
    }

    private static boolean a(int i, int i2) {
        if (i != 4) {
            return ((100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.io.InputStream b(java.net.HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (java.io.IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void b(java.net.HttpURLConnection httpURLConnection, com.anythink.expressad.foundation.g.f.i<?> iVar) {
        byte[] h = iVar.h();
        if (h != null) {
            boolean z = iVar instanceof com.anythink.expressad.foundation.g.f.d.f;
            if (z) {
                httpURLConnection.setChunkedStreamingMode(2048);
            }
            httpURLConnection.setDoOutput(true);
            java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(h);
            if (z) {
                iVar.a((java.io.OutputStream) dataOutputStream);
            }
            dataOutputStream.close();
        }
    }

    @Override // com.anythink.expressad.foundation.g.f.e.a
    public final com.anythink.expressad.foundation.g.f.f.b a(com.anythink.expressad.foundation.g.f.i<?> iVar) {
        java.net.HttpURLConnection httpURLConnection;
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        java.net.URL url = new java.net.URL(iVar.d());
        com.anythink.expressad.foundation.g.f.c.a aVar = this.b;
        if (aVar == null || android.text.TextUtils.isEmpty(aVar.b) || android.text.TextUtils.isEmpty(this.b.c)) {
            httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
        } else {
            java.net.Proxy.Type type = java.net.Proxy.Type.HTTP;
            com.anythink.expressad.foundation.g.f.c.a aVar2 = this.b;
            httpURLConnection = (java.net.HttpURLConnection) url.openConnection(new java.net.Proxy(type, new java.net.InetSocketAddress(aVar2.b, java.lang.Integer.valueOf(aVar2.c).intValue())));
        }
        boolean z = false;
        httpURLConnection.setInstanceFollowRedirects(false);
        int k = iVar.k();
        httpURLConnection.setConnectTimeout(k);
        httpURLConnection.setReadTimeout(k);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.c) != null) {
            ((javax.net.ssl.HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : iVar.g().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
            switch (iVar.a()) {
                case 0:
                    httpURLConnection.setRequestMethod("GET");
                    break;
                case 1:
                    httpURLConnection.setRequestMethod("POST");
                    b(httpURLConnection, iVar);
                    break;
                case 2:
                    httpURLConnection.setRequestMethod("PUT");
                    b(httpURLConnection, iVar);
                    break;
                case 3:
                    httpURLConnection.setRequestMethod("DELETE");
                    break;
                case 4:
                    httpURLConnection.setRequestMethod("HEAD");
                    break;
                case 5:
                    httpURLConnection.setRequestMethod("OPTIONS");
                    break;
                case 6:
                    httpURLConnection.setRequestMethod("TRACE");
                    break;
                case 7:
                    b(httpURLConnection, iVar);
                    httpURLConnection.setRequestMethod("PATCH");
                    break;
                default:
                    throw new java.lang.IllegalStateException("Unknown method type.");
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new java.io.IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (!((iVar.a() == 4 || (100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304) ? false : true)) {
                com.anythink.expressad.foundation.g.f.f.b bVar = new com.anythink.expressad.foundation.g.f.f.b(responseCode, a(httpURLConnection.getHeaderFields()));
                httpURLConnection.disconnect();
                return bVar;
            }
            try {
                return new com.anythink.expressad.foundation.g.f.f.b(responseCode, a(httpURLConnection.getHeaderFields()), new com.anythink.expressad.foundation.g.f.e.b.a(httpURLConnection));
            } catch (java.lang.Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }
}
