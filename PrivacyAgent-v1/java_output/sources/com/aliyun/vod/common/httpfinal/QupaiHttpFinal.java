package com.aliyun.vod.common.httpfinal;

/* loaded from: classes12.dex */
public class QupaiHttpFinal implements com.aliyun.vod.common.httpfinal.HttpInterface {
    private static com.aliyun.vod.common.httpfinal.QupaiHttpFinal instance;

    /* renamed from: com.aliyun.vod.common.httpfinal.QupaiHttpFinal$1, reason: invalid class name */
    public static class AnonymousClass1 implements javax.net.ssl.X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("X509TrustManager checkClientTrusted: ");
            sb.append(x509CertificateArr == null ? com.igexin.push.core.b.m : java.lang.Integer.valueOf(x509CertificateArr.length));
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
            checkServerTrusted(x509CertificateArr, str, null);
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str, java.lang.String str2) throws java.security.cert.CertificateException {
            if (x509CertificateArr == null) {
                throw new java.lang.IllegalArgumentException("X509TrustManager checkServerTrusted: X509Certificate is null");
            }
            try {
                if (x509CertificateArr.length > 0) {
                    x509CertificateArr[0].checkValidity();
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("X509TrustManager checkServerTrusted: checkValidity ");
                sb.append(x509CertificateArr.length);
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("X509TrustManager checkServerTrusted: checkValidity exception ");
                sb2.append(e.getMessage());
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
        }
    }

    /* renamed from: com.aliyun.vod.common.httpfinal.QupaiHttpFinal$2, reason: invalid class name */
    public static class AnonymousClass2 implements javax.net.ssl.HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                boolean verify = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("HostnameVerifier verify true, default verify ");
                sb.append(verify);
                return true;
            } catch (java.lang.Exception e) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("HostnameVerifier verify true, default exception ");
                sb2.append(e.getMessage());
                return true;
            }
        }
    }

    private static void addHttps(com.aliyun.vod.qupaiokhttp.OkHttpFinalConfiguration.Builder builder) {
        try {
            com.aliyun.vod.common.httpfinal.QupaiHttpFinal.AnonymousClass1 anonymousClass1 = new com.aliyun.vod.common.httpfinal.QupaiHttpFinal.AnonymousClass1();
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("SSL");
            sSLContext.init(null, new javax.net.ssl.TrustManager[]{anonymousClass1}, new java.security.SecureRandom());
            builder.setSSLSocketFactory(sSLContext.getSocketFactory(), anonymousClass1);
            builder.setHostnameVerifier(new com.aliyun.vod.common.httpfinal.QupaiHttpFinal.AnonymousClass2());
        } catch (java.security.KeyManagementException e) {
            e.printStackTrace();
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

    public static com.aliyun.vod.common.httpfinal.QupaiHttpFinal getInstance() {
        if (instance == null) {
            synchronized (com.aliyun.vod.common.httpfinal.QupaiHttpFinal.class) {
                if (instance == null) {
                    instance = new com.aliyun.vod.common.httpfinal.QupaiHttpFinal();
                }
            }
        }
        return instance;
    }

    @Override // com.aliyun.vod.common.httpfinal.HttpInterface
    public void initOkHttpFinal() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        okhttp3.Headers build = new okhttp3.Headers.Builder().build();
        com.aliyun.vod.qupaiokhttp.OkHttpFinalConfiguration.Builder debug = new com.aliyun.vod.qupaiokhttp.OkHttpFinalConfiguration.Builder().setCommenParams(arrayList).setCommenHeaders(build).setTimeout(35000L).setInterceptors(new java.util.ArrayList()).setDebug(true);
        addHttps(debug);
        com.aliyun.vod.qupaiokhttp.OkHttpFinal.getInstance().init(debug.build());
    }
}
