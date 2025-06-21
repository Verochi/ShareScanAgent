package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class o implements com.zx.a.I8b7.n0 {
    public final com.zx.a.I8b7.o2 a;

    public o(com.zx.a.I8b7.o2 o2Var) {
        this.a = o2Var;
    }

    @Override // com.zx.a.I8b7.n0
    public com.zx.a.I8b7.t1 a(com.zx.a.I8b7.n0.a aVar) throws java.io.IOException {
        com.zx.a.I8b7.j1 j1Var = (com.zx.a.I8b7.j1) aVar;
        com.zx.a.I8b7.q1 q1Var = j1Var.c;
        java.net.HttpURLConnection httpURLConnection = j1Var.d;
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(q1Var.d != null);
        httpURLConnection.setConnectTimeout(this.a.f);
        httpURLConnection.setReadTimeout(this.a.g);
        httpURLConnection.setInstanceFollowRedirects(this.a.e);
        this.a.getClass();
        httpURLConnection.setUseCaches(false);
        if ("https".equalsIgnoreCase(q1Var.a.getProtocol())) {
            javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) httpURLConnection;
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a.c;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
            }
            javax.net.ssl.HostnameVerifier hostnameVerifier = this.a.d;
            if (hostnameVerifier != null) {
                httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            }
        }
        java.util.Map<java.lang.String, java.lang.String> map = q1Var.c;
        if (map != null && map.size() > 0) {
            for (java.lang.String str : map.keySet()) {
                httpURLConnection.setRequestProperty(str, map.get(str));
            }
        }
        httpURLConnection.connect();
        return j1Var.a(q1Var, httpURLConnection);
    }
}
