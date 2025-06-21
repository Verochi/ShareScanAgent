package com.bytedance.sdk.openadsdk.api.plugin.wg;

/* loaded from: classes22.dex */
public class t {

    public static final class vw {
        private static final com.bytedance.sdk.openadsdk.api.plugin.wg.t vw = new com.bytedance.sdk.openadsdk.api.plugin.wg.t(null);
    }

    private t() {
    }

    public /* synthetic */ t(com.bytedance.sdk.openadsdk.api.plugin.wg.t.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.bytedance.sdk.openadsdk.api.plugin.wg.t vw() {
        return com.bytedance.sdk.openadsdk.api.plugin.wg.t.vw.vw;
    }

    private static java.lang.String vw(java.lang.String str, java.lang.String str2) {
        if (str != null) {
            java.lang.String[] split = str.split(com.alipay.sdk.m.u.i.b, 0);
            for (int i = 1; i < split.length; i++) {
                java.lang.String[] split2 = split[i].trim().split(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER, 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str2;
    }

    private javax.net.ssl.SSLSocketFactory vw(javax.net.ssl.X509TrustManager x509TrustManager) throws java.io.IOException {
        try {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (java.security.GeneralSecurityException e) {
            throw new java.io.IOException("No System TLS", e);
        }
    }

    private static byte[] vw(java.io.InputStream inputStream, int i) throws java.io.IOException {
        if (inputStream == null) {
            return null;
        }
        if (i <= 0) {
            i = 1;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private javax.net.ssl.X509TrustManager wg() throws java.io.IOException {
        try {
            javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((java.security.KeyStore) null);
            javax.net.ssl.TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                javax.net.ssl.TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                    return (javax.net.ssl.X509TrustManager) trustManager;
                }
            }
            throw new java.lang.IllegalStateException("Unexpected default trust managers:" + java.util.Arrays.toString(trustManagers));
        } catch (java.security.GeneralSecurityException e) {
            throw new java.io.IOException("No System TLS", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0085, code lost:
    
        if (r5 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String vw(boolean z, java.lang.String str, byte[] bArr) {
        javax.net.ssl.HttpsURLConnection httpsURLConnection;
        javax.net.ssl.HttpsURLConnection httpsURLConnection2 = null;
        try {
            java.net.URL url = new java.net.URL(str);
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(vw(wg()));
            httpsURLConnection = (javax.net.ssl.HttpsURLConnection) url.openConnection();
            try {
                try {
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setHostnameVerifier(com.bytedance.sdk.openadsdk.api.plugin.wg.vw.vw);
                    if (!z || bArr == null || bArr.length == 0) {
                        httpsURLConnection.setRequestMethod("GET");
                    } else {
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setFixedLengthStreamingMode(bArr.length);
                        java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(httpsURLConnection.getOutputStream());
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        httpsURLConnection.setRequestMethod("POST");
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 300) {
                        java.lang.String str2 = new java.lang.String(vw(httpsURLConnection.getInputStream(), 1024), vw(httpsURLConnection.getHeaderField("Content-Type"), "utf-8"));
                        try {
                            httpsURLConnection.disconnect();
                        } catch (java.lang.Exception unused) {
                        }
                        return str2;
                    }
                } catch (java.lang.Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                httpsURLConnection2 = httpsURLConnection;
                if (httpsURLConnection2 != null) {
                    try {
                        httpsURLConnection2.disconnect();
                    } catch (java.lang.Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            httpsURLConnection = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (httpsURLConnection2 != null) {
            }
            throw th;
        }
        try {
            httpsURLConnection.disconnect();
        } catch (java.lang.Exception unused3) {
        }
        return null;
    }
}
