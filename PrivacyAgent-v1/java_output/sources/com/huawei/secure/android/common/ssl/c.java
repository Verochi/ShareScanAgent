package com.huawei.secure.android.common.ssl;

/* loaded from: classes22.dex */
public class c implements javax.net.ssl.X509TrustManager {
    public java.security.cert.X509Certificate a;
    public java.util.List<javax.net.ssl.X509TrustManager> b = new java.util.ArrayList();

    public c(android.content.Context context) {
        if (context == null) {
            throw new java.lang.NullPointerException("WebViewX509TrustManger context is null");
        }
        com.huawei.secure.android.common.ssl.util.c.a(context);
        java.security.cert.X509Certificate b = new com.huawei.secure.android.common.ssl.util.j(context).b();
        this.a = b;
        if (b == null) {
            throw new java.lang.NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        com.huawei.secure.android.common.ssl.util.g.c("WebViewX509TrustManger", "checkClientTrusted");
        if (this.b.isEmpty()) {
            throw new java.security.cert.CertificateException("checkClientTrusted CertificateException");
        }
        this.b.get(0).checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        com.huawei.secure.android.common.ssl.util.g.c("WebViewX509TrustManger", "checkServerTrusted");
        boolean z = false;
        for (int i = 0; i < x509CertificateArr.length; i++) {
            com.huawei.secure.android.common.ssl.util.g.a("WebViewX509TrustManger", "checkServerTrusted " + i + " : " + x509CertificateArr[i].getIssuerDN().getName());
        }
        java.security.cert.X509Certificate[] x509CertificateArr2 = new java.security.cert.X509Certificate[x509CertificateArr.length];
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            x509CertificateArr2[i2] = x509CertificateArr[(x509CertificateArr.length - 1) - i2];
        }
        java.security.cert.CertificateException e = new java.security.cert.CertificateException("CBG root CA CertificateException");
        try {
            z = com.huawei.secure.android.common.ssl.util.b.a(this.a, x509CertificateArr2);
        } catch (java.security.InvalidKeyException e2) {
            com.huawei.secure.android.common.ssl.util.g.b("WebViewX509TrustManger", "checkServerTrusted InvalidKeyException: " + e2.getMessage());
        } catch (java.security.NoSuchAlgorithmException e3) {
            com.huawei.secure.android.common.ssl.util.g.b("WebViewX509TrustManger", "checkServerTrusted NoSuchAlgorithmException: " + e3.getMessage());
        } catch (java.security.NoSuchProviderException e4) {
            com.huawei.secure.android.common.ssl.util.g.b("WebViewX509TrustManger", "checkServerTrusted NoSuchProviderException: " + e4.getMessage());
        } catch (java.security.SignatureException e5) {
            com.huawei.secure.android.common.ssl.util.g.b("WebViewX509TrustManger", "checkServerTrusted SignatureException: " + e5.getMessage());
        } catch (java.security.cert.CertificateException e6) {
            e = e6;
            com.huawei.secure.android.common.ssl.util.g.b("WebViewX509TrustManger", "checkServerTrusted CertificateException: " + e.getMessage());
        }
        if (!z) {
            throw e;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<javax.net.ssl.X509TrustManager> it = this.b.iterator();
            while (it.hasNext()) {
                arrayList.addAll(java.util.Arrays.asList(it.next().getAcceptedIssuers()));
            }
            return (java.security.cert.X509Certificate[]) arrayList.toArray(new java.security.cert.X509Certificate[arrayList.size()]);
        } catch (java.lang.Exception e) {
            com.huawei.secure.android.common.ssl.util.g.b("WebViewX509TrustManger", "getAcceptedIssuers exception : " + e.getMessage());
            return new java.security.cert.X509Certificate[0];
        }
    }
}
