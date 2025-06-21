package com.huawei.hms.framework.network.grs.h.f;

/* loaded from: classes22.dex */
public class a {
    public static javax.net.ssl.HttpsURLConnection a(java.lang.String str, android.content.Context context, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.net.URLConnection openConnection = new java.net.URL(str).openConnection();
        if (!(openConnection instanceof javax.net.ssl.HttpsURLConnection)) {
            com.huawei.hms.framework.common.Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
            return null;
        }
        javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) openConnection;
        try {
            httpsURLConnection.setSSLSocketFactory(com.huawei.hms.framework.network.grs.h.g.a.a(context));
            httpsURLConnection.setHostnameVerifier(com.huawei.hms.framework.network.grs.h.g.a.a());
        } catch (java.lang.IllegalArgumentException unused) {
            com.huawei.hms.framework.common.Logger.w("URLConnectionHelper", "init https ssl socket failed.");
        }
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        java.lang.String b = com.huawei.hms.framework.network.grs.h.a.b(context, "NetworkKit-grs", str2);
        com.huawei.hms.framework.common.Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is:" + b);
        httpsURLConnection.setRequestProperty("User-Agent", b);
        return httpsURLConnection;
    }

    public static void a(javax.net.ssl.HttpsURLConnection httpsURLConnection, java.lang.String str) {
        java.io.OutputStream outputStream;
        java.lang.String str2;
        if (str == null) {
            str2 = "sendHttpBody: The Body Data is Null";
        } else if (httpsURLConnection == null) {
            str2 = "sendHttpBody: HttpsURLConnection is Null";
        } else {
            try {
                outputStream = httpsURLConnection.getOutputStream();
                try {
                    outputStream.write(str.getBytes("UTF-8"));
                    outputStream.flush();
                    com.huawei.hms.framework.common.IoUtils.closeSecure(outputStream);
                    return;
                } catch (java.lang.Throwable th) {
                    th = th;
                    com.huawei.hms.framework.common.IoUtils.closeSecure(outputStream);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                outputStream = null;
            }
        }
        com.huawei.hms.framework.common.Logger.i("URLConnectionHelper", str2);
    }
}
